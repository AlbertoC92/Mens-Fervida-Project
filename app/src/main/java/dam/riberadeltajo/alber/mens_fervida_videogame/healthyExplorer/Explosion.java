package dam.riberadeltajo.alber.mens_fervida_videogame.healthyExplorer;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.List;

/**
 * Created by Profesor on 18/01/2017.
 */

public class Explosion {
    private float corx;
    private float cory;
    private Bitmap bmp;
    private int life;
    private List<Explosion> temps;
    private int width,height;

    public Explosion(List<Explosion> temps, Juego juego, float x, float y, Bitmap bmp){
        life=10;
        this.width = bmp.getWidth();
        this.height = bmp.getHeight();
        this.temps=temps;
        this.bmp=bmp;
        this.corx= Math.min(Math.max(x-bmp.getWidth()/2,0),juego.getWidth()-bmp.getWidth());
        this.cory= Math.min(Math.max(y-bmp.getHeight()/2,0),juego.getHeight()-bmp.getHeight());
    }

    public void draw(Canvas canvas){
        if(--life<1)
            temps.remove(this);
        else{
            canvas.drawBitmap(bmp,corx,cory,null);
        }
    }
}
