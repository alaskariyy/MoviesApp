package id.mahdan.common.extension

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import id.mahdan.common.utils.Event

fun Fragment.showSnackbar(snackbarText: String, timeLength: Int) {
    activity?.let { Snackbar.make(it.findViewById<View>(android.R.id.content), snackbarText, timeLength).show() }
}

fun Fragment.setupSnackbar(lifecycleOwner: LifecycleOwner, snackbarEvent: LiveData<Event<Int>>, timeLength: Int) {
    snackbarEvent.observe(lifecycleOwner, Observer { event ->
        event.getContentIfNotHandled()?.let { res ->
            context?.let { showSnackbar(it.getString(res), timeLength) }
        }
    })
}

fun RecyclerView.onScrollToEnd(itemPosition: Int, onScrollNearEnd: (Unit) -> Unit)
        = addOnScrollListener(object : RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val linearLayoutManager = this@onScrollToEnd.layoutManager as LinearLayoutManager
        if (linearLayoutManager.childCount + linearLayoutManager.findFirstVisibleItemPosition()
            >= linearLayoutManager.itemCount - itemPosition) {
            onScrollNearEnd(Unit)
        }
    }
})