package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.favorites

import androidx.databinding.ObservableField
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseItemListener

class FavoritesItemViewModel(
    article: Article,
    private val action: () -> Unit
) {
    val imageUrl: ObservableField<String?> = ObservableField(article.imageUrl)
    val title: ObservableField<String?> = ObservableField(article.title)
    val byline: ObservableField<String?> = ObservableField(article.byline)
    val publishedDate: ObservableField<String?> = ObservableField(article.publishedDate)

    fun onItemClick() {
        action.invoke()
    }

    interface FavoritesItemViewModelListener : BaseItemListener<Article> {
        override fun onRetryClick() {}
    }

}