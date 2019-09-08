package id.mahdan.common_test.datasets

import id.mahdan.model.Movie
import id.mahdan.model.MovieSearch

object MovieDataSets {

    val MOVIE_TITLE = "Batman"
    val FAKE_MOVIES = mutableListOf(
        Movie(
            title = "Batman Begins",
            year = "2005",
            id = "tt0372784",
            type =  "movie",
            poster =  "https://m.media-amazon.com/images/M/MV5BZmUwNGU2ZmItMmRiNC00MjhlLTg5YWUtODMyNzkxODYzMmZlXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_SX300.jpg"),
        Movie(
            title = "Batman v Superman: Dawn of Justice",
            year = "2016",
            id = "tt2975590",
            type =  "movie",
            poster =  "https://m.media-amazon.com/images/M/MV5BYThjYzcyYzItNTVjNy00NDk0LTgwMWQtYjMwNmNlNWJhMzMyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg"),
        Movie(
            title = "Batman",
            year = "1989",
            id = "tt0096895",
            type =  "movie",
            poster =  "https://m.media-amazon.com/images/M/MV5BMTYwNjAyODIyMF5BMl5BanBnXkFtZTYwNDMwMDk2._V1_SX300.jpg"))
    val FAKE_MOVIE = Movie(
        title =  "Batman",
        year =  "1989",
        released =  "23 Jun 1989",
        runtime =  "126 min",
        genre =  "Action, Adventure",
        writer =  "Bob Kane (Batman characters), Sam Hamm (story), Sam Hamm (screenplay), Warren Skaaren (screenplay)",
        actors =  "Michael Keaton, Jack Nicholson, Kim Basinger, Robert Wuhl",
        plot =  "The Dark Knight of Gotham City begins his war on crime with his first major enemy being the clownishly homicidal Joker.",
        language =  "English, French, Spanish",
        country =  "USA, UK",
        awards =  "Won 1 Oscar. Another 8 wins & 26 nominations.",
        poster =  "https://m.media-amazon.com/images/M/MV5BMTYwNjAyODIyMF5BMl5BanBnXkFtZTYwNDMwMDk2._V1_SX300.jpg",
        imdbRating =  "7.5",
        imdbVotes =  "316,139",
        id =  "tt0096895",
        type =  "movie",
        production =  "Warner Bros. Pictures"
    )
    val FAKE_MOVIE_SEARCH = MovieSearch(
        searchResult = FAKE_MOVIES,
        totalResults = "3",
        response = "True"
    )

}