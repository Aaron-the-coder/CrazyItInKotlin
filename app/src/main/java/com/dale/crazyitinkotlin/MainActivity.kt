package com.dale.crazyitinkotlin

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 创建一个线性布局
        val ll = LinearLayout(this)
        // 给activity添加该布局
        super.setContentView(ll)
        // 设置线性布局的方向为纵向
        ll.orientation = LinearLayout.VERTICAL
        //创建textview和button
        val textView = TextView(this)
        val btn = Button(this)
        //给控件设置文本和宽高
        btn.text = getString(R.string.ok)
        textView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        btn.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        //向布局加入控件
        ll.addView(textView)
        ll.addView(btn)
        //设置点击事件
        btn.setOnClickListener {
            textView.text = "hello"
        }
    }
}
