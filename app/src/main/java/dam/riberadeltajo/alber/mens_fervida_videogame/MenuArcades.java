package dam.riberadeltajo.alber.mens_fervida_videogame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alber.mens_fervida_videogame.R;

import dam.riberadeltajo.alber.mens_fervida_videogame.entidades.Jugador;

public class MenuArcades extends Activity implements View.OnClickListener{
    Dialog juego1, juego2, juego3, juego4, juego5;
    Button volver;
    TextView estrellas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Línea para ocultar el titulo
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//Línea para ocultar la barra de información de la batería,etc...
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcades);
        volver=(Button)findViewById(R.id.btn_atras_juegos);
        volver.setOnClickListener(this);
        estrellas= (TextView) findViewById(R.id.txt_estrellas_arcade);
        cargarPaneles();
    }

    private void cargarPaneles() {
        juego1 = new DialogJuegoUno(this,R.style.AppTheme, this);
        juego2 = new DialogJuegoDos(this,R.style.AppTheme, this);
        juego3 = new DialogJuegoTres(this,R.style.AppTheme, this);
        juego4=new DialogJuegoCuatro(this,R.style.AppTheme, this);
        juego5=new DialogJuego5(this,R.style.AppTheme, this);
        juego1.show();
    }

    public boolean puedeJugar(){
        if(Jugador.getInstance().getEstrellas()<0.5){
            Toast.makeText(this, "No tiene suficiente crédito", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            Jugador.getInstance().setEstrellas((float) (Jugador.getInstance().getEstrellas()-0.5));
            Jugador.getInstance().guardarSharedPreferences();
            return true;
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_atras_juegos:
                if(juego1.isShowing()){
                    juego1.dismiss();
                }
                if(juego2.isShowing()){
                    juego2.dismiss();
                }
                if(juego3.isShowing()){
                    juego3.dismiss();
                }
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
        Jugador.getInstance(this).cargarSharedPreferences();
        if(Jugador.getInstance().isMusicaPlaying()){
            Intent i = new Intent(this, AudioService.class);
            i.putExtra("action", AudioService.START);
            startService(i);
        }
        estrellas.setText(String.format("%.1f", Jugador.getInstance().getEstrellas()));
    }
}
