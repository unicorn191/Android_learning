package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var bmi_index:TextView
    private lateinit var result_description:TextView
    private lateinit var info:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight_txt:EditText = findViewById(R.id.et_weight)
        val height_txt:EditText = findViewById(R.id.et_height)
        val calculate_btn:Button = findViewById(R.id.button)

        calculate_btn.setOnClickListener {
            val weight = weight_txt.text.toString()
            val height = height_txt.text.toString()
            if(validateInput(weight, height)){
                val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))
                // get result with two decimal places
                val bmi2Digits = String.format("%.2f", bmi).toFloat()
                displayResult(bmi2Digits)
            }
        }
    }

    private fun validateInput(weight:String?, height:String?):Boolean{

        return when{

            weight.isNullOrEmpty() ->{
                bmi_index.text = ""
                result_description.text =""
                info.text =""

                Toast.makeText(this,"Please enter weight.",Toast.LENGTH_SHORT).show()
                return false
            }
            height.isNullOrEmpty() ->{
                bmi_index.text = ""
                result_description.text =""
                info.text =""

                Toast.makeText(this,"Please enter height.",Toast.LENGTH_SHORT).show()
                return false
            }
            else ->{
                return true
            }
        }
    }

    private fun displayResult(bmi:Float){

        bmi_index = findViewById(R.id.tv_bmi)
        result_description = findViewById(R.id.tv_status)
        info = findViewById(R.id.textView6)

        bmi_index.text = bmi.toString()
        info.text = "(Normal range is 18.5 - 24.9 )"

        var result_txt = ""
        var color = 0

        when{
            bmi < 18.50 ->{
                result_txt = "Underweight"
                color = R.color.under_weight
            }
            bmi in 18.50..24.99 ->{
                result_txt = "Healthy"
                color = R.color.normal_weight
            }
            bmi in 25.00..29.99->{
                result_txt = "Overweight"
                color = R.color.over_weight
            }
            bmi > 29.99 -> {
                result_txt ="Obese"
                color = R.color.obese
            }
        }
        result_description.text = result_txt
        result_description.setTextColor(ContextCompat.getColor(this,color))
    }
}