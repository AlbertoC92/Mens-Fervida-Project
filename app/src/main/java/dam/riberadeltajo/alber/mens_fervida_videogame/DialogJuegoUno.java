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

import dam.riberadeltajo.alber.mens_fervida_videogame.juegoComidaCae.MainActivityComidaCae;

public class DialogJuegoUno extends Dialog implements View.OnClickListener, DialogInterface.OnKeyListener {
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
        getWindow().getAttributes().windowAnimations = R.style.PanelNivelUno;
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
        this.setOnKeyListener(this);
        btJugar=(Button)findViewById(R.id.btn_jugar1);
        btJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarAljuego();
            }
        });
    }

    private void pasarAljuego(){
        Intent inte=new Intent(activity,MainActivityComidaCae.class);
        activity.startActivity(inte);
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
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == KeyEvent.KEYCODE_BACK) {
            /*if(this.isShowing()) {
                activity.finish();
                this.dismiss();
            }*/
        }
        return true;
    }
}
