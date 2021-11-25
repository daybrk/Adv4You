package com.example.adv4you;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.adv4you.activitys.types.Consistent;
import com.example.adv4you.activitys.types.Flight;
import com.example.adv4you.activitys.types.Impulsive;
import com.example.adv4you.activitys.types.Seasonal;
import com.example.adv4you.lifecycles.LifecycleOption;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mConsistent;
    Button mImpulsive;
    Button mSeasonal;
    Button mFlight;

    Lifecycle lifecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mConsistent = (Button) findViewById(R.id.consistent);
        mImpulsive = (Button) findViewById(R.id.impulsive);
        mSeasonal = (Button) findViewById(R.id.seasonal);
        mFlight = (Button) findViewById(R.id.flight);

        mConsistent.setOnClickListener(this);
        mImpulsive.setOnClickListener(this);
        mSeasonal.setOnClickListener(this);
        mFlight.setOnClickListener(this);

        LifecycleOption setLifecycle = new LifecycleOption();

        lifecycle = getLifecycle();
        lifecycle.addObserver(setLifecycle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        ConstraintLayout constraintLayout = findViewById(R.id.constraint);
        switch(id){
            case R.id.white:
                constraintLayout.setBackgroundColor(Color.WHITE);
                return true;
            case R.id.black:
                constraintLayout.setBackgroundColor(Color.GRAY);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        Intent intentNewActivity;

        switch(view.getId()) {
            case R.id.consistent:
                intentNewActivity = new Intent(MainActivity.this, Consistent.class);
                startActivity(intentNewActivity);
                break;
            case R.id.impulsive:
                intentNewActivity = new Intent(MainActivity.this, Impulsive.class);
                startActivity(intentNewActivity);
                break;
            case R.id.seasonal:
                intentNewActivity = new Intent(MainActivity.this, Seasonal.class);
                startActivity(intentNewActivity);
                break;
            case R.id.flight:
                intentNewActivity = new Intent(MainActivity.this, Flight.class);
                startActivity(intentNewActivity);
                break;
        }
    }
}