package com.example.alber.mens_fervida_videogame;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import static android.R.attr.drawable;
import static android.R.attr.id;
import static com.example.alber.mens_fervida_videogame.AudioService.ACTIVO;
import static com.example.alber.mens_fervida_videogame.R.drawable.musica_off_rojo;


/**
 * Created by alber on 26/01/2017.
 */
//Clase dialogoOpciones que maneja todas las opciones que aparecen en el dialogo
public class dialogoOpciones extends Dialog implements View.OnClickListener{
    //campo que controla el editext del nombre
    private EditText campoNombre;
    //Spinner para los paises
    private Spinner sp;
    private String paises[]={"España","Polonia","Alemania","Francia"};
    private GridView gridview;
    private ImageView avatares;
    private Context context;
    private Button volver,aceptar,musica,volumen;
    private Activity activity;
    private AvataresAdapter adaptador;
    private GridView listaPersonajes;
    private Intent audio;




    public dialogoOpciones(Context context, int themeResId, Activity activity) {
        super(context, themeResId);
        this.context=context;
        this.activity=activity;
        quitarFondoRedimensionarEfectos();

    }

    public void quitarFondoRedimensionarEfectos(){
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

        LinearLayout ll=(LinearLayout) LayoutInflater.from(context).inflate(R.layout.layout_dialog_inicio, null);
        setContentView(ll);

        listaPersonajes=(GridView)findViewById(R.id.listaPersonajes);
        adaptador=new AvataresAdapter(context);
        campoNombre=(EditText)findViewById(R.id.campoNombre);
        //sp=(Spinner)findViewById(R.id.spPaises);
        //ArrayAdapter<String> adaptadorSp = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,paises);
        //sp.setAdapter(adaptadorSp);
        volver=(Button)findViewById(R.id.btnVolver);
        aceptar=(Button)findViewById(R.id.btnAceptar_dialog_opc);
        musica=(Button)findViewById(R.id.btnmusica);
        volumen=(Button)findViewById(R.id.btnsonido);
        audio = new Intent(context,AudioService.class);
        context.startService(audio);


        aceptar.setOnClickListener(this);
        musica.setOnClickListener(this);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configurarDialogo();
        listaPersonajes.setAdapter(adaptador);

    }

    public void ok(){
        Toast.makeText(context, "hola", Toast.LENGTH_SHORT).show();
    }






    public void quitarMusica(){
                musica.setBackgroundResource(R.drawable.musica_off_rojo);
                Intent i = new Intent(context, AudioService.class);
                i.putExtra("action", AudioService.PAUSE);
                context.startService(i);


    }

    public void activarMusica(){
        musica.setBackgroundResource(R.drawable.btn_musica_rojo);
        Intent i = new Intent(context, AudioService.class);
        i.putExtra("action", AudioService.START);
        context.startService(i);

    }


    //@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    //@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    //@Override
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAceptar_dialog_opc:
                ok();
                break;
            case R.id.btnmusica:
                quitarMusica();
                break;
        }
    }
}
