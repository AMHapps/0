package com.something.artur.RubikApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Notacio extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lnotacio);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}


