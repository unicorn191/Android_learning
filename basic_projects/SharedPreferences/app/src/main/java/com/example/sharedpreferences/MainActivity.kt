package com.example.sharedpreferences

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var etName:EditText
    private lateinit var etAge:EditText
    private lateinit var sp:SharedPreferences
    private lateinit var editor: Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etText)
        etAge = findViewById(R.id.etAge)
        sp = getSharedPreferences("My_sp", MODE_PRIVATE)
        editor = sp.edit()
    }

    override fun onPause() {
        super.onPause()
        val name = etName.text.toString()
        val age = etAge.text.toString().toInt()
        editor.apply{
            putString("sf_name",name)
            putInt("sf_age",age)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        val name = sp.getString("sf_name",null)
        val age = sp.getInt("sf_age",0)
        etName.setText(name.toString())
        if(age != 0){
            etAge.setText(age.toString())
        }
    }



}