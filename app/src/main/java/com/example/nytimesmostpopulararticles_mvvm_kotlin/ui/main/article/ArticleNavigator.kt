package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article

import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.api.ArticlesResponse
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseNavigator

interface ArticleNavigator : BaseNavigator<List<ArticlesResponse.Article>>