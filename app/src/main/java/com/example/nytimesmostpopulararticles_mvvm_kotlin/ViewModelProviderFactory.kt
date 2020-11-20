package com.example.nytimesmostArticlearticles_mvvm_kotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.ArticleDataSource
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.ArticleDetailsDataSource
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.ArticleFavoritesDataSource
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.MainViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.article.ArticleViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.article_details.ArticleDetailsViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.favorites.FavoritesViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelProviderFactory @Inject constructor(
    private val articleDataSource: ArticleDataSource,
    private val articleDetailsDataSource: ArticleDetailsDataSource,
    private val articleFavoritesDataSource: ArticleFavoritesDataSource
) : NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel() as T
            }
            modelClass.isAssignableFrom(ArticleViewModel::class.java) -> {
                ArticleViewModel(articleDataSource) as T
            }
            modelClass.isAssignableFrom(ArticleDetailsViewModel::class.java) -> {
                ArticleDetailsViewModel(articleDetailsDataSource) as T
            }
            modelClass.isAssignableFrom(FavoritesViewModel::class.java) -> {
                FavoritesViewModel(articleFavoritesDataSource) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}