package com.example.cat.widget
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.viewpager.widget.ViewPager

class NoScrollViewPager : ViewPager {
    constructor(context: Context) : super(context) {
        this.clipChildren = false
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        this.clipChildren = false
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return false
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return false
    }

    override fun setCurrentItem(item: Int) {
        super.setCurrentItem(item, false)
    }
}