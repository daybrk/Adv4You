package com.example.adv4you.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.adv4you.pojos.pojos_for_review.ReviewConsistent;
import com.example.adv4you.pojos.pojos_for_review.ReviewFlight;
import com.example.adv4you.pojos.pojos_for_review.ReviewImpulsive;
import com.example.adv4you.pojos.pojos_for_review.ReviewSeasonal;

import java.util.List;

public class ReviewViewModel extends AndroidViewModel {

    Repository repository;
    private final LiveData<List<ReviewConsistent>> reviewConsistent;
    private final LiveData<List<ReviewFlight>> reviewFlight;
    private final LiveData<List<ReviewSeasonal>> reviewSeasonal;
    private final LiveData<List<ReviewImpulsive>> reviewImpulsive;

    public ReviewViewModel(@NonNull Application application) {
        super(application);

        repository = new Repository(application);

        reviewConsistent = repository.getReviewConsistent();
        reviewFlight = repository.getReviewFlight();
        reviewSeasonal = repository.getReviewSeasonal();
        reviewImpulsive = repository.getReviewImpulsive();
    }

    public LiveData<List<ReviewConsistent>> getReviewConsistent() {
        return reviewConsistent;
    }

    public LiveData<List<ReviewFlight>> getReviewFlight() {
        return reviewFlight;
    }

    public LiveData<List<ReviewSeasonal>> getReviewSeasonal() {
        return reviewSeasonal;
    }

    public LiveData<List<ReviewImpulsive>> getReviewImpulsive() {
        return reviewImpulsive;
    }

    public void insertReviewConsistent (ReviewConsistent reviewConsistent) {
        repository.insertReviewConsistent(reviewConsistent);
    }

    public void insertReviewFlight (ReviewFlight reviewFlight) {
        repository.insertReviewFlight(reviewFlight);
    }

    public void insertReviewImpulsive (ReviewImpulsive reviewImpulsive) {
        repository.insertReviewImpulsive(reviewImpulsive);
    }

    public void insertReviewSeasonal (ReviewSeasonal reviewSeasonal) {
        repository.insertReviewSeasonal(reviewSeasonal);
    }

    public void deleteReviewConsistent() {
        repository.deleteReviewConsistent();
    }

    public void deleteReviewFlight() {
        repository.deleteReviewFlight();
    }

    public void deleteReviewImpulsive() {
        repository.deleteReviewImpulsive();
    }

    public void deleteReviewSeasonal() {
        repository.deleteReviewSeasonal();
    }

}
