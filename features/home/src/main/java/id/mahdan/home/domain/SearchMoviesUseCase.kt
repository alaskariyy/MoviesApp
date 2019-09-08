package id.mahdan.home.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import id.mahdan.model.Movie
import id.mahdan.repository.MovieRepository
import id.mahdan.repository.utils.Resource

class SearchMoviesUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke(shouldFetch: Boolean = true,
                                title: String,
                                page: String,
                                type: String = "movie"): LiveData<Resource<MutableList<Movie>>> {
        return Transformations.map(repository.searchMovies(shouldFetch, title, page, type)) {
            it // TODO: Place specific logic actions
        }
    }
}