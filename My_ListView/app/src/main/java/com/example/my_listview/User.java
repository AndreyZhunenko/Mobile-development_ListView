package com.example.my_listview;

import android.util.Log;

import androidx.annotation.NonNull;

public class User {
    String name, phoneNumber, sex;
    User_gender gend;

    public User(String name, String phoneNumber, String sex) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.sex=sex;
        if(sex.equals("MAN"))
            this.gend = User_gender.MAN;
        if(sex.equals("WOMAN"))
            this.gend = User_gender.WOMAN;
        if(sex.equals("UNKNOWN"))
            this.gend = User_gender.UNKNOWN;
    }
}
