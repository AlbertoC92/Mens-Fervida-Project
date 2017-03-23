package dam.riberadeltajo.alber.mens_fervida_videogame.juegoComidaCae;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.alber.mens_fervida_videogame.R;

public class MainArcadeComidaCae extends Activity{
    private GameViewComidaCae gameView;
    private MediaPlayer musica;
    //private int puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Línea para ocultar el titulo
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(new GameViewComidaCae(this));
        gameView=new GameViewComidaCae(this);
        musica=MediaPlayer.create(this, R.raw.cc_caketown);
        //musica.setLooping(true);
        musica.start();

    }

    public void onResume(){
        super.onResume();

    }

    public void onPause(){
        super.onPause();
        musica.stop();
        musica.release();
        this.onDestroy();
    }



    public void fin(int puntos){
        //super.onDestroy();
        Intent intVuelta=new Intent();
        intVuelta.putExtra("puntuacion",puntos);
        setResult(Activity.RESULT_OK,intVuelta);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(Activity.RESULT_CANCELED, intent);
        musica.stop();
        musica.release();
        finish();
    }
}
