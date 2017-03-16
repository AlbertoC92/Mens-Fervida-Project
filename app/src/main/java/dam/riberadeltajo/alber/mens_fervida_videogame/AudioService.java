package dam.riberadeltajo.alber.mens_fervida_videogame;

import android.app.Activity;
import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.alber.mens_fervida_videogame.R;

import dam.riberadeltajo.alber.mens_fervida_videogame.healthyExplorer.ActividadPrincipal;

/**
 * Created by alberto garcia on 29/01/2017.
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

    /**
     * Created by alber on 15/03/2017.
     */

    public static class DialogJuego5 extends Dialog implements View.OnClickListener {
        private Context mContext;
        private Activity activity;
        private Button btnAnterior,btnJugar;

        public DialogJuego5(Context context, int themeResId, Activity activity) {
            super(context, themeResId);
            mContext=context;
            this.activity=activity;
            quitarFondoRedimensionarEfectos();

        }

        public void quitarFondoRedimensionarEfectos(){
            this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            Display display = activity.getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            int height = size.y;
            getWindow().setLayout((int)(size.x*0.9), (int)(size.y*0.7));
            getWindow().getAttributes().windowAnimations = R.style.PanelPregunta;
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN );
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_dialog_juego5);
            btnAnterior=(Button) findViewById(R.id.btn_juego3_anterior);
            btnAnterior.setOnClickListener(this);
            btnJugar = (Button)findViewById(R.id.btnExplorador);
            btnJugar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    jugarExplorador();
                }
            });


        }

        public void jugarExplorador(){
            if(((MenuArcades)mContext).puedeJugar()) {
                Intent intent = new Intent(activity, ActividadPrincipal.class);
                activity.startActivity(intent);
            }
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_juego3_anterior:
                    //getWindow().getAttributes().windowAnimations = R.style.PanelNivelDos;    //Pero hace cosas raras, no funciona bien
                    ((MenuArcades)activity).juego2.show();
                    this.dismiss();
            }
        }

        @Override
        public void onBackPressed() {
            if(this.isShowing()) {

                this.dismiss();
                ((MenuArcades)activity).juego2.show();
            }

        }
    }
}
