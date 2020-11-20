package com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.article

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.BR
import com.example.nytimesmostpopulararticles_mvvm_kotlin.R
import com.example.nytimesmostpopulararticles_mvvm_kotlin.databinding.FragmentArticleBinding
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.base.BaseFragment
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.base.NavigationCommand
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticleFragment : BaseFragment<FragmentArticleBinding, ArticleViewModel>(),
    ArticleAdapterListener {
    private lateinit var articleAdapter: ArticleAdapter

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_article

    override val viewModel: ArticleViewModel by viewModel()

    override fun onRetryClick() {
        viewModel.fetchArticles(7)
    }

    override fun onItemClick(item: ArticleDataItem) {
        navigate(
            NavigationCommand.To(
                ArticleFragmentDirections.toArticleDetailsFragment(
                    item
                )
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        articleAdapter = ArticleAdapter(arrayListOf(), this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        if (activity != null) (activity as MainActivity).setSupportActionBar(
            getViewDataBinding().toolbar
        )
        setHasOptionsMenu(true)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        getViewDataBinding().resultsBeanRecyclerView.layoutManager = LinearLayoutManager(activity)
        getViewDataBinding().resultsBeanRecyclerView.itemAnimator = DefaultItemAnimator()
        getViewDataBinding().resultsBeanRecyclerView.adapter = articleAdapter
    }

    override fun onCreateOptionsMenu(
        menu: Menu,
        inflater: MenuInflater
    ) {
        inflater.inflate(R.menu.main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorites) {
            navigate(NavigationCommand.To(ArticleFragmentDirections.toFavoritesFragment()))
        }
        return super.onOptionsItemSelected(item)
    }
}