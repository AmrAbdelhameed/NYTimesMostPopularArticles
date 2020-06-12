package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article

import androidx.databinding.ObservableField
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseItemListener

class ArticleItemViewModel(
    article: ArticleDataItem,
    private val onItemClick: () -> Unit
) {
    val imageUrl: ObservableField<String?> = ObservableField(article.imageUrl)
    val title: ObservableField<String?> = ObservableField(article.title)
    val byline: ObservableField<String?> = ObservableField(article.byline)
    val publishedDate: ObservableField<String?> = ObservableField(article.publishedDate)

    fun onItemClick() = onItemClick.invoke()

    interface ArticleItemViewModelListener : BaseItemListener<ArticleDataItem>

}