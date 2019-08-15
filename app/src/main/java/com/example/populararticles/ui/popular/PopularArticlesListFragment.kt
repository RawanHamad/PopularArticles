package com.example.populararticles.ui.popular

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.populararticles.R
import com.example.populararticles.base.BaseFragmentBinding
import com.example.populararticles.databinding.PopularListFragmentBinding
import com.example.populararticles.domain.error.Failure
import com.example.populararticles.domain.error.NoDataAvailableFailure
import com.example.populararticles.utils.extension.*
import kotlinx.android.synthetic.main.popular_list_fragment.*
import javax.inject.Inject

class PopularArticlesListFragment : BaseFragmentBinding<PopularListFragmentBinding>() {
    @Inject
    lateinit var popularAdapter: PopularArticlesAdapter

    override fun layoutId() = R.layout.popular_list_fragment

    private lateinit var listViewModel: PopularArticlesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listViewModel = viewModel(viewModelFactory) {

            observe(populars, ::renderPopulars)
            failure(failure, ::handleFailure)
        }

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        if (popularAdapter.collection.isEmpty())
            loadPopulars()
    }


    private fun initializeView() {
        popularList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        popularList.adapter = popularAdapter
        popularList.itemAnimator = DefaultItemAnimator()
        popularList.setHasFixedSize(true)

    }

    private fun loadPopulars() {
        emptyView.invisible()
        popularList.visible()
        showProgress()
        listViewModel.leadPopulars()
    }

    private fun renderPopulars(populars: List<PopularArticleView>?) {
        popularAdapter.collection = populars.orEmpty()
        hideProgress()
    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> renderFailure(R.string.failure_network_connection)
            is Failure.ServerError -> renderFailure(R.string.failure_server_error)
            is NoDataAvailableFailure -> renderFailure(R.string.not_data_available)
        }
    }

    private fun renderFailure(@StringRes message: Int) {
        popularList.invisible()
        emptyView.visible()
        hideProgress()
        notifyWithAction(message, R.string.refresh, ::loadPopulars)
    }


}