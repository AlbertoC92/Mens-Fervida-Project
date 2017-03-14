package dam.riberadeltajo.alber.mens_fervida_videogame.juegoComidaCae;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.alber.mens_fervida_videogame.*;

public class MainArcadeComidaCae extends Activity{

    private MediaPlayer musica;
    private int puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Línea para ocultar el titulo
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(new GameViewComidaCae(this));
    }

    public void onResume(){
        super.onResume();
        musica=MediaPlayer.create(this,R.raw.cc_caketown);
        musica.setLooping(true);
        musica.start();
    }

    public void onPause(){
        super.onPause();
        if(musica!=null){
            musica.stop();
            musica.release();
        }
        this.onDestroy();
    }

    /*
    public void onDestroy(){
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public void onStop(){
        super.onStop();
    }*/

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
        finish();
    }
}
