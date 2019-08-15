package com.example.populararticles.di.component

import android.app.Application
import com.example.populararticles.ArticlesApplication
import com.example.populararticles.data.datasource.local.PopularArticlesDatabase
import com.example.populararticles.di.module.ActivityBindingModule
import com.example.populararticles.di.module.AppModule
import com.example.populararticles.di.module.DaoModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, DaoModule::class, ActivityBindingModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun dataBase(): PopularArticlesDatabase

    fun inject(articlesApplication: ArticlesApplication)
}