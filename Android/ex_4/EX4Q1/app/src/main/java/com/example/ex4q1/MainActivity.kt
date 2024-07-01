package com.example.ex4q1

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.Messenger
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // declaring objects of Button class
    private var start: Button? = null
    private var stop: Button? = null
    private var btnBind: Button? = null
    private var ivUnBind: ImageView? = null

    /** Messenger for communicating with the service.  */
    private var mService: Messenger? = null

    /** Flag indicating whether we have called bind on the service.  */
    private var bound: Boolean = false

    private val mConnection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            // This is called when the connection with the service has been
            // established, giving us the object we can use to
            // interact with the service.  We are communicating with the
            // service using a Messenger, so here we get a client-side
            // representation of that from the raw IBinder object.
            mService = Messenger(service)
            bound = true
            Log.d("TAG", "onServiceConnected")
        }

        override fun onServiceDisconnected(className: ComponentName) {
            // This is called when the connection with the service has been
            // unexpectedly disconnected&mdash;that is, its process crashed.
            mService = null
            bound = false
            Log.d("TAG", "onServiceDisconnected")
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // assigning ID of startButton
        // to the object start
        start = findViewById<View>(R.id.startButton) as Button

        // assigning ID of startButton
        // to the object start
        btnBind = findViewById<Button>(R.id.btnBindService) as Button

        // assigning ID of stopButton
        // to the object stop
        stop = findViewById<View>(R.id.stopButton) as Button

        // assigning ID of stopButton
        // to the object stop
        ivUnBind = findViewById<ImageView>(R.id.ivUnbindService) as ImageView

        // declaring listeners for the
        // buttons to make them respond
        // correctly according to the process
        start!!.setOnClickListener(this)
        stop!!.setOnClickListener(this)

        btnBind!!.setOnClickListener {
            Log.d("TAG", "Bind Service")
            if(!bound) {
                bindService(Intent(this, MyService::class.java), mConnection, Context.BIND_AUTO_CREATE)
                bound = true
            }
        }

        ivUnBind!!.setOnClickListener {
            Log.d("TAG", "Unbind Service")
            if (bound) {
                unbindService(mConnection)
                bound = false
            }
        }
    }

    override fun onClick(view: View) {
        // process to be performed
        // if start button is clicked
        if (view === start) {
            // starting the service
//            startService(Intent(this, MyService::class.java))
//            startService(Intent(this, MyService::class.java))

            // Bind to the service.
            if(!bound) {
                bindService(Intent(this, MyService::class.java), mConnection, Context.BIND_AUTO_CREATE)
                bound = true
            }
            Log.d("TAG", "Service is started")
        }

        // process to be performed
        // if stop button is clicked
        else if (view === stop) {
            // stopping the service
//            stopService(Intent(this, MyService::class.java))
//            stopService(Intent(this, MyService::class.java))

            // Unbind from the service.
            if (bound) {
                unbindService(mConnection)
                bound = false
            }
            Log.d("TAG", "Service is stoped")
        }
    }
}