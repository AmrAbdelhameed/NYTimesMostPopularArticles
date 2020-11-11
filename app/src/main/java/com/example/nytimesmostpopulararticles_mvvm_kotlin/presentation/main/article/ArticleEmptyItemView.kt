package com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.article

class ArticleEmptyItemView(private val onRetry: () -> Unit) {
    fun onRetryClick() = onRetry.invoke()
}