package com.dale.simpleimageviewer.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class DrawView : View {
    val paint = Paint()
    var currX = 40F
    var currY = 50F
    constructor(context: Context):super(context)
    constructor(context: Context, attibutes : AttributeSet) : super(context, attibutes)

    override fun onDraw(canvas: Canvas) {
        paint.color = Color.RED
        canvas.drawCircle(currX, currY, 50F, paint)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        currX = event.x
        currY = event.y
        invalidate()
        return true
    }
}