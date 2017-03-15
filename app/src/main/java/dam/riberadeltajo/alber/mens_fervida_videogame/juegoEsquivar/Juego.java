package dam.riberadeltajo.alber.mens_fervida_videogame.juegoEsquivar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Profesor on 02/03/2017.
 */

public class Juego extends Activity{
    private int record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        record = getIntent().getIntExtra("puntos", 0);
        setContentView(new GameView(this));
    }

    public void fin(int puntos){
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }


}