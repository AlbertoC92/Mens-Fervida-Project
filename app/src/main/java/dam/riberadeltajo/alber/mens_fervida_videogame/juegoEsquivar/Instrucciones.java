package dam.riberadeltajo.alber.mens_fervida_videogame.juegoEsquivar;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.alber.mens_fervida_videogame.R;

/**
 * Created by Antonio Moreno on 15/03/2017.
 */

public class Instrucciones extends Activity{

    private TextView instrucciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones_esquivar );
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        instrucciones=(TextView)findViewById(R.id.tvResultadoInstrucciones);
        mostrarInstrucciones();
    }
    public void mostrarInstrucciones(){
        instrucciones.setText(getResources().getString(R.string.instrucciones));
    }
}
