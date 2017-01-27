package com.example.alber.mens_fervida_videogame;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by alber on 26/01/2017.
 */

public class AvataresAdapter extends BaseAdapter {
    private Context mContext;

    private Integer[] caracteres = {
            R.drawable.avatar1,R.drawable.avatar2, R.drawable.avatar3,
            R.drawable.avatar4,R.drawable.avatar5, R.drawable.avatar6,
            R.drawable.avatar7,R.drawable.avatar8
    };
    public AvataresAdapter(Context c) {
        mContext = c;

    }
    @Override
    public int getCount() {
        return caracteres.length;
    }

    @Override
    public Object getItem(int position) {
        ImageView imageView= new ImageView(mContext.getApplicationContext());
        imageView.setImageResource(caracteres[position]);
        return imageView;
    }

    @Override
    public long getItemId(int position) {

        return caracteres[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            /*
            Crear un nuevo Image View de 90x90
            y con recorte alrededor del centro
             */
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(150,150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        //Setear la imagen desde el recurso drawable
        imageView.setImageResource(caracteres[position]);
        return imageView;

    }
}
