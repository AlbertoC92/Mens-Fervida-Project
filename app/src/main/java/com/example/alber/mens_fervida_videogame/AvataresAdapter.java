package com.example.alber.mens_fervida_videogame;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alber on 26/01/2017.
 */

public class AvataresAdapter extends BaseAdapter {
    private Context mContext;
    private Activity actividad;
    ImageView imageView;

    private Integer[] caracteres = {
            R.drawable.avatar1,R.drawable.avatar2, R.drawable.avatar3,
            R.drawable.avatar4,R.drawable.avatar5, R.drawable.avatar6,
            R.drawable.avatar7,R.drawable.avatar8
    };

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public Activity getActividad() {
        return actividad;
    }

    public void setActividad(Activity actividad) {
        this.actividad = actividad;
    }

    public Integer[] getCaracteres() {
        return caracteres;
    }

    public void setCaracteres(Integer[] caracteres) {
        this.caracteres = caracteres;
    }

    public AvataresAdapter(Context c) {
        mContext = c;

    }
    @Override
    public int getCount() {
        return caracteres.length;
    }

    @Override
    public Object getItem(int position) {
        imageView.setImageResource(caracteres[position]);
        return imageView;
    }


    @Override
    public long getItemId(int position) {

        return caracteres[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {

            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(((int)(parent.getWidth()/2.3)),(int)(parent.getWidth()/2)));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }


        imageView.setImageResource(caracteres[position]);
        return imageView;

        /*View vi=convertView;
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater) actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi=inflater.inflate(R.layout.avatares_adaptador,null);
        }

            ImageView image=(ImageView)vi.findViewById(R.id.avatar);
            image.setImageResource(caracteres[position]);







        return vi;*/

    }
}
