package dam.riberadeltajo.alber.mens_fervida_videogame.juegoCartas;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.alber.mens_fervida_videogame.R;


public class MainActivityCartas extends AppCompatActivity {

    private static final int JUGAR = 1;
    private int puntuacion;
    private int maxX, maxY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Display miDisp = getWindowManager().getDefaultDisplay();
        Point dispSize = new Point();
        miDisp.getSize(dispSize);
        maxX = dispSize.x;
        maxY = dispSize.y;
        setContentView(R.layout.activity_main_cartas);
        // falta Shared prefferences
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == JUGAR){
            if(resultCode == RESULT_OK){
                int puntos = data.getIntExtra("pts",0);
                if(puntos > puntuacion){
                    puntuacion = puntos;
                }
            }
        }
    }

    public void jugar(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("maxX", maxX);
        intent.putExtra("maxY", maxY);
        startActivityForResult(intent, JUGAR);
    }

    public void finalizar(){
        finish();
    }
}
