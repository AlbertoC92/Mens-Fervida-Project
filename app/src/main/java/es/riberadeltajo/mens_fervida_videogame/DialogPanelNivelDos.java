package es.riberadeltajo.mens_fervida_videogame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import es.riberadeltajo.mens_fervida_videogame.R;

/**
 * Created by PedroMiguel on 01/02/2017.
 */

public class DialogPanelNivelDos extends Dialog implements View.OnClickListener{
    private Context mContext;
    private Activity activity;
    public Button btnPrevius, btn6, btn7, btn8,btn9,btn10;

    public DialogPanelNivelDos(Context context, int themeResId, Activity activity) {
        super(context, themeResId);
        mContext=context;
        this.activity=activity;
        quitarFondoRedimensionarEfectos();

    }

    public void quitarFondoRedimensionarEfectos(){
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        getWindow().setLayout((int)(size.x*0.9), (int)(size.y*0.7));
        getWindow().getAttributes().windowAnimations = R.style.PanelNivelDos;
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_niveles2);
        btnPrevius =(Button) findViewById(R.id.btn_pan_nivel_prev);
        btnPrevius.setOnClickListener(this);
        btn6=(Button) findViewById(R.id.btn_nivel_6);
        btn6.setOnClickListener(this);
        btn7=(Button) findViewById(R.id.btn_nivel_7);
        btn7.setOnClickListener(this);
        btn8=(Button) findViewById(R.id.btn_nivel_8);
        btn8.setOnClickListener(this);
        btn9=(Button) findViewById(R.id.btn_nivel_9);
        btn9.setOnClickListener(this);
        btn10=(Button) findViewById(R.id.btn_nivel_10);
        btn10.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.btn_pan_nivel_prev:

                this.dismiss();
               ((MenuNivelesActivity)activity).panel1.show();
                break;
            case R.id.btn_nivel_6:
                i = new Intent(view.getContext(),ActivityPregunta.class);
                i.putExtra("nivel",6);
                ((MenuNivelesActivity)mContext).startActivityForResult(i,MenuNivelesActivity.NIVEL_FINALIZADO);
                this.dismiss();
                break;
            case R.id.btn_nivel_7:
                i = new Intent(view.getContext(),ActivityPregunta.class);
                i.putExtra("nivel",7);
                ((MenuNivelesActivity)mContext).startActivityForResult(i,MenuNivelesActivity.NIVEL_FINALIZADO);
                this.dismiss();
                break;
            case R.id.btn_nivel_8:
                i = new Intent(view.getContext(),ActivityPregunta.class);
                i.putExtra("nivel",8);
                ((MenuNivelesActivity)mContext).startActivityForResult(i,MenuNivelesActivity.NIVEL_FINALIZADO);
                this.dismiss();
                break;
            case R.id.btn_nivel_9:
                i = new Intent(view.getContext(),ActivityPregunta.class);
                i.putExtra("nivel",9);
                ((MenuNivelesActivity)mContext).startActivityForResult(i,MenuNivelesActivity.NIVEL_FINALIZADO);
                this.dismiss();
                break;
            case R.id.btn_nivel_10:
                i = new Intent(view.getContext(),ActivityPregunta.class);
                i.putExtra("nivel",10);
                ((MenuNivelesActivity)mContext).startActivityForResult(i,MenuNivelesActivity.NIVEL_FINALIZADO);
                this.dismiss();
                break;


        }
    }

    @Override
    public void onBackPressed() {
        this.dismiss();
        ((MenuNivelesActivity)mContext).panel1.show();

    }
}
