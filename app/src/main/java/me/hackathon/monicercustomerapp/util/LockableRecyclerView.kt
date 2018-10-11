package me.hackathon.monicercustomerapp.util

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView
import com.sothree.slidinguppanel.SlidingUpPanelLayout

class LockableRecyclerView : RecyclerView {
  var isScrollable = true
    private set
  var slideLayout: SlidingUpPanelLayout? = null

  constructor(context: Context) : super(context) {}

  constructor(
    context: Context,
    attrs: AttributeSet
  ) : super(context, attrs) {
  }

  constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int
  ) : super(context, attrs, defStyleAttr) {
  }

  fun setScrollingEnabled(enabled: Boolean) {
    isScrollable = enabled
  }

  override fun onTouchEvent(ev: MotionEvent): Boolean {
//    if (ev.action == MotionEvent.ACTION_UP) {
//      slideLayout!!.onTouchEvent(ev)
//    }
    when (ev.action) {
      MotionEvent.ACTION_DOWN ->
        // if we can scroll pass the event to the superclass
        return isScrollable && super.onTouchEvent(ev)
      else -> return super.onTouchEvent(ev)
    }
  }

  override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
    // Don't do anything with intercepted touch events if
    // we are not scrollable
    return isScrollable && super.onInterceptTouchEvent(ev)
  }

}