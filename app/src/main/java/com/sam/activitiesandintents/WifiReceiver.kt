package com.sam.activitiesandintents

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.util.Log
import android.widget.Toast

class WifiReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if (action == WifiManager.WIFI_STATE_CHANGED_ACTION){
            val wifiState: Int = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN)
            if (wifiState == WifiManager.WIFI_STATE_ENABLED){
                Log.d("TAG", "Wifi is enabled")
                Toast.makeText(context, "Wifi is enabled", Toast.LENGTH_SHORT).show()
            } else if (wifiState == WifiManager.WIFI_STATE_DISABLED){
                Log.d("TAG", "Wifi is disabled")
                Toast.makeText(context, "Wifi is disabled", Toast.LENGTH_SHORT).show()
            }
        }
    }
}