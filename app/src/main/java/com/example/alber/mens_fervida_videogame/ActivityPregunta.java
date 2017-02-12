package com.example.alber.mens_fervida_videogame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alber.mens_fervida_videogame.entidades.Jugador;
import com.example.alber.mens_fervida_videogame.entidades.Pregunta;

/**
 * Created by PedroMiguel on 01/02/2017.
 */

public class ActivityPregunta extends Activity implements View.OnClickListener{
    public int puntuacionNivel;
    private final int PREGUNTA_ACERTADA_MULT =10;
    private final int TIMER_A_CERO=60;
    private final int PREGUNTA_POR_NIVEL=20;
    private final int SEGUNDOS_TOTAL_MS=60000;
    private final int TIEMPO_RESTA_PUNTI=1000;
    public int nivel,numeroPregunta,vidas,puntosSegundos,idAciertoSound,idFalloSound;
    LinearLayout marcador;
    TextView timerDisplay, puntuacion, estrellasPanel;
    Dialog diaPregunta;
    Pregunta pregunta;
    CountDownTimer timer;
    Button atras;
    SoundPool soundPool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        puntuacionNivel=0;
        numeroPregunta=1;
        vidas=6;
        Bundle bundle=getIntent().getExtras();
        nivel=bundle.getInt("nivel");
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Línea para ocultar el titulo
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//Línea para ocultar la barra de información de la batería,etc...
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pregunta_palabra_comp);
        puntuacion=(TextView) findViewById(R.id.text_puntuacion) ;
        puntuacion.setText(String.format("%d",Jugador.getInstance().getPuntuacion()));
        estrellasPanel=(TextView)findViewById(R.id.txt_estrellas_preg);
        estrellasPanel.setText(String.format("%.1f", Jugador.getInstance().getEstrellas()));
        atras=(Button)findViewById(R.id.btn_atras_pre_com);
        atras.setOnClickListener(this);
        marcador=(LinearLayout)findViewById(R.id.linear_marcador);
        nuevaPregunta();
        cargarEfectosSonidos();

    }

    private void cargarEfectosSonidos() {
        soundPool=new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        idAciertoSound=soundPool.load(this, R.raw.win_sound, 0);
        idFalloSound=soundPool.load(this, R.raw.bad_sound, 0);
    }


    private void iniciarContador() {
        puntosSegundos=TIMER_A_CERO;
        if(timer==null) {
            timer = new CountDownTimer(SEGUNDOS_TOTAL_MS, TIEMPO_RESTA_PUNTI) {
                @Override
                public void onTick(long l) {
                    puntosSegundos--;
                    timerDisplay=(TextView)findViewById(R.id.text_timer);
                    timerDisplay.setText(String.format("00:%02d",puntosSegundos));
                }

                @Override
                public void onFinish() {
                    diaPregunta.dismiss();
                    setResult(RESULT_CANCELED, null);
                    finish();
                }
            }.start();
        }
    }

    private void nuevaPregunta() {
        //pregunta Facil
        if(nivel%2==0){
            pregunta=new Pregunta(Jugador.getInstance().getIdioma(),nivel);
            diaPregunta=new DialogPregPalComp(this, R.style.AppTheme, this);
        }
        //pregunta difucil
        else{
            pregunta=new Pregunta(Jugador.getInstance().getIdioma(),nivel);
            diaPregunta=new DialogPregPalComp(this, R.style.AppTheme, this);
        }
        iniciarContador();
        timer.start();
        diaPregunta.show();
        System.out.println(pregunta);
    }
    public void preguntaAcertada(){
        puntuacionNivel=puntuacionNivel+ nivel*PREGUNTA_ACERTADA_MULT+puntosSegundos;
        puntosSegundos=TIMER_A_CERO;
        puntuacion.setText(String.format("%d",puntuacionNivel));
        timer.cancel();
        soundPool.play(idAciertoSound, 1, 1, 1, 0, 1);
        if(numeroPregunta>=PREGUNTA_POR_NIVEL){
            finalizaNivelOk();
        }
        else{
            diaPregunta.dismiss();
            nuevaPregunta();
            numeroPregunta++;
        }
    }

    public void preguntaFallada(){
        vidas--;
        puntosSegundos=TIMER_A_CERO;
        timer.cancel();
        soundPool.play(idFalloSound, 1, 1, 0, 0, 1);
        switch (vidas){
            case 5:
                LinearLayout linearLayout=(LinearLayout) findViewById(R.id.linear_vida_6);
                linearLayout.setVisibility(View.INVISIBLE);
                nuevaPregunta();
                break;
            case 4:
                linearLayout = (LinearLayout) findViewById(R.id.linear_vida_5);
                linearLayout.setVisibility(View.INVISIBLE);
                nuevaPregunta();
                break;
            case 3:
                linearLayout = (LinearLayout) findViewById(R.id.linear_vida_4);
                linearLayout.setVisibility(View.INVISIBLE);
                nuevaPregunta();
                break;
            case 2:
                linearLayout = (LinearLayout) findViewById(R.id.linear_vida_3);
                linearLayout.setVisibility(View.INVISIBLE);
                nuevaPregunta();
                break;
            case 1:
                linearLayout=(LinearLayout) findViewById(R.id.linear_vida_2);
                linearLayout.setVisibility(View.INVISIBLE);
                nuevaPregunta();
                break;
            case 0:
                linearLayout=(LinearLayout) findViewById(R.id.linear_vida_1);
                linearLayout.setVisibility(View.INVISIBLE);
                setResult(RESULT_CANCELED, null);
                finish();
                break;
        }
    }
    public void finalizaNivelOk(){
        Jugador.getInstance().setPuntuacion(Jugador.getInstance().getPuntuacion()+puntuacionNivel);
        Intent intent= new Intent();
        intent.putExtra("nivelFinalizado",nivel);
        intent.putExtra("estrellasConseguidas",(float)vidas/2);
        setResult(RESULT_OK, intent);
        diaPregunta.dismiss();
        new DialogLevelCompl(this, R.style.AppTheme).show();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_atras_pre_com:
                diaPregunta.dismiss();
                finish();
                break;

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Intent i = new Intent(this, AudioService.class);
        i.putExtra("action", AudioService.PAUSE);
        startService(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Jugador.getInstance().isMusicaPlaying()){
            Intent i = new Intent(this, AudioService.class);
            i.putExtra("action", AudioService.START);
            startService(i);
        }

    }
}
