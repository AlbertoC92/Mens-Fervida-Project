package dam.riberadeltajo.alber.mens_fervida_videogame.juegoComidaCae;

import android.graphics.Canvas;

/**
 * Created by Dani on 11/03/2017.
 */

public class GameLoopThreadComidaCae extends Thread{
    public final static int FPS=45;
    private GameViewComidaCae gameView;
    private boolean running;

    public GameLoopThreadComidaCae(GameViewComidaCae gameView){
        setGameView(gameView);
        setRunning(false);
    }

    public void setGameView(GameViewComidaCae gameView) {
        this.gameView = gameView;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public GameViewComidaCae getGameView() {

        return gameView;
    }

    public boolean isRunning() {
        return running;
    }

    public void run(){
        long tick=1000/FPS;
        long startTime;
        long sleepTime;
        while(isRunning()){
            Canvas canvas=null;
            startTime= System.currentTimeMillis();
            try{
                canvas=getGameView().getHolder().lockCanvas();
                synchronized(getGameView()){
                    getGameView().draw(canvas);
                }
            }finally{
                if(canvas!=null){
                    getGameView().getHolder().unlockCanvasAndPost(canvas);
                }
            }
            sleepTime=tick-(System.currentTimeMillis()-startTime);
            try{
                if(sleepTime>0)
                    sleep(sleepTime);
                else
                    sleep(10);
            }catch(InterruptedException ie){}
        }
    }
}
