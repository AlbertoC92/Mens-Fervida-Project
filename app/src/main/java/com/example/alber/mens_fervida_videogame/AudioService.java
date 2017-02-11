package com.example.alber.mens_fervida_videogame;

import android.app.Service;
import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by alber on 29/01/2017.
 */

public class AudioService extends Service {
    static final int DECREASE = 1, INCREASE = 2, START = 3, PAUSE = 4,STOP=5,ACTIVO=6;
    Boolean shouldPause = false;
    MediaPlayer loop;


    public MediaPlayer getLoop() {
        return loop;
    }

    public void setLoop(MediaPlayer loop) {
        this.loop = loop;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void startLoop(){
        if(loop == null){
            loop = MediaPlayer.create(this, R.raw.jump_and_run);
        }
        if(!loop.isPlaying()){
            loop.setLooping(true);
            loop.start();
        }
    }
    private void decrease(){
        loop.setVolume(0.2f, 0.2f);
    }
    private void increase(){
        loop.setVolume(1.0f, 1.0f);
    }
    private void stop(){loop.stop();}

    private void start(){

        startLoop();
        shouldPause = false;
    }
    private void pause(){
        shouldPause = true;
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        if(shouldPause) {
                            if(loop!=null)
                                loop.pause();


                        }
                    }
                }, 100);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(getClass().getSimpleName(), "Creating service");

    }

    public boolean estaActivo(){

        if(loop.isPlaying()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Log.i(getClass().getSimpleName(), "Intent received");

        try {
            int actionDefault = 0;
            int action = actionDefault;

            if(intent != null){
                if(intent.hasExtra("action")){
                    action = intent.getIntExtra("action", actionDefault);
                }
            }

            switch (action) {
                case INCREASE:
                    increase();
                    break;
                case DECREASE:
                    decrease();
                    break;
                case START:
                    start();
                    break;
                case PAUSE:
                    pause();
                    break;
                case STOP:
                    stop();
                    break;
                case ACTIVO:
                    estaActivo();
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (loop != null) loop.release();
    }

}
