package com.example.q25toq43.Activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.q25toq43.Adapter.EmployeeAdapter_37
import com.example.q25toq43.R
import com.example.q25toq43.databinding.ActivityQ37Binding

class q37 : AppCompatActivity() {
    private lateinit var binding : ActivityQ37Binding


    private val employeeList = listOf(
        "John Doe - HR",
        "Jane Smith - Marketing",
        "Michael Johnson - Finance",
        "Emily Brown - HR",
        "David Lee - Marketing",
        "Emma Wilson - Finance",
        "James Taylor - HR",
        "Olivia Clark - Marketing",
        "Daniel Anderson - Finance"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityQ37Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        var adapter = EmployeeAdapter_37(employeeList)
        binding.recyclerView.adapter = adapter


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    val filteredList = employeeList.filter { it.contains(newText, true) }
                    adapter = EmployeeAdapter_37(filteredList)
                    binding.recyclerView.adapter = adapter
                }
                return true
            }
        })



    }
}