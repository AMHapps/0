package com.something.artur.RubikApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TutoMenu extends AppCompatActivity implements View.OnClickListener {
    Button tboto4_1;
    Button tboto4_2;
    Button tboto4_3;
    Button tboto4_4;
    Button tboto4_5;
    Button tboto4_6;
    Button tboto4_7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ltutomenu);

        tboto4_1 = (Button) findViewById(R.id.boto4_1);
        tboto4_1.setOnClickListener(this);

        tboto4_2 = (Button) findViewById(R.id.boto4_2);
        tboto4_2.setOnClickListener(this);

        tboto4_3 = (Button) findViewById(R.id.boto4_3);
        tboto4_3.setOnClickListener(this);

        tboto4_4 = (Button) findViewById(R.id.boto4_4);
        tboto4_4.setOnClickListener(this);

        tboto4_5 = (Button) findViewById(R.id.boto4_5);
        tboto4_5.setOnClickListener(this);

        tboto4_6 = (Button) findViewById(R.id.boto4_6);
        tboto4_6.setOnClickListener(this);

        tboto4_7 = (Button) findViewById(R.id.boto4_7);
        tboto4_7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.boto4_1:
                Intent quatreq1 = new Intent(this, Tuto1.class);
                startActivity(quatreq1);
                break;


            case R.id.boto4_2:
                Intent quatreq2 = new Intent(this, Tuto2.class);
                startActivity(quatreq2);
                break;

            case R.id.boto4_3:
                Intent quatreq3 = new Intent(this, Tuto3.class);
                startActivity(quatreq3);
                break;

            case R.id.boto4_4:
                Intent quatreq4 = new Intent(this, Tuto4.class);
                startActivity(quatreq4);
                break;

            case R.id.boto4_5:
                Intent quatreq5 = new Intent(this, Tuto5.class);
                startActivity(quatreq5);
                break;

            case R.id.boto4_6:
                Intent quatreq6 = new Intent(this, Tuto6.class);
                startActivity(quatreq6);
                break;

            case R.id.boto4_7:
                Intent quatreq7 = new Intent(this, Tuto7.class);
                startActivity(quatreq7);
                break;

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
