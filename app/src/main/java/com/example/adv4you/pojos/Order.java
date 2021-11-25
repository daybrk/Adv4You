package com.example.adv4you.pojos;

public class Order {

    String fullName;
    String phone;
    String money;

    public Order(String fullName, String phone, String money) {
        this.fullName = fullName;
        this.phone = phone;
        this.money = money;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
