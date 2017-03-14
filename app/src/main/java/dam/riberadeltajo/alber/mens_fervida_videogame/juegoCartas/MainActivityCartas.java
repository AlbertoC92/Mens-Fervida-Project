package dam.riberadeltajo.alber.mens_fervida_videogame.juegoCartas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alber.mens_fervida_videogame.R;


public class MainActivityCartas extends AppCompatActivity {

    private static final int JUGAR = 1;
    private TextView mostrarPuntos;
    private int puntuacion;
    private int maxX, maxY;
    private SharedPreferences prefe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cartas);
        Display miDisp = getWindowManager().getDefaultDisplay();
        Point dispSize = new Point();
        miDisp.getSize(dispSize);
        maxX = dispSize.x;
        maxY = dispSize.y;
        System.out.println("Max X: " + maxX + " /// Max Y: " + maxY);
        mostrarPuntos = (TextView)findViewById(R.id.txtPCartas);
        prefe = getSharedPreferences("datosCartas", Context.MODE_PRIVATE);
        puntuacion = Integer.parseInt(prefe.getString("puntos", "0"));
        mostrarPuntos.setText(String.valueOf(puntuacion));
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == JUGAR){
            if(resultCode == RESULT_OK){
                Bundle b = data.getExtras();
                int puntos = b.getInt("pts");
                if(puntos > puntuacion){
                    puntuacion = puntos;
                    guardar();
                    mostrarPuntos.setText(String.valueOf(puntuacion));
                }
            }
        }
    }

    public void juguemos(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("maxX", maxX);
        intent.putExtra("maxY", maxY);
        startActivityForResult(intent, JUGAR);
    }

    public void salir(View view){
        finish();
    }

    public void guardar(){
        SharedPreferences prefe = getSharedPreferences("datosCartas", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefe.edit();
        editor.putString("puntos", String.valueOf(puntuacion));
        editor.commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
