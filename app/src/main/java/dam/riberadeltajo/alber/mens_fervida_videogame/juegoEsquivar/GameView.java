package dam.riberadeltajo.alber.mens_fervida_videogame.juegoEsquivar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.alber.mens_fervida_videogame.R;

public class GameView extends SurfaceView {
    private SurfaceHolder holder;
    private GameLoop loop;
    private Juego contexto;
    private Player caja;
    private Enemy enemy[];
    private  static int puntuacion;
    private boolean inicializar;
    private Bitmap hamburguesa,sparky;

    public GameView(Context context) {
        super(context);
        contexto = (Juego) context;
        inicializar = true;
        puntuacion = 0;
        loop = new GameLoop(this);
        holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                loop.setRunning(true);
                loop.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                boolean retry = false;
                loop.setRunning(false);

                while (retry ) {
                    try {
                        loop.join();
                        retry = false;
                    } catch (InterruptedException ie) {
                    }
                }
            }
        });
        hamburguesa= BitmapFactory.decodeResource(getResources(), R.drawable.mini_hamburguesa);
        sparky= BitmapFactory.decodeResource(getResources(),R.drawable.mini_sparky);

    }

    private boolean colision() {
        boolean colision = false;
        float xO, yO;
        int wO, hO;
        for (int i = 0; i < enemy.length; i++) {
            xO = enemy[i].getX();
            yO = enemy[i].getY();
            wO = enemy[i].getW();
            hO = enemy[i].getH();
            if (((xO > caja.getCorx() && xO < caja.getCorx() + caja.getW()) && (yO + hO > caja.getCory() && yO + hO < caja.getCory() + caja.getH()))
                    || ((xO + wO >= caja.getCorx() && xO + wO <= caja.getCorx() + caja.getW()) && (yO + hO > caja.getCory() && yO + hO < caja.getCory() + caja.getH()))) {
                colision = true;
            }

            if ((caja.getCorx() > xO && caja.getCorx() <= xO + wO) && (caja.getCory() >= yO && caja.getCory() <= yO + hO)) {
                colision = true;
            }
            if ((caja.getCorx() + caja.getW() > xO && caja.getCorx() + caja.getW() < xO + wO) && (caja.getCory() >= yO && caja.getCory() + caja.getH() <= yO + hO)) {
                colision = true;
            }

        }
        return colision;
    }

    public void setPuntuacion() {
        puntuacion++;
    }
    public  static int getPuntuacion(){
        return puntuacion;
    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (inicializar) {
            caja = new Player(this,sparky);
            enemy = new Enemy[10];
            crearEnemigo();
            inicializar = false;
        }
        canvas.drawARGB(255, 150, 150, 255);


        caja.draw(canvas,sparky);
        for (int i = 0; i < enemy.length; i++) {
            enemy[i].draw(canvas);
        }
        Paint pincel = new Paint();
        pincel.setTextSize(90);
        canvas.drawText(String.valueOf(puntuacion), 5 * getWidth() / 6, getHeight() / 10, pincel);

        if (colision()|| puntuacion>=10) {
            pincel.setColor(Color.WHITE);
            pincel.setTextSize(150);
            if (colision()){
                canvas.drawText(getResources().getString(R.string.jugar), getWidth() / 6, 5 * getHeight() / 10, pincel);
            }else{
                canvas.drawText(getResources().getString(R.string.p_max), getWidth() /4 , 5 * getHeight() / 10, pincel);
            }
            try {
                loop.sleep(3000);
            } catch (InterruptedException e) {
            }
            loop.setRunning(false);
            contexto.fin(puntuacion);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        float eX;
        float eY;
        if (event.getAction() == MotionEvent.ACTION_UP) {
            eX = event.getX();
            eY = event.getY();
            if (eY > caja.getCory() - caja.getH() && eY < caja.getCory() + caja.getH() + caja.getH()) {
                if (eX > caja.getCorx() + caja.getW())
                    caja.derecha();
                if (eX < caja.getCorx())
                    caja.izquierda();
            }
        }
        return true;
    }

    private void crearEnemigo() {
        for (int i = 0; i < enemy.length; i++) {
            enemy[i] = new Enemy(this,hamburguesa);
        }
    }

}