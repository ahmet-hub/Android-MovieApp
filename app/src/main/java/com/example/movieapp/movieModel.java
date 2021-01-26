package com.example.movieapp;

public class movieModel {
    String movieName;
    String movieDate;
    String movieThumb;

    public movieModel(String movieName, String movieDate, String movieThumb) {
        this.movieName = movieName;
        this.movieDate = movieDate;
        this.movieThumb = movieThumb;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public String getMovieThumb() {
        return movieThumb;
    }

    public void setMovieThumb(String movieThumb) {
        this.movieThumb = movieThumb;
    }
}
