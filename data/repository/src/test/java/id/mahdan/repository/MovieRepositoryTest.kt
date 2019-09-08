package id.mahdan.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import id.mahdan.common_test.datasets.MovieDataSets.FAKE_MOVIES
import id.mahdan.common_test.datasets.MovieDataSets.FAKE_MOVIE_SEARCH
import id.mahdan.common_test.rules.CoroutinesMainDispatcherRule
import id.mahdan.local.dao.MovieDao
import id.mahdan.model.Movie
import id.mahdan.remote.MovieDataSource
import id.mahdan.repository.utils.Resource
import io.mockk.coEvery
import io.mockk.confirmVerified
import io.mockk.mockk
import io.mockk.verifyOrder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class MovieRepositoryTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesMainDispatcherRule = CoroutinesMainDispatcherRule()

    private lateinit var movieListObserver: Observer<Resource<List<Movie>>>
    private lateinit var movieObserver: Observer<Resource<Movie>>
    private lateinit var movieRepository: MovieRepository
    private val movieDataSource = mockk<MovieDataSource>()
    private val movieDao = mockk<MovieDao>(relaxed = true)

    @Before
    fun setUp() {
        movieListObserver = mockk(relaxed = true)
        movieObserver = mockk(relaxed = true)
        movieRepository = MovieRepositoryImpl(movieDataSource, movieDao)
    }

    @Test
    fun `when no internet get data from cache`() {
        val exception = Exception("Internet")
        coEvery { movieDataSource.fetchSearchMovies("","","") } throws exception
        coEvery { movieDao.searchMovie("") } returns FAKE_MOVIES

        runBlocking {
            movieRepository.searchMovies(true, "","","").observeForever(movieListObserver)
        }

        verifyOrder {
            movieListObserver.onChanged(Resource.loading(null))
            movieListObserver.onChanged(Resource.loading(FAKE_MOVIES))
            movieListObserver.onChanged(Resource.error(exception, FAKE_MOVIES))
        }
        confirmVerified(movieListObserver)
    }

    @Test
    fun `when database empty get data remote`() {
        coEvery { movieDataSource.fetchSearchMovies("","","") } returns Response.success(FAKE_MOVIE_SEARCH)
        coEvery { movieDao.searchMovie("") } returns mutableListOf() andThen { FAKE_MOVIES }

        runBlocking {
            movieRepository.searchMovies(true, "","","").observeForever(movieListObserver)
        }

        verifyOrder {
            movieListObserver.onChanged(Resource.loading(null))
            movieListObserver.onChanged(Resource.loading(emptyList()))
            movieListObserver.onChanged(Resource.success(FAKE_MOVIES))
        }
        confirmVerified(movieListObserver)
    }

}