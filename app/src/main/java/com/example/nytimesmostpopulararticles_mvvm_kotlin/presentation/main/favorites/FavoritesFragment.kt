package com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.favorites

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimesmostArticlearticles_mvvm_kotlin.ViewModelProviderFactory
import com.example.nytimesmostpopulararticles_mvvm_kotlin.BR
import com.example.nytimesmostpopulararticles_mvvm_kotlin.R
import com.example.nytimesmostpopulararticles_mvvm_kotlin.databinding.FragmentFavoritesBinding
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.base.BaseFragment
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.base.NavigationCommand
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.MainActivity
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.article.ArticleDataItem
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.article.ArticleFragmentDirections
import javax.inject.Inject

class FavoritesFragment :
    BaseFragment<FragmentFavoritesBinding, FavoritesViewModel>(),
    FavoritesItemViewModelListener {
    @Inject
    lateinit var factory: ViewModelProviderFactory
    private lateinit var favoritesAdapter: FavoritesAdapter
    private var favoritesViewModel: FavoritesViewModel? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_favorites

    override val viewModel: FavoritesViewModel
        get() {
            favoritesViewModel = ViewModelProvider(this, factory).get(
                FavoritesViewModel::class.java
            )
            return favoritesViewModel as FavoritesViewModel
        }

    override fun onItemClick(item: Article) {
        navigate(
            NavigationCommand.To(
                ArticleFragmentDirections.toArticleDetailsFragment(
                    ArticleDataItem(
                        item.id,
                        item.imageUrl,
                        item.title,
                        item.byline,
                        item.abstractX,
                        item.publishedDate,
                        item.url,
                        item.coverImageUrl
                    )
                )
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoritesAdapter = FavoritesAdapter(arrayListOf(), this)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        if (activity != null) {
            (activity as MainActivity).setSupportActionBar(getViewDataBinding().toolbar)
            getViewDataBinding().toolbar.title = getString(R.string.favorites)
            (activity as MainActivity).supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
            }

        }
        getViewDataBinding().toolbar.setNavigationOnClickListener {
            if (activity != null) {
                activity?.onBackPressed()
            }
        }
        setHasOptionsMenu(true)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        getViewDataBinding().favoritesRecyclerView.layoutManager = LinearLayoutManager(activity)
        getViewDataBinding().favoritesRecyclerView.itemAnimator = DefaultItemAnimator()
        getViewDataBinding().favoritesRecyclerView.adapter = favoritesAdapter
    }
}