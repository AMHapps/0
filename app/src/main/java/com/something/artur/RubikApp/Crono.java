package com.something.artur.RubikApp;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;


public class Crono extends AppCompatActivity {

    TextView textView ;
    Button start, pause;
    long MillisecondTime, StartTime= 0L ;
    Handler handler;
    int Seconds, Minutes, MilliSeconds ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lcrono);

        textView = (TextView)findViewById(R.id.textcrono);
        start = (Button)findViewById(R.id.cronostart);
        pause = (Button)findViewById(R.id.cronopause);
        handler = new Handler() ;

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MillisecondTime = 0L ;
                StartTime = 0L ;
                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);
                start.setEnabled(false);

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(runnable);
                start.setEnabled(true);

            }
        });
    }

    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;
            Seconds = (int) (MillisecondTime / 1000);
            Minutes = Seconds / 60;
            Seconds = Seconds % 60;
            MilliSeconds = (int) MillisecondTime % 1000;
            textView.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%03d", MilliSeconds));
            handler.postDelayed(this, 0);
        }

    };

}