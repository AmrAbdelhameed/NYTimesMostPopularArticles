package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote.network

import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.api.ArticlesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(ApiEndPoint.ENDPOINT_ARTICLES)
    fun getArticles(@Path("period") period: Int, @Query("api-key") apiKey: String): Single<ArticlesResponse>
}