package com.example.populararticles.di.module

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import com.example.populararticles.ArticlesApplication
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import com.example.populararticles.di.component.DaggerAppComponent

/**
 * Helper class to automatically inject fragments if they implement [Injectable].
 */
object AppInjector {
    fun init(app: ArticlesApplication) {
        DaggerAppComponent.builder().application(app)
            .build().inject(app)
        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                handleActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {

            }

            override fun onActivityResumed(activity: Activity) {

            }

            override fun onActivityPaused(activity: Activity) {

            }

            override fun onActivityStopped(activity: Activity) {

            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {

            }

            override fun onActivityDestroyed(activity: Activity) {

            }
        })
    }

    private fun handleActivity(activity: Activity) {
        if (activity is HasSupportFragmentInjector) {
            AndroidInjection.inject(activity)
        }
        if (activity is androidx.fragment.app.FragmentActivity) {
            activity.supportFragmentManager
                .registerFragmentLifecycleCallbacks(
                    object : androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentAttached(fm: androidx.fragment.app.FragmentManager, f: androidx.fragment.app.Fragment, context: Context) {
                            if (f is Injectable) {
                                AndroidSupportInjection.inject(f)
                            }
                        }

                    }, true
                )
        }
    }
}