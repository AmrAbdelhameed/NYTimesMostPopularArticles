package com.example.nytimesmostpopulararticles_mvvm_kotlin.data

import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.Result
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.db.Article

interface ArticleDetailsDataSource {
    suspend fun insert(article: Article)
    suspend fun delete(article: Article)
    suspend fun getFavoriteById(id: Long): Result<Article>
}