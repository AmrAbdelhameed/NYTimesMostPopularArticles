package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.DataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.api.ArticlesResponse
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.rx.SchedulerProvider

class ArticleViewModel(
    dataManager: DataManager?,
    schedulerProvider: SchedulerProvider?
) : BaseViewModel<ArticleNavigator?>(dataManager, schedulerProvider) {
    private val articlesLiveData: MutableLiveData<List<ArticlesResponse.Article>> =
        MutableLiveData()

    fun fetchArticles(period: Int) {
        setIsLoading(true)
        dataManager
            ?.getArticlesApiCall(period)
            ?.subscribeOn(schedulerProvider?.io())
            ?.observeOn(schedulerProvider?.ui())
            ?.subscribe({ articlesResponse ->
                if (articlesResponse?.articles != null) {
                    articlesLiveData.value = articlesResponse.articles
                }
                setIsLoading(false)
            }) { throwable ->
                setIsLoading(false)
                navigator?.handleError(throwable)
            }?.let {
                compositeDisposable.add(
                    it
                )
            }
    }

    val articlesLiveDataLiveData: LiveData<List<ArticlesResponse.Article>>
        get() = articlesLiveData

    init {
        fetchArticles(7)
    }
}