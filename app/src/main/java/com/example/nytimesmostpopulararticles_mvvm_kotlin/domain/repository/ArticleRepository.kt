package com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.repository

import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.ArticleDataSource
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote.ApiService
import com.example.nytimesmostpopulararticles_mvvm_kotlin.di.ApiInfo
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.Result
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.api.ArticlesResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(
    private val apiService: ApiService,
    @param:ApiInfo private val apiKey: String
) : ArticleDataSource {
    override suspend fun getArticles(period: Int): Result<ArticlesResponse> {
        return try {
            val articlesResponse = apiService.getArticles(period, apiKey)
            Result.Success(articlesResponse)
        } catch (e: Exception) {
            Result.Error(e.localizedMessage)
        }
    }
}