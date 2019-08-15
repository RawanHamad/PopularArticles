package com.example.populararticles.di.module

import com.example.populararticles.di.scoped.ActivityScoped
import com.example.populararticles.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {


    @ActivityScoped
    @ContributesAndroidInjector(modules = [PopularArticlesModule::class])
    abstract fun binMainActivity(): MainActivity

}