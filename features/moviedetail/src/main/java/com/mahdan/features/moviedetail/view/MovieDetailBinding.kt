package com.mahdan.features.moviedetail.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import coil.api.load
import com.mahdan.features.moviedetail.R

object MovieDetailBinding {

    @BindingAdapter("app:whenRefreshing")
    @JvmStatic
    fun showWhenLoading(view: SwipeRefreshLayout, isRefreshing: Boolean?) {
        view.isRefreshing = isRefreshing?: false
    }

    @BindingAdapter("app:imageUrl")
    @JvmStatic fun loadImage(view: ImageView, url: String?) {
        view.load(url) {
            crossfade(true)
            placeholder(R.drawable.ic_broken_image)
        }
    }
}