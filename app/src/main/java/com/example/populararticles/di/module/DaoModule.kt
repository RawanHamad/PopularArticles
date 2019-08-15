package com.example.populararticles.di.module

import androidx.room.Room
import android.content.Context
import com.example.populararticles.data.datasource.local.PopularArticlesDatabase
import dagger.Module
import dagger.Provides

@Module
class DaoModule {
    companion object {
        private const val DATABASE_NAME = "FeedDatabase"
    }

    /**
     * Returns the database of the application.
     * @param context Context in which the application is running
     * @return the database of the application
     */
    @Provides
    fun provideFeedMeDatabase(context: Context): PopularArticlesDatabase {
        return Room.databaseBuilder(
            context.applicationContext, PopularArticlesDatabase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration().build()
    }
}