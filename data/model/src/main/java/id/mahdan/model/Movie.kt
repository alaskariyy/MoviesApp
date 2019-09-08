package id.mahdan.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Movie(

    @PrimaryKey
    @SerializedName("imdbID")
    var id: String = "",

    @SerializedName("Title")
    var title: String = "",

    @SerializedName("Year")
    var year: String = "",

    @SerializedName("Type")
    var type: String = "",

    @SerializedName("Released")
    var released: String = "",

    @SerializedName("Runtime")
    var runtime: String = "",

    @SerializedName("Genre")
    var genre: String = "",

    @SerializedName("Writer")
    var writer: String = "",

    @SerializedName("Actors")
    var actors: String = "",

    @SerializedName("Plot")
    var plot: String = "",

    @SerializedName("Language")
    var language: String = "",

    @SerializedName("Country")
    var country: String = "",

    @SerializedName("Awards")
    var awards: String = "",

    @SerializedName("Poster")
    var poster: String = "",

    @SerializedName("imdbVotes")
    var imdbVotes: String = "",

    @SerializedName("imdbRating")
    var imdbRating: String = "",

    @SerializedName("Production")
    var production: String = "",

    // Catch error

    @SerializedName("Response")
    var response: String = "",

    @SerializedName("Error")
    var error: String = ""

)