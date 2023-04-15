package `in`.app.mydemoproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EmployeeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EmployeeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var selectedItem: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    companion object {
        var myEmpNo: String? = null
        var myEmpName: String? = null
        var myEmpexp: String? = null
        var myEmpdesgi: String? = null

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EmployeeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EmployeeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_employee, container, false)
        val editText1 = view.findViewById<EditText>(R.id.editText1)
        val editText2 = view.findViewById<EditText>(R.id.editText2)
        val editText3 = view.findViewById<EditText>(R.id.editText3)
        val spinner = view.findViewById<Spinner>(R.id.spinner)

        val items = listOf("1 Year", "2 Year", "3 Year") // Data for the Spinner

        val aa = ArrayAdapter<String>(
            requireActivity(),
            R.layout.support_simple_spinner_dropdown_item,
            items.toList()
        )
        spinner.adapter = aa

        // Set up listener for Spinner item selection
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long)
            {
                myEmpexp = items[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }



        // Set click listener for the button
        view.findViewById<Button>(R.id.btntobankfrag).setOnClickListener {
            // Open Fragment2 when button is clicked

            // Create a MyEntity object with the JSON objects

             myEmpNo = editText1.text.toString()
             myEmpName = editText2.text.toString()
             myEmpdesgi  = editText3.text.toString()



            val fragment2 = BankFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, fragment2)
                .addToBackStack(null)
                .commit()
        }

        return view
    }

}