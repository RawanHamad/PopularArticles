package com.example.populararticles.data.datasource.remote

import com.squareup.moshi.Json

data class MediaMetaData(
    @Json(name = "format")
    val format: String? = null,
    @Json(name = "width")
    val width: Int? = null,
    @Json(name = "url")
    val url: String? = null,
    @Json(name = "height")
    val height: Int? = null
)