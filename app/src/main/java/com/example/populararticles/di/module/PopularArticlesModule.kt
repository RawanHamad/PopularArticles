package com.example.populararticles.di.module

import com.example.populararticles.ui.popular.PopularArticlesListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PopularArticlesModule {

    @ContributesAndroidInjector
    abstract fun contributeMovieListFragment(): PopularArticlesListFragment
}