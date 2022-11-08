package com.example.myapplication.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.graphics.drawable.toBitmap
import com.example.myapplication.R

/**
 * @create zhl
 * @date 2022/11/7 17:45
 * @description
 *
 * @update
 * @date
 * @description
 **/
class DoorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {
    private var leftSide: Float = 0F
    private var topSide: Float = 0F
    private var rightSide: Float = 0F
    private var bottomSide: Float = 0F
    private var strokeWidth = 10F
    private var defRadius = 5F
    private var radius = 5F
    private val paint = Paint().also {
        it.color = Color.BLACK
//        it.strokeWidth = 2F
//        it.strokeCap = Paint.Cap.SQUARE
    }
    private var bitmap: Bitmap? = null

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        getContext().obtainStyledAttributes(attrs, R.styleable.DoorView).also {
            strokeWidth = it.getDimension(R.styleable.DoorView_recRadius, defRadius)
            val id = it.getResourceId(R.styleable.DoorView_pic, 0)
            if (id != 0) {
                bitmap = context.getDrawable(id)?.toBitmap()
            }
        }
//        leftSide = width / 2F
//        topSide = 0F
//        rightSide = width.toFloat()
//        bottomSide = height.toFloat()
//        Log.d(javaClass.simpleName, "$leftSide $topSide $rightSide $bottomSide")
    }

    override fun onDraw(canvas: Canvas) {
        Log.d(javaClass.simpleName, "onDraw")
//        super.onDraw(canvas)
//        canvas.drawARGB(255, 255, 0, 0)
        drawRec(canvas)
    }

    private fun drawRec(canvas: Canvas) {
        //左边外矩形
//        canvas.drawRect(
//            0F,
//            0F,
//            width / 2F,
//            height.toFloat(),
//            paint
//        )
        canvas.drawRoundRect(
            0F,
            0F,
            width / 2F,
            height.toFloat(),
            radius,
            radius,
            paint
        )
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        //左边内矩形
        canvas.drawRect(
            strokeWidth,
            strokeWidth,
            width / 2F - strokeWidth,
            height.toFloat() - strokeWidth,
            paint
        )
        paint.xfermode = null
        //右边外矩形
//        canvas.drawRect(
//            leftSide,
//            topSide,
//            rightSide,
//            bottomSide,
//            paint
//        )
        canvas.drawRoundRect(
            leftSide,
            topSide,
            rightSide,
            bottomSide,
            radius,
            radius,
            paint
        )
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        //右边内矩形
        canvas.drawRect(
            leftSide + strokeWidth,
            topSide + strokeWidth,
            rightSide - strokeWidth,
            bottomSide - strokeWidth,
            paint
        )
        paint.xfermode = null
        bitmap?.also {
            canvas.drawBitmap(it, 0F, 0F, paint)
        }

    }


    private fun initDefSide(width: Int, height: Int) {
        Log.d(javaClass.simpleName, "initDefSide w:$width h:$height")
        leftSide = width / 2F
        topSide = strokeWidth
        rightSide = width.toFloat() - strokeWidth
        bottomSide = height.toFloat() - strokeWidth
        Log.d(javaClass.simpleName, "initDefSide $leftSide $topSide $rightSide $bottomSide")
    }

//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        Log.d(javaClass.simpleName, "onMeasure $width $height")
//        val width = MeasureSpec.getSize(widthMeasureSpec)
//        val height = MeasureSpec.getSize(heightMeasureSpec)
//        Log.d(javaClass.simpleName, "onMeasure $width $height")
//        initDefSide(width, height)
//    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Log.d(javaClass.simpleName, "onSizeChanged w:$w h:$h oldw:$oldw oldh:$oldh")
        initDefSide(width, height)
    }
}