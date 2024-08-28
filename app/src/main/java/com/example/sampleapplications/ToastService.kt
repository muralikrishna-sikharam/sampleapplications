package com.example.sampleapplications

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class ToastService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(applicationContext, "Application is closed", Toast.LENGTH_LONG).show()
        stopSelf()  // Stop the service after showing the toast
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
