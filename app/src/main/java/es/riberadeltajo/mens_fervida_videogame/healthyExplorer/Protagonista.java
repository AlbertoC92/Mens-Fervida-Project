package es.riberadeltajo.mens_fervida_videogame.healthyExplorer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by alber on 18/02/2017.
 */

public class Protagonista {

    private final int[] DIRECCION={1,2,3};
    private final int BMP_COLUMNS=4;
    private final int BMP_ROWS=3;
    private int corx,cory;
    private int xSpeed;
    private Juego juego;
    private Bitmap bmp;
    private int currentFrame;
    private int width;
    private int height;
    private int dir;



    public Protagonista(Juego juego, Bitmap bmp,int x , int y,int speed ){
        this.width=bmp.getWidth()*2;
        this.height=bmp.getHeight()*2;
        this.juego=juego;
        this.bmp=bmp;
        currentFrame=0;
        xSpeed= speed;
        corx=  x;
        cory=  y;
        dir = 0;


    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public int getDireccionPersonaje(int i){

        if(i == 0)
           setDir(0);
        if(i==1)
            setDir(1);
        if(i == 2)
            setDir(2);

        return DIRECCION[getDir()];

    }

    private void update(){
        if(corx>=juego.getWidth()-width-xSpeed || corx+xSpeed<=0){
            xSpeed=-xSpeed;
        }
        else
            corx+=xSpeed;

        currentFrame=++currentFrame%BMP_COLUMNS;
    }
    public void actualizarFrame(){
        currentFrame=++currentFrame%BMP_COLUMNS;
    }

    public void draw(Canvas canvas,Paint p){
        //update();
        //juego.actualizar();
        int srcx=currentFrame*getWidth();
        int srcy=getDireccionPersonaje(getDir())*height;
        Rect src=new Rect(srcx,srcy,srcx+width,srcy+height);
        Rect dst=new Rect(corx,cory,corx+width,cory+height);
        canvas.drawBitmap(bmp,src,dst,p);
    }

    public boolean isCollition(float x2,float y2){
        return x2>corx && x2<corx+width && y2>cory && y2<cory+height;
    }
}