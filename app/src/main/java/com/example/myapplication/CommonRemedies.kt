package com.example.myapplication

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class CommonRemedies : AppCompatActivity() {
    private lateinit var resTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var  textview2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common_remedies)
        resTextView = findViewById(R.id.resultText)
        imageView = findViewById(R.id.imageView4)
        textview2 = findViewById(R.id.textView4)

        // Retrieve the result from the intent extras
        val resultText = intent.getStringExtra("text")
        resTextView.text = resultText

        if (resultText != null) {
            if (resultText.contains("potato late blight",ignoreCase=true) ) {
                Log.d("if", "enter if ")
                val remedies =
                        "1)	Remove volunteers from the garden prior to planting and space plants far enough apart to allow for plenty of air circulation.\n"+"\n"+
                        "2)	Apply a copper based fungicide (2 oz/ gallon of water) every 7 days \n or less, following heavy rain or when the amount of disease is increasing rapidly.\n"+"\n"+
                        "3)If possible , time applications so that at least 12 hours of dry weather follows application."

                textview2.text = remedies
            }

        }

        val imageByteArray = intent.getByteArrayExtra("image")

        // Convert the byte array back to a bitmap
        if (imageByteArray != null) {
            val originalBitmap = BitmapFactory.decodeByteArray(imageByteArray, 0, imageByteArray.size)

            // Define a scaling factor (e.g., 2.0 for doubling the size)
            val scalingFactor = 4.0

            // Calculate the new width and height
            val newWidth = (originalBitmap.width * scalingFactor).toInt()
            val newHeight = (originalBitmap.height * scalingFactor).toInt()

            // Create a scaled bitmap
            val scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true)

            // Set the scaled bitmap to the ImageView
            imageView.setImageBitmap(scaledBitmap)
        }
    }
}