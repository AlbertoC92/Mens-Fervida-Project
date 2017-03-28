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
import android.widget.LinearLayout;
import android.widget.TextView;

import es.riberadeltajo.mens_fervida_videogame.R;

/**
 * Created by PedroMiguel on 01/02/2017.
 */

public class DialogLevelCompl extends Dialog implements View.OnClickListener{
    private Context mContext;
    private LinearLayout estrellas, panel;
    private TextView puntuacion,levelcomplete;


    public DialogLevelCompl(Context context, int themeResId) {
        super(context, themeResId);
        mContext=context;
        quitarFondoRedimensionarEfectos();

    }

    public void quitarFondoRedimensionarEfectos(){
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Display display = ((ActivityPregunta)mContext).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        getWindow().setLayout((int)(size.x*0.9), (int)(size.y*0.7));
        getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN );
        setCanceledOnTouchOutside(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_nivel_comp);
        panel=(LinearLayout) findViewById(R.id.linear_nivel_comp);
        panel.setOnClickListener(this);
        estrellas=(LinearLayout)findViewById(R.id.linear_estrellas_lv_comp);
        puntuacion=(TextView)findViewById(R.id.txt_punt_dia_lv_comp);
        puntuacion.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
        puntuacion.setText(String.format("%d", ((ActivityPregunta)mContext).puntuacionNivel));
        levelcomplete=(TextView)findViewById(R.id.txtLevelComplete);
        levelcomplete.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
        ((ActivityPregunta)mContext).marcador.setVisibility(View.INVISIBLE);
        cargarEstrellas();
    }

    private void cargarEstrellas() {
        switch (((ActivityPregunta)mContext).vidas){
            case 1:
                estrellas.setBackground(getContext().getDrawable(R.drawable.estrellla0_2));
                break;
            case 2:
                estrellas.setBackground(getContext().getDrawable(R.drawable.estrellla1));
                break;
            case 3:
                estrellas.setBackground(getContext().getDrawable(R.drawable.estrellla1_2));
                break;
            case 4:
                estrellas.setBackground(getContext().getDrawable(R.drawable.estrella2));
                break;
            case 5:
                estrellas.setBackground(getContext().getDrawable(R.drawable.estrella2_2));
                break;
            case 6:
                estrellas.setBackground(getContext().getDrawable(R.drawable.estrella3));
                break;
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
        ((ActivityPregunta)mContext).finish();
    }



    @Override
    public void onBackPressed() {
        this.dismiss();
    }

    @Override
    public void onClick(View view) {
        this.dismiss();
    }
}
