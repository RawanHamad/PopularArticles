package com.example.populararticles.data.datasource.remote

import com.squareup.moshi.Json

data class PopularArticlesResponse(
    @Json(name = "status")
    var status: String? = null,
    @Json(name = "copyright")
    var copyright: String? = null,
    @Json(name = "num_results")
    var numResults: Int? = null,
    @Json(name = "results")
    var results: List<PopularArticle>? = null

)