package com.example.populararticles.domain.interactor

import com.example.populararticles.data.repository.PopularRepository
import com.example.populararticles.domain.model.ArticleModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetPopularArticles
@Inject constructor(private val popularRepository: PopularRepository) : UseCase<List<ArticleModel>, String?>() {

    override suspend fun run(params: String?) = popularRepository.getPopulars(params)

}