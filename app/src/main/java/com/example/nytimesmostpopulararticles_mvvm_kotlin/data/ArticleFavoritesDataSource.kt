package com.example.nytimesmostpopulararticles_mvvm_kotlin.data

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.db.Article

interface ArticleFavoritesDataSource {
    fun getAllFavorites(): LiveData<List<Article>>
}