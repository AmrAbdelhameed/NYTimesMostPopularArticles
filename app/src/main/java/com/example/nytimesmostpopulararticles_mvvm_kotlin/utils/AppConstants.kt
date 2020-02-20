package com.example.nytimesmostpopulararticles_mvvm_kotlin.utils

import com.example.nytimesmostpopulararticles_mvvm_kotlin.BuildConfig

object AppConstants {
    const val DB_NAME = BuildConfig.APPLICATION_ID + ".db"
    const val PREF_NAME = BuildConfig.APPLICATION_ID + "_pref"
    const val ARTICLE = "article"
    const val VIEW_TYPE_EMPTY = 0
    const val VIEW_TYPE_NORMAL = 1
}