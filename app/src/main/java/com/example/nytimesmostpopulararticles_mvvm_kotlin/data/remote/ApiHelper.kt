package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote

import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.api.ArticlesResponse
import io.reactivex.Single

interface ApiHelper {
    fun getArticlesApiCall(period: Int): Single<ArticlesResponse?>?
}