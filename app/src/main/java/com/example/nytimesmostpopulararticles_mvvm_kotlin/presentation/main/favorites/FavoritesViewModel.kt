package com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.favorites

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.ArticleFavoritesDataSource
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.base.BaseViewModel

class FavoritesViewModel(
    articleFavoritesDataSource: ArticleFavoritesDataSource
) : BaseViewModel() {
    val articlesLiveData: LiveData<List<Article>> = articleFavoritesDataSource.getAllFavorites()
}