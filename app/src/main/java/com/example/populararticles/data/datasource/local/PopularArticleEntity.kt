package com.example.populararticles.data.datasource.local

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.populararticles.domain.model.ArticleModel

@Entity(tableName = "article")
data class PopularArticleEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Long? = null,
    @ColumnInfo(name = "byline")
    var byline: String,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "url")
    var url: String,
    @ColumnInfo(name = "imageUrl")
    var imageUrl: String,
    @ColumnInfo(name = "published_date")
    var publishedDate: String
) {
    companion object {
        fun convertToData(article: ArticleModel) =
            PopularArticleEntity(
                id = article.id,
                byline = article.byline,
                title = article.title,
                url = article.url,
                imageUrl = article.imageUrl,
                publishedDate = article.publishedDate
            )

        fun convertToData(feeds: List<ArticleModel>) = feeds.map { convertToData(it) }
    }

    fun convertToModel() =
        ArticleModel(
            id = this.id,
            byline = this.byline,
            title = this.title,
            url = this.url,
            imageUrl = this.imageUrl,
            publishedDate = this.publishedDate
        )
}
