package org.example.entities;

public class Pair{
   private  double avgRating;
   private  int ratingCnt;
    public Pair(double monthAvgRating,int monthRatingCnt){
        this.avgRating =monthAvgRating;
        this.ratingCnt=monthRatingCnt;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public int getRatingCnt() {
        return ratingCnt;
    }

    public void setRatingCnt(int ratingCnt) {
        this.ratingCnt = ratingCnt;
    }
}