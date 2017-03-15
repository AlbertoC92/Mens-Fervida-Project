package dam.riberadeltajo.alber.mens_fervida_videogame.juegoEsquivar;

import android.graphics.Canvas;

/**
 * Created by Profesor on 02/03/2017.
 */

public class GameLoop extends Thread {

    static final long FPS = 10;
    private GameView gameView;
    private boolean running = false;

    public GameLoop(GameView gameView){
        this.gameView = gameView;
    }

    public void setRunning(boolean running){
        this.running = running;
    }

    @Override
    public void run() {
        long ticksPs = 1000/FPS;
        long startTime;
        long sleepTime;
        while(running){
            Canvas c = null;
            startTime = System.currentTimeMillis();
            try{
                c = gameView.getHolder().lockCanvas();
                synchronized (gameView.getHolder()){
                    gameView.draw(c);
                }
            } finally {
                if(c!=null){
                    gameView.getHolder().unlockCanvasAndPost(c);
                }
            }
            sleepTime = ticksPs-(System.currentTimeMillis()-startTime);
            try{
                if(sleepTime>0)
                    sleep(sleepTime);
                else
                    sleep(10);
            } catch (Exception e){}
        }
    }
}
