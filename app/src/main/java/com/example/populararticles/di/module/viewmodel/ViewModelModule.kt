package com.example.populararticles.di.module.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.populararticles.ui.popular.PopularArticlesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(PopularArticlesViewModel::class)
    abstract fun bindsPopularListViewModel(popularViewModel: PopularArticlesViewModel): ViewModel


}