package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.AppDataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.Result
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.api.ArticlesResponse
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class ArticleViewModel(
    application: Application,
    appDataManager: AppDataManager
) : BaseViewModel<ArticleNavigator>(application, appDataManager) {
    private val articlesLiveData: MutableLiveData<List<ArticlesResponse.Article>> =
        MutableLiveData()

    fun fetchArticles(period: Int) {
        launch {
            setIsLoading(true)
            when (val result = appDataManager.getApiRepository().getArticles(period)) {
                is Result.Success<ArticlesResponse> -> {
                    articlesLiveData.value = result.data.articles
                    setIsLoading(false)
                }
                is Result.Error -> {
                    setIsLoading(false)
                    navigator?.handleError(result.message)
                }
            }
        }
    }

    val articlesLiveDataLiveData: LiveData<List<ArticlesResponse.Article>>
        get() = articlesLiveData

    init {
        fetchArticles(7)
    }

}