package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base

interface BaseNavigator<T> {
    fun handleError(throwable: Throwable)
    fun setData(data: T)
}