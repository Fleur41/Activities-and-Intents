package com.sam.activitiesandintents

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class ActivityB : AppCompatActivity() {
    lateinit var launchActivityB: Button
    lateinit var launchActivityC: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        launchActivityB = findViewById(R.id.launchActivityB)
        launchActivityC = findViewById(R.id.launchActivityC)

        launchActivityB.setOnClickListener {
            val intent = Intent(this, ActivityB::class.java)
            startActivity(intent)
        }

        launchActivityC.setOnClickListener {
            val intent = Intent(this, ActivityC::class.java).apply {
                putExtra("number", Random.nextInt(5, 10))
            }
            startActivity(intent)
        }
    }
}