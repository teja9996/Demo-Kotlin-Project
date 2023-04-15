package `in`.app.mydemoproject.RoomDataBase.MainScreen

import MyAdapter
import `in`.app.mydemoproject.RoomDataBase.MyDatabaseNew
import `in`.app.mydemoproject.PersonalInfoFragment
import `in`.app.mydemoproject.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    lateinit var notesRV: RecyclerView

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        notesRV = view.findViewById(R.id.notesRV)
        notesRV.layoutManager = LinearLayoutManager(requireContext())

        val myDatabase =
            Room.databaseBuilder(requireContext(), MyDatabaseNew::class.java, "my_db")
                .allowMainThreadQueries().build()

        val noteRVAdapter = MyAdapter(this) { item ->

            // Handle item click here, for example, replace or add the fragment


            val bundle = Bundle()
            print(item.jsonData)
            bundle.putString("key", item.jsonData.toString())
            val destinationFragment = PersonalInfoFragment()
            destinationFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.container, destinationFragment)
                .addToBackStack(null)
                .commit()
        }

        val allEntities = myDatabase.myDao().getAllEntities()
        println(allEntities)
        noteRVAdapter.setData(allEntities)
        // on below line we are setting
        // adapter to our recycler view.
        notesRV.adapter = noteRVAdapter
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}