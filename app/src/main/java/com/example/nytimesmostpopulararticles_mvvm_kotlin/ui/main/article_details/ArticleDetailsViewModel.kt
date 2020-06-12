package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article_details

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.AppDataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.Result
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article.ArticleDataItem
import kotlinx.coroutines.launch

class ArticleDetailsViewModel(
    application: Application,
    appDataManager: AppDataManager
) : BaseViewModel<ArticleDetailsNavigator>(application, appDataManager) {
    private val isFavorite: MutableLiveData<Boolean> = MutableLiveData()

    private fun insertArticle(articleDataItem: ArticleDataItem) {
        viewModelScope.launch {
            appDataManager.getDbRepository().insertArticle(
                Article(
                    articleDataItem.id
                    , articleDataItem.imageUrl
                    , articleDataItem.title
                    , articleDataItem.byline
                    , articleDataItem.abstractX
                    , articleDataItem.publishedDate
                    , articleDataItem.url
                    , articleDataItem.coverImageUrl
                )
            )
            isFavorite.value = true
        }
    }

    private fun deleteArticle(articleDataItem: ArticleDataItem) {
        viewModelScope.launch {
            appDataManager.getDbRepository().deleteArticle(
                Article(
                    articleDataItem.id
                    , articleDataItem.imageUrl
                    , articleDataItem.title
                    , articleDataItem.byline
                    , articleDataItem.abstractX
                    , articleDataItem.publishedDate
                    , articleDataItem.url
                    , articleDataItem.coverImageUrl
                )
            )
            isFavorite.value = false
        }
    }

    fun findById(id: Long) {
        viewModelScope.launch {
            when (appDataManager.getDbRepository().findById(id)) {
                is Result.Success<Article> -> {
                    isFavorite.value = true
                }
                is Result.Error -> {
                    isFavorite.value = false
                }
            }
        }
    }

    fun onFavClick(
        isFavorite: Boolean,
        articleDataItem: ArticleDataItem
    ) {
        if (isFavorite) deleteArticle(articleDataItem) else insertArticle(articleDataItem)
    }

    fun getIsFavorite(): LiveData<Boolean> {
        return isFavorite
    }

}