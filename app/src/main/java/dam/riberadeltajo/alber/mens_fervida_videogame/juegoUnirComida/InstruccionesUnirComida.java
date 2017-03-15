package dam.riberadeltajo.alber.mens_fervida_videogame.juegoUnirComida;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.example.alber.mens_fervida_videogame.*;

public class InstruccionesUnirComida extends Activity {

    private Typeface face;
    private TextView tvTituloInstrucciones;
    private TextView tvResultadoInstrucciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones_unircomida);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Línea para ocultar el titulo
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        face= Typeface.createFromAsset(getAssets(), "fonts/some_time_later.otf");
        tvTituloInstrucciones=(TextView)findViewById(R.id.tvTituloInstrucciones);
        tvTituloInstrucciones.setTypeface(face);
        tvResultadoInstrucciones=(TextView)findViewById(R.id.tvResultadoInstrucciones);
        tvResultadoInstrucciones.setTypeface(face);
        mostrarInstrucciones();
    }

    public void mostrarInstrucciones(){
        tvResultadoInstrucciones.setText(getResources().getString(R.string.instrucciones1)
                +"\n"+getResources().getString(R.string.instrucciones2)+"\n"+
                getResources().getString(R.string.instrucciones3)+"\n"+
                getResources().getString(R.string.instrucciones4)+"\n"+
                getResources().getString(R.string.instrucciones5));
    }
}
