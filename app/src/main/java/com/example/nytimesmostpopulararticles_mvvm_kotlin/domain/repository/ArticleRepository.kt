package com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.repository

import com.example.nytimesmostpopulararticles_mvvm_kotlin.BuildConfig
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.ArticleDataSource
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote.ApiService
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.Result
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.api.ArticlesResponse

class ArticleRepository(private val apiService: ApiService) : ArticleDataSource {
    override suspend fun getArticles(period: Int): Result<ArticlesResponse> {
        return try {
            val articlesResponse = apiService.getArticles(period, BuildConfig.API_KEY)
            Result.Success(articlesResponse)
        } catch (e: Exception) {
            Result.Error(e.localizedMessage)
        }
    }
}