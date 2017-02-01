package com.example.alber.mens_fervida_videogame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class DialogoCompartir extends Dialog {
    private Context context;
    private Activity activity;
    private Button btnfa,btngo,btntw;
    private TextView txtfa,txtgo,txttw;



    public DialogoCompartir(Context context, int themeResId, Activity activity) {
        super(context,themeResId);
        this.context=context;
        this.activity=activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_social);
        btnfa=(Button)findViewById(R.id.btnfa);
        btntw=(Button)findViewById(R.id.btntw);
        btngo=(Button)findViewById(R.id.btngo);
        txtfa=(TextView)findViewById(R.id.txtfa);
        txtfa.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/chewy.ttf"));
        txttw=(TextView)findViewById(R.id.txttw);
        txttw.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/chewy.ttf"));
        txtgo=(TextView)findViewById(R.id.txtgo);
        txtgo.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/chewy.ttf"));
        quitarFondoRedimensionar();
        setOnclick();
    }

    public void quitarFondoRedimensionar(){
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        getWindow().setLayout((int)(size.x*0.7), (int)(size.y*0.7));
        getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN );
        setCanceledOnTouchOutside(true);
    }

    public void setOnclick(){
        btnfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.facebook.com/profile.php?id=100010632495177&fref=ts");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });
        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.youtube.com/channel/UC-FAUFolrQ_3cZkZds3IXZw");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });
        btntw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://twitter.com/MensFervidaSp?lang=es");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });
    }

}
