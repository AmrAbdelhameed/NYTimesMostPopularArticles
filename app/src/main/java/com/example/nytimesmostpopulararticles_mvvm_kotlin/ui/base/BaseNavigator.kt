package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base

interface BaseNavigator<T> {
    fun handleError(message: String?)
    fun setData(data: T)
}