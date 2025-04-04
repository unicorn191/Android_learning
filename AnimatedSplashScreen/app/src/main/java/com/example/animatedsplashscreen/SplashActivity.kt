package com.example.animatedsplashscreen

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat
import com.google.android.material.animation.AnimationUtils

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Load rotation animation
         val rotateAnimation = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.rotate)

        val splash_image:ImageView = findViewById(R.id.splash_image)
        splash_image.startAnimation(rotateAnimation)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)




    }
}