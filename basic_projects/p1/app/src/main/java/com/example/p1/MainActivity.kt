package com.example.p1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MYTAg","MainActivity:onCreate()")

        val txtView = findViewById<TextView>(R.id.textView)
        val edtext = findViewById<EditText>(R.id.editTextText)
        val submitbtn = findViewById<Button>(R.id.button)
        val offersbtn = findViewById<Button>(R.id.button2)
        var input = " "

        submitbtn.setOnClickListener {
            input  = edtext.text.toString()
            if(input == ""){
                txtView.text = ""
                offersbtn.visibility = INVISIBLE
                Toast.makeText(this,"Enter name",Toast.LENGTH_SHORT).show()
            }else{
                txtView.text = "Hello $input"
                edtext.text.clear()
                offersbtn.visibility = VISIBLE
            }
            offersbtn.setOnClickListener {
                val intent = Intent(this, ScondActivity::class.java)
                intent.putExtra("userName",input)
                startActivity(intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("MYTAg","MainActivity:onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MYTAg","MainActivity:onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MYTAg","MainActivity:onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MYTAg","MainActivity:onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MYTAg","MainActivity:onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MYTAg","MainActivity:onRestart()")
    }
}