package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article

class ArticleEmptyItemViewModel(private val mListener: ArticleEmptyItemViewModelListener) {
    fun onRetryClick() {
        mListener.onRetryClick()
    }

    interface ArticleEmptyItemViewModelListener {
        fun onRetryClick()
    }

}