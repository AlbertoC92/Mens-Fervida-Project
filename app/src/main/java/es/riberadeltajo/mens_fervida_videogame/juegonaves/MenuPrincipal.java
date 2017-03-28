package es.riberadeltajo.mens_fervida_videogame.juegonaves;

import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import es.riberadeltajo.mens_fervida_videogame.R;



public class MenuPrincipal extends ActionBarActivity {
    int AltoPantalla;
    int AnchoPantalla;

    Button botonJuego;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal_nave);
        botonJuego = (Button) findViewById(R.id.btn_comenzar);




        CalculaTamañoPantalla();
        IniciaMusicaIntro();
        AnimacionInicial();
        findViewById(R.id.btn_comenzar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();mediaPlayer.reset();
                MenuPrincipal.this.startActivity(new Intent(MenuPrincipal.this, ActividadJuego.class));
            }
        });
    }

    public void IniciaMusicaIntro(){

        mediaPlayer = MediaPlayer.create(this, R.raw.intro);
        mediaPlayer.setVolume(0.5f,0.5f);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
        mediaPlayer.start();
    }

    public void CalculaTamañoPantalla(){
        if(Build.VERSION.SDK_INT > 13) {
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            AnchoPantalla = size.x;
            AltoPantalla = size.y;
        }
        else{
            Display display = getWindowManager().getDefaultDisplay();
            AnchoPantalla = display.getWidth();  // deprecated
            AltoPantalla = display.getHeight();  // deprecated
        }

        Log.i(Juego.class.getSimpleName(), "alto:" + AltoPantalla + "," + "ancho:" + AnchoPantalla);
    }

    public void AnimacionInicial(){
        try{

            /*ANIMACIÓN NUBE*/
            ImageView nube = (ImageView) findViewById(R.id.imgNube);
            nube.setVisibility(ImageView.VISIBLE);
            Animation nubeAnim = AnimationUtils.loadAnimation(this, R.anim.nube);
            nube.startAnimation(nubeAnim);


            Thread.sleep(2000); // 2 segundos después

            /*ANIMACIÓN NAVE */
            ImageView nave_der = (ImageView) findViewById(R.id.imgNaveDer);
            nave_der.setVisibility(ImageView.VISIBLE);
                                                         //(xFrom,xTo, yFrom,yTo)
            TranslateAnimation animation = new TranslateAnimation(-650, AnchoPantalla+200,40,40);
            animation.setDuration(10000);  // duración de la animación
            animation.setRepeatCount(Animation.INFINITE);
            animation.setRepeatMode(Animation.RESTART);

            nave_der.startAnimation(animation);  // comenzar animación

        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean result = super.onPrepareOptionsMenu(menu);
        return result;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}
