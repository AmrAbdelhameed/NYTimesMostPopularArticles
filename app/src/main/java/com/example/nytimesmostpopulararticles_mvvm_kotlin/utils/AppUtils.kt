package com.example.nytimesmostpopulararticles_mvvm_kotlin.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.nytimesmostpopulararticles_mvvm_kotlin.R

object AppUtils {
    fun openPlayStoreForApp(context: Context) {
        val appPackageName = context.packageName
        try {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(
                        context
                            .resources
                            .getString(R.string.app_market_link) + appPackageName
                    )
                )
            )
        } catch (e: ActivityNotFoundException) {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(
                        context
                            .resources
                            .getString(R.string.app_google_play_store_link) + appPackageName
                    )
                )
            )
        }
    }
}