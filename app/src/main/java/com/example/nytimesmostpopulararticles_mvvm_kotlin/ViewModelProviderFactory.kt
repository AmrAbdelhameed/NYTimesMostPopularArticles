package com.example.nytimesmostpopulararticles_mvvm_kotlin

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.AppDataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.MainViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article.ArticleViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article_details.ArticleDetailsViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.favorites.FavoritesViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelProviderFactory @Inject constructor(
    private val application: Application,
    private val appDataManager: AppDataManager
) : NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(application, appDataManager) as T
            }
            modelClass.isAssignableFrom(ArticleViewModel::class.java) -> {
                ArticleViewModel(application, appDataManager) as T
            }
            modelClass.isAssignableFrom(ArticleDetailsViewModel::class.java) -> {
                ArticleDetailsViewModel(application, appDataManager) as T
            }
            modelClass.isAssignableFrom(FavoritesViewModel::class.java) -> {
                FavoritesViewModel(application, appDataManager) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}