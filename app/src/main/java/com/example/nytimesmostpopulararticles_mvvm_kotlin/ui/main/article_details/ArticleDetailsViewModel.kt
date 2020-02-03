package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article_details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.DataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.rx.SchedulerProvider

class ArticleDetailsViewModel(
    dataManager: DataManager?,
    schedulerProvider: SchedulerProvider?
) : BaseViewModel<ArticleDetailsNavigator?>(dataManager!!, schedulerProvider!!) {
    private val isFavorite: MutableLiveData<Boolean> = MutableLiveData()
    private fun insertArticle(article: Article?) {
        dataManager
            .insertArticle(article)
            ?.subscribeOn(schedulerProvider.io())
            ?.observeOn(schedulerProvider.ui())
            ?.subscribe({ aBoolean ->
                Log.d(
                    TAG,
                    "insertArticle: $aBoolean"
                )
                isFavorite.value = true
            }, { throwable ->
                Log.d(
                    TAG,
                    "insertArticle: " + throwable.message
                )
            })?.let {
                compositeDisposable.add(
                    it
                )
            }
    }

    private fun deleteArticle(article: Article?) {
        dataManager
            .deleteArticle(article)
            ?.subscribeOn(schedulerProvider.io())
            ?.observeOn(schedulerProvider.ui())
            ?.subscribe({ aBoolean ->
                Log.d(
                    TAG,
                    "deleteArticle: $aBoolean"
                )
                isFavorite.value = false
            }, { throwable ->
                Log.d(
                    TAG,
                    "deleteArticle: " + throwable.message
                )
            })?.let {
                compositeDisposable.add(
                    it
                )
            }
    }

    fun findById(id: Long) {
        dataManager
            .findById(id)
            ?.subscribeOn(schedulerProvider.io())
            ?.observeOn(schedulerProvider.ui())
            ?.subscribe({ article ->
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
            })?.let {
                compositeDisposable.add(
                    it
                )
            }
    }

    fun onFavClick(
        isFavorite: Boolean,
        article: Article?
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