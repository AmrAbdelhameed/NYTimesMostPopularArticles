package com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.repository

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.ArticleFavoritesDataSource
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.AppDatabase
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.db.Article
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleFavoritesRepository @Inject constructor(
    private val mAppDatabase: AppDatabase
) : ArticleFavoritesDataSource {
    override fun getAllFavorites(): LiveData<List<Article>> = mAppDatabase.articleDao().getAllFavorites()
}