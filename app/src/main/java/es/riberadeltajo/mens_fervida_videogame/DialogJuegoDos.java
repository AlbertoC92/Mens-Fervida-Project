package es.riberadeltajo.mens_fervida_videogame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import es.riberadeltajo.mens_fervida_videogame.juegoCartas.MainActivityCartas;

/**
 * Created by Dani on 03/02/2017.
 */

public class DialogJuegoDos extends Dialog implements View.OnClickListener{
    private Context mContext;
    private Activity activity;
    private Button btnSiguiente,btnAnterior;
    private int puntuacion;
    private Button boton;

    public DialogJuegoDos(Context context, int themeResId, Activity activity) {
        super(context, themeResId);
        mContext=context;
        this.activity=activity;
        quitarFondoRedimensionarEfectos();

    }

    public void quitarFondoRedimensionarEfectos(){
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Display display = activity.getWindowManager().getDefaultDisplay();
        getWindow().getAttributes().windowAnimations = R.style.PanelPregunta;
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        getWindow().setLayout((int)(size.x*0.9), (int)(size.y*0.7));
        //getWindow().getAttributes().windowAnimations = R.style.PanelNivelDos;
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_juego2);
        btnSiguiente=(Button)findViewById(R.id.btn_juego2_siguiente);
        btnAnterior=(Button)findViewById(R.id.btn_juego2_anterior);
        btnAnterior.setOnClickListener(this);
        btnSiguiente.setOnClickListener(this);
        boton = (Button)findViewById(R.id.btnJuegoCarta);
        boton.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugarCartas();
            }
        });
    }

    public void jugarCartas(){
        if(((MenuArcades)mContext).puedeJugar()) {
            Intent intent = new Intent(activity, MainActivityCartas.class);
            activity.startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_juego2_siguiente:
                //getWindow().getAttributes().windowAnimations = R.style.PanelNivelUno;     //Esto está aqui por el tema de las animaciones, estaba haciendo pruebas
                ((MenuArcades)activity).juego3.show();
                this.dismiss();
                break;
            case R.id.btn_juego2_anterior:
                //getWindow().getAttributes().windowAnimations = R.style.PanelNivelDos;    //Pero hace cosas raras, no funciona bien
                ((MenuArcades)activity).juego1.show();
                this.dismiss();
        }
    }

    @Override
    public void onBackPressed() {
        if(this.isShowing()) {

            this.dismiss();
            ((MenuArcades)activity).juego1.show();
        }

    }
}
