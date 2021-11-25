package com.example.adv4you.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.adv4you.DataFromDB;
import com.example.adv4you.R;
import com.example.adv4you.ReViewRecycler;
import com.example.adv4you.lifecycles.LifecycleOption;
import com.example.adv4you.lifecycles.LifecycleReviews;
import com.example.adv4you.pojos.pojos_for_review.ReviewConsistent;
import com.example.adv4you.pojos.pojos_for_review.ReviewFlight;
import com.example.adv4you.pojos.pojos_for_review.ReviewImpulsive;
import com.example.adv4you.pojos.pojos_for_review.ReviewSeasonal;
import com.example.adv4you.view_model.ReviewViewModel;

import java.util.List;

public class Reviews extends AppCompatActivity implements View.OnClickListener {

    Button addReview;

    private static RecyclerView recyclerView;
    private static ReviewViewModel viewModel;

    public static Intent intent+;

    private static List<ReviewConsistent> mReviewConsistent;
    private static List<ReviewFlight> mReviewFlight;
    private static List<ReviewImpulsive> mReviewImpulsive;
    private static List<ReviewSeasonal> mReviewSeasonal;

    public static Lifecycle lifecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        addReview = findViewById(R.id.add_review);
        addReview.setOnClickListener(this);

        intent = getIntent();

        viewModel = new ViewModelProvider(this).get(ReviewViewModel.class);

        LifecycleReviews setLifecycle = new LifecycleReviews();

        lifecycle = getLifecycle();
        lifecycle.addObserver(setLifecycle);

        recyclerView = findViewById(R.id.r_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        initViewModel();

    }


    @Override
    public void onClick(View view) {

        Intent newActivity = new Intent(Reviews.this, SendReview.class);
        newActivity.putExtra("type", intent.getStringExtra("type"));
        startActivity(newActivity);
    }

    public static ReviewViewModel getViewModel() {
        return viewModel;
    }

    public static List<ReviewConsistent> getmReviewConsistent() {
        return mReviewConsistent;
    }

    public static void setmReviewConsistent(List<ReviewConsistent> mReviewConsistent) {
        Reviews.mReviewConsistent = mReviewConsistent;
    }

    public static List<ReviewFlight> getmReviewFlight() {
        return mReviewFlight;
    }

    public static void setmReviewFlight(List<ReviewFlight> mReviewFlight) {
        Reviews.mReviewFlight = mReviewFlight;
    }

    public static List<ReviewImpulsive> getmReviewImpulsive() {
        return mReviewImpulsive;
    }

    public static void setmReviewImpulsive(List<ReviewImpulsive> mReviewImpulsive) {
        Reviews.mReviewImpulsive = mReviewImpulsive;
    }

    public static List<ReviewSeasonal> getmReviewSeasonal() {
        return mReviewSeasonal;
    }

    public static void setmReviewSeasonal(List<ReviewSeasonal> mReviewSeasonal) {
        Reviews.mReviewSeasonal = mReviewSeasonal;
    }

    public static RecyclerView getRecyclerView() {
        return recyclerView;
    }

}