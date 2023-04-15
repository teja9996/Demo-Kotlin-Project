package `in`.app.mydemoproject

import `in`.app.mydemoproject.RoomDataBase.*
import `in`.app.mydemoproject.RoomDataBase.MainScreen.MainFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.room.Room

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private var selectedItem = ""

/**
 * A simple [Fragment] subclass.
 * Use the [BankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BankFragment : Fragment() {
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


        val view = inflater.inflate(R.layout.fragment_bank, container, false)
        val editText1 = view.findViewById<EditText>(R.id.editText1)
        val editText2 = view.findViewById<EditText>(R.id.editText2)
        val editText3 = view.findViewById<EditText>(R.id.editText3)
        val spinner = view.findViewById<Spinner>(R.id.spinner)

        val items = listOf("Mahim", "Malad", "Andheri") // Data for the Spinner

        val aa = ArrayAdapter<String>(
            requireActivity(),
            R.layout.support_simple_spinner_dropdown_item,
            items.toList()
        )
        spinner.adapter = aa

        // Set up listener for Spinner item selection
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedItem = items[position] // Get the selected item from the data list

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
        val myDatabase = Room.databaseBuilder(requireContext(), MyDatabaseNew::class.java, "my_db")
            .allowMainThreadQueries().build()
        view.findViewById<Button>(R.id.btnBackToMain).setOnClickListener {

            myBankName = editText1.text.toString()
            myIfc = editText2.text.toString()
            myAcNo = editText3.text.toString()

            val myEntity = MyEntity(
                id = 1,
                jsonData = MyJsonObject(
                    PersonalInfoFragment.myname!!,
                    PersonalInfoFragment.mylastName!!,
                    PersonalInfoFragment.myphone!!,
                    PersonalInfoFragment.mygender!!
                ),
                jsonData2 = MyJsonObject2(
                    EmployeeFragment.myEmpNo!!,
                    EmployeeFragment.myEmpName!!,
                    EmployeeFragment.myEmpdesgi!!,
                    EmployeeFragment.myEmpexp!!
                ),
                jsonData3 = MyJsonObject3(myBankName!!, myIfc!!, myAcNo!!, selectedItem)
            )


            myDatabase.myDao().insertMyEntity(myEntity)

            val allEntities = myDatabase.myDao().getAllEntities()
            println(allEntities)


            val fragment2 = MainFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, fragment2)
                .addToBackStack(null)
                .commit()
        }

        return view
    }

    companion object {

        var myBankName: String? = null
        var myIfc: String? = null
        var myAcNo: String? = null

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}