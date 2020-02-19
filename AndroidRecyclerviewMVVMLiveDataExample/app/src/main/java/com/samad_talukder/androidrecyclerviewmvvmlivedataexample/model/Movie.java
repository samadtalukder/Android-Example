package com.samad_talukder.androidrecyclerviewmvvmlivedataexample.model;

public class Movie {

    private String movieTitle;
    private int moviePoster;
    private String movieGenre;
    private String movieReleaseDate;

    public Movie(String movieTitle, int moviePoster, String movieGenre, String movieReleaseDate) {

        this.movieTitle = movieTitle;
        this.moviePoster = moviePoster;
        this.movieGenre = movieGenre;
        this.movieReleaseDate = movieReleaseDate;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public int getMoviePoster() {
        return moviePoster;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }
}
