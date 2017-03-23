package dam.riberadeltajo.alber.mens_fervida_videogame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.alber.mens_fervida_videogame.R;

import dam.riberadeltajo.alber.mens_fervida_videogame.entidades.Jugador;


/**
 * Created by alberto garcia on 26/01/2017.
 */
//Clase dialogoOpciones que maneja todas las opciones que aparecen en el dialogo
public class dialogoOpciones extends Dialog implements View.OnClickListener{
    //campo que controla el editext del nombre
    private EditText campoNombre;
    private int avatarElegido=0;
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
    private Intent audio;
    private ToggleButton musica;
    private View imagenActual;
    private RadioGroup grupoIdiomas;
    private RadioButton rbSpanish, rbPolish, rbGerman, rbFrench;




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
        campoNombre=(EditText)findViewById(R.id.campo_nombre);
        //sp=(Spinner)findViewById(R.id.spPaises);
        //ArrayAdapter<String> adaptadorSp = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,paises);
        //sp.setAdapter(adaptadorSp);
        volver=(Button)findViewById(R.id.btn_volver_opc);
        aceptar=(Button)findViewById(R.id.btn_aceptar_dialog_opc);
        musica=(ToggleButton) findViewById(R.id.btnmusica);


        audio = new Intent(context,AudioService.class);
        context.startService(audio);
        if(Jugador.getInstance().getNombre()!=null){
            campoNombre.setText(Jugador.getInstance().getNombre());
        }

        aceptar.setOnClickListener(this);
        musica.setOnClickListener(this);

        if(Jugador.getInstance().isMusicaPlaying()){
            musica.setChecked(true);
        }
        else{
            musica.setChecked(false);
        }
        volver.setOnClickListener(this);

    }

    @Override
    public void show() {
        super.show();
        idiomaSeleccionado();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configurarDialogo();
        listaPersonajes.setAdapter(adaptador);

        listaPersonajes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                if(imagenActual!=null){
                    imagenActual.setAlpha((float) 1.0);
                }
                view.setAlpha((float) 0.5);
                imagenActual=view;
                avatarElegido=pos;
            }
        });
        listaPersonajes.setItemChecked(Jugador.getInstance().getAvatar(), true);

        rbSpanish=(RadioButton)findViewById(R.id.rb_spanish);
        rbPolish=(RadioButton)findViewById(R.id.rb_polish);
        rbGerman=(RadioButton)findViewById(R.id.rb_german);
        rbFrench=(RadioButton)findViewById(R.id.rb_french);
        grupoIdiomas=(RadioGroup) findViewById(R.id.grupo_idiomas);

    }

    private void idiomaSeleccionado() {
        switch(Jugador.getInstance().getIdioma()){
            case Jugador.SPANISH:
                rbSpanish.setChecked(true);
                break;
            case Jugador.POLISH:
                rbPolish.setChecked(true);
                break;
            case Jugador.GERMAN:
                rbGerman.setChecked(true);
                break;
            case Jugador.FRENCH:
                rbFrench.setChecked(true);
                break;
        }
    }

    public void ok(){
        Toast.makeText(context.getApplicationContext(), String.valueOf(Jugador.getInstance().getIdioma()), Toast.LENGTH_SHORT);
        Jugador.getInstance().setNombre(campoNombre.getText().toString());
        Jugador.getInstance().setAvatar(avatarElegido);
        if(rbSpanish.isChecked()==true) {
            Jugador.getInstance().setIdioma(0);
            System.out.println(Jugador.getInstance().getIdioma());
        }
        else if(rbPolish.isChecked()==true){
            Jugador.getInstance().setIdioma(Jugador.POLISH);
            System.out.println(Jugador.getInstance().getIdioma());
        }
        else if(rbGerman.isChecked()==true){
            Jugador.getInstance().setIdioma(Jugador.GERMAN);
            System.out.println(Jugador.getInstance().getIdioma());
        }
        else if(rbFrench.isChecked()==true){
            Jugador.getInstance().setIdioma(Jugador.FRENCH);
            System.out.println(Jugador.getInstance().getIdioma());
        }
        else{
            Jugador.getInstance().setIdioma(Jugador.NO_LANGUAGE);
            System.out.println(Jugador.getInstance().getIdioma());
        }
        Jugador.getInstance().setMusicaPlaying(musica.isChecked());
        Jugador.getInstance().guardarSharedPreferences();
        this.dismiss();
        ((MenuPrincipal)context).onResume();
    }





    public void quitarMusica(){
        if (musica.isChecked()) {
            Intent i = new Intent(context, AudioService.class);
            i.putExtra("action", AudioService.START);
            context.startService(i);
            Jugador.getInstance().setMusicaPlaying(true);


        } else {
            Intent i = new Intent(context, AudioService.class);
            i.putExtra("action", AudioService.PAUSE);
            context.startService(i);
            Jugador.getInstance().setMusicaPlaying(false);
        }

    }




    //@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    //@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    //@Override

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_aceptar_dialog_opc:
                System.out.println("ENTRA");
                ok();
                break;
            case R.id.btn_volver_opc:
                this.dismiss();
                break;
            case R.id.btnmusica:

                quitarMusica();
                break;

        }
    }
}
