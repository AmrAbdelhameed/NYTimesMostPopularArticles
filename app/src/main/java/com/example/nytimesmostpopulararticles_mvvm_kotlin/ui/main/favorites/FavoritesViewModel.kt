package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.favorites

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.AppDataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.rx.SchedulerProvider

class FavoritesViewModel(
    appDataManager: AppDataManager,
    schedulerProvider: SchedulerProvider
) : BaseViewModel<FavoritesNavigator>(appDataManager, schedulerProvider) {
    val articlesLiveDataLiveData: LiveData<List<Article>> =
        appDataManager.getDbRepository().allArticles()
}