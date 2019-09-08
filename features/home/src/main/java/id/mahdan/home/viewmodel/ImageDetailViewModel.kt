package id.mahdan.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.mahdan.common.base.BaseViewModel

class ImageDetailViewModel: BaseViewModel(){

    // PRIVATE DATA
    private val _imageUrl = MutableLiveData<String>()
    val imageUrl: LiveData<String> get() = _imageUrl

    // PUBLIC ACTIONS ---
    fun loadImage(imageUrl: String) {
        _imageUrl.value = imageUrl
    }

}