package dam.riberadeltajo.alber.mens_fervida_videogame.healthyExplorer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by alber on 22/02/2017.
 */

public class Bola {
    private final int[] DIRECCION={3,1,2};
    private int corx,cory;
    private int xSpeed,ySpeed;
    private Juego juego;
    private Bitmap bmp;
    private int width;
    private int height;
    private int puntos;
    private final int BOLA_GRANDE=0;
    private final int BOLA_PEQUENA=1;
    private int tipoBola;


    public Bola(Juego juego, Bitmap bmp, int tipo, int puntos){

        this.juego=juego;
        this.bmp=bmp;
        this.puntos=puntos;
        xSpeed=10;
        ySpeed=10;
       // corx=(int)(Math.random()* (juego.AnchoPantalla-juego.getBolaE().getWidth()));
        //cory = (int) (Math.random()*juego.AltoPantalla/5);
        corx=(int)(Math.random()*(juego.AnchoPantalla-bmp.getHeight())-xSpeed);
        cory=(int)(Math.random()*((juego.AltoPantalla/5)+bmp.getWidth()+ySpeed));
        if(tipo == 0){
            tipoBola=BOLA_GRANDE;
            this.width=bmp.getWidth()/2;
            this.height=bmp.getHeight()/2;

        }else {
            tipoBola = BOLA_PEQUENA;
            this.width=bmp.getWidth()/4;
            this.height=bmp.getHeight()/4;

        }
        setPuntos(puntos);

    }



    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getTipoBola() {
        return tipoBola;
    }

    public void setTipoBola(int tipoBola) {
        this.tipoBola = tipoBola;
    }

    public int getCorx() {
        return corx;
    }

    public void setCorx(int corx) {
        this.corx = corx;
    }

    public int getCory() {
        return cory;
    }

    public void setCory(int cory) {
        this.cory = cory;
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

    public void setPuntos(int puntos){
        this.puntos=puntos;
    }

    public int getPuntos(){
        return puntos;
    }




    private void update(){
        if(corx>=juego.getWidth()-width-xSpeed || corx+xSpeed<=0 ){
            xSpeed=-xSpeed;

        }
        else {
            corx += xSpeed;
        }
        if(cory>=juego.AltoPantalla/6*5+juego.getProta().getHeight()-height-ySpeed || cory+ySpeed<=0 ){
            ySpeed=-ySpeed;

        }
        else
            cory+=ySpeed;


    }

    public boolean colision(){
        if(juego.getProta().isCollition(corx,cory)){
            return true;
        }else

            return false;
    }

    public void draw(Canvas canvas,Paint pintar){
        Rect dst=new Rect(corx,cory,corx+width,cory+height);
        canvas.drawBitmap(bmp,null,dst,pintar);
        update();
    }



}
