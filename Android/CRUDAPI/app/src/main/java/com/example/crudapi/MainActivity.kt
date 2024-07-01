package com.example.crudapi

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crudapi.databinding.ActivityMainBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BASE_URL = "https://bhavanshu.000webhostapp.com/"

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TransectionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestSmsPermission()

        adapter = TransectionAdapter(applicationContext, emptyList())
        binding.rvPaymentList.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvPaymentList.adapter = adapter

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create<PaymentsAPI>()

        lifecycleScope.launch {
            try {
                val response = api.getPayments()
                if (response.isSuccessful) {
                    val payments = response.body()!!

                    Log.d(TAG, payments.toString())

                    adapter.updateData(payments)
                } else {
                    Log.d(TAG, "Response unsuccessful: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching payments", e)
            }
        }
    }

    private fun requestSmsPermission() {
        val permission: String = android.Manifest.permission.RECEIVE_SMS
        val grant = ContextCompat.checkSelfPermission(this, permission)
        if (grant != PackageManager.PERMISSION_GRANTED) {
            val permission_list = arrayOfNulls<String>(1)
            permission_list[0] = permission
            ActivityCompat.requestPermissions(this, permission_list, 1)
        }
    }

    companion object {
        const val BASE_URL = "https://bhavanshu.000webhostapp.com/"
    }
}