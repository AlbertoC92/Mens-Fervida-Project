package es.riberadeltajo.mens_fervida_videogame;

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

import es.riberadeltajo.mens_fervida_videogame.R;

import es.riberadeltajo.mens_fervida_videogame.entidades.Jugador;

/**
 * Created by PedroMiguel on 01/02/2017.
 */

public class DialogRankingInd extends Dialog implements View.OnClickListener{
    private Context mContext;
    private Dialog dialogRankGlob;
    private TextView puntuacionMax, estrellas;
    private LinearLayout avatar;
    private Button btRankGlobal;
    private int[] avatares={R.drawable.avatar1,R.drawable.avatar2,R.drawable.avatar3,R.drawable.avatar4,R.drawable.avatar5,R.drawable.avatar6,R.drawable.avatar7,R.drawable.avatar8};


    public DialogRankingInd(Context context, int themeResId) {
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
        setContentView(R.layout.layout_ranking_ind);
        avatar=(LinearLayout)findViewById(R.id.img_rank);
        estrellas=(TextView)findViewById(R.id.txt_estrellas_rank_ind);

        puntuacionMax =(TextView)findViewById(R.id.txt_puntmax_rank_ind);
        btRankGlobal=(Button) findViewById(R.id.btn_rank_global);
        btRankGlobal.setOnClickListener(this);
        btRankGlobal.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/chewy.ttf"));
    }

    private void cargarImagen() {
        avatar.setBackground(getContext().getDrawable(avatares[Jugador.getInstance().getAvatar()]));
    }

    @Override
    public void show() {
        super.show();
        estrellas.setText(String.format("%.1f",Jugador.getInstance().getEstrellas()));
        puntuacionMax.setText(String.format("%d",Jugador.getInstance().getPuntuacionMax()));
        cargarImagen();
    }

    @Override
    public void onBackPressed() {
        this.dismiss();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_rank_global:
                if(dialogRankGlob==null)
                    dialogRankGlob=new DialogRankingGlobal(mContext, R.style.AppTheme);
                dialogRankGlob.show();
                break;
        }
    }
}
