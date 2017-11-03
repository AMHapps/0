package com.something.artur.RubikApp;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.content.Context;
import android.widget.GridLayout;

/**
 * Created by Artur on 14/10/2017.
 */

public class Elboto extends android.support.v7.widget.AppCompatButton{

    protected int row, column, frontDrawableId;
    protected boolean isFlipped = false;
    protected boolean isMatched = false;
    protected Drawable front, back;

    public Elboto(Context context, int r, int c, int frontImageDrawableId){
        super(context);

        //posició fila, posició columna i imatge secreta es pasen per parametre a la creadora
        row = r;
        column = c;
        frontDrawableId = frontImageDrawableId;

        //imatge de davant
        front = AppCompatDrawableManager.get().getDrawable(context, frontImageDrawableId);
        //imatge de darrera
        back = AppCompatDrawableManager.get().getDrawable(context, R.drawable.fet);

        //radera per defecte
        setBackground(back);

        GridLayout.LayoutParams tempParams = new GridLayout.LayoutParams(GridLayout.spec(r), GridLayout.spec(c));

        //defineixo amplada i alçada
        tempParams.width = (int) getResources().getDisplayMetrics().density * 70;
        tempParams.height = (int) getResources().getDisplayMetrics().density * 70;

        setLayoutParams(tempParams);
    }

    //diu si ja ha trobat la parella
    public boolean isMatched() {
        return isMatched;
    }

    //canvia l'estat a parella trobada
    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    //envia la imatge del davant
    public int getFrontDrawableId() {
        return frontDrawableId;
    }

    //gira la imatge
    public void flip()
    {
        //si ja té la parella trobada > no fer res xk ja està girada
        if(isMatched)
            return;
        //si està girada > la tornes a girar perquèes vegi el radera
        if(isFlipped){
            setBackground(back);
            isFlipped = false;
        }
        //si està del reves > ensñas l'imatge secreta
        else{
            setBackground(front);
            isFlipped = true;
        }
    }
}
