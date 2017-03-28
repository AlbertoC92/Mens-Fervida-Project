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

/**
 * Created by PedroMiguel on 01/02/2017.
 */

public class DialogPregPalComp extends Dialog implements View.OnClickListener, DialogInterface.OnKeyListener {
    private Context mContext;
    private TextView word,question,tittle;
    private EditText respuesta;
    private Button btnAceptarRes;


    public DialogPregPalComp(Context context, int themeResId) {
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
        setContentView(R.layout.layout_dialog_pregunta_normal);
        word=(TextView) findViewById(R.id.text_word);
        word.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
        question=(TextView)findViewById(R.id.txtQuestion);
        question.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
        tittle=(TextView)findViewById(R.id.txtTittle);
        tittle.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
        respuesta=(EditText)findViewById(R.id.et_respuesta);
        respuesta.setBackgroundResource(R.drawable.campo_texto);
        word.setText(((ActivityPregunta)mContext).pregunta.getWord());
        btnAceptarRes=(Button) findViewById(R.id.btn_aceptar_pregunta);
        btnAceptarRes.setOnClickListener(this);
        this.setOnKeyListener(this);

    }
    public void comprobarPregunta(){

        if(respuesta.getText().toString().trim().toUpperCase().equals(((ActivityPregunta)mContext).pregunta.getTl1()) || respuesta.getText().toString().trim().toUpperCase().equals(((ActivityPregunta)mContext).pregunta.getTl2()) || respuesta.getText().toString().trim().toUpperCase().equals(((ActivityPregunta)mContext).pregunta.getTl3())){
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
