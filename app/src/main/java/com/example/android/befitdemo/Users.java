package com.example.android.befitdemo;

/**
 * Created by Shubham on 15-09-2017.
 */

public class Users {
    String name;
    String password;
    String email;
    int age;
    double weight;
    double height;
    double bmi;

    public Users(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Users(int age, double weight, double height,double bmi) {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.bmi=bmi;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
