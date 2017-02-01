package com.example.alber.mens_fervida_videogame;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by PedroMiguel on 01/02/2017.
 */

public class MenuNivelesActivity extends Activity implements View.OnClickListener{
    Dialog panel1, panel2;
    Button salir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Línea para ocultar el titulo
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//Línea para ocultar la barra de información de la batería,etc...
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles2);
        salir=(Button) findViewById(R.id.btn_atras_ac_niv);
        salir.setOnClickListener(this);
        cargarPaneles();

    }

    private void cargarPaneles() {
        panel1 = new DialogPanelNivelUno(this,R.style.AppTheme, this);
        panel2 = new DialogPanelNivelDos(this,R.style.AppTheme, this);
        panel1.show();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_atras_ac_niv:
                finish();
                break;
        }
    }
}
