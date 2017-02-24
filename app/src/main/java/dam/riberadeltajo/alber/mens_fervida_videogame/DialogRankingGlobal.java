package dam.riberadeltajo.alber.mens_fervida_videogame;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alber.mens_fervida_videogame.R;

import dam.riberadeltajo.alber.mens_fervida_videogame.entidades.Jugador;
import dam.riberadeltajo.alber.mens_fervida_videogame.entidades.Puntuacion;

/**
 * Created by PedroMiguel on 01/02/2017.
 */

public class DialogRankingGlobal extends Dialog implements View.OnClickListener{
    private Context mContext;
    private TextView puntuacion[]=new TextView[5];
    private TextView usuarios[]=new TextView[5];
    private int[] avatares={R.drawable.avatar1,R.drawable.avatar2,R.drawable.avatar3,R.drawable.avatar4,R.drawable.avatar5,R.drawable.avatar6,R.drawable.avatar7,R.drawable.avatar8};


    public DialogRankingGlobal(Context context, int themeResId) {
        super(context, themeResId);
        mContext=context;
        quitarFondoRedimensionarEfectos();

    }

    public void quitarFondoRedimensionarEfectos(){
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Display display = ((MenuPrincipal)mContext).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        getWindow().setLayout((int)(size.x*0.9), (int)(size.y*0.7));
        getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN );
        setCanceledOnTouchOutside(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_ranking_global);

        usuarios[0]=(TextView) findViewById(R.id.txt_user1);
        puntuacion[0]=(TextView) findViewById(R.id.txt_punt1);
        usuarios[1]=(TextView) findViewById(R.id.txt_user2);
        puntuacion[1]=(TextView) findViewById(R.id.txt_punt2);
        usuarios[2]=(TextView) findViewById(R.id.txt_user3);
        puntuacion[2]=(TextView) findViewById(R.id.txt_punt3);
        usuarios[3]=(TextView) findViewById(R.id.txt_user4);
        puntuacion[3]=(TextView) findViewById(R.id.txt_punt4);
        usuarios[4]=(TextView) findViewById(R.id.txt_user5);
        puntuacion[4]=(TextView) findViewById(R.id.txt_punt5);
        cargarPuntuacion();


    }

    private void cargarPuntuacion() {
        Puntuacion punt= new Puntuacion();
        String [][] puntuaciones= (String[][]) punt.conseguirPuntuacion();
        for(int i=0;i<puntuaciones.length;i++){
            ((TextView)puntuacion[i]).setText(puntuaciones[i][1]);
            ((TextView)usuarios[i]).setText(puntuaciones[i][0]);
        }
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void onBackPressed() {
        this.dismiss();
    }

    @Override
    public void onClick(View view) {

    }
}
