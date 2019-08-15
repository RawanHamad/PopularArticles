package com.example.populararticles.ui.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.populararticles.databinding.ItemPopularBinding
import javax.inject.Inject
import kotlin.properties.Delegates

class PopularArticlesAdapter
@Inject constructor() : RecyclerView.Adapter<PopularArticlesAdapter.ViewHolder>() {

    internal var collection: List<PopularArticleView> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemPopularBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int){
        viewHolder.bind(collection[position])}

    override fun getItemCount(): Int {
        return collection.size}

    class ViewHolder(private val itemPopularBinding: ItemPopularBinding) : RecyclerView.ViewHolder(itemPopularBinding.root) {
        fun bind(popularArticleView: PopularArticleView) {
            itemPopularBinding.feed = popularArticleView
            itemPopularBinding.executePendingBindings()
        }
    }
}