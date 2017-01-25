package com.example.alber.mens_fervida_videogame;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MenuPrincipal extends Activity {
    private Button buttonPlay,buttonOptions,buttonExit;
    private TextView titulo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Línea para ocultar el titulo
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//Línea para ocultar la barra de información de la batería,etc...
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
       /* buttonPlay = (Button)findViewById(R.id.buttonPlay);
        buttonOptions = (Button)findViewById(R.id.buttonOptions);
        buttonExit = (Button)findViewById(R.id.buttonExit);
        buttonPlay.setTextSize(30);
        buttonOptions.setTextSize(30);
        buttonExit.setTextSize(30);
        buttonPlay.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/cinnabar brush.ttf"));
        buttonOptions.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/cinnabar brush.ttf"));
        buttonExit.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/cinnabar brush.ttf"));*/
        Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);

        dialog.setContentView(R.layout.layout_dialog_inicio);
        dialog.show();
    }

    public void jugar(View view){

    }

    public void opciones(View view){

    }

    public void salir(View view){
        finish();
    }
}
