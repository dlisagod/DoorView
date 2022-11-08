package com.example.myapplication.widget

import android.content.Context
import android.view.MotionEvent
import android.widget.TextView

/**
 * @create zhl
 * @date 2022/10/28 18:24
 * @description
 *
 * @update
 * @date
 * @description
 **/
class LineTextVIew(context: Context) : TextView(context) {

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }
}