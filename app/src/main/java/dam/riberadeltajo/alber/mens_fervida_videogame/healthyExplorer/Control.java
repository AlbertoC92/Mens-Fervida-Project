package dam.riberadeltajo.alber.mens_fervida_videogame.healthyExplorer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by alber on 18/02/2017.
 */

public class Control {

    public boolean pulsado=false; //indica si el control está pulsado o no
    public float coordenada_x, coordenada_y; //coordenadas donde se dibuja el control
    private Bitmap imagen,imagenescalada; //imagen del control
    private Context mContexto;
    public String nombre;
    private Juego juego;

    public Control(Context c, float x, float y){
        coordenada_x=x;
        coordenada_y=y;
        mContexto=c;

    }

    //carga su bitmap
    public void Cargar(int recurso){
        imagen= BitmapFactory.decodeResource(mContexto.getResources(), recurso);
        //imagenescalada = imagen.createScaledBitmap(imagen,(int)(juego.getWidth()*0.15),(int)(getHeight()*0.1),true);

    }

    //se dibuja en un canvas con un pincel (incluso transparente)
    public void Dibujar(Canvas c, Paint p){
        c.drawBitmap(imagen,coordenada_x,coordenada_y,p);
    }

    //se comprueba si se ha pulsado con el pointer i
    public boolean comprueba_pulsado(int x, int y){
        if(x>coordenada_x && x<coordenada_x+Ancho() && y>coordenada_y && y<coordenada_y+Alto()){
            pulsado=true;
        }
        return pulsado;
    }


    public void comprueba_soltado(ArrayList<Pulsacion> lista){
        boolean aux=false;
        for(Pulsacion t:lista){
            if(t.x>coordenada_x && t.x<coordenada_x+Ancho() && t.y>coordenada_y && t.y<coordenada_y+Alto()) {
                aux = true;
            }
        }
        if(!aux){
            pulsado=false;
        }
    }

    public int Ancho(){
        return imagen.getWidth();
    }

    public int Alto(){
        return imagen.getHeight();
    }
}
