package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nytimesmostpopulararticles_mvvm_kotlin.databinding.ItemArticleEmptyViewBinding
import com.example.nytimesmostpopulararticles_mvvm_kotlin.databinding.ItemArticleViewBinding
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseRecyclerViewAdapter
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseViewHolder
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article.ArticleItemViewModel.ArticleItemViewModelListener
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.AppConstants.VIEW_TYPE_EMPTY
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.AppConstants.VIEW_TYPE_NORMAL

class ArticleAdapter(items: MutableList<ArticleDataItem>, listener: ArticleItemViewModelListener) :
    BaseRecyclerViewAdapter<ArticleDataItem>(items, listener) {

    override fun getItemCount(): Int {
        return if (items.size > 0) items.size else 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (items.isNotEmpty()) VIEW_TYPE_NORMAL else VIEW_TYPE_EMPTY
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            VIEW_TYPE_NORMAL -> {
                ArticleViewHolder(
                    ItemArticleViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                )
            }
            else -> {
                EmptyViewHolder(
                    ItemArticleEmptyViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                )
            }
        }
    }

    inner class ArticleViewHolder(private val mBinding: ItemArticleViewBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            val article = items[position]
            mBinding.viewModel = ArticleItemViewModel(article) { itemListener.onItemClick(article) }
            mBinding.executePendingBindings()
        }
    }

    inner class EmptyViewHolder(private val mBinding: ItemArticleEmptyViewBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            mBinding.viewModel = ArticleEmptyItemViewModel { itemListener.onRetryClick() }
            mBinding.executePendingBindings()
        }
    }

}