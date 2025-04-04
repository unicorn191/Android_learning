package com.example.animatedsplashscreen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val Ibutton: Button = findViewById(R.id.Ibutton)
        val Ebutton: Button = findViewById(R.id.Ebutton)
        val url = "https://google.com"

        Ebutton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }

        Ibutton.setOnClickListener {
            val intent2 = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent2)
        }
    }
}