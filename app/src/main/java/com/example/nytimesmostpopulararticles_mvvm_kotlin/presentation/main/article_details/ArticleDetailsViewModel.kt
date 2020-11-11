package com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.article_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.ArticleDetailsDataSource
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.Result
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.base.BaseViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.article.ArticleDataItem
import kotlinx.coroutines.launch

class ArticleDetailsViewModel(
    private val articleDetailsDataSource: ArticleDetailsDataSource
) : BaseViewModel() {
    private val isFavorite: MutableLiveData<Boolean> = MutableLiveData()

    private fun insertArticle(articleDataItem: ArticleDataItem) {
        viewModelScope.launch {
            articleDetailsDataSource.insert(
                Article(
                    articleDataItem.id,
                    articleDataItem.imageUrl,
                    articleDataItem.title,
                    articleDataItem.byline,
                    articleDataItem.abstractX,
                    articleDataItem.publishedDate,
                    articleDataItem.url,
                    articleDataItem.coverImageUrl
                )
            )
            isFavorite.value = true
        }
    }

    private fun deleteArticle(articleDataItem: ArticleDataItem) {
        viewModelScope.launch {
            articleDetailsDataSource.delete(
                Article(
                    articleDataItem.id,
                    articleDataItem.imageUrl,
                    articleDataItem.title,
                    articleDataItem.byline,
                    articleDataItem.abstractX,
                    articleDataItem.publishedDate,
                    articleDataItem.url,
                    articleDataItem.coverImageUrl
                )
            )
            isFavorite.value = false
        }
    }

    fun getFavoriteById(id: Long) {
        viewModelScope.launch {
            when (articleDetailsDataSource.getFavoriteById(id)) {
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