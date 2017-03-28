package es.riberadeltajo.mens_fervida_videogame.juegonaves;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;


/**
 * Created by ILM on 27/02/2015.
 */
public class BucleJuego extends Thread {

    // Frames por segundo deseados
    public final static int 	MAX_FPS = 30;
    // Máximo número de frames saltados
    private final static int	MAX_FRAMES_SALTADOS = 3;
    // El periodo de frames
    private final static int	TIEMPO_FRAME = 1000 / MAX_FPS;

    private Juego juego;

    private boolean ejecutandose=true;
    private static final String TAG = Juego.class.getSimpleName();
    private SurfaceHolder surfaceHolder;

    public void fin(){
        ejecutandose=false;
    }

    BucleJuego(SurfaceHolder sh, Juego s){
        juego=s;
        surfaceHolder=sh;
    }

    @Override
    public void run() {
        Canvas canvas;
        Log.d(TAG, "Comienza el game loop");


        long tiempoComienzo;		// Tiempo en el que el ciclo comenzó
        long tiempoDiferencia;		// Tiempo que duró el ciclo
        int tiempoDormir;		// Tiempo que el thread debe dormir (<0 si vamos mal de tiempo)
        int framesASaltar;	// número de frames saltados

        tiempoDormir = 0;

        while (ejecutandose) {
            canvas = null;
            // bloquear el canvas para que nadie más escriba en el
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    tiempoComienzo = System.currentTimeMillis();
                    framesASaltar = 0;	// resetear los frames saltados
                    // Actualizar estado del juego
                    juego.actualizar();
                    // renderizar la imagen
                    juego.renderizar(canvas);
                    // Calcular cuánto tardó el ciclo
                    tiempoDiferencia = System.currentTimeMillis() - tiempoComienzo;
                    // Calcular cuánto debe dormir el thread antes de la siguiente iteración
                    tiempoDormir = (int)(TIEMPO_FRAME - tiempoDiferencia);

                    if (tiempoDormir > 0) {
                        // si sleepTime > 0 vamos bien de tiempo
                        try {
                            // Enviar el thread a dormir
                            // Algo de batería ahorramos
                            Thread.sleep(tiempoDormir);
                        } catch (InterruptedException e) {}
                    }

                    while (tiempoDormir < 0 && framesASaltar < MAX_FRAMES_SALTADOS) {
                        // Vamos mal de tiempo: Necesitamos ponernos al día
                        juego.actualizar(); // actualizar si rendering
                        tiempoDormir += TIEMPO_FRAME;	// actualizar el tiempo de dormir
                        framesASaltar++;
                    }


                }
            } finally {
                // si hay excepción desbloqueamos el canvas
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            //Log.d(TAG, "Nueva iteración!"+ejecutandose);
        }
    }


}
