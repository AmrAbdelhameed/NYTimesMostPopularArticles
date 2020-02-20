package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.favorites

import androidx.databinding.ObservableField
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseItemListener

class FavoritesItemViewModel(
    private val article: Article,
    private val mListener: FavoritesItemViewModelListener
) {
    val imageUrl: ObservableField<String?> = ObservableField(article.imageUrl)
    val title: ObservableField<String?> = ObservableField(article.title)
    val byline: ObservableField<String?> = ObservableField(article.byline)
    val publishedDate: ObservableField<String?> = ObservableField(article.publishedDate)

    fun onItemClick() {
        mListener.onItemClick(article)
    }

    interface FavoritesItemViewModelListener : BaseItemListener<Article>

}