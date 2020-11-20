package com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.repository

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.ArticleFavoritesDataSource
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.AppDatabase
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.db.Article

class ArticleFavoritesRepository(private val mAppDatabase: AppDatabase) :
    ArticleFavoritesDataSource {
    override fun getAllFavorites(): LiveData<List<Article>> = mAppDatabase.articleDao().getAllFavorites()
}