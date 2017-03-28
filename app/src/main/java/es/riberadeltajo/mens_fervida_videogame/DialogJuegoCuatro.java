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

import es.riberadeltajo.mens_fervida_videogame.juegoUnirComida.MainActivityUnirComida;

public class DialogJuegoCuatro extends Dialog implements View.OnClickListener{

    private Context mContext;
    private Activity activity;
    private Button btnAnterior,btnSiguiente, btnJugar4;

    public DialogJuegoCuatro(Context context, int themeResId, Activity activity) {
        super(context, themeResId);
        mContext=context;
        this.activity=activity;
        quitarFondoRedimensionarEfectos();

    }

    public void quitarFondoRedimensionarEfectos(){
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        getWindow().setLayout((int)(size.x*0.9), (int)(size.y*0.7));
        getWindow().getAttributes().windowAnimations = R.style.PanelPregunta;
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_juego_cuatro);
        btnAnterior=(Button) findViewById(R.id.btn_juego4_anterior);
        btnAnterior.setOnClickListener(this);
        btnSiguiente=(Button) findViewById(R.id.btn_juego4_siguiente);
        btnSiguiente.setOnClickListener(this);
        btnJugar4=(Button) findViewById(R.id.btnJugar4);
        btnJugar4.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
        btnJugar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugarUnir();
            }
        });



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_juego4_anterior:
                ((MenuArcades)activity).juego3.show();
                this.dismiss();
                break;
            case R.id.btn_juego4_siguiente:
                //getWindow().getAttributes().windowAnimations = R.style.PanelNivelDos;    //Pero hace cosas raras, no funciona bien
                ((MenuArcades)activity).juego5.show();
                this.dismiss();

        }
    }

    @Override
    public void onBackPressed() {
        if(this.isShowing()) {

            this.dismiss();
            ((MenuArcades)activity).juego3.show();
        }

    }

    public void jugarUnir(){
        if(((MenuArcades)mContext).puedeJugar()) {
            Intent intent = new Intent(activity, MainActivityUnirComida.class);
            activity.startActivity(intent);
        }

    }
}
