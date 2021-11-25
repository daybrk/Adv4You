package com.example.adv4you.lifecycles;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;

import com.example.adv4you.DataFromDB;
import com.example.adv4you.ReViewRecycler;
import com.example.adv4you.activitys.Reviews;
import com.example.adv4you.pojos.Review;
import com.example.adv4you.pojos.pojos_for_review.ReviewConsistent;
import com.example.adv4you.pojos.pojos_for_review.ReviewFlight;
import com.example.adv4you.pojos.pojos_for_review.ReviewImpulsive;
import com.example.adv4you.pojos.pojos_for_review.ReviewSeasonal;

import java.util.List;

public class LifecycleReviews implements LifecycleObserver, LifecycleOwner {

    boolean consistent = false;
    boolean flight = false;
    boolean impulsive = false;
    boolean seasonal = false;

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void initViewModel () {

        switch (Reviews.intent.getStringExtra("type")) {
            case "Последовательно-постоянный":

                Reviews.getViewModel().getReviewConsistent().observe(this, new Observer<List<ReviewConsistent>>() {
                    @Override
                    public void onChanged(List<ReviewConsistent> reviewConsistent) {
                        Reviews.setmReviewConsistent(reviewConsistent);
                        if (!consistent) {
                            DataFromDB.getDataFromDB("consistent");
                            consistent = true;
                        } else {
                            Reviews.getRecyclerView().getAdapter().notifyDataSetChanged();
                        }
                    }
                });

                break;
            case "Флайтовый":


                Reviews.getViewModel().getReviewFlight().observe(this, new Observer<List<ReviewFlight>>() {
                    @Override
                    public void onChanged(List<ReviewFlight> reviewFlight) {
                        Reviews.setmReviewFlight(reviewFlight);
                        if (!flight) {
                            DataFromDB.getDataFromDB("flight");
                            flight = true;
                        } else {
                            Reviews.getRecyclerView().getAdapter().notifyDataSetChanged();
                        }
                    }
                });

                break;
            case "Импульсивный":

                Reviews.getViewModel().getReviewImpulsive().observe(this, new Observer<List<ReviewImpulsive>>() {
                    @Override
                    public void onChanged(List<ReviewImpulsive> reviewImpulsive) {
                        Reviews.setmReviewImpulsive(reviewImpulsive);
                        if (!impulsive) {
                            DataFromDB.getDataFromDB("impulsive");
                            impulsive = true;
                        } else {
                            Reviews.getRecyclerView().getAdapter().notifyDataSetChanged();
                        }
                    }
                });

                break;
            case "Сезонный":

                Reviews.getViewModel().getReviewSeasonal().observe(this, new Observer<List<ReviewSeasonal>>() {
                    @Override
                    public void onChanged(List<ReviewSeasonal> reviewSeasonal) {
                        Reviews.setmReviewSeasonal(reviewSeasonal);
                        if (!seasonal) {
                            DataFromDB.getDataFromDB("seasonal");
                            seasonal = true;
                        } else {
                            Reviews.getRecyclerView().getAdapter().notifyDataSetChanged();
                        }
                    }
                });


                break;
        }

    }



    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void closeActivity() {
        consistent = false;
        flight = false;
        impulsive = false;
        seasonal = false;
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return Reviews.lifecycle;
    }
}
