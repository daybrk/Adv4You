package com.example.adv4you.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.adv4you.pojos.pojos_for_review.ReviewConsistent;
import com.example.adv4you.pojos.pojos_for_review.ReviewFlight;
import com.example.adv4you.pojos.pojos_for_review.ReviewImpulsive;
import com.example.adv4you.pojos.pojos_for_review.ReviewSeasonal;

import java.util.List;

@Dao
public interface ReviewDAO {

    /** Запросы для таблицы Consistent
     */

    @Query("SELECT * FROM ReviewConsistent")
    LiveData<List<ReviewConsistent>> loadAllReviewConsistent();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertReviewConsistent (ReviewConsistent reviewConsistent);

    @Query("DELETE FROM ReviewConsistent")
    void deleteReviewConsistent();

    /** Запросы для таблицы Flight
     */

    @Query("SELECT * FROM ReviewFlight")
    LiveData<List<ReviewFlight>> loadAllReviewFlight();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertReviewFlight (ReviewFlight reviewFlight);

    @Query("DELETE FROM ReviewFlight")
    void deleteReviewFlight();

    /** Запросы для таблицы Impulse
     */

    @Query("SELECT * FROM ReviewImpulsive")
    LiveData<List<ReviewImpulsive>> loadAllReviewImpulsive();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertReviewImpulsive (ReviewImpulsive reviewImpulsive);

    @Query("DELETE FROM ReviewImpulsive")
    void deleteReviewImpulsive();

    /** Запросы для таблицы Seasonal
     */

    @Query("SELECT * FROM ReviewSeasonal")
    LiveData<List<ReviewSeasonal>> loadAllReviewSeasonal();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertReviewSeasonal (ReviewSeasonal reviewSeasonal);

    @Query("DELETE FROM ReviewSeasonal")
    void deleteReviewSeasonal();
}
