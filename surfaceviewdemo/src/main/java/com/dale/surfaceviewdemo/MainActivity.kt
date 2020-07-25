package com.dale.surfaceviewdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

//    val images = listOf(
//        R.drawable.image0,
//        R.drawable.image1,
//        R.drawable.image2,
//        R.drawable.image3,
//        R.drawable.image4
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        banner.addBannerLifecycleObserver(this)//添加生命周期观察者
//            .setAdapter( ImageAdapter(images))
//            .setIndicator( CircleIndicator(this))
//            .start()
    }
}
