package dam.riberadeltajo.alber.mens_fervida_videogame.juegoCartas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        int x = getIntent().getIntExtra("maxX", 0);
        int y = getIntent().getIntExtra("maxY", 1);
        setContentView(new GameView(this, x, y));
    }

    public void finalizar(int puntos){
        Intent intent = new Intent();
        intent.putExtra("pts", puntos);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}
