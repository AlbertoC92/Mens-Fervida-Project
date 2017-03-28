package es.riberadeltajo.mens_fervida_videogame.juegonaves;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

/**
 * Created by ILM on 04/03/2015.
 */
public class Enemigo {

    public final int BURGUER=0; //enemigo que sigue a la nave
    public final int CHIPS=1;       //enemigo que se mueve aleatoriamente

    public final float VELOCIDAD_CHIPS=5;
    public final float VELOCIDAD_BURGUER=2;
    public float velocidad;

    public float coordenada_x, coordenada_y; //coordenadas donde se dibuja el control
    public int tipo_enemigo; //imagen del control

    public float direccion_vertical=1;  //inicialmente hacia abajo
    public float direccion_horizontal=1; //inicialmente derecha
    
    private int Nivel;

    private Juego juego;


    public Enemigo(Juego j, int n){
        juego=j;
        Nivel=n;
        //probabilidad de enemigo tonto 80%, enemigo listo 20%
        if(Math.random()>0.20) {
            tipo_enemigo = BURGUER;
            velocidad = (VELOCIDAD_BURGUER+Nivel)*juego.AltoPantalla/1920;
            Log.i(Juego.class.getSimpleName(),"Velocidad de las hamburguesas "+velocidad);
        }
        else {
            tipo_enemigo = CHIPS;
            velocidad = (VELOCIDAD_CHIPS+Nivel)*juego.AltoPantalla/1920;
            Log.i(Juego.class.getSimpleName(),"Velocidad de las patatas "+velocidad);
        }

        //para el enemigo tonto se calcula la dirección aleatoria
        if(Math.random()>0.5)
            direccion_horizontal=1; //derecha
        else
            direccion_horizontal=-1; //izquierda

        if(Math.random()>0.5)
            direccion_vertical=1; //abajo
        else
            direccion_vertical=-1; //arriba


        CalculaCoordenadas();

    }

    public void CalculaCoordenadas(){
        double x; //aleatorio
        /* Posicionamiento del enemigo */
        //entre 0 y 0.125 sale por la izquierda (x=0, y=aleatorio(1/5) pantalla)
        //entre 0.125 y 0.25 sale por la derecha (x=AnchoPantalla-anchobitmap, y=aleatorio(1/5))
        //>0.25 sale por el centro (y=0, x=aleatorio entre 0 y AnchoPantalla-AnchoBitmap)

        x=Math.random();

        if(x<=0.25){
            //25% de probabilidad de que el enemigo salga por los lados
            if(x<0.125) //sale por la izquierda
                coordenada_x = 0;
            else
                coordenada_x = juego.AnchoPantalla-juego.hamburguesa.getWidth();
            coordenada_y = (int) (Math.random()*juego.AltoPantalla/5);
        }else{
            coordenada_x=(int)(Math.random()* (juego.AnchoPantalla-juego.hamburguesa.getWidth()));

            coordenada_y=0;
        }
    }

    //Actualiza la coordenada del enemigo con respecto a la coordenada de la nave
    public void ActualizaCoordenadas(){
        if(tipo_enemigo==CHIPS) {
            if (juego.xNave > coordenada_x)
                coordenada_x+=velocidad;
            else if (juego.xNave < coordenada_x)
                coordenada_x-=velocidad;

            if(Math.abs(coordenada_x-juego.xNave)<velocidad)
                coordenada_x=juego.xNave; //si está muy cerca se pone a su altura

            if( coordenada_y>=juego.AltoPantalla-juego.patatas.getHeight()
                    && direccion_vertical==1)
                direccion_vertical=-1;
            if(coordenada_y<=0 && direccion_vertical ==-1)
                direccion_vertical=1;

            coordenada_y+=direccion_vertical*velocidad;
        }
        else{
            //el enemigo tonto hace caso omiso a la posición de la nave,
            //simplemente pulula por la pantalla
            coordenada_x+=direccion_horizontal*velocidad;
            coordenada_y+=direccion_vertical*velocidad;
            //Cambios de direcciones al llegar a los bordes de la pantalla
            if(coordenada_x<=0 && direccion_horizontal==-1)
                direccion_horizontal=1;
            if(coordenada_x>juego.AnchoPantalla-juego.hamburguesa.getWidth() && direccion_horizontal==1)
                direccion_horizontal=-1;
            if(coordenada_y>=juego.AltoPantalla && direccion_vertical ==1)
                direccion_vertical=-1;
            if(coordenada_y<=0 && direccion_vertical==-1)
                direccion_vertical=1;
        }
    }

    public void Dibujar(Canvas c, Paint p){
        if(tipo_enemigo==BURGUER)
            c.drawBitmap(juego.hamburguesa,coordenada_x,coordenada_y,p);
        else
            c.drawBitmap(juego.patatas,coordenada_x,coordenada_y,p);
    }

    public int Ancho(){
        if(tipo_enemigo==BURGUER)
            return juego.hamburguesa.getWidth();
        else
            return juego.patatas.getWidth();
    }

    public int Alto(){
        if(tipo_enemigo==BURGUER)
            return juego.hamburguesa.getHeight();
        else
            return juego.patatas.getHeight();
    }

}
