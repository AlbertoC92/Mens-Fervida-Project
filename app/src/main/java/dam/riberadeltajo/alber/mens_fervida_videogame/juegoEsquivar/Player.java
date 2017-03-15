package dam.riberadeltajo.alber.mens_fervida_videogame.juegoEsquivar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Profesor on 02/03/2017.
 */

public class Player {
    private GameView gameView;
    private int wPant, hPant;
    private int w, h;
    private float corx, cory;
    private static final int xSpeed = 10;
    private Bitmap bmp;

    public Player(GameView gameView,Bitmap bmp){
        setBmp(bmp);
        this.gameView = gameView;
        wPant = gameView.getWidth();
        hPant = gameView.getHeight();
        w = wPant/25;
        h = hPant/45;
        corx = (wPant/2)-(w/2);
        cory = hPant-3*h;
    }

    public void draw(Canvas canvas, Bitmap bmp){
        Paint pincel = new Paint();
        int corx=Math.round(getCorx());
        int cory=Math.round(getCory());

        Rect src=new Rect(0,0,bmp.getWidth(),bmp.getHeight());
        Rect dst=new Rect(corx,cory,corx+bmp.getWidth(),cory+bmp.getHeight());
        canvas.drawBitmap(getBmp(),src,dst,null);
    }

    public void derecha(){
        if(corx +h+ xSpeed <=wPant) {
            corx += xSpeed;
        }
    }

    public void izquierda(){
        if(corx +h+ xSpeed >=0) {
            corx -= xSpeed;
        }
    }

    public float getCorx(){
        return corx;
    }

    public float getCory(){
        return cory;
    }

    public int getH(){
        return h;
    }

    public int getW(){
        return w;
    }
    public Bitmap getBmp() {
        return bmp;
    }

    public void setBmp(Bitmap bmp) {
        this.bmp = bmp;
    }
}
