package com.example.populararticles

import android.app.Activity
import android.app.Application
import com.example.populararticles.di.module.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class ArticlesApplication  : Application(), HasActivityInjector {


    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
    }

    private fun injectMembers() = AppInjector.init(this)

}