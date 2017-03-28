package es.riberadeltajo.mens_fervida_videogame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import es.riberadeltajo.mens_fervida_videogame.R;


/**
 * Created by alber on 15/02/2017.
 */

public class DialogoCreditos extends Dialog implements View.OnClickListener{


    private Context mContext;
    private Button volver,siguiente;


    public DialogoCreditos(Activity context, int themeResId) {
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
        setContentView(R.layout.dialog_creditos1);
        volver = (Button)findViewById(R.id.btnback);
        volver.setOnClickListener(this);
        siguiente =(Button)findViewById(R.id.btnadelante);
        siguiente.setOnClickListener(this);

    }

    @Override
    public void dismiss() {
        super.dismiss();
        ((MenuPrincipal)mContext).onResume();
    }



    @Override
    public void onBackPressed() {
        this.dismiss();
    }

    @Override
    public void onClick(View view) {

       switch(view.getId()){
           case R.id.btnback:
               this.dismiss();
               break;
           case R.id.btnadelante:
            new DialogoCreditos2((Activity) mContext,R.style.AppTheme).show();
               break;
       }
    }

}
