package com.example.e_motorcycle

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

class PartialCircleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = ContextCompat.getColor(context, R.color.cardBackground) // Set your color
    }
    private var progress = 1.0f // Full circle by default

    fun setProgress(progress: Float) {
        this.progress = progress
        invalidate() // Request to redraw the view
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val path = Path()
        val radius = width / 2f
        path.moveTo(radius, radius)
        path.addArc(0f, 0f, width.toFloat(), height.toFloat(), -90f, 360 * progress)
        path.lineTo(radius, radius)
        path.close()
        canvas.drawPath(path, paint)
    }
}