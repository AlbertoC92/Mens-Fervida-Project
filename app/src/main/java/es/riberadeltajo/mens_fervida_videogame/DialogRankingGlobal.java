package es.riberadeltajo.mens_fervida_videogame;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import es.riberadeltajo.mens_fervida_videogame.R;

import es.riberadeltajo.mens_fervida_videogame.entidades.Puntuacion;

/**
 * Created by PedroMiguel on 01/02/2017.
 */

public class DialogRankingGlobal extends Dialog implements View.OnClickListener{
    private Context mContext;
    private TextView puntuacion[]=new TextView[5];
    private TextView usuarios[]=new TextView[5];
    private ImageView paisesImagenes[]=new ImageView[5];
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
        paisesImagenes[0]=(ImageView) findViewById(R.id.ima_pos1_1);

        usuarios[1]=(TextView) findViewById(R.id.txt_user2);
        puntuacion[1]=(TextView) findViewById(R.id.txt_punt2);
        paisesImagenes[1]=(ImageView) findViewById(R.id.ima_pos2_2);

        usuarios[2]=(TextView) findViewById(R.id.txt_user3);
        puntuacion[2]=(TextView) findViewById(R.id.txt_punt3);
        paisesImagenes[2]=(ImageView) findViewById(R.id.ima_pos3_3);

        usuarios[3]=(TextView) findViewById(R.id.txt_user4);
        puntuacion[3]=(TextView) findViewById(R.id.txt_punt4);
        paisesImagenes[3]=(ImageView) findViewById(R.id.ima_pos4_4);

        usuarios[4]=(TextView) findViewById(R.id.txt_user5);
        puntuacion[4]=(TextView) findViewById(R.id.txt_punt5);
        paisesImagenes[4]=(ImageView) findViewById(R.id.ima_pos5_5);

        cargarPuntuacion();


    }

    private void cargarPuntuacion() {
        Puntuacion punt= new Puntuacion();
        String [][] puntuaciones= (String[][]) punt.conseguirPuntuacion();
        if(puntuaciones!=null){
            for(int i=0;i<puntuaciones.length;i++){
                ((TextView)usuarios[i]).setText(puntuaciones[i][0]);
                ((TextView)puntuacion[i]).setText(puntuaciones[i][1]);
                cargarImagen(i, puntuaciones[i][4]);
            }
        }

    }

    private void cargarImagen(int i, String s) {
        switch (s){
            case "0":
                paisesImagenes[i].setBackground(getContext().getDrawable(R.drawable.es));
                break;
            case "1":
                paisesImagenes[i].setBackground(getContext().getDrawable(R.drawable.pl));
                break;
            case "2":
                paisesImagenes[i].setBackground(getContext().getDrawable(R.drawable.de));
                break;
            case "3":
                paisesImagenes[i].setBackground(getContext().getDrawable(R.drawable.fr));
                break;
            default:
                paisesImagenes[i].setBackground(null);
                break;
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
