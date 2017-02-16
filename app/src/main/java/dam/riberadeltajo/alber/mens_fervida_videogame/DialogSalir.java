package dam.riberadeltajo.alber.mens_fervida_videogame;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.alber.mens_fervida_videogame.R;

/**
 * Created by PedroMiguel on 01/02/2017.
 */

public class DialogSalir extends Dialog implements View.OnClickListener{
    private Context mContext;
    private Button btnOk, btnCancel;


    public DialogSalir(Context context, int themeResId) {
        super(context, themeResId);
        mContext=context;
        quitarFondoRedimensionarEfectos();

    }

    public void quitarFondoRedimensionarEfectos(){
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Display display = ((MenuNivelesActivity)mContext).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        getWindow().setLayout((int)(size.x*0.9), (int)(size.y*0.7));
        getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_salir);
        btnOk=(Button)findViewById(R.id.btn_salir_aceptar);
        btnOk.setOnClickListener(this);
        btnCancel=(Button)findViewById(R.id.btn_salir_cancelar);
        btnCancel.setOnClickListener(this);

    }



    @Override
    public void dismiss() {
        super.dismiss();

    }



    @Override
    public void onBackPressed() {
        this.dismiss();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_salir_aceptar:
                ((MenuNivelesActivity)mContext).finish();
                this.dismiss();

                break;
            case R.id.btn_salir_cancelar:
                this.dismiss();
                ((MenuNivelesActivity)mContext).onResume();
                break;
        }

    }
}
