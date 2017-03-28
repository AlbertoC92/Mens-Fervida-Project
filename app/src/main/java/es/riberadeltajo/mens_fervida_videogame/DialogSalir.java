package es.riberadeltajo.mens_fervida_videogame;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import es.riberadeltajo.mens_fervida_videogame.R;

import es.riberadeltajo.mens_fervida_videogame.entidades.Jugador;

/**
 * Created by PedroMiguel on 01/02/2017.
 */

public class DialogSalir extends Dialog implements View.OnClickListener{
    private Context mContext;
    private Button btnOk, btnCancel;
    private TextView tittle;


    public DialogSalir(Context context, int themeResId) {
        super(context, themeResId);
        mContext=context;
        quitarFondoRedimensionarEfectos();

    }

    public void quitarFondoRedimensionarEfectos(){
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Display display = ((MenuNivelesActivity)mContext).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        getWindow().setLayout((int)(size.x*0.9), (int)(size.y*0.7));
        getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_salir);
        btnOk=(Button)findViewById(R.id.btn_salir_aceptar);
        btnOk.setOnClickListener(this);
        btnCancel=(Button)findViewById(R.id.btn_salir_cancelar);
        btnCancel.setOnClickListener(this);
        tittle=(TextView)findViewById(R.id.txtTittle);
        tittle.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));

    }



    @Override
    public void dismiss() {
        super.dismiss();

    }

    public void GuardaPuntuacion(){
        Jugador.getInstance().guardarSharedPreferences();
    }

    @Override
    public void onBackPressed() {
        this.dismiss();
        ((MenuNivelesActivity)mContext).onResume();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_salir_aceptar:
                GuardaPuntuacion();
                ((MenuNivelesActivity)mContext).finish();
                this.dismiss();

                break;
            case R.id.btn_salir_cancelar:
                this.dismiss();
                ((MenuNivelesActivity)mContext).onResume();
                break;
        }

    }
}
