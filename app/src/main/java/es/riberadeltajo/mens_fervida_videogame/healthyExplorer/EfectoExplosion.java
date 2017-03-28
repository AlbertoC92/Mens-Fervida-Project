package es.riberadeltajo.mens_fervida_videogame.healthyExplorer;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Profesor on 25/01/2017.
 */

public class EfectoExplosion extends Thread {

    private MediaPlayer sonido;

    public EfectoExplosion(Context context, int sonido){
        this.sonido= MediaPlayer.create(context,sonido);
    }

    public void run(){
        sonido.start();
        while(sonido.isPlaying()){}
        sonido.stop();
        sonido.release();
    }
}
