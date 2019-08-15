package com.example.populararticles.ui.popular

import androidx.lifecycle.MutableLiveData
import com.example.populararticles.base.BaseViewModel
import com.example.populararticles.domain.funtional.fold
import com.example.populararticles.domain.interactor.GetPopularArticles
import com.example.populararticles.domain.model.ArticleModel
import javax.inject.Inject

class PopularArticlesViewModel  @Inject constructor(private val getPopulars: GetPopularArticles) : BaseViewModel() {
    var popularList = ArrayList<PopularArticleView>()
    var populars: MutableLiveData<List<PopularArticleView>> = MutableLiveData()

    fun leadPopulars(query: String? = null) {
        getPopulars(query) { it.fold(::handleFailure, ::handleResult) }
    }

    private fun handleResult(populars: List<ArticleModel>) {
        popularList.addAll(PopularArticleView.convertToData(populars))
        this.populars.value = popularList
    }

}