package com.example.populararticles.ui.popular

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.populararticles.BR
import com.example.populararticles.domain.model.ArticleModel

class PopularArticleView(
    id: Long = -1,
    byline: String="",
    title: String = "",
    url: String = "",
    imageUrl: String = "",
    publishedDate: String=""
) : BaseObservable() {

    @Bindable
    var id: Long = id
        set(value) {
            field = value
            notifyPropertyChanged(BR.id)
        }

    @Bindable
    var byline: String = byline
        set(value) {
            field = value
            notifyPropertyChanged(BR.byline)
        }

    @Bindable
    var title: String = title
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }



    @Bindable
    var url: String = url
        set(value) {
            field = value
            notifyPropertyChanged(BR.url)
        }

    @Bindable
    var imageUrl: String = imageUrl
        set(value) {
            field = value
            notifyPropertyChanged(BR.imageUrl)
        }

    @Bindable
    var publishedDate: String = publishedDate
        set(value) {
            field = value
            notifyPropertyChanged(BR.publishedDate)
        }

    fun parseToData(article: ArticleModel) {
        this.id = article.id ?: -1
        this.byline=article.byline
        this.title = article.title
        this.url = article.url
        this.imageUrl = article.imageUrl
        this.publishedDate=article.publishedDate
    }

    companion object {

        fun convertToData(article: ArticleModel) = PopularArticleView(
            article.id ?: -1,
            article.byline,
            article.title,
            article.url,
            article.imageUrl,
            article.publishedDate

        )

        fun convertToData(article: List<ArticleModel>) = article.map {
            convertToData(
                it
            )
        }
    }

}