package id.mahdan.remote

import id.mahdan.model.Movie
import id.mahdan.model.MovieSearch
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET(".")
    suspend fun searchMovies(
        @Query("apikey") apikey: String,
        @Query("s") search: String,
        @Query("page") page: String,
        @Query("type") type: String
    ): Response<MovieSearch>

    @GET(".")
    suspend fun getMovie(
        @Query("apikey") apikey: String,
        @Query("i") id: String
    ): Response<Movie>

}