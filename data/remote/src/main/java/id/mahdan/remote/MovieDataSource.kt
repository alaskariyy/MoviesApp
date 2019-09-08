package id.mahdan.remote

class MovieDataSource (
    var movieService: MovieService,
    val apiKey: String
){
    suspend fun fetchSearchMovies(search: String, page: String, type: String) =
        movieService.searchMovies(apiKey, search, page, type)

    suspend fun fetchMovie(id: String) =
        movieService.getMovie(apiKey, id)

}