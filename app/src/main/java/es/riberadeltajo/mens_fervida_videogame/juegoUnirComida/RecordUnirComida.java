package es.riberadeltajo.mens_fervida_videogame.juegoUnirComida;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import es.riberadeltajo.mens_fervida_videogame.*;

public class RecordUnirComida extends Activity {

    private SharedPreferences prefe;
    private TextView tvTituloRecord;
    private TextView tvResultadoRecord;
    private Typeface face;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_unircomida);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        prefe=getSharedPreferences("puntos",Context.MODE_PRIVATE);
        face=Typeface.createFromAsset(getAssets(), "fonts/some_time_later.otf");
        tvTituloRecord=(TextView)findViewById(R.id.tvTituloRecord);
        tvTituloRecord.setTypeface(face);
        tvResultadoRecord=(TextView)findViewById(R.id.tvResultadoRecord);
        tvResultadoRecord.setTypeface(face);
        mostrarRecord();
    }

    public void mostrarRecord(){
        tvResultadoRecord.setText(getResources().getString(R.string.elrecord_es)+"\n\n"+prefe.getString("puntos", "0")
                +"\n\n"+getResources().getString(R.string.puntos));
    }
}
