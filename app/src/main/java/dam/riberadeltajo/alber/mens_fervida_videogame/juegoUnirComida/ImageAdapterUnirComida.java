package dam.riberadeltajo.alber.mens_fervida_videogame.juegoUnirComida;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.alber.mens_fervida_videogame.R;

import java.util.ArrayList;


public class ImageAdapterUnirComida extends BaseAdapter {
    private Context mContext;
    private ArrayList<Bitmap> bmpDisponibles;
    private ArrayList<Bitmap> imagenesIniciales;
    private Bitmap bmp;
    private int enlaces;
    private int ancho;
    private int alto;

    public ImageAdapterUnirComida(Context c, int ancho, int alto) {
        mContext = c;
        bmpDisponibles=new ArrayList<Bitmap>();
        initBmpDisponibles();
        imagenesIniciales=new ArrayList<Bitmap>();
        initImagenesIniciales();
        enlaces=0;
        this.ancho=ancho;
        this.alto=alto;
    }



    public int getCount() {
        return imagenesIniciales.size();
    }

    public Object getItem(int position) {
        return imagenesIniciales.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        enlaces=0;
        ImageView imageView;
        if (convertView == null) {

            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(ancho/8, alto/15));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 0, 0);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageBitmap(imagenesIniciales.get(position));
        return imageView;
    }
    private void initBmpDisponibles() {
        bmp= BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.hamburguesa);
        bmpDisponibles.add(0,bmp);
        bmp= BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.kebab);
        bmpDisponibles.add(1,bmp);
        bmp= BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.perrito);
        bmpDisponibles.add(2,bmp);
        bmp= BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.platano);
        bmpDisponibles.add(3,bmp);
        bmp= BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.tomate);
        bmpDisponibles.add(4,bmp);
        bmp= BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.uvas);
        bmpDisponibles.add(5,bmp);
        bmp= BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.zanahoria);
        bmpDisponibles.add(6,bmp);


    }

    public void initImagenesIniciales(){
        for(int i=0;i<80;i++){
            imagenesIniciales.add(bmpDisponibles.get((int)(Math.random()*7)));
        }
    }

    public int borrarElemento(int position){



        if(position-8>=0 && getItem(position)==getItem(position-8)){
            enlaces++;
            imagenesIniciales.remove(position-8);
            if(position>0){
                position--;
            }

        }
        if(position-1>=0 && getItem(position)==getItem(position-1)){
            enlaces++;
            imagenesIniciales.remove(position-1);
            if(position>0){
                position--;
            }
        }
        if(position+1<=imagenesIniciales.size()-1 && getItem(position)==getItem(position+1)){
            enlaces++;
            imagenesIniciales.remove(position+1);
            if(position>0){
                position--;
            }
        }
        if(position+8<=imagenesIniciales.size()-1 && getItem(position)==getItem(position+8)){
            enlaces++;
            imagenesIniciales.remove(position+8);
            if(position>0){
                position--;
            }
        }
        imagenesIniciales.remove(position);
        return enlaces;
    }

    public ArrayList<Bitmap> getBmpDisponibles(){
        return bmpDisponibles;
    }

    public boolean noMasPlatano(){
        boolean acabado=false;

        for(int i=0;i<imagenesIniciales.size();i++){
            if(imagenesIniciales.get(i) != getBmpDisponibles().get(3) ){
                acabado = true;
            }else{
                acabado = false;
            }
        }
        return acabado;
    }

    public boolean noMasTomate(){
        boolean acabado=false;

        for(int i=0;i<imagenesIniciales.size();i++){
            if(imagenesIniciales.get(i) != getBmpDisponibles().get(4) ){
                acabado = true;
            }else{
                acabado = false;
            }
        }
        return acabado;
    }

    public boolean noMasUvas(){
        boolean acabado=false;

        for(int i=0;i<imagenesIniciales.size();i++){
            if(imagenesIniciales.get(i) != getBmpDisponibles().get(5) ){
                acabado = true;
            }else{
                acabado = false;
            }
        }
        return acabado;
    }
    public boolean noMasZanahorias(){
        boolean acabado=false;

        for(int i=0;i<imagenesIniciales.size();i++){
            if(imagenesIniciales.get(i) != getBmpDisponibles().get(6) ){
                acabado = true;
            }else{
                acabado = false;
            }
        }
        return acabado;
    }

    public boolean noMasComidaSana(){
        boolean acabado=false;


            if(noMasPlatano() && noMasTomate() && noMasUvas() && noMasZanahorias() ){
                acabado = true;
            }else{
                acabado = false;
            }

        return acabado;
    }
}