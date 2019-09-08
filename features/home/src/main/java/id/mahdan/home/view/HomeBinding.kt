package id.mahdan.home.view

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import coil.api.load
import id.mahdan.home.R
import id.mahdan.model.Movie
import id.mahdan.repository.utils.Resource

object HomeBinding {

    @BindingAdapter("app:whenRefreshing")
    @JvmStatic
    fun <T>showWhenLoading(view: SwipeRefreshLayout, resource: Resource<T>?) {
        Log.d(HomeBinding::class.java.simpleName, "Resource: $resource")
        if (resource != null) view.isRefreshing = resource.status == Resource.Status.LOADING
    }

    @BindingAdapter("app:movies")
    @JvmStatic fun setMovies(recyclerView: RecyclerView, resource: Resource<List<Movie>>?) {
        with(recyclerView.adapter as MovieAdapter) {
            resource?.data?.let { updateData(it) }
        }
    }

    @BindingAdapter("app:imageUrl")
    @JvmStatic fun loadImage(view: ImageView, url: String?) {
        view.load(url) {
            crossfade(true)
            placeholder(R.drawable.ic_broken_image)
        }
    }
}