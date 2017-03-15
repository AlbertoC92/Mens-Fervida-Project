package dam.riberadeltajo.alber.mens_fervida_videogame.juegoEsquivar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;



public class Enemy{
    private GameView gameView;
    private int wPant, hPant;
    private int w, h;
    private float x, y;
    private int ySpeed;
    private Bitmap bmp;

    public Enemy(GameView gameView,Bitmap bmp){
        setBmp(bmp);
        this.gameView = gameView;
        wPant = gameView.getWidth();
        hPant = gameView.getHeight();
        w = wPant/30;
        h = hPant/50;
        y = 0;
        x = (int)(Math.random()*(wPant-w));
        ySpeed = (int)((Math.random()*30) + 1);
    }

    public void draw(Canvas canvas){
        update();
        Paint pincel = new Paint();
        pincel.setColor(Color.RED);
        int corx=Math.round(getX());
        int cory=Math.round(getY());

        Rect src=new Rect(0,0,bmp.getWidth(),bmp.getHeight());
        Rect dst=new Rect(corx,cory,corx+bmp.getWidth(),cory+bmp.getHeight());
        canvas.drawBitmap(getBmp(),src,dst,null);


    }

    public void update(){
        if(y+h+ySpeed<hPant){
            y+=ySpeed;
        } else {
            x = (int)(Math.random()*(wPant-w));
            y=0;
            ySpeed++;
            gameView.setPuntuacion();
        }
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
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
