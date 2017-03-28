package es.riberadeltajo.mens_fervida_videogame.juegoComidaCae;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Dani on 11/03/2017.
 */

public class EfectoComidaCae extends Thread {
    private MediaPlayer sonido;

    public EfectoComidaCae(Context context, int sonido){
        this.sonido=MediaPlayer.create(context,sonido);
    }

    public void run(){
        sonido.start();
        while(sonido.isPlaying()){}
        sonido.release();
    }
}
