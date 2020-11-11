package com.example.nytimesmostpopulararticles_mvvm_kotlin.data

import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.Result
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.api.ArticlesResponse

interface ArticleDataSource {
    suspend fun getArticles(period: Int): Result<ArticlesResponse>
}