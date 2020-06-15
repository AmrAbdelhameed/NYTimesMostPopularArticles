package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base

interface BaseItemListener<T> {
    fun onItemClick(item: T)
    fun onRetryClick()
}