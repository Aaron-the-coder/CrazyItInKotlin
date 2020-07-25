package com.dale.surfaceviewdemo

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class SurfaceViewTemplate : SurfaceView, Drawable.Callback, Runnable, SurfaceHolder.Callback {
    private lateinit var mPaint: Paint
    private lateinit var mHolder: SurfaceHolder

    /**
     * 与SurfaceHolder绑定的Canvas
     */
    private lateinit var mCanvas: Canvas
    private var currIndex: Int = 0
    val images = intArrayOf(
        R.drawable.image0,
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4
    )
    /**
     * 用于绘制的线程
     */
    private lateinit var t: Thread
    /**
     * 线程的控制开关
     */
    private var isRunning = false;

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mHolder = getHolder();
        mHolder.addCallback(this);
        mPaint = Paint()

        // setZOrderOnTop(true);// 设置画布 背景透明
        // mHolder.setFormat(PixelFormat.TRANSLUCENT);

        //设置可获得焦点
        setFocusable(true);
        setFocusableInTouchMode(true);
        //设置常亮
        this.setKeepScreenOn(true);

    }

    override fun surfaceCreated(p0: SurfaceHolder?) {
        // 开启线程
        isRunning = true;
        t = Thread(this);
        t.start();
    }

    override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {

    }

    override fun surfaceDestroyed(p0: SurfaceHolder?) {
        // 通知关闭线程
        isRunning = false;
    }

    override fun run() {
        // 不断的进行draw
        while (isRunning) {
            draw()
        }
    }

    private fun draw() {
        try {
            // 获得canvas
            mCanvas = mHolder.lockCanvas();
            mCanvas.drawBitmap(
                BitmapFactory.decodeResource(
                    context.resources,
                    images[++currIndex % images.size]
                ), 0F, 0F, mPaint
            )
        } catch (e: Exception) {
        } finally {
            mHolder.unlockCanvasAndPost(mCanvas);
        }

    }
}