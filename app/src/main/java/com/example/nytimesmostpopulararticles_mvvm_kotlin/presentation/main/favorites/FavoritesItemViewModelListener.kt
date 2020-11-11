package com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.favorites

import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.base.BaseItemListener

interface FavoritesItemViewModelListener : BaseItemListener<Article> {
    override fun onRetryClick() {}
}