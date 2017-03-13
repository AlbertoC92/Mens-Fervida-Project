package dam.riberadeltajo.alber.mens_fervida_videogame.juegoUnirComida;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.alber.mens_fervida_videogame.*;


public class MainActivityUnirComida extends Activity {

    private Button btnJugar;
    private Button btnInstrucciones;
    private Button btnRecord;
    private Typeface face;
    private MediaPlayer musica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_unircomida);

        face= Typeface.createFromAsset(getAssets(), "fonts/some_time_later.otf");
        btnJugar=(Button)findViewById(R.id.btnJugar);
        btnJugar.setTypeface(face);
        btnInstrucciones=(Button)findViewById(R.id.btnInstrucciones);
        btnInstrucciones.setTypeface(face);
        btnRecord=(Button)findViewById(R.id.btnRecord);
        btnRecord.setTypeface(face);
    }

    public void abrirJugar(View view){
        Intent i = new Intent(this, PartidaUnirComida.class );
        startActivity(i);
    }

    public void abrirInstrucciones(View view){
        Intent i = new Intent(this, InstruccionesUnirComida.class );
        startActivity(i);
    }

    public void abrirRecord(View view){
        Intent i = new Intent(this, RecordUnirComida.class );
        startActivity(i);
    }

    public void onResume(){
        super.onResume();
        if(musica==null){
            musica=MediaPlayer.create(this,R.raw.theme);
            musica.setLooping(true);
            musica.start();
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
        musica.stop();
    }

    public void fin(){
        this.onPause();
        finish();
    }


}
