package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.databinding.ItemFavoritesEmptyViewBinding
import com.example.nytimesmostpopulararticles_mvvm_kotlin.databinding.ItemFavoritesViewBinding
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseViewHolder
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.favorites.FavoritesItemViewModel.FavoritesItemViewModelListener

class FavoritesAdapter(private val articles: MutableList<Article>?) :
    RecyclerView.Adapter<BaseViewHolder>() {
    private var mListener: FavoritesAdapterListener? = null
    override fun getItemCount(): Int {
        return if (articles != null && articles.size > 0) {
            articles.size
        } else {
            1
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (articles != null && !articles.isEmpty()) {
            VIEW_TYPE_NORMAL
        } else {
            VIEW_TYPE_EMPTY
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            VIEW_TYPE_NORMAL -> {
                val favoritesViewBinding =
                    ItemFavoritesViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                FavoritesViewHolder(favoritesViewBinding)
            }
            VIEW_TYPE_EMPTY -> {
                val emptyViewBinding =
                    ItemFavoritesEmptyViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                EmptyViewHolder(
                    emptyViewBinding
                )
            }
            else -> {
                val emptyViewBinding =
                    ItemFavoritesEmptyViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                EmptyViewHolder(
                    emptyViewBinding
                )
            }
        }
    }

    fun addItems(articles: List<Article?>?) {
        if (articles != null) {
            for (article in articles) {
                article?.let { this.articles!!.add(it) }
            }
        }
        notifyDataSetChanged()
    }

    fun clearItems() {
        articles!!.clear()
    }

    fun setListener(listener: FavoritesAdapterListener?) {
        mListener = listener
    }

    interface FavoritesAdapterListener {
        fun onItemClick(article: Article?)
    }

    inner class FavoritesViewHolder(private val mBinding: ItemFavoritesViewBinding) :
        BaseViewHolder(mBinding.root), FavoritesItemViewModelListener {
        private var mfavoritesItemViewModel: FavoritesItemViewModel? = null
        override fun onBind(position: Int) {
            val article =
                articles!![position]
            mfavoritesItemViewModel = FavoritesItemViewModel(article, this)
            mBinding.viewModel = mfavoritesItemViewModel
            mBinding.executePendingBindings()
        }

        override fun onItemClick(article: Article?) {
            if (article != null) {
                mListener!!.onItemClick(article)
            }
        }

    }

    inner class EmptyViewHolder(private val mBinding: ItemFavoritesEmptyViewBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            val emptyItemViewModel = FavoritesEmptyItemViewModel()
            mBinding.viewModel = emptyItemViewModel
        }

    }

    companion object {
        const val VIEW_TYPE_EMPTY = 0
        const val VIEW_TYPE_NORMAL = 1
    }

}