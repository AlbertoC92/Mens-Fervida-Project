package dam.riberadeltajo.alber.mens_fervida_videogame.juegoEsquivar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.alber.mens_fervida_videogame.R;

public class MainActivity extends Activity {


    private SharedPreferences preferences;
    private int puntuacion;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_esquivar1);
            preferences = getSharedPreferences("maxPuntos", Context.MODE_PRIVATE);
            puntuacion = Integer.parseInt(preferences.getString("puntosJuegoEsquivar", "0"));

        }




    public void jugar(View view){
        Intent intent = new Intent(this, Juego.class);
        startActivityForResult(intent,1);
    }
    public void instrucciones (View view){
        Intent intent= new Intent(this,Instrucciones.class);
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if(resultCode == RESULT_OK){
                Bundle bundle = data.getExtras();
                int puntos = bundle.getInt("puntuacion");
                if(puntos>puntuacion){
                    puntuacion=puntos;
                    guardar();
                }
                String mensaje=String.format("Has obtenido %d puntos",puntos);

                Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
            }
        }

    }
    public void guardar(){
        SharedPreferences prefe = getSharedPreferences("maxPuntuacion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefe.edit();
        editor.putString("puntosEsquivarJuego", String.valueOf(puntuacion));
        editor.commit();
    }
    public void salir(View view){
        finish();
    }
}

