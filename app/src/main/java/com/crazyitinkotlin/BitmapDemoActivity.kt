package com.crazyitinkotlin

import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dale.crazyitinkotlin.R
import kotlinx.android.synthetic.main.activity_bitmap_demo.*

class BitmapDemoActivity : AppCompatActivity() {

    private lateinit var images : Array<String>
    private var currindex:Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmap_demo)
        images = assets.list("")
        btn_next.setOnClickListener {
            currindex = (currindex+1)%images.size
            while (!images[currindex].endsWith("jpg") && !images[currindex].endsWith("png")){
                currindex = (currindex+1)%images.size
            }
            val image = assets.open(images[currindex])
            val bitmapDrawable = iv_demo.drawable as BitmapDrawable
            if (bitmapDrawable != null && !bitmapDrawable.bitmap.isRecycled){
                bitmapDrawable.bitmap.recycle()
            }
            iv_demo.setImageBitmap(BitmapFactory.decodeStream(image))
        }
    }
}
