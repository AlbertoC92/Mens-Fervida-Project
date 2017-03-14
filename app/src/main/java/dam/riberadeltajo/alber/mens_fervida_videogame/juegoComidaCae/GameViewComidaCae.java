package dam.riberadeltajo.alber.mens_fervida_videogame.juegoComidaCae;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

import com.example.alber.mens_fervida_videogame.*;
/**
 * Created by Dani on 11/03/2017.
 */

public class GameViewComidaCae extends SurfaceView {

    private GameLoopThreadComidaCae loop;
    private MainArcadeComidaCae actividad;
    private SurfaceHolder holder;
    private Bitmap cereza,zanahoria,naranja,platano,ciruela,melocoton,uva,limon,pera,palote,paloteDer,tarta,tartaIzq,gelatina,gelatinaIzq,fondo,panel,cruz1,cruz2,cruz3,marcador;
    private Bitmap panelTapado1, panelTapado2, panelTapado3, panelTapado4;
    private ArrayList<SpriteComidaCae> listaFrutasCentro= new ArrayList<SpriteComidaCae>();
    private ArrayList<SpriteComidaCae> listaFrutasIzq= new ArrayList<SpriteComidaCae>();
    private ArrayList<SpriteComidaCae> listaFrutasDer= new ArrayList<SpriteComidaCae>();
    private int frutas_minuto;// velocidad de generacion de frutas
    private int frames_para_nueva_fruta_Centro=0;// frames que tienen que pasar pra crear nueva fruta centro
    private int frames_para_nueva_fruta_Izq=0;// frames que tienen que pasar para crear nueva fruta izquierda
    private int frames_para_nueva_fruta_Der=0;// frames que tienen que pasar para crear nueva fruta derecha
    private int vidas=3;
    private int puntos=0;
    private boolean fin=false;
    private long crono;         //CAMBIADO
    private long inicio;        //CAMBIADO


    public GameViewComidaCae(Context context){
        super(context);
        loop=new GameLoopThreadComidaCae(this);
        actividad=(MainArcadeComidaCae)context;
        this.inicio=System.currentTimeMillis();  //CAMBIADO
        frutas_minuto=20;
        holder=getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                cargaSpriteCentro();
                cargaSpriteIzq();
                cargaSpriteDer();
                loop.setRunning(true);
                loop.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                boolean volver=true;
                loop.setRunning(false);
                while(volver){
                    try{
                        loop.join();
                        volver=false;
                    }catch(InterruptedException ie){}
                }
            }
        });

        fondo= BitmapFactory.decodeResource(getResources(),R.drawable.cc_fondo);
        panel= BitmapFactory.decodeResource(getResources(),R.drawable.cc_panelverde1);
        cruz1=BitmapFactory.decodeResource(getResources(),R.drawable.cc_cruz);
        cruz2=BitmapFactory.decodeResource(getResources(),R.drawable.cc_cruz);
        cruz3=BitmapFactory.decodeResource(getResources(),R.drawable.cc_cruz);
        marcador=BitmapFactory.decodeResource(getResources(),R.drawable.cc_marcador);

        //panelTapado1=BitmapFactory.decodeResource(getResources(),R.drawable.panel);
        //panelTapado2=BitmapFactory.decodeResource(getResources(),R.drawable.panel);
        //panelTapado3=BitmapFactory.decodeResource(getResources(),R.drawable.panel);
        //panelTapado4=BitmapFactory.decodeResource(getResources(),R.drawable.panel);

    }

    public int getVidas() {
        return vidas;
    }

    synchronized public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public float obtenerHeightLimite(){
        return (float)(getHeight()*0.65);
    }

    private void cargaSpriteCentro(){//metodo para cargar las imagenes (creo que habra que poner un metodo de carga por cada columna)
        frames_para_nueva_fruta_Centro=loop.FPS*10/frutas_minuto;// tiempo que va a tardar en salir al inicio, al decrementar el valor numérico, antes aparece
        cereza= BitmapFactory.decodeResource(getResources(),R.drawable.cc_cereza);
        zanahoria=BitmapFactory.decodeResource(getResources(),R.drawable.cc_zanahoria);
        naranja=BitmapFactory.decodeResource(getResources(),R.drawable.cc_naranja);
        palote=BitmapFactory.decodeResource(getResources(),R.drawable.cc_palote);
        tarta=BitmapFactory.decodeResource(getResources(),R.drawable.cc_tarta);
    }

    private void cargaSpriteIzq(){
        frames_para_nueva_fruta_Izq=loop.FPS*10/frutas_minuto;
        pera=BitmapFactory.decodeResource(getResources(),R.drawable.cc_pera);
        platano=BitmapFactory.decodeResource(getResources(),R.drawable.cc_platano);
        melocoton=BitmapFactory.decodeResource(getResources(),R.drawable.cc_melocoton);
        gelatinaIzq=BitmapFactory.decodeResource(getResources(),R.drawable.cc_gelatina);
        tartaIzq=BitmapFactory.decodeResource(getResources(),R.drawable.cc_tarta);
    }

    private void cargaSpriteDer(){
        frames_para_nueva_fruta_Der=loop.FPS*10/frutas_minuto;
        limon=BitmapFactory.decodeResource(getResources(),R.drawable.cc_limon);
        ciruela=BitmapFactory.decodeResource(getResources(),R.drawable.cc_ciruela);
        uva=BitmapFactory.decodeResource(getResources(),R.drawable.cc_uva);
        paloteDer=BitmapFactory.decodeResource(getResources(),R.drawable.cc_palote);
        gelatina=BitmapFactory.decodeResource(getResources(),R.drawable.cc_gelatina);
    }

    private void crearNuevaFrutaCentro(){// Método  que crea e ingresa elementos en el arraylist, dependiendo del numero que salga en el random crea un elemento u otro(habra que hacer un metodo de estos por cada columna).

        int randomImg = (int)(Math.random()*5)+1;// a mayor numero elementos menor posibilidad de que salga cada uno
        if(randomImg==1) {
            listaFrutasCentro.add(new SpriteComidaCae(this, cereza,"bueno",(float)(getWidth()*0.40)));
        }
        if(randomImg==2){
            listaFrutasCentro.add(new SpriteComidaCae(this,tarta,"malo",(float)(getWidth()*0.40)));
        }
        if(randomImg==3){
            listaFrutasCentro.add(new SpriteComidaCae(this,naranja,"bueno",(float)(getWidth()*0.40)));
        }
        if(randomImg==4){
            listaFrutasCentro.add(new SpriteComidaCae(this,palote,"malo",(float)(getWidth()*0.40)));
        }
        if(randomImg==5){
            listaFrutasCentro.add(new SpriteComidaCae(this,zanahoria,"bueno",(float)(getWidth()*0.40)));
        }
    }

    private void crearNuevaFrutaIzq(){
        int randomImg = (int)(Math.random()*5)+1;
        if(randomImg==1){
            listaFrutasIzq.add(new SpriteComidaCae(this, pera,"bueno",(float)(getWidth()*0.75)));
        }
        if(randomImg==2){
            listaFrutasIzq.add(new SpriteComidaCae(this,tartaIzq,"malo",(float)(getWidth()*0.75)));
        }
        if(randomImg==3){
            listaFrutasIzq.add(new SpriteComidaCae(this,platano,"bueno",(float)(getWidth()*0.75)));
        }
        if(randomImg==4){
            listaFrutasIzq.add(new SpriteComidaCae(this,gelatinaIzq,"malo",(float)(getWidth()*0.75)));
        }
        if(randomImg==5){
            listaFrutasIzq.add(new SpriteComidaCae(this,melocoton,"bueno",(float)(getWidth()*0.75)));
        }
    }

    private void crearNuevaFrutaDer(){
        int randomImg = (int)(Math.random()*5)+1;
        if(randomImg==1){
            listaFrutasDer.add(new SpriteComidaCae(this, limon,"bueno",(float)(getWidth()*0.10)));
        }
        if(randomImg==2){
            listaFrutasDer.add(new SpriteComidaCae(this,paloteDer,"malo",(float)(getWidth()*0.10)));
        }
        if(randomImg==3){
            listaFrutasDer.add(new SpriteComidaCae(this,ciruela,"bueno",(float)(getWidth()*0.10)));
        }
        if(randomImg==4){
            listaFrutasDer.add(new SpriteComidaCae(this,gelatina,"malo",(float)(getWidth()*0.10)));
        }
        if(randomImg==5){
            listaFrutasDer.add(new SpriteComidaCae(this,uva,"bueno",(float)(getWidth()*0.10)));
        }

    }

    public void fallar(){
        new EfectoComidaCae(getContext(),R.raw.cc_ohoh).start();
    }

    public void acertar(){
        new EfectoComidaCae(getContext(),R.raw.cc_positivo).start();
    }


    public void draw(Canvas canvas){
        long actual;
        actual=System.currentTimeMillis();
        if(!fin){
            Paint paint = new Paint();
            canvas.drawBitmap(Bitmap.createScaledBitmap(fondo, getWidth(), getHeight(), false), 0, 0, null);
            //-------------------   CENTRO -------------------------//

            if (frames_para_nueva_fruta_Centro == 0) {// que cree nuevos elementos hasta que el tiempo de espera ha llegado a 0 y hasta que el array tenga 8 elementos, para que no se monten unas encima de otras
                crearNuevaFrutaCentro();
                frames_para_nueva_fruta_Centro = loop.FPS * 10 / frutas_minuto;// incrementa el tiempo hasta que salga nuevo elemento
            }
            frames_para_nueva_fruta_Centro--;// si aun el tiempo para crear el nuevo elemento no ha llegado, decrementa en cada iteraccion el tiempo hasta que llegue a 0 donde creara el nuevo elemento


            synchronized (listaFrutasCentro) {
                for (SpriteComidaCae spc : listaFrutasCentro) {//dibuja los elementos del array
                    spc.draw(canvas);
                }
            }


            //--------------------- IZQUIERDA ----------------------//
            if (frames_para_nueva_fruta_Izq == 0) {
                crearNuevaFrutaIzq();
                frames_para_nueva_fruta_Izq = loop.FPS * 10 / frutas_minuto;
            }
            frames_para_nueva_fruta_Izq--;


            synchronized (listaFrutasIzq) {
                for (SpriteComidaCae spi : listaFrutasIzq) {
                    spi.draw(canvas);
                }
            }

            //--------------------- DERECHA -----------------------//


            if (frames_para_nueva_fruta_Der == 0) {
                crearNuevaFrutaDer();
                frames_para_nueva_fruta_Der = loop.FPS * 10 / frutas_minuto;
            }
            frames_para_nueva_fruta_Der--;

            synchronized (listaFrutasDer) {
                for (SpriteComidaCae spd : listaFrutasDer) {
                    spd.draw(canvas);
                }
            }

            //---------------------- PARA HACER EL TEMPORIZAR ---------------------------------------------//
            crono=(actual-inicio)/1000;
            paint.setColor(Color.RED);
            paint.setStrokeWidth(4);
            paint.setTextSize((float) (getWidth() * 0.07));
            canvas.drawText(String.format("%s",crono),(float)(getWidth()*0.1),(float)(getHeight()*0.5),paint);
            if(crono>20){
                for(int i=0;i<listaFrutasCentro.size();i++){
                    listaFrutasCentro.get(i).setySpeed(15);
                }

                for(int i=0;i<listaFrutasIzq.size();i++){
                    listaFrutasIzq.get(i).setySpeed(15);
                }

                for(int i=0;i<listaFrutasDer.size();i++){
                    listaFrutasDer.get(i).setySpeed(15);
                }
                frutas_minuto=25;
            }
            if(crono>35){
                for(int i=0;i<listaFrutasCentro.size();i++){
                    listaFrutasCentro.get(i).setySpeed(20);
                }

                for(int i=0;i<listaFrutasIzq.size();i++){
                    listaFrutasIzq.get(i).setySpeed(20);
                }

                for(int i=0;i<listaFrutasDer.size();i++){
                    listaFrutasDer.get(i).setySpeed(20);
                }
                frutas_minuto=30;
            }
            if(crono>50){
                for(int i=0;i<listaFrutasCentro.size();i++){
                    listaFrutasCentro.get(i).setySpeed(25);
                }

                for(int i=0;i<listaFrutasIzq.size();i++){
                    listaFrutasIzq.get(i).setySpeed(25);
                }

                for(int i=0;i<listaFrutasDer.size();i++){
                    listaFrutasDer.get(i).setySpeed(25);
                }
                frutas_minuto=35;
            }
            if(crono>60){
                for(int i=0;i<listaFrutasCentro.size();i++){
                    listaFrutasCentro.get(i).setySpeed(30);
                }

                for(int i=0;i<listaFrutasIzq.size();i++){
                    listaFrutasIzq.get(i).setySpeed(30);
                }

                for(int i=0;i<listaFrutasDer.size();i++){
                    listaFrutasDer.get(i).setySpeed(30);
                }
                frutas_minuto=40;
            }
            //---------------------- PANEL ,MARCADOR, PUNTUACIÓN Y VIDA -----------------------------------//
            paint.setColor(Color.RED);

            paint.setStrokeWidth(4);
            canvas.drawLine(0, (float)(getHeight()*0.55), canvas.getWidth(), (float)(getHeight()*0.55), paint);
            canvas.drawLine(0, (float)(getHeight()*0.65), canvas.getWidth(), (float)(getHeight()*0.65), paint);
            //canvas.drawBitmap(panel, (float) (getWidth() * 0.02), (float) (getHeight() * 0.655), null); //PINTA EL PANEL
            canvas.drawBitmap(panel,0,(float) (getHeight() * 0.65), null);                  //ESTA ES LA FORMA PROVISIONAL

            //--Para pintar el panel de abajo
            /*Paint pincel=new Paint();
            pincel.setColor(Color.GREEN);
            canvas.drawRect(0,getWidth(),(float) (getHeight() * 0.65),getHeight(),pincel);*/

            canvas.drawBitmap(marcador, (float) (getWidth() * 0.29), (float) (getHeight() * 0.72), null);
            paint.setTextSize((float) (getWidth() * 0.07));
            canvas.drawText(String.format("%02d", puntos), (float) (getWidth() * 0.45), (float) (getHeight() * 0.785), paint);
            //canvas.drawText(String.format("%02d",vidas),(float)(getWidth()*0.60),(float)(getHeight()*0.09),paint);
            //------------------------------ Se dibujan las vidas, si no han sido recicladas(eliminadas) se vuelven a dibujar ----- //
            if (!cruz1.isRecycled()) {
                canvas.drawBitmap(cruz1, (float) (getWidth() * 0.30), (float) (getHeight() * 0.87), null);
            }
            if (!cruz2.isRecycled()) {
                canvas.drawBitmap(cruz2, (float) (getWidth() * 0.45), (float) (getHeight() * 0.87), null);
            }
            if (!cruz3.isRecycled()) {
                canvas.drawBitmap(cruz3, (float) (getWidth() * 0.60), (float) (getHeight() * 0.87), null);
            }

            // -------------------- Comrpobación de vidas ----------------------//

            if (vidas == 2) {
                cruz3.recycle();
            }
            if (vidas == 1) {
                cruz2.recycle();
            }
            if (vidas <= 0) {
                cruz1.recycle();
                fin=true;
                finalizar();
            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ArrayList removeCentro = new ArrayList();
        ArrayList removeIzq = new ArrayList();
        ArrayList removeDer = new ArrayList();
        if(event.getAction()==MotionEvent.ACTION_DOWN) {
            synchronized (getHolder()) {
                synchronized (listaFrutasCentro) {
                    for (int i = listaFrutasCentro.size() - 1; i >= 0; i--) {
                        if (listaFrutasCentro.get(i).isCollition(event.getX(), event.getY())) {
                            if (event.getY() > ((float)(getHeight()*0.55)) && event.getY() < ((float)(getHeight()*0.65))) {
                                if (listaFrutasCentro.get(i).getTipo().equals("bueno")) {
                                    puntos += 5;
                                    acertar();
                                }
                                if (listaFrutasCentro.get(i).getTipo().equals("malo")) {
                                    vidas -= 1;
                                    fallar();
                                }
                                removeCentro.add(listaFrutasCentro.get(i));
                                break;
                            }

                        }
                    }
                    listaFrutasCentro.removeAll(removeCentro);
                }

                synchronized (listaFrutasIzq) {
                    for (int i = listaFrutasIzq.size() - 1; i >= 0; i--) {
                        if (listaFrutasIzq.get(i).isCollition(event.getX(), event.getY())) {
                            if (event.getY() > ((float)(getHeight()*0.55)) && event.getY() < ((float)(getHeight()*0.65))) {
                                if (listaFrutasIzq.get(i).getTipo().equals("bueno")) {
                                    puntos += 5;
                                    acertar();
                                }
                                if (listaFrutasIzq.get(i).getTipo().equals("malo")) {
                                    vidas -= 1;
                                    fallar();
                                }
                                removeIzq.add(listaFrutasIzq.get(i));
                                break;
                            }

                        }
                    }
                    listaFrutasIzq.removeAll(removeIzq);
                }

                synchronized (listaFrutasDer) {
                    for (int i = listaFrutasDer.size() - 1; i >= 0; i--) {
                        if (listaFrutasDer.get(i).isCollition(event.getX(), event.getY())) {
                            if (event.getY() > ((float)(getHeight()*0.55)) && event.getY() < ((float)(getHeight()*0.65))) {
                                if (listaFrutasDer.get(i).getTipo().equals("bueno")) {
                                    puntos += 5;
                                    acertar();
                                }
                                if (listaFrutasDer.get(i).getTipo().equals("malo")) {
                                    vidas -= 1;
                                    fallar();
                                }

                                removeDer.add(listaFrutasDer.get(i));
                                break;
                            }

                        }

                    }
                    listaFrutasDer.removeAll(removeDer);
                }

            }
        }
        return true;
    }

    private void finalizar(){
        loop.setRunning(false);
        /*try{
            Thread.sleep(1000);
        }catch(InterruptedException ie){}*/
        actividad.fin(puntos);
    }

}
