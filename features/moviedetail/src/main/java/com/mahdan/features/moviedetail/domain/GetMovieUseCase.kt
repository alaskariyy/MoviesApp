package com.mahdan.features.moviedetail.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import id.mahdan.model.Movie
import id.mahdan.repository.MovieRepository
import id.mahdan.repository.utils.Resource

class GetMovieUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke(id: String): LiveData<Resource<Movie>> {
        return Transformations.map(repository.getMovie(true, id)) {
            it // Place here your specific logic actions
        }
    }
}