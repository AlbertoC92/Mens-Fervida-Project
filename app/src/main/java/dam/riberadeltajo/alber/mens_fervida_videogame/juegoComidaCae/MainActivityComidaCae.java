package dam.riberadeltajo.alber.mens_fervida_videogame.juegoComidaCae;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alber.mens_fervida_videogame.*;

public class MainActivityComidaCae extends Activity {
    private Button btJugar;
    private Button btSalir;
    private TextView txtRecord;
    private SharedPreferences prefe;
    private int puntuacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Línea para ocultar el titulo
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_comida_cae);
        btJugar=(Button)findViewById(R.id.btJugarComCae);
        btSalir=(Button)findViewById(R.id.btSalirComidaCae);
        txtRecord=(TextView)findViewById(R.id.txtComidaCaeRecord);
        prefe = getSharedPreferences("recordComidaCae", Context.MODE_PRIVATE);
        puntuacion = Integer.parseInt(prefe.getString("puntosComidaCae", "0"));
        txtRecord.setText(String.valueOf(puntuacion));

        btJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarAljuego();
            }
        });

        btSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void pasarAljuego(){
        Intent inte=new Intent(this,MainArcadeComidaCae.class);
        startActivityForResult(inte,1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if(resultCode == RESULT_OK){
                Bundle bundle = data.getExtras();
                int puntos = bundle.getInt("puntuacion");
                if(puntos>puntuacion){
                    puntuacion=puntos;
                    guardar();
                    txtRecord.setText(String.valueOf(puntuacion));
                }
                String mensaje=String.format("Has obtenido %d puntos",puntos);

                Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
            }
        }
    }

    public void guardar(){
        SharedPreferences prefe = getSharedPreferences("recordComidaCae", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefe.edit();
        editor.putString("puntosComidaCae", String.valueOf(puntuacion));
        editor.commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
