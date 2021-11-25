package com.example.adv4you.view_model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.adv4you.dao.ReviewDAO;
import com.example.adv4you.dao.ReviewDatabase;
import com.example.adv4you.pojos.pojos_for_review.ReviewConsistent;
import com.example.adv4you.pojos.pojos_for_review.ReviewFlight;
import com.example.adv4you.pojos.pojos_for_review.ReviewImpulsive;
import com.example.adv4you.pojos.pojos_for_review.ReviewSeasonal;

import java.util.List;

public class Repository {

    LiveData<List<ReviewConsistent>> reviewConsistent;
    LiveData<List<ReviewFlight>> reviewFlight;
    LiveData<List<ReviewSeasonal>> reviewSeasonal;
    LiveData<List<ReviewImpulsive>> reviewImpulsive;

    ReviewDAO dao;

    public Repository(Application application) {
        ReviewDatabase rd = ReviewDatabase.getDatabase(application);

        dao = rd.reviewDAO();

        reviewConsistent = dao.loadAllReviewConsistent();
        reviewFlight = dao.loadAllReviewFlight();
        reviewSeasonal = dao.loadAllReviewSeasonal();
        reviewImpulsive = dao.loadAllReviewImpulsive();
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

    void insertReviewConsistent (ReviewConsistent reviewConsistent) {
        ReviewDatabase.dbWriteExecutor.execute(() -> dao.insertReviewConsistent(reviewConsistent));
    }

    void insertReviewFlight (ReviewFlight reviewFlight) {
        ReviewDatabase.dbWriteExecutor.execute(() -> dao.insertReviewFlight(reviewFlight));

    }

    void insertReviewImpulsive (ReviewImpulsive reviewImpulsive) {
        ReviewDatabase.dbWriteExecutor.execute(() -> dao.insertReviewImpulsive(reviewImpulsive));
    }

    void insertReviewSeasonal (ReviewSeasonal reviewSeasonal) {
        ReviewDatabase.dbWriteExecutor.execute(() -> dao.insertReviewSeasonal(reviewSeasonal));
    }

    void deleteReviewConsistent() {
        dao.deleteReviewConsistent();
    }

    void deleteReviewFlight() {
        dao.deleteReviewFlight();
    }

    void deleteReviewImpulsive() {
        dao.deleteReviewImpulsive();
    }

    void deleteReviewSeasonal() {
        dao.deleteReviewSeasonal();
    }

}
