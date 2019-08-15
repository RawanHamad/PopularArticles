package com.example.populararticles.data.datasource.local

import androidx.room.*

@Dao
interface PopularArticlesDao {

    @Query("SELECT * FROM article")
    fun findAllPopular(): List<PopularArticleEntity>?

    @Query("SELECT * FROM article WHERE id = :id")
    fun findPopularById(id: Long): PopularArticleEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(map: List<PopularArticleEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(popular: PopularArticleEntity): Long

    @Transaction
    fun save(populars: List<PopularArticleEntity>): List<PopularArticleEntity> {
        populars.forEach {
            it.id = save(it)
        }
        return populars
    }

    @Query("DELETE FROM article")
    fun removeAll()
}