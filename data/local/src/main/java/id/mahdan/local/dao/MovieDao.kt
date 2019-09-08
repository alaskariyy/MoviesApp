package id.mahdan.local.dao

import androidx.room.*
import id.mahdan.model.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM Movie WHERE title LIKE '%' || :search || '%' ORDER BY title ASC")
    suspend fun searchMovie(search: String): MutableList<Movie>

    @Query("SELECT * FROM Movie WHERE id IS :id")
    suspend fun getMovie(id: String): Movie

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movies: Movie)

}