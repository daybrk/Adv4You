package com.example.adv4you.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adv4you.lifecycles.LifecycleOption;
import com.example.adv4you.pojos.Order;
import com.example.adv4you.R;

public class MakingAnOrder extends AppCompatActivity implements View.OnClickListener {

    EditText typeOfExtension;
    EditText edFullName;
    EditText edPhone;
    EditText edMoney;
    Button makingAnOrder;

    static Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_making_an_order);

        typeOfExtension = findViewById(R.id.type_of_extension);
        edFullName = findViewById(R.id.ed_full_name);
        edPhone = findViewById(R.id.ed_phone);
        edMoney = findViewById(R.id.ed_money);


        makingAnOrder = findViewById(R.id.making_an_order);
        makingAnOrder.setOnClickListener(this);

        intent = getIntent();
        typeOfExtension.setText(intent.getStringExtra("type"));
    }

    @Override
    public void onClick(View view) {
        if (String.valueOf(edFullName.getText()).equals("") &&
                String.valueOf(edPhone.getText()).equals("") &&
                String.valueOf(edMoney.getText()).equals("")) {
            Toast toast = Toast.makeText(this, "Проверьте правильность ввода данных", Toast.LENGTH_SHORT);
            toast.show();
        } else {

            Toast toast;

            String fullName = String.valueOf(edFullName.getText());
            String phone = String.valueOf(edPhone.getText());
            String money = String.valueOf(edMoney.getText());
            Order newOrder = new Order(fullName, phone, money);

            switch (intent.getStringExtra("type")) {
                case "Последовательно-постоянный":
                    LifecycleOption.getRef().child("/consistent/order").push().setValue(newOrder);
                    toast = Toast.makeText(this, "Заказ на продвижение был оформлен", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                case "Флайтовый":
                    LifecycleOption.getRef().child("/flight/order").push().setValue(newOrder);
                    toast = Toast.makeText(this, "Заказ на продвижение был оформлен", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                case "Импульсивный":
                    LifecycleOption.getRef().child("/impulsive/order").push().setValue(newOrder);
                    toast = Toast.makeText(this, "Заказ на продвижение был оформлен", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                case "Сезонный":
                    LifecycleOption.getRef().child("/seasonal/order").push().setValue(newOrder);
                    toast = Toast.makeText(this, "Заказ на продвижение был оформлен", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
            }
        }
    }
}