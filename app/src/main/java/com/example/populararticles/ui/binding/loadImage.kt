package com.example.populararticles.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.populararticles.R
import com.example.populararticles.utils.extension.loadFromUrl

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String?) =
    url?.let { if (it.isNotBlank()) this.loadFromUrl(url, R.drawable.ic_broken_image) }