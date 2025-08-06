package com.sam.activitiesandintents

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.os.Handler
import android.os.Looper


class LoggingService : Service() {
    val handler = Handler(Looper.getMainLooper())
    val runnable = Runnable {
        Log.d("TAG", "This log is printed from ${this::class.simpleName}")
//        There are two ways to stop a service: Method 1
        stopSelf()
    }
    override fun onCreate() {
        Log.d("TAG", "onCreate called in ${this::class.simpleName}")
        super.onCreate()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("TAG", "Intent is null: ${intent == null}")
//        For foreground service, we need to call startForeground()
        runnable.run()
        handler.postDelayed(runnable, 5000)
        return START_REDELIVER_INTENT
    }
    override fun onBind(intent: Intent): IBinder? {
       return null
    }

    override fun onDestroy() {
        Log.d("TAG", "onDestroy called in ${this::class.simpleName}")
        super.onDestroy()
    }
}