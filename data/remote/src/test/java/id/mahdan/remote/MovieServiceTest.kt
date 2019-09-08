package id.mahdan.remote

import id.mahdan.common_test.datasets.MovieDataSets
import id.mahdan.remote.base.BaseTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.koin.test.inject
import java.net.HttpURLConnection

class MovieServiceTest: BaseTest() {

    private val movieService by inject<MovieService>()

    @Test
    fun `search movie success`(){
        mockHttpResponse(mockServer, "movie_search.json", HttpURLConnection.HTTP_OK)
        runBlocking {
            val movieSearchResult = movieService.searchMovies("","","","")
            Assert.assertEquals(3, movieSearchResult.body()?.searchResult?.size)
            Assert.assertEquals(MovieDataSets.FAKE_MOVIES.first(), movieSearchResult.body()?.searchResult?.first())
        }
    }

    @Test
    fun `search movie failed`(){
        mockHttpResponse(mockServer, "movie_search_error.json", HttpURLConnection.HTTP_OK)
        runBlocking {
            val movieSearchResult = movieService.searchMovies("", "", "", "")
            Assert.assertTrue(movieSearchResult.body()?.searchResult?.isEmpty()?: false)
        }
    }

    @Test
    fun `get movie success`(){
        mockHttpResponse(mockServer, "movie_detail.json", HttpURLConnection.HTTP_OK)
        runBlocking {
            val movieResult = movieService.getMovie("","")
            Assert.assertEquals(MovieDataSets.FAKE_MOVIE.id, movieResult.body()?.id)
            Assert.assertEquals(MovieDataSets.FAKE_MOVIE.title, movieResult.body()?.title)
            Assert.assertEquals(MovieDataSets.FAKE_MOVIE.year, movieResult.body()?.year)
            Assert.assertEquals(MovieDataSets.FAKE_MOVIE.released, movieResult.body()?.released)
            Assert.assertEquals(MovieDataSets.FAKE_MOVIE.genre, movieResult.body()?.genre)
            Assert.assertEquals(MovieDataSets.FAKE_MOVIE.actors, movieResult.body()?.actors)
        }
    }

}