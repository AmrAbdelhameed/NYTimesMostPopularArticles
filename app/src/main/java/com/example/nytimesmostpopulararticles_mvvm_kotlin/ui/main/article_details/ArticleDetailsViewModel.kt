package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article_details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.AppDataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.rx.SchedulerProvider

class ArticleDetailsViewModel(
    appDataManager: AppDataManager,
    schedulerProvider: SchedulerProvider
) : BaseViewModel<ArticleDetailsNavigator>(appDataManager, schedulerProvider) {
    private val isFavorite: MutableLiveData<Boolean> = MutableLiveData()

    private fun insertArticle(article: Article) {
        compositeDisposable.add(
            appDataManager.getDbRepository().insertArticle(article)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    Log.d(
                        TAG,
                        "insertArticle: "
                    )
                    isFavorite.value = true
                }, { throwable ->
                    Log.d(
                        TAG,
                        "insertArticle: " + throwable.message
                    )
                })
        )
    }

    private fun deleteArticle(article: Article) {
        compositeDisposable.add(
            appDataManager.getDbRepository().deleteArticle(article)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    Log.d(
                        TAG,
                        "deleteArticle: "
                    )
                    isFavorite.value = false
                }, { throwable ->
                    Log.d(
                        TAG,
                        "deleteArticle: " + throwable.message
                    )
                })
        )
    }

    fun findById(id: Long) {
        compositeDisposable.add(
            appDataManager.getDbRepository().findById(id)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({ article ->
                    Log.d(
                        TAG,
                        "findById: " + article?.id
                    )
                    isFavorite.value = true
                }, { throwable ->
                    Log.d(
                        TAG,
                        "findById: " + throwable.message
                    )
                    isFavorite.setValue(false)
                })
        )
    }

    fun onFavClick(
        isFavorite: Boolean,
        article: Article
    ) {
        if (isFavorite) deleteArticle(article) else insertArticle(article)
    }

    fun getIsFavorite(): LiveData<Boolean> {
        return isFavorite
    }

    companion object {
        private const val TAG = "ArticleDetailsViewModel"
    }

}