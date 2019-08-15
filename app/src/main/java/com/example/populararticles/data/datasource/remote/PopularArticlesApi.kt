package com.example.populararticles.data.datasource.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PopularArticlesApi  {
    companion object {
        private const val VERSION = "v2"
        private const val BASE_PATH = "svc/mostpopular/$VERSION/mostviewed/{sections}/{period}.json?"
        private const val KEY_SECTION = "sections"
        private const val KEY_PERIOD = "period"
    }

    @GET(BASE_PATH)
    fun getPopulars(
        @Path(KEY_SECTION) sections: String? = "all-sections",
        @Path(KEY_PERIOD) period: String? = "7"
    ): Call<PopularArticlesResponse>

}
