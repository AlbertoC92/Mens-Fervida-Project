package dam.riberadeltajo.alber.mens_fervida_videogame.healthyExplorer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.alber.mens_fervida_videogame.R;

public class ActividadPrincipal extends AppCompatActivity {
    private Button play;
    public MediaPlayer mediaPlayer;
    private  int AltoPantalla;
    private int AnchoPantalla;
    private int puntuacion;
    SharedPreferences preferencias;
    private int request_code=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu_juego);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        play = (Button)findViewById(R.id.btnplay);
        setMediaPlayer(mediaPlayer);
        cargarSharedPreferences();
        CalculaTamañoPantalla();
        //IniciaMusicaIntro();
        AnimacionInicial();
    }

    private void cargarSharedPreferences() {
        preferencias= getSharedPreferences("maxscore", Context.MODE_PRIVATE);
        puntuacion=preferencias.getInt("puntuacion",0);
    }
    /*public void IniciaMusicaIntro(){

        mediaPlayer = MediaPlayer.create(this, R.raw.intro);
        mediaPlayer.setVolume(0.5f,0.5f);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
        mediaPlayer.start();
    }*/

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==request_code){
            if(resultCode==RESULT_OK){
                Bundle bundle=data.getExtras();
                int puntJuego = bundle.getInt("puntuacionMaxima");
                if(puntJuego>puntuacion){
                    puntuacion=puntJuego;
                    guardarPuntuacion();
                }
            }
        }
    }

    public void Jugar(View vista){
        mediaPlayer.stop();
        mediaPlayer.reset();
        Intent intent =new Intent(this, Instrucciones.class);
        startActivityForResult(intent,request_code);
    }
    public void maxPuntuacion(View vista){
        int msgPuntuacion = R.string.maximaScore;
        Toast.makeText(this,String.format("Your Hight Score is: %d",puntuacion),Toast.LENGTH_LONG).show();
    }
    private void guardarPuntuacion() {
        SharedPreferences.Editor editor= preferencias.edit();
        editor.putInt("puntuacion",puntuacion);
        editor.commit();
    }


    public void AnimacionInicial(){
        try{

            /*ANIMACIÓN METEORITO*/
            ImageView pizza = (ImageView) findViewById(R.id.imgPizza);
            pizza.setVisibility(ImageView.VISIBLE);
            Animation comidaAnimPizza = AnimationUtils.loadAnimation(this, R.anim.comida);
            pizza.startAnimation(comidaAnimPizza);


            Thread.sleep(2000); // 2 segundos después

            /*ANIMACIÓN PLANETA */
            ImageView hamburguesa = (ImageView) findViewById(R.id.imgHamburguesa);
            hamburguesa.setVisibility(ImageView.VISIBLE);
            TranslateAnimation animation = new TranslateAnimation(-300, AnchoPantalla+200,80, 200);
            animation.setDuration(10000);  // duración de la animación
            animation.setRepeatCount(Animation.INFINITE);


            hamburguesa.startAnimation(animation);  // comenzar animación

           // Thread.sleep(2000);
            /*ANIMACIÓN METEORITO*/
            ImageView cola = (ImageView) findViewById(R.id.imgCola);
            cola.setVisibility(ImageView.VISIBLE);
            Animation comidaAnim = AnimationUtils.loadAnimation(this, R.anim.comida);
            cola.startAnimation(comidaAnim);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public void onResume(){
        super.onResume();
        if(mediaPlayer==null){
            mediaPlayer=MediaPlayer.create(this,R.raw.introexplorer);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }

    }

    public void onPause(){
        super.onPause();
    }

    public void onStop(){
        super.onStop();

    }

    public void onDestroy(){
        super.onDestroy();
        mediaPlayer.stop();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(Activity.RESULT_CANCELED, intent);
        finish();
    }
    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }
}
