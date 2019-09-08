package com.mahdan.features.moviedetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mahdan.features.moviedetail.R
import com.mahdan.features.moviedetail.domain.GetMovieUseCase
import id.mahdan.common.base.BaseViewModel
import id.mahdan.model.Movie
import id.mahdan.repository.AppDispatchers
import id.mahdan.repository.utils.Resource
import id.mahdan.repository.utils.Resource.Status
import id.mahdan.common.utils.Event
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailViewModel(private val getMovieUseCase: GetMovieUseCase,
                           private val dispatchers: AppDispatchers) : BaseViewModel() {
    private lateinit var currentId: String

    private val _movie = MediatorLiveData<Movie>()
    val movie: LiveData<Movie> get() = _movie

    private val _showLoading = MutableLiveData<Boolean>()
    val showLoading: LiveData<Boolean> get() = _showLoading

    private var movieSource: LiveData<Resource<Movie>> = MutableLiveData<Resource<Movie>>()

    fun userRefreshes(){
        getMovie(currentId)
    }

    fun getMovie(id: String) = viewModelScope.launch(dispatchers.main) {
        currentId = id
        _movie.removeSource(movieSource)
        withContext(dispatchers.io) { movieSource = getMovieUseCase(id) }
        if (!movieSource.hasActiveObservers()) {
            _movie.addSource(movieSource) {
                _showLoading.postValue(it.status == Status.LOADING)
                _movie.postValue(it.data)
                if (it.status == Status.ERROR) _snackbarError.value = Event(R.string.error_happened)
            }
        }
    }

}