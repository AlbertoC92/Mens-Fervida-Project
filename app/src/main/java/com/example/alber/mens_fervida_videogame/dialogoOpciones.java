package com.example.alber.mens_fervida_videogame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.Intent.getIntent;

/**
 * Created by alber on 26/01/2017.
 */
//Clase dialogoOpciones que maneja todas las opciones que aparecen en el dialogo
public class dialogoOpciones extends Dialog {
    //campo que controla el editext del nombre
    private EditText campoNombre;
    //Spinner para los paises
    private Spinner sp;
    private String paises[]={"España","Polonia","Alemania","Francia"};
    private GridView gridview;
    private ImageView avatares;
    private Context context;
    private Button volver,aceptar;
    private Activity activity;
    private AvataresAdapter adaptador;
    private GridView listaPersonajes;


    public dialogoOpciones(Context context, int themeResId, Activity activity) {
        super(context, themeResId);
        this.context=context;
        this.activity=activity;
        quitarFondoRedimensionar();

    }

    public void quitarFondoRedimensionar(){
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        getWindow().setLayout((int)(size.x*0.7), (int)(size.y*0.7));
        getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN );
        setCanceledOnTouchOutside(true);
    }


    //metodo que inicializa botones
    public void configurarDialogo(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_dialog_inicio);
        listaPersonajes=(GridView)findViewById(R.id.listaPersonajes);
        adaptador=new AvataresAdapter(context);
        campoNombre=(EditText)findViewById(R.id.campoNombre);
        //sp=(Spinner)findViewById(R.id.spPaises);
        //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,paises);
        //sp.setAdapter(adaptador);
        volver=(Button)findViewById(R.id.btnVolver);
        aceptar=(Button)findViewById(R.id.btnAceptar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configurarDialogo();
        listaPersonajes.setAdapter(adaptador);
        listaPersonajes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(view.getContext(), listaPersonajes.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
