package dam.riberadeltajo.alber.mens_fervida_videogame;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alber.mens_fervida_videogame.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by PedroMiguel on 01/02/2017.
 */

public class DialogPregPalOpc extends Dialog implements View.OnClickListener {
    private Context mContext;
    private TextView word;
    private EditText respuesta;
    private Button btnAceptarRes, opc1, opc2, opc3, opc4;


    public DialogPregPalOpc(Context context, int themeResId) {
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
        setContentView(R.layout.layout_dialog_pregunta_opc);
        word=(TextView) findViewById(R.id.text_word);
        opc1=(Button) findViewById(R.id.btn_opc1);
        opc2=(Button) findViewById(R.id.btn_opc2);
        opc3=(Button) findViewById(R.id.btn_opc3);
        opc4=(Button) findViewById(R.id.btn_opc4);
        word.setText(((ActivityPregunta)mContext).pregunta.getWord());
        opc1.setOnClickListener(this);
        opc2.setOnClickListener(this);
        opc3.setOnClickListener(this);
        opc4.setOnClickListener(this);
        cargarOpcionesAleatoriamente();

    }

    private void cargarOpcionesAleatoriamente() {
        boolean todoPuesto=false;
        Random random= new Random();
        String [] opciones=((ActivityPregunta)mContext).pregunta.getOtherWordsYourLanguage();
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
        if(opcion.getText().toString().trim().toUpperCase().equals(((ActivityPregunta)mContext).pregunta.getTl1()) || opcion.getText().toString().trim().toUpperCase().equals(((ActivityPregunta)mContext).pregunta.getTl2()) || opcion.getText().toString().trim().toUpperCase().equals(((ActivityPregunta)mContext).pregunta.getTl3())){
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
