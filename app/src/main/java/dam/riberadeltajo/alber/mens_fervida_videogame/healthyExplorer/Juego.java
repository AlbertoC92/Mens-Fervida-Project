package dam.riberadeltajo.alber.mens_fervida_videogame.healthyExplorer;

import android.app.Activity;
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

/**
 * Created by Alberto Garcia Castro AKA (Albert_Style)on 18/02/2017.
 */

public class Juego extends SurfaceView implements SurfaceHolder.Callback, SurfaceView.OnTouchListener {
    //COMPONENTES JUEGO
    private SurfaceHolder holder;
    public BucleJuego bucle;
    private Activity actividad;

    //DIMENSIONES PANTALLA
    public int AltoPantalla;
    public int AnchoPantalla;

    //BOLAS
    private Bitmap bolaG;
    private Bitmap bolaE;
    private Bitmap ensalada;
    private ArrayList<Bola> numBolas;
    private ArrayList<Bola> numBolasDivididas;
    private int enemigos_minuto = 6;
    private int frames_para_nuevo_enemigo = 0;
    private int bolas_nivel = 4;
    private int bolas_creadas = 0;
    private int bolas_destruidas = 0;
    private int bolas_divididas = 0;
    private int bolas_divididasDestruidas = 0;


    //FONDO
    private Bitmap fondoPantalla;
    private int[] fotos = {R.drawable.hamburguesa2, R.drawable.pizza, R.drawable.cocacola};
    private int[] fondos = {R.drawable.spain, R.drawable.polonia, R.drawable.alemania, R.drawable.francia};
    private static final String TAG = Juego.class.getSimpleName();

    //CONTROL DE EL TOUCHPAD
    private ArrayList<Pulsacion> toques = new ArrayList<Pulsacion>();
    boolean hayToque = false;


    //CONTROLES
    private final int IZQUIERDA = 0;
    private final int DERECHA = 1;
    private final int DISPARO = 2;
    private final int VELOCIDAD_HORIZONTAL; //pixels por frame
    Control controles[] = new Control[3];
    private Bitmap suelo;


    //PUNTOS
    private int Puntos = 0;
    private int nivel = 0;
    private int nivelAnterior = 0;


    //VARIABLES FIN JUEGO
    private boolean victoria, derrota, finalizarNivel;


    //DISPAROS
    private ArrayList<Disparo> lista_disparos = new ArrayList<Disparo>();
    Bitmap disparo;
    private int frames_para_nuevo_disparo = 0;
    private final int MAX_FRAMES_ENTRE_DISPARO = 15;
    private boolean nuevo_disparo = false;

    //EXPLOSION
    private ArrayList<Explosion> explosiones;
    private Bitmap explosion;


    //PROTAGONISTA
    private Protagonista prota;
    private Bitmap protagonista;
    private Bitmap protagonista2;
    private int xProtagonista;
    private int yProtagonista;
    //public final int[] DIRECCION={1,2,3};
    // public final int BMP_COLUMNS=4;
    //public final int BMP_ROWS=3;
    //public int protaWidth,protaHeight;
    // public int currentFrame=0;
    //public Rect src,dst;


    //SONIDO
    MediaPlayer mediaPlayer;

    //CONSTRUCTOR DE LA CLASE JUEGO
    public Juego(Activity context) {
        super(context);
        //INICIALIZO COMPONENTES DE LA CLASE Y VARIABLES DE USO
        actividad = context;
        holder = getHolder();
        holder.addCallback(this);
        derrota = false;
        victoria = false;
        finalizarNivel = false;
        //CARGO EL TAMAÑO DE PANTALLA Y INICIO LA MUSICA DEL JUEGO
        IniciarMusicaJuego();

        CalculaTamañoPantalla();

        //INICIALIZO FONDO DE PANTALLA
        iniciarFondo();


        //CREO AL PROTAGONISTA
        protagonista = BitmapFactory.decodeResource(getResources(), R.drawable.protagonista1);
        xProtagonista = AnchoPantalla / 2 - protagonista.getWidth() / 2;
        yProtagonista = AltoPantalla / 5 * 4;
        VELOCIDAD_HORIZONTAL = AnchoPantalla * 10 / 1080; //VELOCIDAD_HORIZONTAL adaptada

        prota = new Protagonista(this, protagonista, xProtagonista, yProtagonista, VELOCIDAD_HORIZONTAL);
        //INICIALIZO LOS ARRAY DE BOLAS
        numBolas = new ArrayList<Bola>();
        numBolasDivididas = new ArrayList<Bola>();
        //CARGO LOS CONTROLES Y LAS BOLAS EN SUS RESPECTIVOS ARRAY
        CargaControles();
        inicializarBolas();
        //CREO LOS DISPAROS
        disparo = BitmapFactory.decodeResource(getResources(), R.drawable.shoot);
        suelo = BitmapFactory.decodeResource(getResources(), R.drawable.suelo);

        //INICIALIZAR EXPLOSION
        explosiones = new ArrayList<Explosion>();
        explosion = BitmapFactory.decodeResource(getResources(), R.drawable.explosionbola);
        setOnTouchListener(this);

    }

    //METODO QUE INICIALIZA EL FONDO DE PANTALLA QUE POR DEFECTO SERA EL DEL NIVEL 1
    private void iniciarFondo() {
        fondoPantalla = BitmapFactory.decodeResource(getResources(), fondos[0]);
    }

    public void cambiarFondo(int nivel) {
        fondoPantalla = BitmapFactory.decodeResource(getResources(), fondos[nivel]);
    }

    //METODO QUE INICIALIZA LA MUSICA DEL JUEGO
    private void IniciarMusicaJuego() {
        mediaPlayer = MediaPlayer.create(actividad, R.raw.sonidojuego);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
        mediaPlayer.start();


    }

    //METODO QUE INICIALIZA LAS BOLAS
    public void inicializarBolas() {
        frames_para_nuevo_enemigo = bucle.MAX_FPS * 20 / enemigos_minuto;
        bolaG = BitmapFactory.decodeResource(getResources(), fotos[((int) (Math.random() * 3))]);
        bolaE = BitmapFactory.decodeResource(getResources(), fotos[(int) (Math.random() * 3)]);
    }

    //METODO QUE CREA LAS BOLAS QUE SE VAN A REPRODUCIR EN CADA NIVEL
    //Y LAS INSERTA EN SU ARRAY PARA SER PINTADAS
    private void crearBolas() {
        int tipoEnemigo = (int) (Math.random() * 2);
        if (bolas_creadas != bolas_nivel) {
            if (tipoEnemigo == 0) {
                numBolas.add(new Bola(this, bolaG, 0, 20));
                bolas_creadas++;
                bolas_divididas++;

            } else if (tipoEnemigo == 1) {
                numBolas.add(new Bola(this, bolaE, 1, 10));
                bolas_creadas++;

            }
        }
    }

    //METODOS GET Y SET DE VARIABLES NECESARIAS PARA EL USO Y LA EJECUCION DEL JUEGO
    public Bitmap getBolaG() {
        return bolaG;
    }

    public void setBolaG(Bitmap bolaG) {
        this.bolaG = bolaG;
    }

    public Bitmap getBolaE() {
        return bolaE;
    }

    public void setBolaE(Bitmap bolaE) {
        this.bolaE = bolaE;
    }

    //METODO QUE CREA LOS CONTROLES Y LOS POSICIONA
    public void CargaControles() {
        float aux;

        //flecha_izda
        controles[IZQUIERDA] = new Control(getContext(), 0, AltoPantalla / 5 * 4 + protagonista.getHeight());
        controles[IZQUIERDA].Cargar(R.drawable.btn_izquierda);
        controles[IZQUIERDA].nombre = "IZQUIERDA";
        //flecha_derecha
        controles[DERECHA] = new Control(getContext(),controles[0].Ancho() + controles[0].coordenada_x + 3, controles[0].coordenada_y);
        controles[DERECHA].Cargar(R.drawable.btn_derecha);
        controles[DERECHA].nombre = "DERECHA";

        //disparo
        aux = 5.0f / 7.0f * AnchoPantalla; //en los 5/7 del ancho
        controles[DISPARO] = new Control(getContext(), aux, controles[0].coordenada_y);
        controles[DISPARO].Cargar(R.drawable.disparar);
        controles[DISPARO].nombre = "DISPARO";
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

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

    //METODO QUE CALCULA EL TAMAÑO DE LA PANTALLA

    public void CalculaTamañoPantalla() {
        if (Build.VERSION.SDK_INT > 15) {
            Display display = actividad.getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            AnchoPantalla = size.x;
            AltoPantalla = size.y;
        } else {
            Display display = actividad.getWindowManager().getDefaultDisplay();
            AnchoPantalla = display.getWidth();  // deprecated
            AltoPantalla = display.getHeight();  // deprecated
        }
        Log.i(Juego.class.getSimpleName(), "alto:" + AltoPantalla + "," + "ancho:" + AnchoPantalla);
    }

    public void cambiarNivel() {
        if (bolas_destruidas == bolas_nivel && bolas_divididasDestruidas == bolas_divididas) {
            nivel++;
            bolas_nivel = bolas_nivel + 2;
            bolas_creadas = 0;
            bolas_destruidas = 0;
            bolas_divididas = 0;
            bolas_divididasDestruidas = 0;


        }

    }

    /**
     * Este método actualiza el estado del juego. Contiene la lógica del videojuego
     * generando los nuevos estados y dejando listo el sistema para un repintado.
     */
    public void actualizar() {
        //INICIO EL FONDO SEGUN EL NIVEL EN EL QUE ESTA EL JUEGO

        if (!derrota) {
            //ACTUALIZO LOS CONTROLES PARA CONTROLAR SI ESTA PULSADO O NO LO ESTA
            if (!finalizarNivel) {
                if (controles[IZQUIERDA].pulsado) {
                    if (xProtagonista > 0)
                        xProtagonista = xProtagonista - VELOCIDAD_HORIZONTAL;
                    prota.actualizarFrame();
                    prota.getDireccionPersonaje(0);

                }

                if (controles[DERECHA].pulsado) {
                    if (xProtagonista < AnchoPantalla - protagonista.getWidth()) {
                        xProtagonista = xProtagonista + VELOCIDAD_HORIZONTAL;
                        prota.actualizarFrame();
                        prota.getDireccionPersonaje(1);

                    }
                }
                if (!controles[IZQUIERDA].pulsado && !controles[DERECHA].pulsado) {
                    prota.actualizarFrame();
                    prota.getDireccionPersonaje(2);
                }


                //CICLOS DE REPETICION DE LOS DISPAROS
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
                //MOVIMIENTOS DE LOS DISPAROS
                for (Iterator<Disparo> it_disparos = lista_disparos.iterator(); it_disparos.hasNext(); ) {
                    Disparo d = it_disparos.next();
                    d.ActualizaCoordenadas();

                    if (d.FueraDePantalla()) {
                        it_disparos.remove();
                    }

                }

                //CREACION DE LOS ENEMIGOS SEGUN LA CANTIDAD DE ESTOS EN PANTALLA Y DEL MAXIMO PERMITIDO
                //if (frames_para_nuevo_enemigo == 0) {
                    crearBolas();
                    //nuevo ciclo de enemigos
                   // frames_para_nuevo_enemigo = bucle.MAX_FPS * 10 / enemigos_minuto;
                //}
                //frames_para_nuevo_enemigo--;


                //COMPRUEBO LAS COLISIONES CON LAS BOLAS Y CON EL JUGADOR
                compruebaFinJuego();
                comprobarColisionesBola();
                comprobarColisonesBolasDivididas();
                cambiarNivel();
                comprobarFinalNivel();

            }else{
                cambiarFondo(nivel);
                finalizarNivel = false;



            }


        }
    }

    public boolean comprobarFinalNivel() {
        if (nivelAnterior == nivel) {

            return finalizarNivel =false;
        } else{

            return finalizarNivel=true;
        }
    }

    //METODO QUE CONPRUEBA SI E LOGRADO GANAR O NO
    public void compruebaFinJuego() {

        for (Bola b : numBolas) {
            if (colisionProtagonista(b)) {
                //finalizarNivel=true;
                derrota = true;

            }
        }
        if (!derrota)
            //COMPRUEBA SI EL NIVEL ALCANZADO ES MAYOR QUE EL 4 Y QUE LAS BOLAS DESTRUIDAS SEAN LAS TOTALES
            if (nivel > 3)
                if (bolas_destruidas == bolas_nivel && bolas_divididasDestruidas == bolas_divididas)
                    //finalizarNivel=true;
                    victoria = true;

    }

    //COMPROBACION DE COLISIONES TANTO CON EL PROTAGONISTA COMO CON LOS DISPAROS
    public boolean colisionProtagonista(Bola b) {
        int alto_mayor = b.getHeight() > protagonista.getHeight() ? b.getHeight() : protagonista.getHeight();
        int ancho_mayor = b.getWidth() > protagonista.getWidth() ? b.getWidth() : protagonista.getWidth();
        float diferenciaX = Math.abs(b.getCorx() - xProtagonista);
        float diferenciaY = Math.abs(b.getCory() - yProtagonista);
        return diferenciaX < ancho_mayor && diferenciaY < alto_mayor;

    }

    public boolean colisionBola(Bola b, Disparo d) {
        int alto_mayor = b.getHeight() > d.Alto() ? b.getHeight() : d.Alto();
        int ancho_mayor = b.getWidth() > d.Ancho() ? b.getWidth() : d.Ancho();
        float diferenciaX = Math.abs(b.getCorx() - d.coordenada_x);
        float diferenciaY = Math.abs(b.getCory() - d.coordenada_y);
        return diferenciaX < ancho_mayor && diferenciaY < alto_mayor;
    }

    //METODO A EJECUTAR EN ACTUALIZAR QUE COMPRUEBA LA COLISION ENTRE LA BOLA Y EL DISPARO
    public void comprobarColisionesBola() {
        Iterator<Bola> iterator_bolas = numBolas.iterator();
        while (iterator_bolas.hasNext()) {
            Bola b = iterator_bolas.next();
            Iterator<Disparo> iterator_disparos = lista_disparos.iterator();
            while (iterator_disparos.hasNext()) {
                Disparo d = iterator_disparos.next();
                if (colisionBola(b, d)) {
                    //SI LA COLISION SE DA, COMPRUEBO SI EL TIPO DE BOLA ES GRANDE O SMALL
                    //EN EL PRIMER CASO, ELIMINO LA BOLA GRANDE Y EN SU LUGAR CREO UNA SMALL
                    try {
                        if (b.getTipoBola() == 1) {

                            iterator_bolas.remove();
                            iterator_disparos.remove();
                            Puntos += b.getPuntos();
                            explosion();
                            explosiones.add(new Explosion(explosiones, this, b.getCorx(), b.getCory(), explosion));
                            bolas_destruidas++;
                        } else if (b.getTipoBola() == 0) {
                            numBolasDivididas.add(pincharIzzquierda(b));
                            iterator_bolas.remove();
                            iterator_disparos.remove();
                            Puntos += b.getPuntos();
                            explosion();
                            explosiones.add(new Explosion(explosiones, this, b.getCorx(), b.getCory(), explosion));
                            bolas_destruidas++;


                            break;
                        }
                    } catch (Exception es) {
                    }
                }
            }
        }
    }

    //ESTE METODO SE ENCARGA DE COMPROBAR LAS COLISIONES CON LAS BOLAS CREADAS AL ROMPER UNA BOLA GRANDE
    public void comprobarColisonesBolasDivididas() {
        Iterator<Bola> iterator_bolas = numBolasDivididas.iterator();
        while (iterator_bolas.hasNext()) {
            Bola b = iterator_bolas.next();
            Iterator<Disparo> iterator_disparos = lista_disparos.iterator();
            while (iterator_disparos.hasNext()) {
                Disparo d = iterator_disparos.next();
                if (colisionBola(b, d)) {
                    try {
                        iterator_bolas.remove();
                        iterator_disparos.remove();
                        Puntos += b.getPuntos();
                        explosion();
                        explosiones.add(new Explosion(explosiones, this, b.getCorx(), b.getCory(), explosion));
                        bolas_divididasDestruidas++;

                    } catch (Exception es) {
                    }
                }
            }
        }
    }

    //METODO QUE SE EJECUTA AL DESTRUIR UNA BOLA GRANDE QUE CREA UNA NUEVA BOLA SMALL CON LA DIRECCION CAMBIADA PARA
    //ACENTUAR SU MOVIMIENTO DE GENERACION
    public Bola pincharIzzquierda(Bola bola) {
        bola.setWidth(bolaE.getWidth() / 4);
        bola.setHeight(bolaE.getHeight() / 4);
        bola.setPuntos(10);
        bola.setCorx(bola.getCorx() + bola.getxSpeed() * 2);
        bola.setCory(bola.getCory() + 2);
        bola.setxSpeed(bola.getxSpeed() + bola.getxSpeed());
        bola.setCorx(bola.getCorx() + bola.getxSpeed());
        return bola;
    }


    /**
     * Este método dibuja el siguiente paso de la animación correspondiente
     */

    //METODO QUE PINTA A CADA FRAME
    public void renderizar(Canvas canvas) {
        if (canvas != null) {
            //pinceles
            Paint myPaint = new Paint();
            myPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            myPaint.setColor(Color.BLACK);

            Paint myPaint2 = new Paint();
            myPaint2.setStyle(Paint.Style.FILL);
            myPaint2.setTextSize(50);


            canvas.drawBitmap(Bitmap.createScaledBitmap(fondoPantalla, getWidth(), getHeight(), false), 0, 0, null);
            //DIBUJAR SUELO
            //canvas.drawBitmap(suelo, getWidth(), (getHeight() ), null);

            //SI NO SE HA DADO UNA DERROTA, ENTONCES PINTAR TODOS LOS COMPONENTES DEL JUEGO
            if (!derrota)
                //DIBUJAR PROTAGONISTA
                //prota.draw(canvas,myPaint);
                canvas.drawBitmap(protagonista, xProtagonista, yProtagonista, null);

            //dibuja los enemigos

            for (Bola b : numBolas) {
                b.draw(canvas, myPaint);
            }
            //GENERAR LA EXPLOSION TRAS LA DESTRUCCION DE LA BOLA
            for (int i = explosiones.size() - 1; i >= 0; i--)
                explosiones.get(i).draw(canvas);
            //SI EL ARRAY DE BOLAS GENERADAS TRAS ROMPER UNA BOLA GRANDE NO ESTA VACIO
            //ENTONCES PINTAR LAS BOLAS NUEVAS
            if (!numBolasDivididas.isEmpty()) {
                for (Bola bola : numBolasDivididas)
                    bola.draw(canvas, myPaint);
            }


            //DIBUJAR DISPAROS
            for (Disparo d : lista_disparos) {
                d.Dibujar(canvas, myPaint);
            }

            //DIBUJAR LOS CONTROLES
            myPaint.setAlpha(200);//MODIFICA LA TRANSPARENCIA DE LOS CONTROLES
            for (int i = 0; i < 3; i++) {
                controles[i].Dibujar(canvas, myPaint);
            }

            //ESCRIBO LOS PUNTOS
            myPaint.setTextSize(AnchoPantalla / 15); //25 es el número de letras aprox que sale en una línea
            //canvas.drawText(String.format("%02d", Puntos), (float) (getWidth() * 0.85), (float) (getHeight() * 0.09), myPaint);
            canvas.drawText("PUNTOS:" + Puntos + " - Nivel: " + nivel, 50, 50, myPaint);



            if (victoria) {
                myPaint.setAlpha(0);
                myPaint.setColor(Color.BLACK);
                myPaint.setTextSize(AnchoPantalla / 10);
                canvas.drawText("VICTORY!!", 50, AltoPantalla / 2 - 100, myPaint);
                myPaint.setTextSize(AnchoPantalla / 20);
                canvas.drawText("FAST FOOD WILL NEVER COME BACK", 50, AltoPantalla / 2 + 100, myPaint);
                ((MenuJuego)getContext()).finalizar(Puntos);
            }

            if (derrota) {
                myPaint.setAlpha(0);
                myPaint.setColor(Color.BLACK);
                myPaint.setTextSize(AnchoPantalla / 10);
                canvas.drawText("YOU LOSE!!", 50, AltoPantalla / 2 - 100, myPaint);
                myPaint.setTextSize(AnchoPantalla / 20);
                canvas.drawText("THE HUMANS ARE WASTED!!!!", 50, AltoPantalla / 2 + 100, myPaint);
                ((MenuJuego)getContext()).finalizar(Puntos);
            }

        }
    }

    //METODO QUE INICIA LOS DISPAROS
    public void CreaDisparo() {
        lista_disparos.add(new Disparo(this, xProtagonista, yProtagonista));
    }

    //METODO QUE MUESTRA UN TEXTO TRAS FINALZIAR NIVEL
    public void finalizarNivel(Canvas canvas, Paint myPaint) {
        myPaint.setAlpha(0);
        myPaint.setColor(Color.RED);
        myPaint.setTextSize(AnchoPantalla / 10);
        canvas.drawText("LEVEL COMPLETE!!", 50, AltoPantalla / 2 - 100, myPaint);
        myPaint.setTextSize(AnchoPantalla / 20);
        canvas.drawText("YOU GOT CLEAR THE ZONE OUT OF FAST FOOD", 500, AltoPantalla / 2 + 100, myPaint);
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



    //METODO ONTOUCH SOBREESCRITO QUE COMPRUEBA LA PRESION DE LOS BOTONES
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int index;
        int x, y;

        // Obtener el pointer asociado con la acción
        index = MotionEventCompat.getActionIndex(event);

        x = (int) MotionEventCompat.getX(event, index);
        y = (int) MotionEventCompat.getY(event, index);

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                hayToque = true;

                synchronized (this) {
                    toques.add(index, new Pulsacion(index, x, y));
                }

                //se comprueba si se ha pulsado
                for (int i = 0; i < 3; i++)
                    controles[i].comprueba_pulsado(x, y);
                break;

            case MotionEvent.ACTION_POINTER_UP:
                synchronized (this) {
                    toques.remove(index);
                }

                //se comprueba si se ha soltado el botón
                for (int i = 0; i < 3; i++)
                    controles[i].comprueba_soltado(toques);
                break;

            case MotionEvent.ACTION_UP:
                synchronized (this) {
                    toques.clear();
                }
                hayToque = false;
                //se comprueba si se ha soltado el botón
                for (int i = 0; i < 3; i++)
                    controles[i].comprueba_soltado(toques);
                break;
        }

        return true;
    }

    //METODO QUE INICIALIZA LAS EXPLOSIONES
    private void explosion() {
        new EfectoExplosion(getContext(), R.raw.jump).start();
    }

    //METODO QUE TERMINA EL JUEGO
    public void fin() {
        bucle.fin();
        mediaPlayer.release();
        fondoPantalla.recycle();
        protagonista.recycle();
        bolaG.recycle();
        bolaE.recycle();
        disparo.recycle();
        actividad.finish();
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean isFinalizarNivel() {
        return finalizarNivel;
    }

    public void setFinalizarNivel(boolean finalizarNivel) {
        this.finalizarNivel = finalizarNivel;
    }

    public Protagonista getProta() {
        return prota;
    }

    public void setProta(Protagonista prota) {
        this.prota = prota;
    }
}
