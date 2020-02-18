package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article

import androidx.databinding.ObservableField
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.api.ArticlesResponse

class ArticleItemViewModel(
    private val article: ArticlesResponse.Article,
    private val mListener: ArticleItemViewModelListener
) {
    val imageUrl: ObservableField<String?> = ObservableField(article.media?.get(0)?.mediametadata?.get(1)?.url)
    val title: ObservableField<String?> = ObservableField(article.title)
    val byline: ObservableField<String?> = ObservableField(article.byline)
    val publishedDate: ObservableField<String?> = ObservableField(article.published_date)

    fun onItemClick() {
        mListener.onItemClick(article)
    }

    interface ArticleItemViewModelListener {
        fun onItemClick(article: ArticlesResponse.Article)
    }

}