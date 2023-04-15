import `in`.app.mydemoproject.RoomDataBase.MainScreen.MainFragment
import `in`.app.mydemoproject.RoomDataBase.MyEntity
import `in`.app.mydemoproject.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val context: MainFragment, private val onItemClick: (MyEntity) -> Unit) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var dataList = listOf<MyEntity>()

    fun setData(data: List<MyEntity>) {
        dataList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the layout for each item in the RecyclerView
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)


        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Bind the data to the views in the ViewHolder
        val myObject = dataList[position]






        holder.bind(myObject)


    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.name)
        val lastname: TextView = itemView.findViewById(R.id.lastname)
        val phone: TextView = itemView.findViewById(R.id.phone)
        val gender: TextView = itemView.findViewById(R.id.gender)


        val empNumber: TextView = itemView.findViewById(R.id.empNumber)
        val empName: TextView = itemView.findViewById(R.id.empName)
        val empExp: TextView = itemView.findViewById(R.id.empExp)
        val empDesgi: TextView = itemView.findViewById(R.id.empDesgi)


        val bankName: TextView = itemView.findViewById(R.id.bankName)
        val bankIfc: TextView = itemView.findViewById(R.id.bankIfc)
        val bankAc: TextView = itemView.findViewById(R.id.bankAc)
        val bankBranch: TextView = itemView.findViewById(R.id.bankBranch)


        fun bind(myObject: MyEntity) {
            // Set the text to the TextView in the ViewHolder
            name.text = myObject.jsonData.name
            lastname.text = myObject.jsonData.lastnem
            phone.text = myObject.jsonData.phone
            gender.text = myObject.jsonData.gender

            empNumber.text = myObject.jsonData2.EmployeeNo
            empName.text = myObject.jsonData2.Employename
            empExp.text = myObject.jsonData2.EmployeWorkExpType
            empDesgi.text = myObject.jsonData2.EmployeDesignation

            bankName.text = myObject.jsonData3.Bankname
            bankIfc.text = myObject.jsonData3.BankIfc
            bankAc.text = myObject.jsonData3.BankAcNo
            bankBranch.text = myObject.jsonData3.Barnch


        }
    }
}


