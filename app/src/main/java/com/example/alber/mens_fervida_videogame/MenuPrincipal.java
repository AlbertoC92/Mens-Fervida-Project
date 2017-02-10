package com.example.alber.mens_fervida_videogame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alber.mens_fervida_videogame.entidades.Jugador;
import com.example.alber.mens_fervida_videogame.sqlite.IdiomasSQLiteOpenHelper;

public class MenuPrincipal extends Activity {
    private Button buttonPlay,buttonOptions,buttonArcade,buttonExit;
    LinearLayout relativeLayout;
    private TextView titulo;
    private dialogoOpciones dialog;
    private DialogoCompartir dialogCompartir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Línea para ocultar el titulo
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//Línea para ocultar la barra de información de la batería,etc...
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu_principal);
        buttonPlay = (Button)findViewById(R.id.bt_jugar);
        buttonOptions = (Button)findViewById(R.id.bt_opciones);
        buttonExit = (Button)findViewById(R.id.bt_salir);
        buttonArcade = (Button)findViewById(R.id.bt_arcade);
        buttonPlay.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/chewy.ttf"));
        buttonOptions.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/chewy.ttf"));
        buttonExit.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/chewy.ttf"));
        buttonArcade.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/chewy.ttf"));
        relativeLayout=(LinearLayout) findViewById(R.id.activity_main);
        IdiomasSQLiteOpenHelper.getInstance(this);
        Jugador.getInstance(this);



    }

    public void jugar(View view){
        if(Jugador.getInstance().getNombre()==null || Jugador.getInstance().getIdioma()==Jugador.NO_LANGUAGE){
            abrirOpciones();
        }
        else{
            Intent i = new Intent(this,MenuNivelesActivity.class);
            startActivity(i);
        }


    }

    public void opciones(View view){
        abrirOpciones();
    }


    public void salir(View view){

        finish();

    }

    public void arcades(View view){
        Intent i=new Intent(this,MenuArcades.class);
        startActivity(i);
    }

    public void compartir(View view){

        dialogoCompartir();
    }

    private void abrirOpciones() {
        String gender;
        dialogoOpciones dialog = new dialogoOpciones(MenuPrincipal.this,R.style.AppTheme, this);
        dialog.show();

    }
    private void dialogoCompartir(){
        dialogCompartir = new DialogoCompartir(MenuPrincipal.this,R.style.AppTheme,this);
        dialogCompartir.show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Intent i = new Intent(this, AudioService.class);
        i.putExtra("action", AudioService.PAUSE);
        startService(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Jugador.getInstance(this).getNombre()==null){
            abrirOpciones();
        }
        if(Jugador.getInstance().isMusicaPlaying()){
            Intent i = new Intent(this, AudioService.class);
            i.putExtra("action", AudioService.START);
            startService(i);
        }
    }


}


