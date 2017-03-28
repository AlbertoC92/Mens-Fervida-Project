package es.riberadeltajo.mens_fervida_videogame.healthyExplorer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import es.riberadeltajo.mens_fervida_videogame.R;

public class Instrucciones extends AppCompatActivity {
    private ActividadPrincipal acti;
    private int request_code=2;
    private int puntuacion;
    private MediaPlayer musica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        acti = new ActividadPrincipal();
        musica = acti.getMediaPlayer();
        puntuacion = 0;
        setContentView(R.layout.activity_instrucciones);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void Jugar(View vista){

        Intent intent =new Intent(this, MenuJuego.class);
        startActivityForResult(intent,request_code);
    }

    public void volver(View vista){
        Intent intent=new Intent();
        intent.putExtra("puntuacionMaxima",puntuacion);
        setResult(RESULT_OK,intent);
        this.finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==request_code){
            if(resultCode==RESULT_OK){
                Bundle bundle=data.getExtras();
                int puntJuego = bundle.getInt("puntuacion");
                if(puntJuego>puntuacion){
                    puntuacion=puntJuego;
                }
            }
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
    @Override
    public void onBackPressed() {
        finish();
    }
}
