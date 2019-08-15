package com.example.populararticles.data.datasource.remote

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PopularArticleService
@Inject constructor(retrofit: Retrofit) : PopularArticlesApi {

    private val popularApi by lazy { retrofit.create(PopularArticlesApi::class.java) }
    override fun getPopulars(sections: String?, period: String?) = popularApi.getPopulars(sections, period)
}