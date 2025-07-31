package com.sam.activitiesandintents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    var counter: Int = 0
    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var launchActivityB: Button
    lateinit var launchBrowser: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        launchActivityB = findViewById(R.id.launchActivityB)
        launchBrowser = findViewById(R.id.launchBrowser)

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
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}

