package com.example.q23

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapter

    private val totalItems = 100
    private val visibleThreshold = 5
    private var loading = false
    private var lastVisibleItem: Int = 0
    private var totalItemCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = RecyclerViewAdapter(mutableListOf())
        adapter = RecyclerViewAdapter(getItems(100))
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                totalItemCount = layoutManager.itemCount
                lastVisibleItem = layoutManager.findLastVisibleItemPosition()

                if (!loading && totalItemCount <= lastVisibleItem + visibleThreshold && totalItemCount < totalItems) {
                    loadMore()
                    loading = true
                }
            }
        })
    }

    private fun loadMore() {
        val itemsToAdd = getItems(20)
        adapter.addItems(itemsToAdd)
        loading = false
    }

    private fun getItems(count: Int): MutableList<String> {
        val items = mutableListOf<String>()
        repeat(count) {
            items.add("Item ${adapter.itemCount + it + 1}")
        }
        return items
    }
}
