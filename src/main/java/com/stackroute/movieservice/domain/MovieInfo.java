package com.stackroute.movieservice.domain;


import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@ApiModel(description = "All details about the Movie")
public class MovieInfo {

    @Override
    public String toString() {
        return "MovieInfo{" +
                "movieId=" + movieId +
                ", movieLanguage='" + movieLanguage + '\'' +
                ", movieOverview='" + movieOverview + '\'' +
                ", movieName='" + movieName + '\'' +
                '}';
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public void setMovieOverview(String movieOverview) {
        this.movieOverview = movieOverview;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Id
    private long movieId;
    private String movieLanguage;

    public MovieInfo(long movieId, String movieLanguage, String movieOverview, String movieName) {
        this.movieId = movieId;
        this.movieLanguage = movieLanguage;
        this.movieOverview = movieOverview;
        this.movieName = movieName;
    }

    public MovieInfo() {
    }

    private String movieOverview;
    private String movieName;

}
