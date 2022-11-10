package com.example.myapplication.widget

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
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
    private var defStrokeWidth = 10F
    private var strokeWidth = defStrokeWidth
    private var defRadius = 5F
    private var radius = defRadius
    private val paint = Paint().also {
        it.color = Color.BLACK
        it.isAntiAlias = true
//        it.strokeWidth = 2F
//        it.strokeCap = Paint.Cap.SQUARE
    }
    private val camera = Camera()
    private var recWidth = 0F
    private var recHeight = 0F
    private var bitmap: Bitmap? = null
    private var drawable: Drawable? = null
    private var picX: Float = 0F
    private var picY: Float = 0F
    private var picWidth: Float = 0F
    private var picHeight: Float = 0F

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        getContext().obtainStyledAttributes(attrs, R.styleable.DoorView).also {
            radius = it.getDimension(R.styleable.DoorView_recRadius, defRadius)
            strokeWidth = it.getDimension(R.styleable.DoorView_strokeWidth, defStrokeWidth)
            picWidth = it.getDimension(R.styleable.DoorView_picWidth, 0F)
            picHeight = it.getDimension(R.styleable.DoorView_picHeight, 0F)
            recHeight = it.getDimension(R.styleable.DoorView_recHeight, 0F)
            recWidth = it.getDimension(R.styleable.DoorView_recWidth, 0F)
            val id = it.getResourceId(R.styleable.DoorView_pic, 0)
            if (id != 0) {
                bitmap = AppCompatResources.getDrawable(context, id)
                    ?.toBitmap(picWidth.toInt(), picHeight.toInt())
            }
            picX = it.getDimension(R.styleable.DoorView_picX, 0F)
            picY = it.getDimension(R.styleable.DoorView_picY, 0F)
            it.recycle()
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
        canvas.drawARGB(255, 255, 0, 0)
//        drawStart(canvas)
        drawStart2(canvas)
    }

    private var degress = 0F

    private fun drawStart(canvas: Canvas) {

        //左边外矩形
//        canvas.drawRect(
//            0F,
//            0F,
//            width / 2F,
//            height.toFloat(),
//            paint
//        )
        canvas.drawRoundRect(
            width / 2F - recWidth,
            height.toFloat() / 2 - recHeight / 2,
            width / 2F,
            height.toFloat() / 2 - recHeight / 2 + recHeight,
            radius,
            radius,
            paint
        )
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        //左边内矩形
        canvas.drawRect(
            width / 2F - recWidth + strokeWidth,
            height.toFloat() / 2 - recHeight / 2 + strokeWidth,
            width / 2F - strokeWidth,
            height.toFloat() / 2 - recHeight / 2 + recHeight - strokeWidth,
            paint
        )
        paint.xfermode = null

        canvas.save()
        canvas.translate(width / 2F, height / 2F)
        camera.save()
        camera.rotateY(degress)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.translate(-width / 2F, -height / 2F)
        //右边外矩形
//        canvas.drawRect(
//            leftSide,
//            topSide,
//            rightSide,
//            bottomSide,
//            paint
//        )
        canvas.drawRoundRect(
            width / 2F,
            height.toFloat() / 2 - recHeight / 2 + strokeWidth,
            width / 2F + recWidth - strokeWidth,
            height.toFloat() / 2 - recHeight / 2 + recHeight - strokeWidth,
            radius,
            radius,
            paint
        )
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        //右边内矩形
        canvas.drawRect(
            width / 2F + strokeWidth,
            height.toFloat() / 2 - recHeight / 2 + strokeWidth + strokeWidth,
            width / 2F + recWidth - strokeWidth - strokeWidth,
            height.toFloat() / 2 - recHeight / 2 + recHeight - strokeWidth - strokeWidth,
            paint
        )
        paint.xfermode = null
        bitmap?.also {
            canvas.drawBitmap(it, picX, picY, paint)
        }
        canvas.restore()
    }

    private fun drawStart2(canvas: Canvas) {
//        canvas.translate(width / 2F, 0F)
//        canvas.save()
//        canvas.translate(width / 2F, height / 2F)
//        canvas.translate(width.toFloat(), height.toFloat())
//        canvas.translate(width.toFloat(), height / 2F)
//        canvas.translate(width.toFloat(), 0F)
//        canvas.translate(width / 2F, height.toFloat())
//        canvas.translate(width / 2F, height / 2F)
//        canvas.translate(width / 2F, 0F)
//        camera.save()
//        camera.rotateX(30F)
//        camera.applyToCanvas(canvas)
//        camera.restore()
//        canvas.translate(-width / 2F, -height / 2F)
//        canvas.translate(-width.toFloat(), -height.toFloat())
//        canvas.translate(-width.toFloat(), -height / 2F)
//        canvas.translate(-width.toFloat(), 0F)
//        canvas.translate(-width / 2F, -height.toFloat())
//        canvas.translate(-width / 2F, -height / 2F)
//        canvas.translate(-width / 2F, 0F)
//        canvas.restore()
        //左边外矩形
//        canvas.drawRect(
//            0F,
//            0F,
//            width / 2F,
//            height.toFloat(),
//            paint
//        )

        canvas.drawRoundRect(
            width / 2F - recWidth,
            height.toFloat() / 2 - recHeight / 2,
            width / 2F,
            height.toFloat() / 2 - recHeight / 2 + recHeight,
            radius,
            radius,
            paint
        )
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        //左边内矩形
        canvas.drawRect(
            width / 2F - recWidth + strokeWidth,
            height.toFloat() / 2 - recHeight / 2 + strokeWidth,
            width / 2F - strokeWidth,
            height.toFloat() / 2 - recHeight / 2 + recHeight - strokeWidth,
            paint
        )
        paint.xfermode = null

//        canvas.save()
        canvas.translate(width / 2F, height / 2F)
        camera.save()
        camera.setLocation(0F,0F,-20F)
        camera.rotateY(degress)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.translate(-width / 2F, -height / 2F)
        //右边外矩形
//        canvas.drawRect(
//            leftSide,
//            topSide,
//            rightSide,
//            bottomSide,
//            paint
//        )
        canvas.drawRoundRect(
            width / 2F,
            height.toFloat() / 2 - recHeight / 2 + strokeWidth,
            width / 2F + recWidth - strokeWidth,
            height.toFloat() / 2 - recHeight / 2 + recHeight - strokeWidth,
            radius,
            radius,
            paint
        )
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        //右边内矩形
        canvas.drawRect(
            width / 2F + strokeWidth,
            height.toFloat() / 2 - recHeight / 2 + strokeWidth + strokeWidth,
            width / 2F + recWidth - strokeWidth - strokeWidth,
            height.toFloat() / 2 - recHeight / 2 + recHeight - strokeWidth - strokeWidth,
            paint
        )
        paint.xfermode = null
        bitmap?.also {
            canvas.drawBitmap(it, picX, picY, paint)
        }
//        canvas.restore()
//        canvas.save()
//        canvas.translate(width / 2F, height / 2F)
//        camera.save()
//        camera.rotateX(30F)
//        camera.applyToCanvas(canvas)
//        camera.restore()
//        canvas.translate(-width / 2F, -height / 2F)
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


    private var runnable = object : Runnable {
        override fun run() {
            degress--
            if (degress >= -180) {
                invalidate()
                postDelayed(this, 20)
            } else {
                postDelayed(this, 2000)
                degress = 0F
            }
        }
    }

    fun startCloseDoor() {
        closing = true
        post(runnable)
    }

    var closing: Boolean = false
        private set

    fun stopCloseDoor(reset: Boolean = false) {
        closing = false
        removeCallbacks(runnable)
        if (reset) {
            degress = 0F
            invalidate()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        stopCloseDoor()
    }
}