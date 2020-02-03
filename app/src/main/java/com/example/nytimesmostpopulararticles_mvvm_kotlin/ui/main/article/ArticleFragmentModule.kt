package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article

import dagger.Module
import dagger.Provides
import java.util.*

@Module
class ArticleFragmentModule {
    @Provides
    fun provideArticleAdapter(): ArticleAdapter {
        return ArticleAdapter(ArrayList())
    }
}