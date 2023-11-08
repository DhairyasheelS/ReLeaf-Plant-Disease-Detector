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

        if (resultText == "potato late blight") {
            val remedies = "Remedies for potato late blight:\n" +
                    "1) Leaf curl can be controlled by applying sulfur or\n"
                    "copper-based fungicides that are labeled for use on"+
                    "peaches and nectarines.\n"+
                    " Spray the entire tree after 90% of the leaves have"+
                    "dropped in the fall and again in the early spring."
            textview2.text = remedies
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