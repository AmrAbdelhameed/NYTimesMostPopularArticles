package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.db

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.Result
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article

interface DbDataSource {
    suspend fun insertArticle(article: Article)
    suspend fun deleteArticle(article: Article)
    suspend fun findById(id: Long): Result<Article>
    fun allArticles(): LiveData<List<Article>>
}