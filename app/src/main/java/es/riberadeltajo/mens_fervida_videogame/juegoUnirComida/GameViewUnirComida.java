package es.riberadeltajo.mens_fervida_videogame.juegoUnirComida;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

public class GameViewUnirComida extends SurfaceView {


    private SurfaceHolder holder;
    private GameLoopThreadUnirComida loop;
    private Typeface face;
    private final int TIEMPO_MAX=30;
    private long crono;
    private PartidaUnirComida actividad;
    private ImageAdapterUnirComida adaptador;



    public GameViewUnirComida(Context context) {
        super(context);


        loop=new GameLoopThreadUnirComida(this);
        actividad=(PartidaUnirComida)context;

        holder=getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {

            @SuppressLint("WrongCall")
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                loop.setRunning(true);
                loop.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                boolean volver=true;
                loop.setRunning(false);
                while(volver){
                    try{
                        loop.join();
                        volver=false;
                    }catch(InterruptedException ie){}
                }
            }
        });
    }

    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize((float) (getWidth() * 0.1));
        Toast.makeText(getContext(),
                String.format(pasarSeg(TIEMPO_MAX-crono)), Toast.LENGTH_SHORT);

    }

    private String pasarSeg(float time) {
        String cad = "";
        String txt = String.valueOf(time);
        int pos = 0;
        while (pos < txt.length()) {
            if (txt.charAt(pos) == '.' || txt.charAt(pos) == ',') {
                if (cad.length() > 1)
                    return cad;
                else return String.format("0%s", cad);
            } else {
                cad = String.format("%s%c", cad, txt.charAt(pos));
                pos++;
            }
        }
        return "";
    }

    private void finalizar(){
        loop.setRunning(false);
        try{
            Thread.sleep(2000);
        }catch(InterruptedException ie){}

        actividad.fin();
    }

}
