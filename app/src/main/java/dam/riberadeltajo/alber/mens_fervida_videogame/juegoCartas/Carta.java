package dam.riberadeltajo.alber.mens_fervida_videogame.juegoCartas;

import android.graphics.Bitmap;

public class Carta {
    private Bitmap bmp;
    private int ancho;
    private int alto;
    private int left, top;
    private int indiceCarta;

    public Carta(Bitmap bmp, int left, int top, int indice){
        setBmp(bmp);
        setAlto(bmp.getHeight());
        setAncho(bmp.getWidth());
        setLeft(left);
        setTop(top);
        setIndiceCarta(indice);

    }

    public int getIndiceCarta() {
        return indiceCarta;
    }

    public void setIndiceCarta(int indiceCarta) {
        this.indiceCarta = indiceCarta;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public Bitmap getBmp() {
        return bmp;
    }

    public void setBmp(Bitmap bmp) {
        this.bmp = bmp;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }
}