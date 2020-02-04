package com.example.nytimesmostpopulararticles_mvvm_kotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.DataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.MainViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article.ArticleViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article_details.ArticleDetailsViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.favorites.FavoritesViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.rx.SchedulerProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelProviderFactory @Inject constructor(
    private val dataManager: DataManager,
    private val schedulerProvider: SchedulerProvider
) : NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dataManager, schedulerProvider) as T
        } else if (modelClass.isAssignableFrom(ArticleViewModel::class.java)) {
            return ArticleViewModel(dataManager, schedulerProvider) as T
        } else if (modelClass.isAssignableFrom(ArticleDetailsViewModel::class.java)) {
            return ArticleDetailsViewModel(dataManager, schedulerProvider) as T
        } else if (modelClass.isAssignableFrom(FavoritesViewModel::class.java)) {
            return FavoritesViewModel(dataManager, schedulerProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}