package com.something.artur.RubikApp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.Random;

public class Minijoc extends AppCompatActivity implements View.OnClickListener{

    private int numeroElements;
    private Elboto[] botons;
    private int[] posicioBotons;
    private int[] fotosBotons;
    private Elboto botoSeleccionat1, botoSeleccionat2;
    private boolean estaOcupat = false;
    private Button reiniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lminijoc);

        reiniciar = (Button) findViewById(R.id.reiniciar);
        reiniciar.setOnClickListener(this);

        //declaro un GridLayout (taula)
        GridLayout gridLayout = (GridLayout)findViewById(R.id.grid_layout_4x4);

        int numColumns = 4;
        int numRows = 4;
        numeroElements = numColumns * numRows;

        //inicialitzo els vectors (16 botons i 8 imatges)
        botons = new Elboto[numeroElements];
        fotosBotons = new int[numeroElements / 2];
        posicioBotons = new int[numeroElements];

        //assigno les imatges a cada botó
        fotosBotons[0] = R.drawable.ctg01;
        fotosBotons[1] = R.drawable.ctg02;
        fotosBotons[2] = R.drawable.ctg03;
        fotosBotons[3] = R.drawable.ctg04;
        fotosBotons[4] = R.drawable.ctg05;
        fotosBotons[5] = R.drawable.ctg06;
        fotosBotons[6] = R.drawable.ctg07;
        fotosBotons[7] = R.drawable.ctg08;

        //funció per ordenar els botons de forma aleatoria
        shufflefotosBotons();

        //inicialitzo els botons i els coloca a la seva posició
        for (int r = 0; r < numRows; r++){
            for (int c = 0; c < numColumns; c++){
                Elboto tempbotoApretat = new Elboto(this, r, c, fotosBotons[posicioBotons[r * numColumns + c]]);
                tempbotoApretat.setId(View.generateViewId());
                tempbotoApretat.setOnClickListener(this);
                botons[r * numColumns + c] = tempbotoApretat;
                gridLayout.addView(tempbotoApretat);
            }
        }

    }

    //funció per ordenar els botons de forma aleatoria
    protected void shufflefotosBotons() {
        Random rand = new Random();

        for(int i = 0; i < numeroElements; i++){
            posicioBotons[i] = i % (numeroElements / 2);
        }
        //bucle per odenar els botons de forma aleatoria
        for(int i = 0; i < numeroElements; i++){
            int temp = posicioBotons[i];
            int swapIndex = rand.nextInt(16);
            posicioBotons[i] = posicioBotons[swapIndex];
            posicioBotons[swapIndex] = temp;
        }
    }


    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.reiniciar){
            Intent refresh = new Intent(this, Minijoc.class);
            startActivity(refresh);
            this.finish();
        }
        else {

            //si està ocupat, no fa res
            if (estaOcupat) return;

            //determina quin botó apreta l'usuari amb el dit
            Elboto botoApretat = (Elboto) view;

            //si aquell botó ja s0ha trobat la parella, no fa res
            if (botoApretat.isMatched) return;

            //si és el primer boto que selecciones l'assiges al 1 i el gires
            if (botoSeleccionat1 == null) {
                botoSeleccionat1 = botoApretat;
                botoSeleccionat1.flip();
                return;
            }

            //si tornes a apretar el mateix botó que acabes d'apretar no fa res
            if (botoSeleccionat1.getId() == botoApretat.getId()) return;

            //si el primer i el segon que apretes tenen la mateixa imatge > matched = true i neteges el botoSeleccionat1
            if (botoSeleccionat1.getFrontDrawableId() == botoApretat.getFrontDrawableId()) {
                botoApretat.flip();
                botoApretat.setMatched(true);
                botoSeleccionat1.setMatched(true);
                botoSeleccionat1.setEnabled(false);
                botoApretat.setEnabled(false);
                botoSeleccionat1 = null;
                return;
            }
            //en canvi, si les imatges són diferents espera una estona i els torna a girar (netega botoSeleccionat1 i botoSeleccionat2)
            else {
                botoSeleccionat2 = botoApretat;
                botoSeleccionat2.flip();
                estaOcupat = true;

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        botoSeleccionat2.flip();
                        botoSeleccionat1.flip();
                        botoSeleccionat1 = null;
                        botoSeleccionat2 = null;
                        estaOcupat = false;
                    }
                }, 500);
            }
        }
    }

}
