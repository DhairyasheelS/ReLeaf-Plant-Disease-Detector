package com.example.myapplication

import android.Manifest
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Bundle
import android.provider.MediaStore
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.io.IOException
import android.view.animation.AnimationUtils

class MainActivity : AppCompatActivity() {
    private lateinit var mClassifier: Classifier
    private lateinit var mBitmap: Bitmap

    private val mCameraRequestCode = 0
    private val mGalleryRequestCode = 2

    private val mInputSize = 224
    private val mModelPath = "plant_disease_model.tflite"
    private val mLabelPath = "plant_labels.txt"
    private val mSamplePath = "soybean.JPG"

    private lateinit var mPhotoImageView: ImageView
    private lateinit var mCameraButton: Button
    private lateinit var mGalleryButton: Button
    private lateinit var mDetectButton: Button
    private lateinit var mResultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        setContentView(R.layout.activity_main)

        mPhotoImageView = findViewById(R.id.mPhotoImageView)
        mCameraButton = findViewById(R.id.mCameraButton)
        mGalleryButton = findViewById(R.id.mGalleryButton)
        mDetectButton = findViewById(R.id.mDetectButton)
        mResultTextView = findViewById(R.id.mResultTextView)

//        val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.button_bounce)
//        mCameraButton.startAnimation(bounceAnimation)
//        mGalleryButton.startAnimation(bounceAnimation)
//        mDetectButton.startAnimation(bounceAnimation)
//        val imageView = findViewById<ImageView>(R.id.imageView2)
//        val imageView1 = findViewById<ImageView>(R.id.imageView6)
//        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.animation)
//        imageView.startAnimation(fadeInAnimation)
//        imageView1.startAnimation(fadeInAnimation)


        mClassifier = Classifier(assets, mModelPath, mLabelPath, mInputSize)

        // Load the sample image
        try {
            resources.assets.open(mSamplePath).use {
                mBitmap = BitmapFactory.decodeStream(it)
                mBitmap = scaleImage(mBitmap)
                mPhotoImageView.setImageBitmap(mBitmap)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        mCameraButton.setOnClickListener {
            if (isCameraPermissionGranted()) {
                showToast("Camera permission is granted!")
                takePhoto()
            } else {
                requestCameraPermission()
            }
        }

        mGalleryButton.setOnClickListener {
            val callGalleryIntent = Intent(Intent.ACTION_PICK)
            callGalleryIntent.type = "image/*"
            startActivityForResult(callGalleryIntent, mGalleryRequestCode)
        }

        mDetectButton.setOnClickListener {
            // Run the detection on a background thread using Coroutines
            CoroutineScope(Dispatchers.IO).launch {
                val results = mClassifier.recognizeImage(mBitmap).firstOrNull()
                runOnUiThread {
                    mResultTextView.text = results?.title + "\n Accuracy:" + (results?.confidence?.times(100))


                    val byteArrayOutputStream = ByteArrayOutputStream()
                    mBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
                    val byteArray = byteArrayOutputStream.toByteArray()
                    // Create an intent to start the CommonRemedies activity
                    val intent = Intent(this@MainActivity, CommonRemedies::class.java)
                    // Pass the result as an extra with a key ("text")
                    intent.putExtra("text", mResultTextView.text.toString())
                    intent.putExtra("image", byteArray)
                    startActivity(intent)
                }
            }
        }
    }



    private fun isCameraPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestCameraPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CAMERA),
            mCameraRequestCode
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == mCameraRequestCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showToast("Camera permission granted!")
                takePhoto()
            } else {
                showToast("Camera permission denied.")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun takePhoto() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, mCameraRequestCode)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == mCameraRequestCode){
            if(resultCode == RESULT_OK && data != null) {
                mBitmap = data.extras!!.get("data") as Bitmap
                mBitmap = scaleImage(mBitmap)
                val toast = Toast.makeText(this, ("Image crop to: w= ${mBitmap.width} h= ${mBitmap.height}"), Toast.LENGTH_LONG)
                toast.setGravity(Gravity.BOTTOM, 0, 20)
                toast.show()
                mPhotoImageView.setImageBitmap(mBitmap)
                mResultTextView.text= "Your photo image set now."
            } else {
                Toast.makeText(this, "Camera cancel..", Toast.LENGTH_LONG).show()
            }
        } else if(requestCode == mGalleryRequestCode) {
            if (data != null) {
                val uri = data.data

                try {
                    mBitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                println("Success!!!")
                mBitmap = scaleImage(mBitmap)
                mPhotoImageView.setImageBitmap(mBitmap)

            }
        } else {
            Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_LONG).show()

        }
    }

    private fun scaleImage(bitmap: Bitmap?): Bitmap {
        val orignalWidth = bitmap!!.width
        val originalHeight = bitmap.height
        val scaleWidth = mInputSize.toFloat() / orignalWidth
        val scaleHeight = mInputSize.toFloat() / originalHeight
        val matrix = Matrix()
        matrix.postScale(scaleWidth, scaleHeight)
        return Bitmap.createBitmap(bitmap, 0, 0, orignalWidth, originalHeight, matrix, true)
    }

}

private fun Intent.putExtra(s: String, mResultTextView: TextView?) {

}

