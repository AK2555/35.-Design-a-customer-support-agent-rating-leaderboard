package org.example.entities;

import java.util.Date;
import java.util.UUID;

public class Rating {
    private final String id;
    private int rating;
    private String ratingDate;

    public Rating(int rating,String ratingDate){
        this.id= UUID.randomUUID().toString();
        this.rating=rating;
        this.ratingDate=ratingDate;
    }

    public String getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(String ratingDate) {
        this.ratingDate = ratingDate;
    }
}
