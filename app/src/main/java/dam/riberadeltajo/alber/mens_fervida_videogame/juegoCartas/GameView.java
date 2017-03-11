package dam.riberadeltajo.alber.mens_fervida_videogame.juegoCartas;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.example.alber.mens_fervida_videogame.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class GameView extends SurfaceView implements View.OnTouchListener{
    private static final int MAX_FALLOS = 10; // Número máximo de fallos (cada selección de 2 cartas)
    private static int[] imagenes = {R.drawable.alb, R.drawable.cereza,
            R.drawable.fresa, R.drawable.kiwi, R.drawable.limon, R.drawable.manzana, R.drawable.melon,
            R.drawable.naranja, R.drawable.pina, R.drawable.platano, R.drawable.sandia, R.drawable.uvas};
    private Carta[] cartasEnJuego; // Array con las 12 cartas que se pintan
    private SurfaceHolder holder;
    private Canvas canv;
    private int maxX, maxY;
    private int[][] baraja;
    private int contadorCartaDescubierta = 0; // Contador para saber si ya se ha mostrado 1 carta
    private int contadorCartasYaAdivinadas = 0; // Contador de cuantas cartas se han acertado
    private Carta cartaDescubierta = null; // Auxiliar para comparar las cartas y sumar/restar puntos
    private Carta[] cartasYaAdivinadas = new Carta[12]; // Array auxiliar para almacenar las cartas ya  adivinadas
    private int fallos = 0; // Contador con los fallos del usuario
    private Main2Activity actividad;
    private int puntuacion = 0; // Puntuacion del usuario. +5 Acierto, -2 fallo.

    public GameView(final Context context, int maxX, int maxY) {
        super(context);
        holder = getHolder();
        this.maxX = maxX;
        this.maxY = maxY;
        actividad = (Main2Activity)context;
        baraja = new int[4][3];
        sacar6Imagenes();
        cartasEnJuego = new Carta[12];
        setCartasEnJuego();
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int corX = (int) motionEvent.getX();
                int corY = (int) motionEvent.getY();
                toque(motionEvent, corX, corY, context);
                return true;
            }
        });
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Canvas c = holder.lockCanvas(null);
                draw(c);
                holder.unlockCanvasAndPost(c);
            }
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format,
                                       int width, int height) {
            }
        });
    }

    /*
    En este método se va pintando a Sparky y las frutas según se van acertando.
    También se van haciendo la comprobaciones necesarias para terminar el juego
     */
    private void rellenarSparkys(Carta carta) {
        canv = holder.lockCanvas();
        canv.drawColor(Color.WHITE);

        // Si no hay ninguna carta descubierta, entra en el if y se procede a descubrirla
        if(contadorCartaDescubierta == 0){
            // Se dibujan los Sparkys
            for(int i = 0; i < baraja.length; i++){
                for(int j = 0; j < baraja[i].length; j++){
                    canv.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sparky), (maxX/3) * j + 25, (maxY/5) * i + 25, null);
                }
            }

            // Se dibujan las cartas adivinadas
            for(int i = 0; i < cartasYaAdivinadas.length; i++){
                if(cartasYaAdivinadas[i] != null){
                    canv.drawBitmap(cartasYaAdivinadas[i].getBmp(), cartasYaAdivinadas[i].getLeft(), cartasYaAdivinadas[i].getTop(), null);
                }
            }

            // Se dibuja la carta seleccionada
            canv.drawBitmap(carta.getBmp(), carta.getLeft(), carta.getTop(), null);
            // Se muestran los fallos y la puntuación del jugador
            contarFallos();
            // Contador de que llevamos 1 carta descubierta
            contadorCartaDescubierta++;
            // Auxiliar para saber que carta es la descubierta
            cartaDescubierta = carta;
        }else { // Si ya hay una descubierta, se procede a descubrir otra y comparar
            // Se dibujan los Sparkys
            for (int i = 0; i < baraja.length; i++) {
                for (int j = 0; j < baraja[i].length; j++) {
                    canv.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sparky), (maxX / 3) * j + 25, (maxY / 5) * i + 25, null);
                }
            }
            // Se dibujan las cartas adivinadas
            for (int i = 0; i < cartasYaAdivinadas.length; i++) {
                if (cartasYaAdivinadas[i] != null) {
                    canv.drawBitmap(cartasYaAdivinadas[i].getBmp(), cartasYaAdivinadas[i].getLeft(), cartasYaAdivinadas[i].getTop(), null);
                }
            }
            // Se dibuja la carta descubierta antes
            canv.drawBitmap(cartaDescubierta.getBmp(), cartaDescubierta.getLeft(), cartaDescubierta.getTop(), null);
            // Se dibuja la carta seleccionada
            canv.drawBitmap(carta.getBmp(), carta.getLeft(), carta.getTop(), null);

            // Si coinciden se suman puntos y se agrega al array auxiliar de cartas adivinadas
            if (carta.getIndiceCarta() == cartaDescubierta.getIndiceCarta()) {
                cartasYaAdivinadas[contadorCartasYaAdivinadas] = carta;
                contadorCartasYaAdivinadas++;
                cartasYaAdivinadas[contadorCartasYaAdivinadas] = cartaDescubierta;
                contadorCartasYaAdivinadas++;
                puntuacion += 5;

                // Si ya se han descubierto todas las cartas, se termina el juego
                if (contadorCartasYaAdivinadas == 12) {
                    finalizar();

                    // ---------------<<<<<<<<<<<<<<<<<--------- FALTA PONER MAS TIEMPO Y DEVOLVER LOS PUNTOS
                }
            } else { // Si no coinciden, se restan puntos y suman fallos al usuario
                fallos++;
                if (puntuacion == 1) {
                    puntuacion = 0;
                } else if (puntuacion > 1) {
                    puntuacion -= 2;
                }

                // Si se ha llegado al máximo de fallos, se termina el juego
                if (fallos == MAX_FALLOS) {
                    finalizar();
                    // ---------------<<<<<<<<<<<<<<<<<--------- FALTA PONER MAS TIEMPO Y DEVOLVER LOS PUNTOS
                }

                // restar puntos y notificar
                //canv.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sparky), carta.getLeft(), carta.getTop(), null);
                //canv.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sparky), cartaDescubierta.getLeft(), cartaDescubierta.getTop(), null);
            }
            contarFallos();
            cartaDescubierta = null;
            // Se reinicia el contador.
            contadorCartaDescubierta = 0;
        }
        holder.unlockCanvasAndPost(canv);
    }

    // Método para controlar los eventos del usuario, dónde toca para descubrir la carta correspondiente
    private void toque(MotionEvent motionEvent, int corX, int corY, Context context) {
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            if(cartasEnJuego[0].getTop() <= corY && (cartasEnJuego[0].getTop() + cartasEnJuego[0].getAlto()) >= corY && (cartasEnJuego[0].getAncho() + cartasEnJuego[0].getLeft()) >= corX
                    && cartasEnJuego[0].getLeft() <= corX){
                rellenarSparkys(cartasEnJuego[0]);
            }
            if(cartasEnJuego[1].getTop() <= corY && (cartasEnJuego[1].getTop() + cartasEnJuego[1].getAlto()) >= corY && (cartasEnJuego[1].getAncho() + cartasEnJuego[1].getLeft()) >= corX
                    && cartasEnJuego[1].getLeft() <= corX){
                rellenarSparkys(cartasEnJuego[1]);
            }
            if(cartasEnJuego[2].getTop() <= corY && (cartasEnJuego[2].getTop() + cartasEnJuego[2].getAlto()) >= corY && (cartasEnJuego[2].getAncho() + cartasEnJuego[2].getLeft()) >= corX
                    && cartasEnJuego[2].getLeft() <= corX){
                rellenarSparkys(cartasEnJuego[2]);
            }
            if(cartasEnJuego[3].getTop() <= corY && (cartasEnJuego[3].getTop() + cartasEnJuego[3].getAlto()) >= corY && (cartasEnJuego[3].getAncho() + cartasEnJuego[3].getLeft()) >= corX
                    && cartasEnJuego[3].getLeft() <= corX){
                rellenarSparkys(cartasEnJuego[3]);
            }
            if(cartasEnJuego[4].getTop() <= corY && (cartasEnJuego[4].getTop() + cartasEnJuego[4].getAlto()) >= corY && (cartasEnJuego[4].getAncho() + cartasEnJuego[4].getLeft()) >= corX
                    && cartasEnJuego[4].getLeft() <= corX){
                rellenarSparkys(cartasEnJuego[4]);
            }
            if(cartasEnJuego[5].getTop() <= corY && (cartasEnJuego[5].getTop() + cartasEnJuego[5].getAlto()) >= corY && (cartasEnJuego[5].getAncho() + cartasEnJuego[5].getLeft()) >= corX
                    && cartasEnJuego[5].getLeft() <= corX){
                rellenarSparkys(cartasEnJuego[5]);
            }
            if(cartasEnJuego[6].getTop() <= corY && (cartasEnJuego[6].getTop() + cartasEnJuego[6].getAlto()) >= corY && (cartasEnJuego[6].getAncho() + cartasEnJuego[6].getLeft()) >= corX
                    && cartasEnJuego[6].getLeft() <= corX){
                rellenarSparkys(cartasEnJuego[6]);
            }
            if(cartasEnJuego[7].getTop() <= corY && (cartasEnJuego[7].getTop() + cartasEnJuego[7].getAlto()) >= corY && (cartasEnJuego[7].getAncho() + cartasEnJuego[7].getLeft()) >= corX
                    && cartasEnJuego[7].getLeft() <= corX){
                rellenarSparkys(cartasEnJuego[7]);
            }
            if(cartasEnJuego[8].getTop() <= corY && (cartasEnJuego[8].getTop() + cartasEnJuego[8].getAlto()) >= corY && (cartasEnJuego[8].getAncho() + cartasEnJuego[8].getLeft()) >= corX
                    && cartasEnJuego[8].getLeft() <= corX){
                rellenarSparkys(cartasEnJuego[8]);
            }
            if(cartasEnJuego[9].getTop() <= corY && (cartasEnJuego[9].getTop() + cartasEnJuego[9].getAlto()) >= corY && (cartasEnJuego[9].getAncho() + cartasEnJuego[9].getLeft()) >= corX
                    && cartasEnJuego[9].getLeft() <= corX){
                rellenarSparkys(cartasEnJuego[9]);
            }
            if(cartasEnJuego[10].getTop() <= corY && (cartasEnJuego[10].getTop() + cartasEnJuego[10].getAlto()) >= corY && (cartasEnJuego[10].getAncho() + cartasEnJuego[10].getLeft()) >= corX
                    && cartasEnJuego[10].getLeft() <= corX){
                rellenarSparkys(cartasEnJuego[10]);
            }
            if(cartasEnJuego[11].getTop() <= corY && (cartasEnJuego[11].getTop() + cartasEnJuego[11].getAlto()) >= corY && (cartasEnJuego[11].getAncho() + cartasEnJuego[11].getLeft()) >= corX
                    && cartasEnJuego[11].getLeft() <= corX){
                rellenarSparkys(cartasEnJuego[11]);
            }
        }
    }

    // Método para rellenar el array principal con las 12 imágenes de frutas que previamente se han elegido de forma aleatoria
    private void setCartasEnJuego(){
        int numCarta = 0;
        for(int i = 0; i < baraja.length; i++){
            for(int j = 0; j < baraja[i].length; j++){
                cartasEnJuego[numCarta] = new Carta(BitmapFactory.decodeResource(getResources(), baraja[i][j]), (maxX/3) * j + 25, (maxY/5) * i + 25, baraja[i][j]);
                numCarta++;
            }
        }
    }

    private void sacar6Imagenes(){
        int cartas = 0;
        Integer aux[] = new Integer[6];

        while(cartas < 6){ // para rellenar el array de imagenes
            Integer randomCarta = new Integer((int)(Math.random()*12)+0);
            List<Integer> lista = Arrays.asList(aux);
            boolean encontrado = Arrays.asList(aux).contains(imagenes[randomCarta]);

            if(!encontrado){
                lista.set(cartas, imagenes[randomCarta]);
                cartas++;
            }
        }

        // Duplicar
        Integer aux2[] = new Integer[12];
        int num = 0;
        do{
            for(int i = 0; i < aux.length; i++){
                aux2[num] = aux[i];
                num++;
            }
        }while(num < 12);
        System.out.println(" Aux2;: " + aux2.toString());
        // Barajear
        List<Integer> lista2 = Arrays.asList(aux2);
        Collections.shuffle(lista2);
        rellenarBaraja((Integer[]) lista2.toArray());
    }

    private void rellenarBaraja(Integer[] lista) {
        int numImg = 0;
        for(int i = 0; i < baraja.length; i++){
            for(int j = 0; j < baraja[i].length; j++){
                baraja[i][j] = lista[numImg].intValue();
                numImg++;
            }
        }
    }

    private void finalizar(){

        actividad.finalizar(puntuacion);

    }

    private String pasarSeg(float time){
        String cad="";
        String txt=String.valueOf(time);
        int pos=0;
        while(pos<txt.length()){
            if (txt.charAt(pos) == '.' || txt.charAt(pos) == ',') {
                if(cad.length()>1)
                    return cad;
                else return String.format("0%s",cad);
            }
            else {
                cad=String.format("%s%c",cad,txt.charAt(pos));
                pos++;
            }
        }
        return "";
    }

    // Dibuja todas las posiciones con sparky para empezar el juego
    private void dibujarSparkys(Canvas canvas) {
        for(int i = 0; i < baraja.length; i++){
            for(int j = 0; j < baraja[i].length; j++){
                canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sparky), (maxX/3) * j + 25, (maxY/5) * i + 25, null);
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        this.canv = canvas;
        canvas.drawColor(Color.WHITE);
        for(int i = 0; i < cartasEnJuego.length; i++){
            canvas.drawBitmap(cartasEnJuego[i].getBmp(), cartasEnJuego[i].getLeft(), cartasEnJuego[i].getTop(), null);
        }
        dibujarSparkys(canvas);
        contarFallos();
    }

    private void contarFallos() {
        Paint pincel=new Paint();
        pincel.setColor(Color.RED);
        pincel.setTextSize(150);
        canv.drawText(String.format("%s",pasarSeg(MAX_FALLOS - fallos)), this.getWidth() / 9, this.getHeight() - 200, pincel);
        canv.drawText(String.format("%s", puntuacion), this.getWidth() - 200, this.getHeight() - 200, pincel);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}