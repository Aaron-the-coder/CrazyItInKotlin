package com.dale.simpleimageviewer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dale.simpleimageviewer.widget.DrawView
import kotlinx.android.synthetic.main.activity_ball.*

class BallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ball)
        val ball = DrawView(this)
        ball.minimumWidth = 300
        ball.minimumHeight = 500
        ll_ball_container.addView(ball)
    }
}
