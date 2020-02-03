package com.example.nytimesmostpopulararticles_mvvm_kotlin.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.api.ArticlesResponse
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article.ArticleAdapter
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.favorites.FavoritesAdapter

object BindingUtils {
    @JvmStatic
    @BindingAdapter("adapter")
    fun addArticleItems(
        recyclerView: RecyclerView,
        articles: List<ArticlesResponse.Article?>?
    ) {
        val adapter = recyclerView.adapter as ArticleAdapter?
        if (adapter != null) {
            adapter.clearItems()
            adapter.addItems(articles)
        }
    }

    @JvmStatic
    @BindingAdapter("adapter_fav")
    fun addFavoritesItems(
        recyclerView: RecyclerView,
        articles: List<Article?>?
    ) {
        val adapter = recyclerView.adapter as FavoritesAdapter?
        if (adapter != null) {
            adapter.clearItems()
            adapter.addItems(articles)
        }
    }

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {
        Glide.with(imageView.context).load(url).into(imageView)
    }

    @JvmStatic
    @BindingAdapter("imageUrlCrop")
    fun setImageUrlCrop(imageView: ImageView, url: String?) {
        Glide.with(imageView.context).load(url).apply(RequestOptions.circleCropTransform())
            .into(imageView)
    }
}