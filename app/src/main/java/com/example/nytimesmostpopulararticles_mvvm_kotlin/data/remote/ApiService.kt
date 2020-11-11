package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote

import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.api.ArticlesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(ApiEndPoint.ENDPOINT_ARTICLES)
    suspend fun getArticles(
        @Path("period") period: Int,
        @Query("api-key") apiKey: String
    ): ArticlesResponse
}