package com.example.alber.mens_fervida_videogame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by PedroMiguel on 01/02/2017.
 */

public class DialogPanelNivelDos extends Dialog implements View.OnClickListener, DialogInterface.OnKeyListener {
    private Context mContext;
    private Activity activity;
    private Button btnPrevius, btn6, btn7, btn8,btn9,btn10;

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
        this.setOnKeyListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_pan_nivel_prev:

                this.dismiss();
               ((MenuNivelesActivity)activity).panel1.show();
                break;
            case R.id.btn_nivel_6:
                btn7.setEnabled(true);
                break;
            case R.id.btn_nivel_7:
                btn8.setEnabled(true);
                break;
            case R.id.btn_nivel_8:
                btn9.setEnabled(true);
                break;
            case R.id.btn_nivel_9:
                btn10.setEnabled(true);
                break;
            case R.id.btn_nivel_10:
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                btn9.setEnabled(false);
                btn10.setEnabled(false);
                break;


        }
    }



    @Override
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == KeyEvent.KEYCODE_BACK) {

           /* this.dismiss();
            ((MenuNivelesActivity)activity).panel1.show();*/
        }
        return true;
    }
}
