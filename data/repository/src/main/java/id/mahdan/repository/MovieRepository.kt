package id.mahdan.repository

import androidx.lifecycle.LiveData
import id.mahdan.local.dao.MovieDao
import id.mahdan.model.Movie
import id.mahdan.model.MovieSearch
import id.mahdan.remote.MovieDataSource
import id.mahdan.repository.utils.NetworkBoundResource
import id.mahdan.repository.utils.Resource
import retrofit2.Response

interface MovieRepository {
    suspend fun searchMovies(shouldFetch: Boolean, title: String, page: String, type: String): LiveData<Resource<MutableList<Movie>>>
    suspend fun getMovie(shouldFetch: Boolean,id: String): LiveData<Resource<Movie>>
}

class MovieRepositoryImpl(private val datasource: MovieDataSource,
                          private val dao: MovieDao): MovieRepository {
    override suspend fun searchMovies(shouldFetch: Boolean, title: String, page: String, type: String): LiveData<Resource<MutableList<Movie>>> {
        return object : NetworkBoundResource<MutableList<Movie>, MovieSearch>() {
            override fun processResponse(response: MovieSearch): MutableList<Movie>
                    = response.searchResult

            override suspend fun saveCallResults(items: MutableList<Movie>)
                    = dao.saveMovies(items)

            override fun shouldFetch(data: MutableList<Movie>?): Boolean
                    = data?.isEmpty() ?: true || shouldFetch

            // TODO: Implement paging in room
            override suspend fun loadFromDb(): MutableList<Movie>
                    = dao.searchMovie(title/*, page */)

            override suspend fun createCallAsync(): Response<MovieSearch>
                    = datasource.fetchSearchMovies(title, page, type)

        }.build().asLiveData()
    }

    override suspend fun getMovie(shouldFetch: Boolean,id: String): LiveData<Resource<Movie>> {
        return object : NetworkBoundResource<Movie, Movie>() {
            override fun processResponse(response: Movie): Movie
                    = response

            override suspend fun saveCallResults(items: Movie)
                    = dao.saveMovie(items)

            override fun shouldFetch(data: Movie?): Boolean
                    = data == null || shouldFetch

            override suspend fun loadFromDb(): Movie
                    = dao.getMovie(id)

            override suspend fun createCallAsync(): Response<Movie>
                    = datasource.fetchMovie(id)

        }.build().asLiveData()
    }

}