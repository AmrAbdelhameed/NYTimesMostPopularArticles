package com.example.nytimesmostpopulararticles_mvvm_kotlin.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.example.nytimesmostpopulararticles_mvvm_kotlin.R

object ViewUtils {
    fun changeIconDrawableToGray(
        context: Context?,
        drawable: Drawable?
    ) {
        if (drawable != null) {
            drawable.mutate()
            drawable.setColorFilter(
                ContextCompat.getColor(context!!, R.color.dark_gray),
                PorterDuff.Mode.SRC_ATOP
            )
        }
    }

    fun dpToPx(dp: Float): Int {
        val density =
            Resources.getSystem().displayMetrics.density
        return Math.round(dp * density)
    }

    fun pxToDp(px: Float): Float {
        val densityDpi =
            Resources.getSystem().displayMetrics.densityDpi.toFloat()
        return px / (densityDpi / 160f)
    }
}