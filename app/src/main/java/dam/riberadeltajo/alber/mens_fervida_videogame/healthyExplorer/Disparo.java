package dam.riberadeltajo.alber.mens_fervida_videogame.healthyExplorer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.util.Log;

import com.example.alber.mens_fervida_videogame.R;

/**
 * Created by alber on 18/02/2017.
 */

public class Disparo {

    public float coordenada_x, coordenada_y; //coordenadas donde se dibuja el control
    private Juego juego;
    private float velocidad;
    private MediaPlayer mediaPlayer; //para reproducir el sonido de disparo
    /*Constructor con coordenadas iniciales y número de disparo*/
    public Disparo(Juego j,float x, float y){
        juego=j;
        coordenada_x=x;
        coordenada_y=y-j.disparo.getHeight()+15;
        velocidad=10*(j.AltoPantalla)/1920; //adaptar velocidad al tamaño de pantalla
        Log.i(Juego.class.getSimpleName(),"Velocidad de disparo: " + velocidad);
        mediaPlayer=MediaPlayer.create(j.getContext(), R.raw.lava);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        mediaPlayer.start();
    }

    //se actualiza la coordenada y nada más
    public void ActualizaCoordenadas(){
        coordenada_y-=velocidad;
    }

    public void Dibujar(Canvas c, Paint p) {
        c.drawBitmap(juego.disparo, coordenada_x, coordenada_y, p);
    }

    public int Ancho(){
        return juego.disparo.getWidth();
    }

    public int Alto(){
        return juego.disparo.getHeight();
    }

    public boolean FueraDePantalla() {
        return coordenada_y < 0;
    }

}
