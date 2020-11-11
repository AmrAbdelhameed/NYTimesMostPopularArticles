package com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.favorites

class FavoritesItemView(private val action: () -> Unit) {
    fun onItemClick() = action.invoke()
}