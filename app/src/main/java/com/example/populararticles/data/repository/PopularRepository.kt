package com.example.populararticles.data.repository

import com.example.populararticles.data.datasource.local.PopularArticleEntity.Companion.convertToData
import com.example.populararticles.data.datasource.local.PopularArticlesDatabase
import com.example.populararticles.data.datasource.remote.PopularArticleService
import com.example.populararticles.domain.error.Failure
import com.example.populararticles.domain.error.NoDataAvailableFailure
import com.example.populararticles.utils.NetworkHandler
import com.example.populararticles.domain.funtional.Either
import com.example.populararticles.domain.model.ArticleModel
import com.example.populararticles.domain.repository.Repository
import javax.inject.Inject

class PopularRepository @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val database: PopularArticlesDatabase,
    private val service: PopularArticleService) : Repository {

    override fun getPopulars(query: String?): Either<Failure, List<ArticleModel>> {
        val popularArticlesDao = database.popularArticlesDao()
        return when (networkHandler.isConnected) {
            true -> {
                val execute = service.getPopulars().execute()
                when (val response = ApiResponse.create(execute)) {
                    is ApiResponse.ApiEmptyResponse -> Either.Left(Failure.ServerError)
                    is ApiResponse.ApiSuccessResponse -> {
                        val map = response.body.results?.map { it.convertToModel()
                        }
                        map?.let { mapSafe ->
                            Either.Right(popularArticlesDao.save(convertToData(mapSafe)).map { it.convertToModel() })
                        } ?: run { Either.Left(Failure.ServerError) }


                    }
                    is ApiResponse.ApiErrorResponse -> Either.Left(Failure.ServerError)
                }
            }
            false -> {
                val populars = popularArticlesDao.findAllPopular()?.map { it.convertToModel() }
                populars?.let { Either.Right(it) } ?: kotlin.run { Either.Left(NoDataAvailableFailure()) }
            }
        }
    }

    override fun getPopulars(popularId: Long): Either<Failure, ArticleModel> {
        val popularArticle = database.popularArticlesDao().findPopularById(popularId)?.convertToModel()
        return popularArticle?.let { Either.Right(it) } ?: kotlin.run { Either.Left(NoDataAvailableFailure()) }
    }



}