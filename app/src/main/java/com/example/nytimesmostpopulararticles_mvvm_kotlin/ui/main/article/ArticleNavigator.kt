package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article

import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.api.ArticlesResponse

interface ArticleNavigator {
    fun handleError(throwable: Throwable?)
    fun updateArticle(articles: List<ArticlesResponse.Article?>?)
}