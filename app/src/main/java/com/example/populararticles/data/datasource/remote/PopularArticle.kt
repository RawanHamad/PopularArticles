package com.example.populararticles.data.datasource.remote

import com.example.populararticles.domain.model.ArticleModel
import com.example.populararticles.utils.extension.empty
import com.squareup.moshi.Json

data class PopularArticle(
    @Json(name = "column")
    var column: String? = null,
    @Json(name = "section")
    private var section: String? = null,
    @Json(name = "abstract")
    var abstract: String? = null,
    @Json(name = "source")
    var source: String? = null,
    @Json(name = "asset_id")
    var assetId: Long? = null,
    @Json(name = "media")
    var media: List<Media>? = null,
    @Json(name = "type")
    var type: String? = null,
    @Json(name = "title")
    var title: String? = null,
    @Json(name = "url")
    var url: String? = null,
    @Json(name = "adx_keywords")
    var adxKeywords: String? = null,
    @Json(name = "id")
    var id: Long? = null,
    @Json(name = "byline")
    var byline: String? = null,
    @Json(name = "published_date")
    var publishedDate: String? = null,
    @Json(name = "views")
    var views: Int? = null
) {

    fun convertToModel() =
        ArticleModel(
            id = this.id,
            byline = this.byline ?: String.empty(),
            title = this.title ?: String.empty(),
            url = this.url ?: String.empty(),
            imageUrl = this.media!![0].mediaMetadata!![0].url?:String.empty(),
            publishedDate = this.publishedDate ?: String.empty()

        )

}