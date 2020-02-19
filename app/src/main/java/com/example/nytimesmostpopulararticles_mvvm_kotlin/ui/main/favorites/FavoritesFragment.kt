package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.favorites

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.BR
import com.example.nytimesmostpopulararticles_mvvm_kotlin.R
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ViewModelProviderFactory
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.databinding.FragmentFavoritesBinding
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseFragment
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.MainActivity
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.favorites.FavoritesAdapter.FavoritesAdapterListener
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.AppConstants
import javax.inject.Inject

class FavoritesFragment :
    BaseFragment<FragmentFavoritesBinding, FavoritesViewModel>(), FavoritesNavigator,
    FavoritesAdapterListener {
    @Inject
    lateinit var factory: ViewModelProviderFactory
    @Inject
    lateinit var favoritesAdapter: FavoritesAdapter
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

    override fun onItemClick(article: Article) {
        val bundle = Bundle()
        bundle.putParcelable(AppConstants.ARTICLE, article)
        getNavController().navigate(
            R.id.action_favoritesFragment_to_articleDetailsFragment,
            bundle
        )
    }

    override fun handleError(message: String?) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun setData(data: List<Article>) {
        favoritesAdapter.addItems(data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoritesViewModel?.setNavigator(this)
        favoritesAdapter.setListener(this)
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
            val actionBar = (activity as MainActivity).supportActionBar
            actionBar?.setDisplayHomeAsUpEnabled(true)
            actionBar?.setDisplayShowHomeEnabled(true)
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
        getViewDataBinding().favoritesRecyclerView.layoutManager = LinearLayoutManager(
            activity
        )
        getViewDataBinding().favoritesRecyclerView.itemAnimator = DefaultItemAnimator()
        getViewDataBinding().favoritesRecyclerView.adapter = favoritesAdapter
    }
}