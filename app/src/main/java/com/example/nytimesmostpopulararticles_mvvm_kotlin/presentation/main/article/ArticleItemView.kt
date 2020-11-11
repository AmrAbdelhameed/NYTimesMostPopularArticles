package com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.article

class ArticleItemView(private val onItemClick: () -> Unit) {
    fun onItemClick() = onItemClick.invoke()
}