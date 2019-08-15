package com.example.populararticles.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [PopularArticleEntity::class], version = 1)
abstract class PopularArticlesDatabase : RoomDatabase() {
    abstract fun popularArticlesDao(): PopularArticlesDao
}