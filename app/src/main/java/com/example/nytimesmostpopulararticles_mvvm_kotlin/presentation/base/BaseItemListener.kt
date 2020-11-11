package com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.base

interface BaseItemListener<T> {
    fun onItemClick(item: T)
    fun onRetryClick()
}