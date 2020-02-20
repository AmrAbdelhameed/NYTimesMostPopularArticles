package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.api.ArticlesResponse
import com.example.nytimesmostpopulararticles_mvvm_kotlin.databinding.ItemArticleEmptyViewBinding
import com.example.nytimesmostpopulararticles_mvvm_kotlin.databinding.ItemArticleViewBinding
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseEmptyItemListener
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseItemListener
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseRecyclerViewAdapter
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseViewHolder
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article.ArticleItemViewModel.ArticleItemViewModelListener
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.AppConstants.VIEW_TYPE_EMPTY
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.AppConstants.VIEW_TYPE_NORMAL

class ArticleAdapter(items: MutableList<ArticlesResponse.Article>) :
    BaseRecyclerViewAdapter<ArticlesResponse.Article>(items) {
    private lateinit var mListener: ArticleAdapterListener

    fun setListener(listener: ArticleAdapterListener) {
        mListener = listener
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

    interface ArticleAdapterListener : BaseItemListener<ArticlesResponse.Article>,
        BaseEmptyItemListener

    inner class ArticleViewHolder(private val mBinding: ItemArticleViewBinding) :
        BaseViewHolder(mBinding.root), ArticleItemViewModelListener {
        override fun onBind(position: Int) {
            val article = items[position]
            mBinding.viewModel = ArticleItemViewModel(article, this)
            mBinding.executePendingBindings()
        }

        override fun onItemClick(item: ArticlesResponse.Article) {
            mListener.onItemClick(item)
        }

    }

    inner class EmptyViewHolder(private val mBinding: ItemArticleEmptyViewBinding) :
        BaseViewHolder(mBinding.root), BaseEmptyItemListener {
        override fun onBind(position: Int) {
            mBinding.viewModel = ArticleEmptyItemViewModel(this)
            mBinding.executePendingBindings()
        }

        override fun onRetryClick() {
            mListener.onRetryClick()
        }

    }

}