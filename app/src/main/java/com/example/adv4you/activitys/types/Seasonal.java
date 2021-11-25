package com.example.adv4you.activitys.types;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.adv4you.R;
import com.example.adv4you.activitys.MakingAnOrder;
import com.example.adv4you.activitys.Reviews;

public class Seasonal extends AppCompatActivity implements View.OnClickListener {

    Button placeAnOrder;
    Button reviews;
    TextView reviewsTW;
    TextView placeAnOrderTW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasonal);

        placeAnOrder = findViewById(R.id.place_an_order);
        reviews = findViewById(R.id.reviews_button);
        reviewsTW = findViewById(R.id.reviews_tw);
        placeAnOrderTW = findViewById(R.id.place_an_order_tw);

        placeAnOrder.setOnClickListener(this);
        placeAnOrderTW.setOnClickListener(this);
        reviews.setOnClickListener(this);
        reviewsTW.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        Intent newActivity;

        switch (view.getId()) {
            case R.id.reviews_button:
            case R.id.reviews_tw:
                newActivity = new Intent(Seasonal.this, Reviews.class);
                newActivity.putExtra("type", "Сезонный");
                startActivity(newActivity);
                break;
            case R.id.place_an_order:
            case R.id.place_an_order_tw:
                newActivity = new Intent(Seasonal.this, MakingAnOrder.class);
                newActivity.putExtra("type", "Сезонный");
                startActivity(newActivity);
                break;

        }
    }

}