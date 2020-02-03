package com.example.nytimesmostpopulararticles_mvvm_kotlin.utils

import com.example.nytimesmostpopulararticles_mvvm_kotlin.BuildConfig

object AppConstants {
    const val DB_NAME = BuildConfig.APPLICATION_ID + ".db"
    const val PREF_NAME = BuildConfig.APPLICATION_ID + "_pref"
    const val TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss"
    const val ARTICLE = "article"
}