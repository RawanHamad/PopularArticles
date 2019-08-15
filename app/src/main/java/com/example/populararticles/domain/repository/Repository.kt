package com.example.populararticles.domain.repository

import com.example.populararticles.domain.error.Failure
import com.example.populararticles.domain.funtional.Either
import com.example.populararticles.domain.model.ArticleModel

interface Repository {

    fun getPopulars(query: String?): Either<Failure, List<ArticleModel>>

    fun getPopulars(popularId: Long): Either<Failure, ArticleModel>
}