package com.something.artur.RubikApp;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Recursos extends AppCompatActivity implements View.OnClickListener{

    Button tboto7_1;
    Button tboto7_2;
    Button tboto7_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lrecursos);

        tboto7_1 = (Button) findViewById(R.id.boto7_1);
        tboto7_1.setOnClickListener(this);

        tboto7_2 = (Button) findViewById(R.id.boto7_2);
        tboto7_2.setOnClickListener(this);

        tboto7_3 = (Button) findViewById(R.id.boto7_3);
        tboto7_3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.boto7_1:
                Intent web1 = new Intent(Intent.ACTION_VIEW);
                web1.setData(Uri.parse("https://www.worldcubeassociation.org/results/events.php"));
                startActivity(web1);
                break;
            case R.id.boto7_2:
                Intent web2 = new Intent(Intent.ACTION_VIEW);
                web2.setData(Uri.parse("https://cstimer.net/"));
                startActivity(web2);
                break;
            case R.id.boto7_3:
                Intent web3 = new Intent(Intent.ACTION_VIEW);
                web3.setData(Uri.parse("http://cubecomps.com/"));
                startActivity(web3);
                break;


        }
    }
}
