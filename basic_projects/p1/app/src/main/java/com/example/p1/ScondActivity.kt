package com.example.p1

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scond)
        Log.i("MYTAg","ScondActivity:onCreate()")
        val msgtxt = findViewById<TextView>(R.id.textView2)

        val bundle_sg = intent.getStringExtra("userName")
      // val msg= bundle?.getString("userName").toString()
        msgtxt.text = "Welcome to the second Activity $bundle_sg"
    }

    override fun onStart() {
        super.onStart()
        Log.i("MYTAg","ScondActivity:onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MYTAg","ScondActivity:onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MYTAg","ScondActivity:onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MYTAg","ScondActivity:onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MYTAg","ScondActivity:onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MYTAg","ScondActivity:onRestart()")
    }
}