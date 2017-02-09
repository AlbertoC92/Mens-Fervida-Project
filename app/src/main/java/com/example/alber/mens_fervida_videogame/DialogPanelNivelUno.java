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
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by PedroMiguel on 01/02/2017.
 */

public class DialogPanelNivelUno extends Dialog implements View.OnClickListener, DialogInterface.OnKeyListener {
    private Context mContext;
    private Activity activity;
    private Button btnSiguiente, btn1, btn2, btn3,btn4,btn5;

    public DialogPanelNivelUno(Context context, int themeResId, Activity activity) {
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
        getWindow().getAttributes().windowAnimations = R.style.PanelNivelUno;
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_niveles1);
        btnSiguiente=(Button) findViewById(R.id.btn_pn_nv1);
        btnSiguiente.setOnClickListener(this);
        btn1=(Button) findViewById(R.id.btn_nivel_1);
        btn1.setOnClickListener(this);
        btn2=(Button) findViewById(R.id.btn_nivel_2);
        btn2.setOnClickListener(this);
        btn3=(Button) findViewById(R.id.btn_nivel_3);
        btn3.setOnClickListener(this);
        btn4=(Button) findViewById(R.id.btn_nivel_4);
        btn4.setOnClickListener(this);
        btn5=(Button) findViewById(R.id.btn_nivel_5);
        btn5.setOnClickListener(this);
        this.setOnKeyListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_pn_nv1:
                ((MenuNivelesActivity)activity).panel2.show();
                this.dismiss();
                break;
            case R.id.btn_nivel_1:
                btn2.setEnabled(true);
                break;
            case R.id.btn_nivel_2:
                btn3.setEnabled(true);
                break;
            case R.id.btn_nivel_3:
                btn4.setEnabled(true);
                break;
            case R.id.btn_nivel_4:
                btn5.setEnabled(true);
                break;
            case R.id.btn_nivel_5:
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                break;


        }
    }



    @Override
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == KeyEvent.KEYCODE_BACK) {
            /*if(this.isShowing()) {
                activity.finish();
                this.dismiss();
            }*/
        }
        return true;
    }
}
