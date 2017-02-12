package com.example.alber.mens_fervida_videogame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
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

import java.util.Locale;

public class MenuPrincipal extends Activity {
    private Button buttonPlay,buttonOptions,buttonArcade,buttonExit;
    LinearLayout relativeLayout;
    private Dialog dialogCompartir, dialogOpciones, dialogRank;

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
        if(dialogOpciones==null)
            dialogOpciones = new dialogoOpciones(MenuPrincipal.this,R.style.AppTheme, this);
        dialogOpciones.show();

    }
    private void dialogoCompartir(){
        if(dialogCompartir==null)
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
        cargarIdiomaApp();
        if(Jugador.getInstance().isMusicaPlaying()){
            Intent i = new Intent(this, AudioService.class);
            i.putExtra("action", AudioService.START);
            startService(i);
        }
    }

    private void cargarIdiomaApp() {
        switch (Jugador.getInstance().getIdioma()){
            case 0:
                Configuration config1 = new Configuration();
                config1.setLocale(new Locale("es"));
                Locale.setDefault(new Locale("es")); // has no effect
                Resources res = getApplicationContext().getResources();
                res.updateConfiguration(config1, res.getDisplayMetrics());
                break;
            case 1:
                Configuration config2 = new Configuration();
                config2.setLocale(new Locale("pl"));
                Locale.setDefault(new Locale("pl")); // has no effect
                Resources res2 = getApplicationContext().getResources();
                res2.updateConfiguration(config2, res2.getDisplayMetrics());
                break;
            case 2:
                Configuration config3 = new Configuration();
                config3.setLocale(Locale.GERMAN);
                Locale.setDefault(Locale.GERMAN); // has no effect
                Resources res3 = getApplicationContext().getResources();
                res3.updateConfiguration(config3, res3.getDisplayMetrics());
                break;
        }
    }

    public void abrirRanking(View view){
        if(dialogRank==null)
            dialogRank=new DialogRankingInd(this, R.style.AppTheme);
        dialogRank.show();
    }


}


