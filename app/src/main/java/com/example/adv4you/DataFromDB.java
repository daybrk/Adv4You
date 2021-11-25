package com.example.adv4you;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.adv4you.activitys.Reviews;
import com.example.adv4you.lifecycles.LifecycleOption;
import com.example.adv4you.pojos.pojos_for_review.ReviewConsistent;
import com.example.adv4you.pojos.pojos_for_review.ReviewFlight;
import com.example.adv4you.pojos.pojos_for_review.ReviewImpulsive;
import com.example.adv4you.pojos.pojos_for_review.ReviewSeasonal;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class DataFromDB {

    String type;


    public static void getDataFromDB(String type) {

        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                switch (type) {
                    case "consistent":
                        Reviews.getViewModel().deleteReviewConsistent();

                        break;
                    case "flight":
                        Reviews.getViewModel().deleteReviewFlight();

                        break;
                    case "impulsive":
                        Reviews.getViewModel().deleteReviewImpulsive();

                        break;
                    case "seasonal":
                        Reviews.getViewModel().deleteReviewSeasonal();

                        break;
                }

                snapshot = snapshot.child("/" + type + "/reviews");

                int i = 0;
                for (DataSnapshot ds : snapshot.getChildren()) {
                    addDataToRoomDB(ds, type);
                    i++;
                }

                switch (type) {
                    case "consistent":
                        Reviews.getRecyclerView().setAdapter(new ReViewRecycler(Reviews.getmReviewConsistent(), null, null, null));
                        break;
                    case "flight":
                        Reviews.getRecyclerView().setAdapter(new ReViewRecycler(null, Reviews.getmReviewFlight(), null, null));
                        break;
                    case "impulsive":
                        Reviews.getRecyclerView().setAdapter(new ReViewRecycler(null, null, Reviews.getmReviewImpulsive(), null));
                        break;
                    case "seasonal":
                        Reviews.getRecyclerView().setAdapter(new ReViewRecycler(null, null, null, Reviews.getmReviewSeasonal()));
                        break;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        LifecycleOption.getRef().addValueEventListener(vListener);

    }

    private static void addDataToRoomDB(DataSnapshot ds, String type) {

        switch (type) {
            case "consistent":
                ReviewConsistent reviewConsistent = new ReviewConsistent();
                reviewConsistent.setName(String.valueOf(ds.child("name").getValue()));
                reviewConsistent.setReview(String.valueOf(ds.child("review").getValue()));
                Reviews.getViewModel().insertReviewConsistent(reviewConsistent);
                break;
            case "flight":
                ReviewFlight reviewFlight = new ReviewFlight();
                reviewFlight.setName(String.valueOf(ds.child("name").getValue()));
                reviewFlight.setReview(String.valueOf(ds.child("review").getValue()));
                Reviews.getViewModel().insertReviewFlight(reviewFlight);
                break;
            case "impulsive":
                ReviewImpulsive reviewImpulsive = new ReviewImpulsive();
                reviewImpulsive.setName(String.valueOf(ds.child("name").getValue()));
                reviewImpulsive.setReview(String.valueOf(ds.child("review").getValue()));
                Reviews.getViewModel().insertReviewImpulsive(reviewImpulsive);
                break;
            case "seasonal":
                ReviewSeasonal reviewSeasonal = new ReviewSeasonal();
                reviewSeasonal.setName(String.valueOf(ds.child("name").getValue()));
                reviewSeasonal.setReview(String.valueOf(ds.child("review").getValue()));
                Reviews.getViewModel().insertReviewSeasonal(reviewSeasonal);
                break;
        }
    }

}
