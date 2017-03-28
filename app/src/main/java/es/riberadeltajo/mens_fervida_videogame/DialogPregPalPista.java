package es.riberadeltajo.mens_fervida_videogame;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import es.riberadeltajo.mens_fervida_videogame.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by PedroMiguel on 01/02/2017.
 */

public class DialogPregPalPista extends Dialog implements View.OnClickListener, DialogInterface.OnKeyListener {
    private Context mContext;
    private TextView tl1, titulo,tittle;
    private EditText respuesta;
    private Button btnAceptarRes;


    public DialogPregPalPista(Context context, int themeResId) {
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
        setContentView(R.layout.layout_dialog_pregunta_pista);
        tl1=(TextView) findViewById(R.id.text_word_pista);
        tl1.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
        respuesta=(EditText)findViewById(R.id.et_respuesta_pista);
        titulo=(TextView) findViewById(R.id.txt_titulo_preg_pista);
        titulo.setText(String.format("%s %s",getContext().getString(R.string.txt_preg_pista), ((ActivityPregunta)mContext).pregunta.getTl1()));
        tittle=(TextView)findViewById(R.id.txtTittle);
        tittle.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
        titulo.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
        respuesta.setBackgroundResource(R.drawable.campo_texto);
        cargarTextoPista();
        btnAceptarRes=(Button) findViewById(R.id.btn_aceptar_pregunta);
        btnAceptarRes.setOnClickListener(this);
        this.setOnKeyListener(this);

    }



    private void cargarTextoPista() {
        boolean todoPuesto=false;
        Random random= new Random();
        String word=((ActivityPregunta)mContext).pregunta.getWord();
        ArrayList<Integer> posAle= new ArrayList<>();
        String pista="";
        if (word.length() <=3)  {
            while(posAle.size()<1){
                Integer i=random.nextInt(word.length());
                if(!posAle.contains(i)){
                    posAle.add(i);
                }
            }

            for(int i=0;i<word.length();i++){
                if(i==posAle.get(0)){
                    pista=String.format("%s%c ",pista, word.charAt(i));
                } else
                    pista=String.format("%s_ ", pista);
            }
        }
        else if (word.length() <=5)  {
            while(posAle.size()<2){
                Integer i=random.nextInt(word.length());
                if(!posAle.contains(i)){
                    posAle.add(i);
                }
            }
            for(int i=0;i<word.length();i++){
                if(i==posAle.get(0) || i==posAle.get(1)){
                    pista=String.format("%s%c ",pista, word.charAt(i));
                } else
                    pista=String.format("%s_ ", pista);
            }

        }
        else if (word.length() <=7)  {
            while(posAle.size()<3){
                Integer i=random.nextInt(word.length());
                if(!posAle.contains(i)){
                    posAle.add(i);
                }
            }
            for(int i=0;i<word.length();i++){
                if(i==posAle.get(0) || i==posAle.get(1) || i==posAle.get(2)){
                    pista=String.format("%s%c ",pista, word.charAt(i));
                } else
                    pista=String.format("%s_ ", pista);
            }
        }
        else if (word.length() <=10)  {
            while(posAle.size()<4){
                Integer i=random.nextInt(word.length());
                if(!posAle.contains(i)){
                    posAle.add(i);
                }
            }
            for(int i=0;i<word.length();i++){
                if(i==posAle.get(0) || i==posAle.get(1) || i==posAle.get(2) ||i==posAle.get(3)){
                    pista=String.format("%s%c ",pista, word.charAt(i));
                } else
                    pista=String.format("%s_ ", pista);
            }
        }
        else if (word.length() <=13)  {
            while(posAle.size()<5){
                Integer i=random.nextInt(word.length());
                if(!posAle.contains(i)){
                    posAle.add(i);
                }
            }
            for(int i=0;i<word.length();i++){
                if(i==posAle.get(0) || i==posAle.get(1) || i==posAle.get(2) ||i==posAle.get(3) || i==posAle.get(4)){
                    pista=String.format("%s%c ",pista, word.charAt(i));
                } else
                    pista=String.format("%s_ ", pista);
            }
        }
        else{
            while(posAle.size()<6){
                Integer i=random.nextInt(word.length());
                if(!posAle.contains(i)){
                    posAle.add(i);
                }
            }
            for(int i=0;i<word.length();i++){
                if(i==posAle.get(0) || i==posAle.get(1) || i==posAle.get(2) ||i==posAle.get(3) || i==posAle.get(4) || i==posAle.get(5)){
                    pista=String.format("%s%c ",pista, word.charAt(i));
                } else
                    pista=String.format("%s_ ", pista);
            }
        }


        tl1.setText(pista);
    }

    public void comprobarPregunta(){


        if(respuesta.getText().toString().trim().toUpperCase().equals(((ActivityPregunta)mContext).pregunta.getWord())){
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
            case R.id.btn_aceptar_pregunta:
                comprobarPregunta();
                break;



        }
    }


    @Override
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if(i==KeyEvent.KEYCODE_ENTER){
            comprobarPregunta();
        }
        if(i==KeyEvent.KEYCODE_VOLUME_DOWN){
            return super.onKeyDown(i, keyEvent);
        }
        if(i==KeyEvent.KEYCODE_VOLUME_UP){
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }


}
