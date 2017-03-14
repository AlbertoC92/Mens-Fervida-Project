package dam.riberadeltajo.alber.mens_fervida_videogame.juegoComidaCae;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.alber.mens_fervida_videogame.*;

public class MainActivityComidaCae extends Activity {
    private Button btJugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Línea para ocultar el titulo
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_comida_cae);
        btJugar=(Button)findViewById(R.id.btJugarComCae);
        btJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarAljuego();
            }
        });
    }

    private void pasarAljuego(){
        Intent inte=new Intent(this,MainArcadeComidaCae.class);
        startActivityForResult(inte,1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if(resultCode == RESULT_OK){
                Bundle bundle = data.getExtras();
                int puntuacion = bundle.getInt("puntuacion");
                String mensaje=String.format("Has obtenido %d puntos",puntuacion);
                Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
                finish();
            }

            /*if(resultCode == RESULT_CANCELED){
                Toast.makeText(this,"Has vuelto",Toast.LENGTH_LONG).show();
                finish();
            }*/
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
