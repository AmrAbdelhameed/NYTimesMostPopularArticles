package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.favorites

import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article

interface FavoritesNavigator {
    fun handleError(throwable: Throwable?)
    fun updateArticle(articles: List<Article?>?)
}