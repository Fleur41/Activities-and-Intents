package com.sam.activitiesandintents

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.net.wifi.WifiManager
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import java.lang.reflect.Method
import kotlin.jvm.java


class MainActivity : ComponentActivity() {
    var counter: Int = 0
    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var startService: Button
    lateinit var launchActivityB: Button
    lateinit var launchBrowser: Button
    lateinit var wifiReceiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        launchActivityB = findViewById(R.id.launchActivityB)
        launchBrowser = findViewById(R.id.launchBrowser)
        startService = findViewById(R.id.startService)

        button.setOnClickListener {
            counter++
            textView.text = "Count: $counter"
        }

        launchActivityB.setOnClickListener {
            val intent = Intent(this, ActivityB::class.java)
            startActivity(intent)
        }


        launchBrowser.setOnClickListener {
            val url = "https://www.google.com"
            //method 1
            try {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(url)
                }
                startActivity(intent)
            } catch (e: Exception) {
//                TODO("Not yet implemented")
                Toast.makeText(this, "Failed to open webpage", Toast.LENGTH_SHORT).show()
            }

//            method 2
//            val intent = Intent(Intent.ACTION_VIEW).apply {
//                data = Uri.parse(url)
//            }
//            if (intent.resolveActivity(packageManager) != null) {
//                startActivity(intent)
//            }

        }
            wifiReceiver = WifiReceiver()
            this.registerReceiver(
                wifiReceiver,
                IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
            )
//        wifiReceiver = WifiReceiver()
//        val intentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
//        registerReceiver(wifiReceiver, intentFilter)
        ContextCompat.registerReceiver(
            this,
            wifiReceiver,
            IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION),
            ContextCompat.RECEIVER_EXPORTED
        )

//        LocalBroadcastManager.getInstance(this).sendBroadcast(Intent("Logout is done"))
//        LocalBroadcastManager.getInstance(this).registerReceiver()
        startService.setOnClickListener {
            val intent = Intent(this, LoggingService::class.java)
            startService(intent)
//            Method 2:
            stopService(intent)
            startForegroundService(intent)
        }
    }

    override fun onStart() {
        super.onStart()
    }



    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
        this.unregisterReceiver(
            wifiReceiver
        )
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val count = savedInstanceState.getInt("count")
        textView.text = "Count: $count"
    }
}

