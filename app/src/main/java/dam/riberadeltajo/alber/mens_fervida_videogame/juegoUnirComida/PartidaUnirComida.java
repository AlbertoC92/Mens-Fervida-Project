package dam.riberadeltajo.alber.mens_fervida_videogame.juegoUnirComida;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import com.example.alber.mens_fervida_videogame.*;
import static android.content.SharedPreferences.*;


public class PartidaUnirComida extends Activity {

    private TextView tvPuntuacion;
    private TextView tvTiempo;
    private Typeface face;
    private GridView gridview;
    private ImageAdapterUnirComida adaptador;
    private boolean saludable;
    private int puntos;

    private TextView tvPuntos;

    private SharedPreferences prefe;
    private Display display;
    private int ancho;
    private int alto;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida_unircomida);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        display = getWindowManager().getDefaultDisplay();
        ancho=display.getWidth();
        alto=display.getHeight();

        prefe=getSharedPreferences("puntos",Context.MODE_PRIVATE);
        face=Typeface.createFromAsset(getAssets(), "fonts/some_time_later.otf");
        tvPuntuacion=(TextView)findViewById(R.id.tvPuntuacion);
        tvPuntuacion.setTypeface(face);
        adaptador=new ImageAdapterUnirComida(this, ancho, alto);
        puntos=0;
        tvPuntos=(TextView)findViewById(R.id.tvPuntos);
        tvPuntos.setText(String.valueOf(puntos));


        gridview = (GridView) findViewById(R.id.gridview);

        gridview.setAdapter(adaptador);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // dentro de este listener difinimos la función que se ejecuta al
            // hacer click en un item
            // el metodo pertenece a AdapterView, es decir, es
            // AdapterView.OnItemClickListener
            // dentro de este, tenemos el método onItemClick, que es el que se
            // invoca al pulsar un item del AdapterView
            // esa función recibe el objeto padre, que es un adapterview en el
            // que se ha pulsado, una vista, que es el elemento sobre el que se
            // ha pulsado,
            // una posicion, que es la posicion del elemento dentro del adapter,
            // y un id, que es el id de fila del item que se ha pulsado
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                //Primero comprobará si es saludable o no.
                if(adaptador.getItem(position)==adaptador.getBmpDisponibles().get(0) ||
                        adaptador.getItem(position)==adaptador.getBmpDisponibles().get(1) ||
                        adaptador.getItem(position)==adaptador.getBmpDisponibles().get(2)){
                    //No es saludable, así que restará puntos
                    saludable=false;
                    puntos=puntos-(adaptador.borrarElemento(position));
                }
                else{
                    //Es saludable, así que sumará puntos.
                    saludable=true;
                    puntos=puntos+adaptador.borrarElemento(position);
                }
                tvPuntos.setText(String.valueOf(puntos));
                adaptador.notifyDataSetChanged();
                if(adaptador.getCount()==0){
                    finalizar(v);
                }
            }
        });

    }

    private void finalizar(View view) {
        int puntuacion;

        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("\t"+getResources().getString(R.string.popup)+" "+String.valueOf(puntos)
                +" "+getResources().getString(R.string.puntos))
                .setTitle("RESULTADO")
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();*/

        SharedPreferences preferencias=getSharedPreferences("puntos",Context.MODE_PRIVATE);
        Editor editor=preferencias.edit();
        if(Integer.parseInt(preferencias.getString("puntos", "0"))<puntos){
            editor.putString("puntos", String.valueOf(puntos));
            editor.commit();
        }
        esperarYCerrar(3000);
    }

    public void esperarYCerrar(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, milisegundos);
    }

    public void fin(){
        this.onPause();
        finish();
    }





}
