package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            finish()
        },3200)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.animation)
        imageView.startAnimation(fadeInAnimation)

    }



}