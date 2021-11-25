package com.example.adv4you.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adv4you.lifecycles.LifecycleOption;

import com.example.adv4you.R;
import com.example.adv4you.pojos.Review;

public class SendReview extends AppCompatActivity implements View.OnClickListener {

    Button sendReview;
    EditText edName;
    EditText edReview;
    static Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_review);

        sendReview = findViewById(R.id.send_review);
        edName = findViewById(R.id.ed_name);
        edReview = findViewById(R.id.ed_review);

        intent = getIntent();

        sendReview.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (String.valueOf(edName.getText()).equals("") &&
                String.valueOf(edReview.getText()).equals("")) {
            Toast toast = Toast.makeText(this, "Отсутсвет Имя/Комментарий", Toast.LENGTH_SHORT);
            toast.show();
        } else {

            Toast toast;

            String name = String.valueOf(edName.getText());
            String review = String.valueOf(edReview.getText());

            Review newOrder = new Review(name, review);

            switch (intent.getStringExtra("type")) {
                case "Последовательно-постоянный":
                    LifecycleOption.getRef().child("/consistent/reviews").push().setValue(newOrder);
                    toast = Toast.makeText(this, "Ваш отзыв был отправлен", Toast.LENGTH_SHORT);
                    toast.show();
                    finish();
                    break;
                case "Флайтовый":
                    LifecycleOption.getRef().child("/flight/reviews").push().setValue(newOrder);
                    toast = Toast.makeText(this, "Ваш отзыв был отправлен", Toast.LENGTH_SHORT);
                    toast.show();
                    finish();
                    break;
                case "Импульсивный":
                    LifecycleOption.getRef().child("/impulsive/reviews").push().setValue(newOrder);
                    toast = Toast.makeText(this, "Ваш отзыв был отправлен", Toast.LENGTH_SHORT);
                    toast.show();
                    finish();
                    break;
                case "Сезонный":
                    LifecycleOption.getRef().child("/seasonal/reviews").push().setValue(newOrder);
                    toast = Toast.makeText(this, "Ваш отзыв был отправлен", Toast.LENGTH_SHORT);
                    toast.show();
                    finish();
                    break;
            }
        }
    }
}