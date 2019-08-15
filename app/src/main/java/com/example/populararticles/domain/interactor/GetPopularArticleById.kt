package com.example.populararticles.domain.interactor

import com.example.populararticles.data.repository.PopularRepository
import com.example.populararticles.domain.model.ArticleModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetPopularArticleById
@Inject constructor(private val popularRepository: PopularRepository) : UseCase<ArticleModel, Long>() {

    override suspend fun run(params: Long) = popularRepository.getPopulars(params)

}