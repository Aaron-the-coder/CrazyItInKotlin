package com.dale.simpleimageviewer

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val images = intArrayOf(R.drawable.image0, R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4)
    var curr = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imgview = ImageView(this)
        ll_container.addView(imgview)
        imgview.setImageResource(images[0])
        imgview.setOnClickListener { imgview.setImageResource(images[++curr % images.size]) }
    }
}
