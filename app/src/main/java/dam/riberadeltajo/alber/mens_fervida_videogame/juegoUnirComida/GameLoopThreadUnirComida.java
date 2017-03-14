package dam.riberadeltajo.alber.mens_fervida_videogame.juegoUnirComida;

import android.graphics.Canvas;



public class GameLoopThreadUnirComida extends Thread{
    private final long FPS=10;
    private GameViewUnirComida gameView;
    private boolean running;

    public GameLoopThreadUnirComida(GameViewUnirComida gameView){
        setGameView(gameView);
        setRunning(false);
    }
    //
    public void setGameView(GameViewUnirComida gameView) {
        this.gameView = gameView;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public GameViewUnirComida getGameView() {

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
            startTime=System.currentTimeMillis();
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
