package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article_details

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.AppDataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.Result
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class ArticleDetailsViewModel(
    application: Application,
    appDataManager: AppDataManager
) : BaseViewModel<ArticleDetailsNavigator>(application, appDataManager) {
    private val isFavorite: MutableLiveData<Boolean> = MutableLiveData()

    private fun insertArticle(article: Article) {
        launch {
            appDataManager.getDbRepository().insertArticle(article)
            isFavorite.value = true
        }
    }

    private fun deleteArticle(article: Article) {
        launch {
            appDataManager.getDbRepository().deleteArticle(article)
            isFavorite.value = false
        }
    }

    fun findById(id: Long) {
        launch {
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
        article: Article
    ) {
        if (isFavorite) deleteArticle(article) else insertArticle(article)
    }

    fun getIsFavorite(): LiveData<Boolean> {
        return isFavorite
    }

}