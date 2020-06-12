package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.favorites

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.AppDataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseViewModel

class FavoritesViewModel(
    application: Application,
    appDataManager: AppDataManager
) : BaseViewModel<FavoritesNavigator>(application, appDataManager) {
    val articlesLiveData: LiveData<List<Article>> = appDataManager.getDbRepository().allArticles()
}