package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article

import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseEmptyItemListener

class ArticleEmptyItemViewModel(private val mListener: BaseEmptyItemListener) {
    fun onRetryClick() {
        mListener.onRetryClick()
    }

}