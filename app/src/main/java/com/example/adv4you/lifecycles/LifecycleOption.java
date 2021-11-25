package com.example.adv4you.lifecycles;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LifecycleOption implements LifecycleObserver, LifecycleOwner {

    static FirebaseDatabase mDataBase;
    static DatabaseReference ref;

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void init() {

        mDataBase = FirebaseDatabase.getInstance();

        ref = mDataBase.getReference("type");

    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return null;
    }

    public static DatabaseReference getRef() {
        return ref;
    }

    public static void setRef(DatabaseReference ref) {
        LifecycleOption.ref = ref;
    }

    public static FirebaseDatabase getMDataBase() {
        return mDataBase;
    }
}
