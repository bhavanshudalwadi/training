package com.example.q25toq43.Adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.q25toq43.R

class EmployeeAdapter_37(private val employeeList: List<String>) : RecyclerView.Adapter<EmployeeAdapter_37.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_employee_37, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val employee = employeeList[position]
        holder.bind(employee)
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val employeeTextView: TextView = itemView.findViewById(R.id.employeeTextView)

        fun bind(employee: String) {
            employeeTextView.text = employee
        }
    }
}
