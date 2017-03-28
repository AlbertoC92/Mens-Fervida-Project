package es.riberadeltajo.mens_fervida_videogame;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import es.riberadeltajo.mens_fervida_videogame.R;

import java.util.ArrayList;
import java.util.Random;

import es.riberadeltajo.mens_fervida_videogame.entidades.Imagen;

/**
 * Created by PedroMiguel on 01/02/2017.
 */

public class DialogPregPalOpcIma extends Dialog implements View.OnClickListener {
    private Context mContext;
    private ImageView imagen;
    private TextView tittle;
    private EditText respuesta;
    private Button btnAceptarRes, opc1, opc2, opc3, opc4;


    public DialogPregPalOpcIma(Context context, int themeResId) {
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
        getWindow().setLayout((int)(size.x*0.8), (int)(size.y*0.56));
        getWindow().getAttributes().windowAnimations = R.style.PanelPregunta;
        getWindow().getAttributes().gravity= Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        getWindow().getAttributes().y= (int) (height*0.1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_pregunta_opc_ima);
        imagen=(ImageView) findViewById(R.id.img_latouy_dialog_opc);
        tittle=(TextView)findViewById(R.id.txtTittle);
        tittle.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
        opc1=(Button) findViewById(R.id.btn_opc1);
        opc2=(Button) findViewById(R.id.btn_opc2);
        opc3=(Button) findViewById(R.id.btn_opc3);
        opc4=(Button) findViewById(R.id.btn_opc4);
        opc1.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
        opc2.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
        opc3.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
        opc4.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
        Drawable image=mContext.getDrawable(Imagen.obtenerImagen(((ActivityPregunta)mContext).pregunta.getWord()));
        imagen.setImageDrawable(image);
        opc1.setOnClickListener(this);
        opc2.setOnClickListener(this);
        opc3.setOnClickListener(this);
        opc4.setOnClickListener(this);
        cargarOpcionesAleatoriamente();

    }

    private void cargarOpcionesAleatoriamente() {
        boolean todoPuesto=false;
        Random random= new Random();
        String [] opciones={
                            ((ActivityPregunta)mContext).pregunta.getWord(),
                            ((ActivityPregunta)mContext).pregunta.getTl1(),
                            ((ActivityPregunta)mContext).pregunta.getTl2(),
                            ((ActivityPregunta)mContext).pregunta.getTl3()};
        ArrayList<Integer> posAle= new ArrayList<>();
        while(posAle.size()<4){
            Integer i=random.nextInt(4);
            if(!posAle.contains(i)){
                posAle.add(i);
            }
        }
        opc1.setText(opciones[posAle.get(0)]);
        opc2.setText(opciones[posAle.get(1)]);
        opc3.setText(opciones[posAle.get(2)]);
        opc4.setText(opciones[posAle.get(3)]);

    }

    public void comprobarPregunta(Button opcion){


        if(opcion.getText().toString().trim().toUpperCase().equals(((ActivityPregunta)mContext).pregunta.getWord())){
            ((ActivityPregunta)mContext).preguntaAcertada();
            this.dismiss();
        }
        else{
            ((ActivityPregunta)mContext).preguntaFallada();
            this.dismiss();

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_opc1:
                comprobarPregunta(opc1);
                break;
            case R.id.btn_opc2:
                comprobarPregunta(opc2);
                break;
            case R.id.btn_opc3:
                comprobarPregunta(opc3);
                break;
            case R.id.btn_opc4:
                comprobarPregunta(opc4);
                break;



        }
    }


    @Override
    public void onBackPressed() {

    }
}
