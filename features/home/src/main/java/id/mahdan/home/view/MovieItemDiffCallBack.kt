package id.mahdan.home.view

import androidx.recyclerview.widget.DiffUtil
import id.mahdan.model.Movie

class MovieItemDiffCallBack(private val oldList: List<Movie>,
                            private val newList: List<Movie>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)
            = oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }
}