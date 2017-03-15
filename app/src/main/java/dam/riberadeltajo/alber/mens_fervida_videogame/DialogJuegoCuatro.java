package dam.riberadeltajo.alber.mens_fervida_videogame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.alber.mens_fervida_videogame.R;

import dam.riberadeltajo.alber.mens_fervida_videogame.juegoCartas.MainActivityCartas;
import dam.riberadeltajo.alber.mens_fervida_videogame.juegoUnirComida.MainActivityUnirComida;

public class DialogJuegoCuatro extends Dialog implements View.OnClickListener{

    private Context mContext;
    private Activity activity;
    private Button btnAnterior, btnJugar4;

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
        btnAnterior=(Button) findViewById(R.id.btn_juego3_anterior);
        btnAnterior.setOnClickListener(this);
        btnJugar4=(Button) findViewById(R.id.btnJugar4);
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
            case R.id.btn_juego3_anterior:
                ((MenuArcades)activity).juego3.show();
                this.dismiss();
                break;

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
