package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.favorites

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.DataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.rx.SchedulerProvider

class FavoritesViewModel(
    dataManager: DataManager,
    schedulerProvider: SchedulerProvider?
) : BaseViewModel<FavoritesNavigator?>(dataManager, schedulerProvider!!) {
    val articlesLiveDataLiveData: LiveData<List<Article?>?>? = dataManager.allArticles

}