package es.riberadeltajo.mens_fervida_videogame.juegoComidaCae;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Dani on 11/03/2017.
 */

public class SpriteComidaCae {
    private GameViewComidaCae gameView;
    private float corx,cory;
    private float width,height;
    private Bitmap bmp;
    private int ySpeed;
    private String tipo;
    private Boolean comprobado;

    public SpriteComidaCae(GameViewComidaCae gameView, Bitmap bmp,String tipo, float x){
        this.width=bmp.getWidth();
        this.height=bmp.getHeight();
        this.bmp=bmp;
        this.gameView=gameView;
        this.tipo=tipo;
        comprobado=false;
        corx=x;
        cory=0-height;
        ySpeed=10;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private void actualizar(){
        if(cory<=gameView.getHeight()-height) {
            cory += ySpeed;
        }else if(cory==0){
            cory=(float)(gameView.getHeight()+height);
        }else{
            if(cory>=((int)gameView.obtenerHeightLimite()) && !comprobado){
                if(tipo.equals("bueno")){
                    gameView.setVidas(gameView.getVidas()-1);
                    comprobado=true;
                }
            }
        }
    }


    public boolean isCollition(float x2,float y2){
        return x2>corx && x2<corx+width && y2>cory && y2<cory+height;
    }

    public void draw(Canvas canvas){
        actualizar();
        canvas.drawBitmap(bmp,corx,cory,null);
    }
}
