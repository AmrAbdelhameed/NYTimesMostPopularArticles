package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.favorites

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FavoritesFragmentProvider {
    @ContributesAndroidInjector
    abstract fun provideFavoritesFragmentFactory(): FavoritesFragment
}