package com.example.q25toq43.Activities

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.q25toq43.Adapter.q25GridviewAdapter

import com.example.q25toq43.databinding.ActivityQ25Binding

class q25 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: q25GridviewAdapter
    private lateinit var progressBar: ProgressBar

    private val totalItems = 100
    private val itemsPerLoad = 20
    private var loadedItems = 0
    private var loading = false
    private var isLoading = false

    private lateinit var binding: ActivityQ25Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQ25Binding.inflate(layoutInflater)
        setContentView(binding.root)

         recyclerView = binding.RecycleView
         progressBar = binding.Loading

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter = q25GridviewAdapter(this,ArrayList())
        recyclerView.adapter = adapter

        loadMoreItems()

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as GridLayoutManager
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                val totalItemCount = layoutManager.itemCount

                if (!loading && !isLoading && totalItemCount - 1 == lastVisibleItemPosition) {
                    loadMoreItems()
                }
            }
        })

    }

    private fun loadMoreItems() {
        loading = true
        progressBar.visibility = View.VISIBLE

        Handler().postDelayed({
            val newItems = ArrayList<String>()
            for (i in 0 until itemsPerLoad) {
                if (loadedItems < totalItems) {
                    newItems.add("Item ${loadedItems + 1}")
                    loadedItems++
                }
            }
            adapter.addMoreItems(newItems)
            progressBar.visibility = View.VISIBLE
            loading = false
        }, 3000) // Simulate loading for 3 seconds
    }
}