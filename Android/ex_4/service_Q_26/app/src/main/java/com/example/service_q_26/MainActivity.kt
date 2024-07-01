package com.example.service_q_26

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.service_q_26.adapter.MyAdapter

//Question 26,27 , 28, 29..................

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    private var isServiceRunning = false
    private var isServiceBound = false
    private lateinit var myServiceIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val intent = Intent(this, MyIntentService::class.java)
        startService(intent)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager=LinearLayoutManager(this)
        adapter = MyAdapter(generateData())
        recyclerView.adapter=adapter

        myServiceIntent = Intent(this, MyIntentService::class.java)

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener (){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val firstVisibleItemPosition=(recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                val lastVisibleItemPosition=(recyclerView.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()

                if (firstVisibleItemPosition==0 && !isServiceRunning){
                    startService()
                    bindService()
                }
                // Stop the service when the user scrolls to the 10th item
                if (firstVisibleItemPosition >= 6 && isServiceBound) {
                    unbindService()
                }
//                else if (lastVisibleItemPosition==adapter.itemCount-1 && isServiceRunning){
//                    stopService()
//                    unbindService()
//                }


            }
        })

    }

    private fun startService(){
        val intent= Intent(this, MyIntentService::class.java)
        startService(intent)
        isServiceRunning=true
    }
    private fun stopService(){
        val intent= Intent(this, MyIntentService::class.java)
        stopService(intent)
        isServiceRunning=false
    }
//    private fun generateData(): List<String>{
//        val data = mutableListOf<String>()
//        for (i in 1..100){
//            data.add("Item $i")
//        }
//        return data
//    }

    private fun generateData(): List<String> {
        val data = mutableListOf<String>()
        for (i in 1..20) {
            data.add("Item $i")
        }
        return data
    }


    private fun bindService(){
        bindService(myServiceIntent, serviceConnection, Context.BIND_AUTO_CREATE)
        isServiceBound=true
        Toast.makeText(this, "Service bound", Toast.LENGTH_SHORT).show()
    }
    private fun unbindService(){
        unbindService(serviceConnection)
        isServiceBound=false
        Toast.makeText(this, "Service Unbound", Toast.LENGTH_SHORT).show()

    }
    private val serviceConnection=object : ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {

        }

        override fun onServiceDisconnected(name: ComponentName?) {

        }
    }

}