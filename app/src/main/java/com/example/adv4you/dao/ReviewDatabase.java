package com.example.adv4you.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.adv4you.pojos.pojos_for_review.ReviewConsistent;
import com.example.adv4you.pojos.pojos_for_review.ReviewFlight;
import com.example.adv4you.pojos.pojos_for_review.ReviewImpulsive;
import com.example.adv4you.pojos.pojos_for_review.ReviewSeasonal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ReviewConsistent.class, ReviewFlight.class, ReviewImpulsive.class,
        ReviewSeasonal.class}, version = 1, exportSchema = false)

abstract public class ReviewDatabase extends RoomDatabase {
    public abstract ReviewDAO reviewDAO();

    private static volatile ReviewDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService dbWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static ReviewDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ReviewDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ReviewDatabase.class, "database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
