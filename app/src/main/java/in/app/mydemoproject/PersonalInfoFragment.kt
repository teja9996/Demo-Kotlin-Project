package `in`.app.mydemoproject

import `in`.app.mydemoproject.RoomDataBase.*
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.room.Room


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"

/**
 * A simple [Fragment] subclass.
 * Use the [PersonalInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PersonalInfoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    companion object {

        var myname: String? = null
        var mylastName: String? = null
        var myphone: String? = null
        var mygender: String = ""

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PersonalInfoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: MyEntity, param2: String) =
            PersonalInfoFragment().apply {
                arguments = Bundle().apply {

                    putString(ARG_PARAM2, param2)
                }
            }
    }

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

        val receivedData = arguments?.getString("key")
        print(receivedData)
        val view = inflater.inflate(R.layout.fragment_personal_info, container, false)


        val editText1 = view.findViewById<EditText>(R.id.editText1)
        val editText2 = view.findViewById<EditText>(R.id.editText2)
        val editText3 = view.findViewById<EditText>(R.id.editText3)

        val myDatabase =
            Room.databaseBuilder(requireContext(), MyDatabaseNew::class.java, "my_db")
                .allowMainThreadQueries().build()


        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->

            when (checkedId) {
                R.id.radioButton1 -> {
                    mygender = "Male"   // Option 1 selected
                }
                R.id.radioButton2 -> {
                    // Option 2 selected
                    mygender = "Feamle"
                }


            }
        }

        view.findViewById<Button>(R.id.btnNext).setOnClickListener {

            myname = editText1.text.toString()
            mylastName = editText2.text.toString()
            myphone = editText3.text.toString()

            val fragment2 = EmployeeFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, fragment2)
                .addToBackStack(null)
                .commit()
        }

        return view

    }

}