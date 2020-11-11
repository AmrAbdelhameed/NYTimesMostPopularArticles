package com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nytimesmostpopulararticles_mvvm_kotlin.databinding.ItemFavoritesEmptyViewBinding
import com.example.nytimesmostpopulararticles_mvvm_kotlin.databinding.ItemFavoritesViewBinding
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.base.BaseRecyclerViewAdapter
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.base.BaseViewHolder
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.AppConstants.VIEW_TYPE_EMPTY
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.AppConstants.VIEW_TYPE_NORMAL

class FavoritesAdapter(items: MutableList<Article>, listener: FavoritesItemViewModelListener) :
    BaseRecyclerViewAdapter<Article>(items, listener) {

    override fun getItemCount(): Int {
        return if (items.size > 0) items.size else 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (items.isNotEmpty()) VIEW_TYPE_NORMAL else VIEW_TYPE_EMPTY
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            VIEW_TYPE_NORMAL -> {
                FavoritesViewHolder(
                    ItemFavoritesViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                )
            }
            else -> {
                EmptyViewHolder(
                    ItemFavoritesEmptyViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                )
            }
        }
    }

    inner class FavoritesViewHolder(private val mBinding: ItemFavoritesViewBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            val article = items[position]
            mBinding.article = article
            mBinding.item = FavoritesItemView { itemListener.onItemClick(article) }
            mBinding.executePendingBindings()
        }
    }

    inner class EmptyViewHolder(private val mBinding: ItemFavoritesEmptyViewBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            mBinding.executePendingBindings()
        }
    }
}