package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.AppDataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.api.ArticlesResponse
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.rx.SchedulerProvider

class ArticleViewModel(
    appDataManager: AppDataManager,
    schedulerProvider: SchedulerProvider
) : BaseViewModel<ArticleNavigator>(appDataManager, schedulerProvider) {
    private val articlesLiveData: MutableLiveData<List<ArticlesResponse.Article>> = MutableLiveData()

    fun fetchArticles(period: Int) {
        setIsLoading(true)
        compositeDisposable.add(appDataManager.getApiRepository().getArticles(period)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({ articlesResponse ->
                if (articlesResponse.articles != null) {
                    articlesLiveData.value = articlesResponse.articles
                }
                setIsLoading(false)
            }) { throwable ->
                setIsLoading(false)
                navigator?.handleError(throwable)
            })
    }

    val articlesLiveDataLiveData: LiveData<List<ArticlesResponse.Article>>
        get() = articlesLiveData

    init {
        fetchArticles(7)
    }

}