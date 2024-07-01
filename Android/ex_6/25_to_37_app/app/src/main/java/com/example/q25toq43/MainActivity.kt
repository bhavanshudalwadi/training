package com.example.q25toq43

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.q25toq43.Activities.q25
import com.example.q25toq43.Activities.q26
import com.example.q25toq43.Activities.q27
import com.example.q25toq43.Activities.q28
import com.example.q25toq43.Activities.q29
import com.example.q25toq43.Activities.q30
import com.example.q25toq43.Activities.q31
import com.example.q25toq43.Activities.q32
import com.example.q25toq43.Activities.q33
import com.example.q25toq43.Activities.q34
import com.example.q25toq43.Activities.q35
import com.example.q25toq43.Activities.q36
import com.example.q25toq43.Activities.q37
import com.example.q25toq43.Adapter.ActivityAdapter
import com.example.q25toq43.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ActivityAdapter.OnItemClickListener {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activitiesList = arrayListOf<Class<*>>(
            q25::class.java,
            q26::class.java,
            q27::class.java,
            q28::class.java,
            q29::class.java,
            q30::class.java,
            q31::class.java,
            q32::class.java,
            q33::class.java,
            q34::class.java,
            q35::class.java,
            q36::class.java,
            q37::class.java
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycle_view = binding.recyclerView

        recycle_view.layoutManager = LinearLayoutManager(this)

        val adapter = ActivityAdapter(this, activitiesList,this)
        recycle_view.adapter = adapter




    }
    override fun onItemClick(activityClass: Class<*>) {
        // Handle item click here
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}