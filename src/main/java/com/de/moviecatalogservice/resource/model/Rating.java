package com.de.moviecatalogservice.resource.model;

import java.util.Objects;

public class Rating {

    private Integer movieId;
    private Integer rating;

    public Rating() {
    }

    public Rating(Integer movieId, Integer rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return Objects.equals(movieId, rating1.movieId) &&
                Objects.equals(rating, rating1.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, rating);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "movieId=" + movieId +
                ", rating=" + rating +
                '}';
    }
}
