package c.gingdev.present.Utils.etc

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import c.gingdev.present.R

fun Activity.statusBarTransparent() {
    window.apply {
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
        statusBarColor = Color.TRANSPARENT
    }
}

fun Activity.statusBarColor(@ColorRes color: Int) {
    window.apply {
        statusBarColor = resources.getColor(color)
    }
}

private fun Window.setWindowFlag(flag: Int, on: Boolean) {
    apply {
        if (on)
            attributes.flags = attributes.flags or flag
        else
            attributes.flags = attributes.flags and flag.inv()
    }
}

fun Activity.getStatusBarHeight(): Int {
    var result = 0
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0)
        result = resources.getDimensionPixelSize(resourceId)
    return result
}

fun Activity.checkBackgroundColor(view: View): Int {
    var color: Int
    if (colorChecker(view).isLight()) {
//            현제 밝음
        color = ContextCompat.getColor(this, R.color.colorBlack)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        else
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

    } else {
//            현재 어두움.
        color = ContextCompat.getColor(this, R.color.colorWhite)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or 0
        else
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }

    return color
}