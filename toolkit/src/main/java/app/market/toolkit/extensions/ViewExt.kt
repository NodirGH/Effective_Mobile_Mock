package app.market.toolkit.extensions

import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator

fun View.hideAnimWithSlideDown(duration: Long = 300, endAction: () -> Unit = {}) {
    if (isVisible()) {
        animate()
            .alpha(0.5f)
            .translationY(height.toFloat())
            .withEndAction {
                hide()
                endAction()
            }
            .setInterpolator(AccelerateInterpolator())
            .setDuration(duration)
            .start()
    } else {
        endAction()
    }
}

fun View.showAnimWithSlideUp(duration: Long = 300, endAction: () -> Unit = {}) {
    if (isNotVisible()) {
        show()
        this.doOnPreDraw {
            translationY = height.toFloat()
            alpha = 0.5f
            animate()
                .alpha(1f)
                .translationY(0f)
                .withEndAction(endAction)
                .setInterpolator(DecelerateInterpolator())
                .setDuration(duration)
                .start()
        }
    } else {
        endAction()
    }
}

fun View.isNotVisible(): Boolean {
    return this.visibility != (View.VISIBLE)
}

fun View.show() {
    this.visibility = (View.VISIBLE)
}

fun View.doOnPreDraw(callback: () -> Unit) {
    viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
        override fun onPreDraw(): Boolean {
            viewTreeObserver.removeOnPreDrawListener(this)
            callback.invoke()
            return true
        }
    })
}

fun View.isVisible(): Boolean {
    return this.visibility == (View.VISIBLE)
}

fun View.hide(): View {
    this.visibility = (View.GONE)
    return this
}