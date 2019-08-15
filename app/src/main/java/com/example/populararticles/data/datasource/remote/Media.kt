package com.example.populararticles.data.datasource.remote

import com.squareup.moshi.Json

data class Media(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "copyright")
    val copyright: String? = null,
    @Json(name = "media-metadata")
    val mediaMetadata: List<MediaMetaData>? = null,
    @Json(name = "subtype-metadata")
    val subtype: String? = null,
    @Json(name = "caption")
    val caption: String? = null,
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "approved_for_syndication")
    val approvedForSyndication: Int? = null
)