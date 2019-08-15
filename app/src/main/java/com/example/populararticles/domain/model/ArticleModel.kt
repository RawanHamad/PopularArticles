package com.example.populararticles.domain.model

import com.example.populararticles.testing.OpenForTesting

@OpenForTesting
data class ArticleModel(
    val id: Long? = null,
    val byline: String,
    val title: String,
    val url: String,
    val imageUrl:String,
    val publishedDate: String
)