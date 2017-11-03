package com.something.artur.RubikApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Locale;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;


public class Principal extends AppCompatActivity implements View.OnClickListener{
Button tboto1;
    Spinner spinnerctrl;
    Button btn;
    Locale myLocale;
    Button tboto2;
    Button tboto3;
    Button tboto4;
    Button tboto5;
    Button tboto6;
    Button tboto7;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lprincipal);
        tboto1 = (Button) findViewById(R.id.boto1);
        tboto1.setOnClickListener(this);
        spinnerctrl = (Spinner) findViewById(R.id.spinner01);
        tboto2 = (Button) findViewById(R.id.boto2);
        tboto2.setOnClickListener(this);
        tboto3 = (Button) findViewById(R.id.boto3);
        tboto3.setOnClickListener(this);
        tboto4 = (Button) findViewById(R.id.boto4);
        tboto4.setOnClickListener(this);
        tboto5 = (Button) findViewById(R.id.boto5);
        tboto5.setOnClickListener(this);
        tboto6 = (Button) findViewById(R.id.boto6);
        tboto6.setOnClickListener(this);
        tboto7 = (Button) findViewById(R.id.boto7);
        tboto7.setOnClickListener(this);




        spinnerctrl.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                if (pos == 1) {

                    setLocale("en");

                } else if (pos == 2) {

                    setLocale("ca");
                } else if (pos == 3) {

                    setLocale("es");

                }

            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }

        });
    }

    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, Principal.class);
        startActivity(refresh);
    }





    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.boto1:
                Intent udos = new Intent(this,Notacio.class);
                startActivity(udos);
                break;

            case R.id.boto2:
                Intent utres = new Intent(this,Parts.class);
                startActivity(utres);
                break;
            case R.id.boto3:
                Intent uquatre = new Intent(this,TutoMenu.class);
                startActivity(uquatre);
                break;

            case R.id.boto4:
                Intent ucinc = new Intent(this,Minijoc.class);
                startActivity(ucinc);
                break;

            case R.id.boto5:
                Intent usis = new Intent(this,Categories.class);
                startActivity(usis);
                break;

            case R.id.boto6:
                Intent uset = new Intent(this,Recursos.class);
                startActivity(uset);
                break;

            case R.id.boto7:
                Intent uvuit = new Intent(this,Crono.class);
                startActivity(uvuit);
                break;
        }

    }



}


