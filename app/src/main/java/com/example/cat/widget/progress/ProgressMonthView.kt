package com.example.cat.widget.progress

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import com.haibin.calendarview.Calendar
import com.haibin.calendarview.MonthView
import java.lang.String
import kotlin.Boolean
import kotlin.Float
import kotlin.Int


class ProgressMonthView(context: Context) : MonthView(context) {
    private val mProgressPaint = Paint()
    private val mNoneProgressPaint = Paint()
    private var mRadius = 0

    init {
        mProgressPaint.isAntiAlias = true
        mProgressPaint.style = Paint.Style.STROKE
        mProgressPaint.strokeWidth = dipToPx(context, 2.2f).toFloat()
        mProgressPaint.color = -0x440ab600
        mNoneProgressPaint.isAntiAlias = true
        mNoneProgressPaint.style = Paint.Style.STROKE
        mNoneProgressPaint.strokeWidth = dipToPx(context, 2.2f).toFloat()
        mNoneProgressPaint.color = -0x6f303031
    }

    override fun onPreviewHook() {
        mRadius = Math.min(mItemWidth, mItemHeight) / 11 * 4
    }

    override fun onDrawSelected(
        canvas: Canvas,
        calendar: Calendar?,
        x: Int,
        y: Int,
        hasScheme: Boolean
    ): Boolean {
        val cx = x + mItemWidth / 2
        val cy = y + mItemHeight / 2
        canvas.drawCircle(cx.toFloat(), cy.toFloat(), mRadius.toFloat(), mSelectedPaint)
        return true
    }

    override fun onDrawScheme(canvas: Canvas, calendar: Calendar, x: Int, y: Int) {
        val cx = x + mItemWidth / 2
        val cy = y + mItemHeight / 2
        calendar.scheme
        if (calendar.scheme == "100") {
            val startX = (cx - mRadius).toFloat()
            val startY = (cy - mRadius).toFloat()
            val endX = (cx + mRadius).toFloat()
            val endY = (cy + mRadius).toFloat()
            canvas.drawLine(startX, startY, endX, endY, mProgressPaint)
            canvas.drawLine(startX, endY, endX, startY, mProgressPaint)
        } else {

            val angle = getAngle(calendar.getScheme().toInt())
            val progressRectF = RectF(
                (cx - mRadius).toFloat(),
                (cy - mRadius).toFloat(),
                (cx + mRadius).toFloat(),
                (cy + mRadius).toFloat()
            )
            canvas.drawArc(progressRectF, -90f, angle.toFloat(), false, mProgressPaint)
            val noneRectF = RectF(
                (cx - mRadius).toFloat(),
                (cy - mRadius).toFloat(),
                (cx + mRadius).toFloat(),
                (cy + mRadius).toFloat()
            )
            canvas.drawArc(
                noneRectF,
                (angle - 90).toFloat(),
                (360 - angle).toFloat(),
                false,
                mNoneProgressPaint
            )
        }


    }

    override fun onDrawText(
        canvas: Canvas,
        calendar: Calendar,
        x: Int,
        y: Int,
        hasScheme: Boolean,
        isSelected: Boolean
    ) {
        val baselineY = mTextBaseLine + y
        val cx = x + mItemWidth / 2
        if (isSelected) {
            canvas.drawText(
                String.valueOf(calendar.getDay()),
                cx.toFloat(),
                baselineY,
                mSelectTextPaint
            )
        } else if (hasScheme) {
            canvas.drawText(
                String.valueOf(calendar.getDay()),
                cx.toFloat(),
                baselineY,
                if (calendar.isCurrentDay()) mCurDayTextPaint else if (calendar.isCurrentMonth()) mSchemeTextPaint else mOtherMonthTextPaint
            )
        } else {
            canvas.drawText(
                String.valueOf(calendar.getDay()), cx.toFloat(), baselineY,
                if (calendar.isCurrentDay()) mCurDayTextPaint else if (calendar.isCurrentMonth()) mCurMonthTextPaint else mOtherMonthTextPaint
            )
        }
    }

    companion object {
        /**
         * 获取角度
         *
         * @param progress 进度
         * @return 获取角度
         */
        private fun getAngle(progress: Int): Int {
            return (progress * 3.6).toInt()
        }

        /**
         * dp转px
         *
         * @param context context
         * @param dpValue dp
         * @return px
         */
        private fun dipToPx(context: Context, dpValue: Float): Int {
            val scale = context.resources.displayMetrics.density
            return (dpValue * scale + 0.5f).toInt()
        }
    }
}