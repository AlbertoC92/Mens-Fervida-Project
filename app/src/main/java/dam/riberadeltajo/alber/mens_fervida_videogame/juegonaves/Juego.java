package dam.riberadeltajo.alber.mens_fervida_videogame.juegonaves;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.example.alber.mens_fervida_videogame.R;

import java.util.ArrayList;
import java.util.Iterator;

import static com.example.alber.mens_fervida_videogame.R.drawable.burger;
import static com.example.alber.mens_fervida_videogame.R.drawable.chips;


/**
 * Created by ILM on 27/02/2015.
 */
public class Juego extends SurfaceView implements SurfaceHolder.Callback, SurfaceView.OnTouchListener {
    private SurfaceHolder holder;
    public BucleJuego bucle;
    private Activity actividad;



    public int AltoPantalla;
    public int AnchoPantalla;


    private static final String TAG = Juego.class.getSimpleName();

    /*Array de Touch */
    private ArrayList<Toque> toques = new ArrayList<Toque>();
    boolean hayToque=false;

    private Bitmap fondo; //Bitmap auxiliar para cargar en el array los recursos
    private static final int MAX_IMAGENES_FONDO= 3; //imagenes que componen el escenario
    Bitmap imagenes[]=new Bitmap[MAX_IMAGENES_FONDO]; // Arrays de imágenes
    /* Array de recursos que componen el escenario*/
    int recursos_imagenes[]={R.drawable.bg1,R.drawable.bg2,R.drawable.bg3};

    /* Controles */
    private final int IZQUIERDA=0;
    private final int DERECHA=1;
    private final int DISPARO=2;

    private final float VELOCIDAD_HORIZONTAL; //pixels por frame
    Control controles[]=new Control[3];

    /* Enemigos */
    Bitmap hamburguesa, patatas;
    public final int TOTAL_ENEMIGOS=500; //Enemigos para acabar el juego
    private int enemigos_minuto=50; //número de enemigos por minuto
    private int frames_para_nuevo_enemigo=0; //frames que restan hasta generar nuevo enemigo
    private int enemigos_muertos=0; //Contador de enemigos muertos
    private int enemigos_creados=0;

    /*Puntos */
    private int Puntos=0;
    private int Nivel=0;
    private int PUNTOS_CAMBIO_NIVEL=2000;

    /* Fin de juego */
    private boolean victoria=false,derrota=false;

    /* Lista Enemigos */
    private ArrayList<Enemigo> lista_enemigos=new ArrayList<Enemigo>();

    /* Disparos */
    private ArrayList<Disparo> lista_disparos=new ArrayList<Disparo>();

    Bitmap disparo;
    private int frames_para_nuevo_disparo=0;
    //entre disparo y disparo deben pasar al menos MAX_FRAMES_ENTRE_DISPARO
    private final int MAX_FRAMES_ENTRE_DISPARO=20;  //4 disparos por segundo aprox.
    private boolean nuevo_disparo=false;

    /*explosiones*/

    private ArrayList<Explosion> lista_explosiones=new ArrayList<Explosion>();
    Bitmap explosion;

    /*Nave*/
    Bitmap nave;
    float xNave; //Coordenada X de la nave, variará con gestos de tipo fling
    float yNave; //Coordenada Y de la nave

    //coordenadas y del fondo actual y del siguiente
    int yImgActual,yImgSiguiente;

    /*índices del array de imagenes para alternar el fondo*/
    int img_actual=0,img_siguiente=1;


    /* sonidos */
    MediaPlayer mediaPlayer; //para reproducir la música de fondo

    public Juego(Activity context) {
        super(context);
        actividad=context;
        holder = getHolder();
        holder.addCallback(this);

        IniciarMusicaJuego();

        CalculaTamañoPantalla();

        /*Carga la nave*/
        nave = BitmapFactory.decodeResource(getResources(), R.drawable.nave);

        /*Carga la explosión*/
        explosion=BitmapFactory.decodeResource(getResources(), R.drawable.explosion);

        /*posición inicial de la Nave */
        xNave=AnchoPantalla/2-nave.getWidth()/2;
        yNave=AltoPantalla/5*4;
        VELOCIDAD_HORIZONTAL=AnchoPantalla*10/1080; //VELOCIDAD_HORIZONTAL adaptada
        /* Inicialización de coordenadas de fondo (Se ejecuta primero actualizar()*/
        yImgActual=-1;
        yImgSiguiente=-AltoPantalla-1;
        CargaBackground();
        CargaControles();
        CargaEnemigos();
        //carga disparo
        disparo = BitmapFactory.decodeResource(getResources(), R.drawable.shot);
        //listener para onTouch
        setOnTouchListener(this);

    }
    private void IniciarMusicaJuego(){
        mediaPlayer = MediaPlayer.create(actividad, R.raw.juego);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
        mediaPlayer.start();


    }
    public void CargaEnemigos(){
        frames_para_nuevo_enemigo=bucle.MAX_FPS*60/enemigos_minuto;
        hamburguesa = BitmapFactory.decodeResource(getResources(), burger);
        patatas = BitmapFactory.decodeResource(getResources(), chips);
    }

    public void CargaControles(){
        float aux;

        //flecha_izda
        controles[IZQUIERDA]=new Control(getContext(),0,AltoPantalla/5*4+nave.getHeight());
        controles[IZQUIERDA].Cargar( R.drawable.flcha_izq);
        controles[IZQUIERDA].nombre="IZQUIERDA";
        //flecha_derecha
        controles[DERECHA]=new Control(getContext(),
                    controles[0].Ancho()+controles[0].coordenada_x+5,controles[0].coordenada_y);
        controles[DERECHA].Cargar(R.drawable.flcha_der);
        controles[DERECHA].nombre="DERECHA";

        //disparo
        aux=5.0f/7.0f*AnchoPantalla; //en los 5/7 del ancho
        controles[DISPARO]=new Control(getContext(),aux,controles[0].coordenada_y);
        controles[DISPARO].Cargar(R.drawable.boton_disparo);
        controles[DISPARO].nombre="DISPARO";
    }

    public void CargaBackground(){
        //cargamos todos los fondos en un array
        for(int i=0;i<MAX_IMAGENES_FONDO;i++) {
            fondo = BitmapFactory.decodeResource(getResources(), recursos_imagenes[i]);
            if(imagenes[i]==null)
                imagenes[i] = fondo.createScaledBitmap(fondo, AnchoPantalla, AltoPantalla, true);
            fondo.recycle();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int forma, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // se crea la superficie, creamos el game loop

        // Para interceptar los eventos de la SurfaceView
        getHolder().addCallback(this);

        // creamos el game loop
        bucle = new BucleJuego(getHolder(), this);

        // Hacer la Vista focusable para que pueda capturar eventos
        setFocusable(true);

        //comenzar el bucle
        bucle.start();
    }

    public void CalculaTamañoPantalla(){
        if(Build.VERSION.SDK_INT > 13) {
            Display display = actividad.getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            AnchoPantalla = size.x;
            AltoPantalla = size.y;
        }
        else{
            Display display = actividad.getWindowManager().getDefaultDisplay();
            AnchoPantalla = display.getWidth();  // deprecated
            AltoPantalla = display.getHeight();  // deprecated
        }
        Log.i(Juego.class.getSimpleName(), "alto:" + AltoPantalla + "," + "ancho:" + AnchoPantalla);
    }

    /**
     * Este método actualiza el estado del juego. Contiene la lógica del videojuego
     * generando los nuevos estados y dejando listo el sistema para un repintado.
     */
    public void actualizar() {

        actualiza_fondo();

        /* Controles */
        if(!derrota) {
            if (controles[IZQUIERDA].pulsado) {
                if (xNave > 0)
                    xNave = xNave - VELOCIDAD_HORIZONTAL;
            }

            if (controles[DERECHA].pulsado) {
                if (xNave < AnchoPantalla - nave.getWidth())
                    xNave = xNave + VELOCIDAD_HORIZONTAL;
            }

            /* Disparo */
            if (controles[DISPARO].pulsado)
                nuevo_disparo = true;

            if (frames_para_nuevo_disparo == 0) {
                if (nuevo_disparo) {
                    CreaDisparo();
                    nuevo_disparo = false;
                }
                //nuevo ciclo de disparos
                frames_para_nuevo_disparo = MAX_FRAMES_ENTRE_DISPARO;
            }
            frames_para_nuevo_disparo--;
        }

        //Los disparos se mueven
        for(Iterator<Disparo> it_disparos=lista_disparos.iterator();it_disparos.hasNext();) {
            Disparo d=it_disparos.next();
            d.ActualizaCoordenadas();

            if(d.FueraDePantalla()) {
                it_disparos.remove();
            }

        }

        /*Enemigos*/
        if(frames_para_nuevo_enemigo==0){
            CrearNuevoEnemigo();
            //nuevo ciclo de enemigos
            frames_para_nuevo_enemigo=bucle.MAX_FPS*60/enemigos_minuto;
        }
        frames_para_nuevo_enemigo--;

        //Los enemigos persiguen al jugador
        for(Enemigo e: lista_enemigos){
            e.ActualizaCoordenadas();
        }

        //colisiones
        for(Iterator<Enemigo> it_enemigos= lista_enemigos.iterator();it_enemigos.hasNext();) {
            Enemigo e = it_enemigos.next();
            for(Iterator<Disparo> it_disparos=lista_disparos.iterator();it_disparos.hasNext();) {
                Disparo d=it_disparos.next();
                if (Colision(e, d)) {
                    /* Creamos un nuevo objeto explosión */
                    lista_explosiones.add(new Explosion(this,e.coordenada_x, e.coordenada_y));
                    /* eliminamos de las listas tanto el disparo como el enemigo */
                    try {
                        it_enemigos.remove();
                        it_disparos.remove();
                    }
                    catch(Exception ex){}
                    enemigos_muertos++; //un enemigo menos para el final

                    /*Puntos*/
                    if(e.tipo_enemigo==e.CHIPS)
                        Puntos+=50;
                    else
                        Puntos+=10;
                }
            }
        }

        //actualizar explosiones
        for(Iterator<Explosion> it_explosiones=lista_explosiones.iterator();it_explosiones.hasNext();){
            Explosion exp=it_explosiones.next();
            exp.ActualizarEstado();
            if(exp.HaTerminado()) it_explosiones.remove();
        }

        //cada PUNTOS_CAMBIO_NIVEL puntos se incrementa la dificultad
        if(Nivel!=Puntos/PUNTOS_CAMBIO_NIVEL) {
            Nivel = Puntos / PUNTOS_CAMBIO_NIVEL;
            enemigos_minuto += (20 * Nivel);
        }

        if(!derrota && !victoria)
            CompruebaFinJuego();

    }

    public void CompruebaFinJuego(){

        for(Enemigo e:lista_enemigos){
            if(ColisionNave(e)){
                lista_explosiones.add(new Explosion(this,e.coordenada_x, e.coordenada_y));
                derrota=true;
            }
        }

        if(!derrota)
            if(enemigos_muertos==TOTAL_ENEMIGOS)
                victoria=true;

    }

    public boolean ColisionNave(Enemigo e){
        int alto_mayor=e.Alto()>nave.getHeight()?e.Alto():nave.getHeight();
        int ancho_mayor=e.Ancho()>nave.getWidth()?e.Ancho():nave.getWidth();
        float diferenciaX=Math.abs(e.coordenada_x-xNave);
        float diferenciaY=Math.abs(e.coordenada_y-yNave);
        return diferenciaX<ancho_mayor &&diferenciaY<alto_mayor;
    }

    public boolean Colision(Enemigo e, Disparo d){
        int alto_mayor=e.Alto()>d.Alto()?e.Alto():d.Alto();
        int ancho_mayor=e.Ancho()>d.Ancho()?e.Ancho():d.Ancho();
        float diferenciaX=Math.abs(e.coordenada_x-d.coordenada_x);
        float diferenciaY=Math.abs(e.coordenada_y-d.coordenada_y);
        return diferenciaX<ancho_mayor &&diferenciaY<alto_mayor;
    }

    /**
     * Este método dibuja el siguiente paso de la animación correspondiente
     */
    public void renderizar(Canvas canvas) {
        if(canvas!=null) {
            //pinceles
            Paint myPaint = new Paint();
            myPaint.setStyle(Paint.Style.STROKE);
            myPaint.setColor(Color.WHITE);

            Paint myPaint2 = new Paint();
            myPaint2.setStyle(Paint.Style.FILL);
            myPaint2.setTextSize(50);

            //dibujamos el fondo
            canvas.drawBitmap(imagenes[img_actual],0,yImgActual,null);
            canvas.drawBitmap(imagenes[img_siguiente],0,yImgSiguiente,null);

            //Si ha ocurrido un toque en la pantalla "Touch", dibujar un círculo

            if(!derrota)
                //dibuja la nave (posición fija a 4/5 de alto y la mitad de ancho)
                canvas.drawBitmap(nave,xNave,yNave,null);

            //dibuja los enemigos
            for(Enemigo e: lista_enemigos){
                e.Dibujar(canvas,myPaint);
            }

            //dibuja los disparos
            for(Disparo d:lista_disparos){
                d.Dibujar(canvas,myPaint);
            }

            //dibuja las explosiones
            for(Explosion exp: lista_explosiones)
                exp.Dibujar(canvas,myPaint);

            //dibuja los controles
            myPaint.setAlpha(200);
            for(int i=0;i<3;i++){
                controles[i].Dibujar(canvas,myPaint);
            }

            //escribe los puntos
            myPaint.setTextSize(AnchoPantalla/25); //25 es el número de letras aprox que sale en una línea
            canvas.drawText("PUNTOS " + Puntos + " - Nivel " + Nivel, 50, 50, myPaint);
            canvas.drawText("Enemigos por matar "+(TOTAL_ENEMIGOS-enemigos_muertos), 50, 100, myPaint);

            if(victoria){
                myPaint.setAlpha(0);
                myPaint.setColor(Color.RED);
                myPaint.setTextSize(AnchoPantalla/10);
                canvas.drawText("VICTORIA!!", 50, AltoPantalla/2-100, myPaint);
                myPaint.setTextSize(AnchoPantalla/20);
                canvas.drawText("Las tropas enemigas han sido derrotadas", 50, AltoPantalla/2+100, myPaint);
            }

            if(derrota) {
                myPaint.setAlpha(0);
                myPaint.setColor(Color.RED);
                myPaint.setTextSize(AnchoPantalla/10);
                canvas.drawText("DERROTA!!", 50, AltoPantalla/2-100, myPaint);
                myPaint.setTextSize(AnchoPantalla/20);
                canvas.drawText("La raza humana está condenada!!!!", 50, AltoPantalla/2+100, myPaint);            }

        }
    }

    public void CreaDisparo(){
        lista_disparos.add(new Disparo(this,xNave,yNave));
    }

    public void CrearNuevoEnemigo(){
        if(TOTAL_ENEMIGOS-enemigos_creados>0) {
            lista_enemigos.add(new Enemigo(this, Nivel));
            enemigos_creados++;
        }
    }

    public void actualiza_fondo(){
        //nueva posición del fondo
        yImgActual++;
        yImgSiguiente++;

        /*Si la imagen de fondo actual ya ha bajado completamente*/
        if(yImgActual>AltoPantalla){

            //Se actualiza la imagen actual a la siguiente del array de imagenes
            if(img_actual==MAX_IMAGENES_FONDO-1)
                img_actual=0;
            else
                img_actual++;

            //Se actualiza la imagen siguiente
            if(img_siguiente==MAX_IMAGENES_FONDO-1)
                img_siguiente=0;
            else
                img_siguiente++;

            //Nuevas coordenadas
            yImgActual=0;
            yImgSiguiente=-AltoPantalla;
        }
    }


    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        // cerrar el thread y esperar que acabe
        boolean retry = true;
        while (retry) {
            try {
                fin();
                bucle.join();
                retry = false;
            } catch (InterruptedException e) {

            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int index;
        int x,y;

        // Obtener el pointer asociado con la acción
        index = MotionEventCompat.getActionIndex(event);

        x = (int) MotionEventCompat.getX(event, index);
        y = (int) MotionEventCompat.getY(event, index);

        switch(event.getActionMasked()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                hayToque=true;

                synchronized(this) {
                    toques.add(index, new Toque(index, x, y));
                }

                //se comprueba si se ha pulsado
                for(int i=0;i<3;i++)
                    controles[i].comprueba_pulsado(x,y);
                break;

            case MotionEvent.ACTION_POINTER_UP:
                synchronized(this) {
                    toques.remove(index);
                }

                //se comprueba si se ha soltado el botón
                for(int i=0;i<3;i++)
                    controles[i].comprueba_soltado(toques);
                break;

            case MotionEvent.ACTION_UP:
                synchronized(this) {
                    toques.clear();
                }
                hayToque=false;
                //se comprueba si se ha soltado el botón
                for(int i=0;i<3;i++)
                    controles[i].comprueba_soltado(toques);
                break;
        }

        return true;
    }

   public void fin(){
        bucle.fin();
        mediaPlayer.release();
        for(int i=0;i<MAX_IMAGENES_FONDO;i++)
            imagenes[i].recycle();
        nave.recycle();
        hamburguesa.recycle();
        patatas.recycle();
        disparo.recycle();
    }
}
