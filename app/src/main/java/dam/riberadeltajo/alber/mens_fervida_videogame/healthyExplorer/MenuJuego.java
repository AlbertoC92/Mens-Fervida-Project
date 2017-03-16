package dam.riberadeltajo.alber.mens_fervida_videogame.healthyExplorer;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

public class MenuJuego extends AppCompatActivity {
    Juego j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        j=new Juego(this);
       // hideSystemUI();
        setContentView(j);

    }

   /* private void hideSystemUI() {
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            //A partir de kitkat
            j.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                            | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            //cuando se presiona volumen, por ejemplo, se cambia la visibilidad, hay que volver
            //a ocultar
            j.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                @Override
                public void onSystemUiVisibilityChange(int visibility) {
                    hideSystemUI();
                }
            });
        }
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB &&
                Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            // Pre-Jelly Bean, we must manually hide the action bar
            // and use the old window flags API.
            getActionBar().hide();
        }
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }*/

    @Override
    protected void onDestroy() {
        j.fin();
        super.onDestroy();
    }

    public void finalizar(int puntuacion){
        Intent intent=new Intent();
        intent.putExtra("puntuacion",puntuacion);
        setResult(RESULT_OK,intent);
        this.finish();
    }
}
