package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.favorites

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
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
    BaseFragment<FragmentFavoritesBinding?, FavoritesViewModel?>(), FavoritesNavigator,
    FavoritesAdapterListener {
    @Inject
    lateinit var factory: ViewModelProviderFactory
    @Inject
    lateinit var favoritesAdapter: FavoritesAdapter
    private var fragmentFavoritesBinding: FragmentFavoritesBinding? = null
    private var favoritesViewModel: FavoritesViewModel? = null
    private var navController: NavController? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_favorites

    override val viewModel: FavoritesViewModel?
        get() {
            favoritesViewModel = ViewModelProvider(this, factory).get(
                FavoritesViewModel::class.java
            )
            return favoritesViewModel
        }

    override fun onItemClick(article: Article?) {
        val bundle = Bundle()
        bundle.putParcelable(AppConstants.ARTICLE, article)
        navController?.navigate(R.id.action_favoritesFragment_to_articleDetailsFragment, bundle)
    }

    override fun handleError(throwable: Throwable?) {
        Toast.makeText(activity, throwable?.message, Toast.LENGTH_SHORT).show()
    }

    override fun updateArticle(articles: List<Article?>?) {
        favoritesAdapter.addItems(articles)
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
        fragmentFavoritesBinding = getViewDataBinding()
        navController = Navigation.findNavController(view)
        setUp()
    }

    private fun setUp() {
        if (activity != null) {
            (activity as MainActivity?)?.setSupportActionBar(fragmentFavoritesBinding?.toolbar)
            fragmentFavoritesBinding?.toolbar?.title = getString(R.string.favorites)
            val actionBar =
                (activity as MainActivity?)?.supportActionBar
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true)
                actionBar.setDisplayShowHomeEnabled(true)
            }
        }
        fragmentFavoritesBinding?.toolbar?.setNavigationOnClickListener {
            if (activity != null) {
                activity?.onBackPressed()
            }
        }
        setHasOptionsMenu(true)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        fragmentFavoritesBinding?.favoritesRecyclerView?.layoutManager = LinearLayoutManager(
            activity
        )
        fragmentFavoritesBinding?.favoritesRecyclerView?.itemAnimator = DefaultItemAnimator()
        fragmentFavoritesBinding?.favoritesRecyclerView?.adapter = favoritesAdapter
    }
}