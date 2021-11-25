package com.example.adv4you.pojos;

public class Review {

    String name;

    String review;

    public Review(String name, String review) {
        this.name = name;
        this.review = review;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
