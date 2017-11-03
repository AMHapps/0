package com.something.artur.RubikApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class Tuto1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ltuto1);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }


}
