package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote

import com.example.nytimesmostpopulararticles_mvvm_kotlin.BuildConfig

object ApiEndPoint {
    const val ENDPOINT_ARTICLES = BuildConfig.BASE_URL + "/v2/viewed/{period}.json"
}