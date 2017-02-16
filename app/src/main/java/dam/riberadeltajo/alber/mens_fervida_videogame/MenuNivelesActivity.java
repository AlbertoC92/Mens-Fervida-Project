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

import com.example.alber.mens_fervida_videogame.R;

import dam.riberadeltajo.alber.mens_fervida_videogame.entidades.Jugador;

/**
 * Created by PedroMiguel on 01/02/2017.
 */

public class MenuNivelesActivity extends Activity implements View.OnClickListener{
    Dialog panel1, panel2, diaSalir;
    public static final int NIVEL_FINALIZADO=1;
    TextView puntuacionJugador, estrellasJugador;
    Button salir;
    private int siguienteNivel=2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Línea para ocultar el titulo
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//Línea para ocultar la barra de información de la batería,etc...
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles2);
        Jugador.getInstance().setPuntuacion(0);

        salir=(Button) findViewById(R.id.btn_atras_ac_niv);
        salir.setOnClickListener(this);
        puntuacionJugador=(TextView)findViewById(R.id.txt_puntuacion_niveles);
        estrellasJugador=(TextView)findViewById(R.id.text_estrellas_niveles);
        estrellasJugador.setText(String.format("%.1f", Jugador.getInstance().getEstrellas()));
        cargarPaneles();

    }

    private void cargarPaneles() {
        panel1 = new DialogPanelNivelUno(this,R.style.AppTheme, this);
        panel2 = new DialogPanelNivelDos(this,R.style.AppTheme, this);
        panel1.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle bundle=null;
        if(!(data ==null)){
            bundle=data.getExtras();
        }

        switch (requestCode){
            case NIVEL_FINALIZADO:
                if(resultCode==RESULT_OK){
                    Jugador.getInstance().setEstrellas(Jugador.getInstance().getEstrellas()+bundle.getFloat("estrellasConseguidas"));
                    Jugador.getInstance().guardarSharedPreferences();
                    estrellasJugador.setText(String.format("%.1f", Jugador.getInstance().getEstrellas()));

                    switch (bundle.getInt("nivelFinalizado")){
                        case 1:
                            ((DialogPanelNivelUno)panel1).btn1.setClickable(false);
                            ((DialogPanelNivelUno)panel1).btn1.setBackground(getDrawable(R.drawable.btn_aceptar));
                            ((DialogPanelNivelUno)panel1).btn2.setEnabled(true);
                            siguienteNivel=2;
                            break;
                        case 2:
                            ((DialogPanelNivelUno)panel1).btn2.setClickable(false);
                            ((DialogPanelNivelUno)panel1).btn2.setBackground(getDrawable(R.drawable.btn_aceptar));
                            ((DialogPanelNivelUno)panel1).btn3.setEnabled(true);
                            siguienteNivel=3;
                            break;
                        case 3:
                            ((DialogPanelNivelUno)panel1).btn3.setClickable(false);
                            ((DialogPanelNivelUno)panel1).btn3.setBackground(getDrawable(R.drawable.btn_aceptar));
                            ((DialogPanelNivelUno)panel1).btn4.setEnabled(true);
                            siguienteNivel=4;
                            break;
                        case 4:
                            ((DialogPanelNivelUno)panel1).btn4.setClickable(false);
                            ((DialogPanelNivelUno)panel1).btn4.setBackground(getDrawable(R.drawable.btn_aceptar));
                            ((DialogPanelNivelUno)panel1).btn5.setEnabled(true);
                            siguienteNivel=5;
                            break;
                        case 5:
                            ((DialogPanelNivelUno)panel1).btn5.setClickable(false);
                            ((DialogPanelNivelUno)panel1).btn5.setBackground(getDrawable(R.drawable.btn_aceptar));
                            panel2.show();
                            ((DialogPanelNivelDos)panel2).btn6.setEnabled(true);
                            siguienteNivel=6;
                            break;
                        case 6:
                            ((DialogPanelNivelDos)panel2).btn6.setClickable(false);
                            ((DialogPanelNivelDos)panel2).btn6.setBackground(getDrawable(R.drawable.btn_aceptar));
                            ((DialogPanelNivelDos)panel2).btn7.setEnabled(true);
                            siguienteNivel=7;
                            break;
                        case 7:
                            ((DialogPanelNivelDos)panel2).btn7.setClickable(false);
                            ((DialogPanelNivelDos)panel2).btn7.setBackground(getDrawable(R.drawable.btn_aceptar));
                            ((DialogPanelNivelDos)panel2).btn8.setEnabled(true);
                            siguienteNivel=8;
                            break;
                        case 8:
                            ((DialogPanelNivelDos)panel2).btn8.setClickable(false);
                            ((DialogPanelNivelDos)panel2).btn8.setBackground(getDrawable(R.drawable.btn_aceptar));
                            ((DialogPanelNivelDos)panel2).btn9.setEnabled(true);
                            siguienteNivel=9;
                            break;
                        case 9:
                            ((DialogPanelNivelDos)panel2).btn9.setClickable(false);
                            ((DialogPanelNivelDos)panel2).btn9.setBackground(getDrawable(R.drawable.btn_aceptar));
                            ((DialogPanelNivelDos)panel2).btn10.setEnabled(true);
                            siguienteNivel=10;
                            break;
                        case 10:
                            ((DialogPanelNivelDos)panel2).btn10.setClickable(false);
                            ((DialogPanelNivelDos)panel2).btn10.setBackground(getDrawable(R.drawable.btn_aceptar));
                            break;
                    }

                }
                break;
        }
    }
    public void mostarDiallogSalir(){
        panel1.dismiss();
        panel2.dismiss();
        if(diaSalir==null)
            diaSalir=new DialogSalir(this, R.style.AppTheme);
        diaSalir.show();

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_atras_ac_niv:
                mostarDiallogSalir();
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
        if(!(siguienteNivel/5>=1) || siguienteNivel==5){
            panel1.show();
        }
        else{
            panel2.show();
        }
        puntuacionJugador.setText(String.format("%d",Jugador.getInstance().getPuntuacion()));
        if(Jugador.getInstance().isMusicaPlaying()){
            Intent i = new Intent(this, AudioService.class);
            i.putExtra("action", AudioService.START);
            startService(i);
        }
    }
}
