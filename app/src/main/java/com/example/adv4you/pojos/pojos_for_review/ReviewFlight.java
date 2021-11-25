package com.example.adv4you.pojos.pojos_for_review;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ReviewFlight")
public class ReviewFlight {

    @PrimaryKey(autoGenerate = true)
    int id;

    String name;

    String review;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
