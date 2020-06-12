package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article

class ArticleEmptyItemViewModel(private val onRetry: () -> Unit) {
    fun onRetryClick() = onRetry.invoke()
}