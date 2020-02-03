package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote

import com.example.nytimesmostpopulararticles_mvvm_kotlin.BuildConfig
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.api.ArticlesResponse
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppApiHelper @Inject constructor() : ApiHelper {
    override fun getArticlesApiCall(period: Int): Single<ArticlesResponse?>? {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_ARTICLES)
            .addQueryParameter(
                "api-key",
                BuildConfig.API_KEY
            )
            .addPathParameter("period", period.toString())
            .build()
            .getObjectSingle(ArticlesResponse::class.java)
    }
}