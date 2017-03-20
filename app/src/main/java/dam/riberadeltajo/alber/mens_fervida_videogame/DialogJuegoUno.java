package dam.riberadeltajo.alber.mens_fervida_videogame;

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

import com.example.alber.mens_fervida_videogame.R;

import dam.riberadeltajo.alber.mens_fervida_videogame.juegoComidaCae.MainActivityComidaCae;

public class DialogJuegoUno extends Dialog implements View.OnClickListener{
    private Context mContext;
    private Activity activity;
    private Button btnSiguiente;
    private Button btJugar; //CAMBIADO

    public DialogJuegoUno(Context context, int themeResId, Activity activity) {
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
    protected void onCreate(Bundle savedInstanceState) {        //EN ESTE DIALOG ESTÁ METIDO EL JUEGO DE ANGEL Y CARRION YA.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_juego1);
        btnSiguiente=(Button) findViewById(R.id.btn_juego1_siguiente);
        btnSiguiente.setOnClickListener(this);
        btJugar=(Button)findViewById(R.id.btn_jugar1);
        btJugar.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
        btJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarAljuego();
            }
        });
    }

    private void pasarAljuego(){
        if(((MenuArcades)mContext).puedeJugar()) {
            Intent inte = new Intent(activity, MainActivityComidaCae.class);
            activity.startActivity(inte);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_juego1_siguiente:
                ((MenuArcades)activity).juego2.show();
                this.dismiss();
                break;

        }
    }




    @Override
    public void onBackPressed() {
        if(this.isShowing()) {

            this.dismiss();
            activity.finish();
        }

    }
}
