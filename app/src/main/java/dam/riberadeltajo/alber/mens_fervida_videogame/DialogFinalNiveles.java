package dam.riberadeltajo.alber.mens_fervida_videogame;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alber.mens_fervida_videogame.R;

import dam.riberadeltajo.alber.mens_fervida_videogame.entidades.Jugador;


/**
 * Created by alber on 15/02/2017.
 */

public class DialogFinalNiveles extends Dialog implements View.OnClickListener{

    private TextView felicidades;
    private EditText puntos,estrellas;
    private Context mContext;
    private LinearLayout panel;

    public DialogFinalNiveles(Context context, int themeResId) {
        super(context, themeResId);
        mContext=context;
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
        setContentView(R.layout.dialog_niveles_finalizados);
        panel =(LinearLayout)findViewById(R.id.linear_niveles_finalizados);
        panel.setOnClickListener(this);
        felicidades = (TextView)findViewById(R.id.txtFelicidades);
        felicidades.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
        puntos = (EditText)findViewById(R.id.txtPuntos);
        puntos.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));

        estrellas = (EditText)findViewById(R.id.txtEstrellas);
        estrellas.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));

        puntos.setText(String.format("%d", Jugador.getInstance().getPuntuacion()));
        estrellas.setText(String.format("%.1f", ((ActivityPregunta)mContext).estrellasSesion));
        ((ActivityPregunta)mContext).marcador.setVisibility(View.INVISIBLE);

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
