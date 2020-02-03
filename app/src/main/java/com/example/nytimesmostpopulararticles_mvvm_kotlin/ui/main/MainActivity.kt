package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.nytimesmostpopulararticles_mvvm_kotlin.BR
import com.example.nytimesmostpopulararticles_mvvm_kotlin.R
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ViewModelProviderFactory
import com.example.nytimesmostpopulararticles_mvvm_kotlin.databinding.ActivityMainBinding
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding?, MainViewModel?>(),
    HasAndroidInjector {
    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    @Inject
    lateinit var factory: ViewModelProviderFactory
    private var mActivityMainBinding: ActivityMainBinding? = null
    private var mainViewModel: MainViewModel? = null

    override fun androidInjector(): AndroidInjector<Any> {
        return fragmentDispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityMainBinding = getViewDataBinding()
    }

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel?
        get() {
            mainViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
            return mainViewModel as MainViewModel
        }
}