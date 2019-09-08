package id.mahdan.local

import id.mahdan.common_test.datasets.MovieDataSets.FAKE_MOVIE
import id.mahdan.common_test.datasets.MovieDataSets.FAKE_MOVIES
import id.mahdan.common_test.datasets.MovieDataSets.MOVIE_TITLE
import id.mahdan.local.base.BaseTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieDaoTest: BaseTest() {

    override fun setUp(){
        super.setUp()
        fillDatabase()
    }

    @Test
    fun searchSavedMovies() = runBlocking {
        val moviesResult = database.movieDao().searchMovie(MOVIE_TITLE)
        assertEquals(3, moviesResult.size)
        assertEquals(FAKE_MOVIES.first(), moviesResult.first())
    }

    @Test
    fun getSavedMovieAndUpdate() = runBlocking {
        val movieResult = database.movieDao().getMovie(FAKE_MOVIE.id)
        assertEquals(FAKE_MOVIES[2], movieResult)

        database.movieDao().saveMovie(FAKE_MOVIE)
        val updatedMovieResult = database.movieDao().getMovie(FAKE_MOVIE.id)
        assertEquals(FAKE_MOVIE.id, updatedMovieResult.id)
        assertEquals(FAKE_MOVIE.title, updatedMovieResult.title)
        assertEquals(FAKE_MOVIE.year, updatedMovieResult.year)
        assertEquals(FAKE_MOVIE.released, updatedMovieResult.released)
        assertEquals(FAKE_MOVIE.genre, updatedMovieResult.genre)
        assertEquals(FAKE_MOVIE.actors, updatedMovieResult.actors)
    }

    private fun fillDatabase() {
        runBlocking {
            database.movieDao().saveMovies(FAKE_MOVIES)
        }
    }
}