package com.example.q24
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var progressBar: ProgressBar

    private val totalItems = 100
    private val itemsPerLoad = 20
    private var loadedItems = 0
    private var loading = false
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.RecycleView)
        progressBar = findViewById(R.id.Loading)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter(this,ArrayList())
        recyclerView.adapter = adapter

        loadMoreItems()

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
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
            progressBar.visibility = View.INVISIBLE
            loading = false
        }, 3000) // Simulate loading for 3 seconds
    }
}
