package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
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
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.api.ArticlesResponse
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.databinding.FragmentArticleBinding
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseFragment
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.MainActivity
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article.ArticleAdapter.ArticleAdapterListener
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.AppConstants
import javax.inject.Inject

class ArticleFragment : BaseFragment<FragmentArticleBinding?, ArticleViewModel?>(),
    ArticleNavigator, ArticleAdapterListener {
    @Inject
    lateinit var factory: ViewModelProviderFactory
    @Inject
    lateinit var articleAdapter: ArticleAdapter
    private var fragmentArticleBinding: FragmentArticleBinding? = null
    private var articleViewModel: ArticleViewModel? = null
    private var navController: NavController? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_article

    override val viewModel: ArticleViewModel?
        get() {
            articleViewModel = ViewModelProvider(this, factory).get(ArticleViewModel::class.java)
            return articleViewModel
        }

    override fun onRetryClick() {
        articleViewModel!!.fetchArticles(7)
    }

    override fun onItemClick(article: ArticlesResponse.Article?) {
        val bundle = Bundle()
        bundle.putParcelable(
            AppConstants.ARTICLE,
            Article(
                article!!.id
                , article.media?.get(0)?.mediametadata?.get(2)?.url
                , article.title
                , article.byline
                , article.abstractX
                , article.published_date
                , article.url,
                article.media?.get(0)?.mediametadata?.get(1)?.url
            )
        )
        navController!!.navigate(R.id.action_articleFragment_to_articleDetailsFragment, bundle)
    }

    override fun handleError(throwable: Throwable?) {
        Toast.makeText(activity, throwable!!.message, Toast.LENGTH_SHORT).show()
    }

    override fun updateArticle(articles: List<ArticlesResponse.Article?>?) {
        articleAdapter.addItems(articles)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        articleViewModel!!.setNavigator(this)
        articleAdapter.setListener(this)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        fragmentArticleBinding = getViewDataBinding()
        navController = Navigation.findNavController(view)
        setUp()
    }

    private fun setUp() {
        if (activity != null) (activity as MainActivity?)!!.setSupportActionBar(
            fragmentArticleBinding!!.toolbar
        )
        setHasOptionsMenu(true)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        fragmentArticleBinding!!.resultsBeanRecyclerView.layoutManager = LinearLayoutManager(
            activity
        )
        fragmentArticleBinding!!.resultsBeanRecyclerView.itemAnimator = DefaultItemAnimator()
        fragmentArticleBinding!!.resultsBeanRecyclerView.adapter = articleAdapter
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
            navController!!.navigate(R.id.action_articleFragment_to_favoritesFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}