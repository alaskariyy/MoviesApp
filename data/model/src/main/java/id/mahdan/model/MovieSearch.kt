package id.mahdan.model

import com.google.gson.annotations.SerializedName

data class MovieSearch (

    @SerializedName("Search")
    var searchResult: MutableList<Movie> = mutableListOf(),

    @SerializedName("totalResults")
    var totalResults: String = "",

    // Catch error

    @SerializedName("Response")
    var response: String = "",

    @SerializedName("Error")
    var error: String = ""
)