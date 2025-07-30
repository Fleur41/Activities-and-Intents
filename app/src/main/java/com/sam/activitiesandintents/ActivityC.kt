package com.sam.activitiesandintents

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class ActivityC : AppCompatActivity() {
    lateinit var launchActivityB: Button
    lateinit var launchActivityC: Button
    lateinit var launchActivityD: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        launchActivityB = findViewById(R.id.launchActivityB)
        launchActivityC = findViewById(R.id.launchActivityC)
        launchActivityD = findViewById(R.id.launchActivityD)

        val number = intent.getIntExtra("number", 0)
        Toast.makeText(this, "Number: $number", Toast.LENGTH_SHORT).show()

        launchActivityB.setOnClickListener {
            val intent = Intent(this, ActivityB::class.java)
            startActivity(intent)
        }

        launchActivityC.setOnClickListener {
            val intent = Intent(this, ActivityC::class.java).apply {
                putExtra("number", Random.nextInt(11, 20))
            }
            startActivity(intent)
        }

        launchActivityD.setOnClickListener {
            val intent = Intent(this, ActivityD::class.java)
            startActivity(intent)
        }
    }
        override fun onNewIntent(intent: Intent){
            super.onNewIntent(intent)
            val number = intent.getIntExtra("number", 0)
            Toast.makeText(this, "Number from onNewIntent: $number", Toast.LENGTH_SHORT).show()
        }

}