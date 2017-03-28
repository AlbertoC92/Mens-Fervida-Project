package es.riberadeltajo.mens_fervida_videogame.entidades;

import es.riberadeltajo.mens_fervida_videogame.R;

import java.util.Hashtable;

/**
 * Created by PedroMiguel on 23/02/2017.
 */

public class Imagen {
    public Hashtable<String, Integer> imagenes;
    private static Imagen imagen;
    private Imagen(){
        imagenes = new Hashtable<String, Integer>();
        cargarImagenes();
    }

    public static int obtenerImagen(String clave){
        if(imagen==null){
            imagen=new Imagen();
        }

        return imagen.imagenes.get(clave);
    }
    private void cargarImagenes(){
        imagenes.put("SIEVE", R.drawable.sieve);
        imagenes.put("PEELER", R.drawable.peeler);
        imagenes.put("GRATER", R.drawable.sieve);
        imagenes.put("WHISK", R.drawable.sieve);
        imagenes.put("baking pan".toUpperCase(), R.drawable.bakingpan);
        imagenes.put("ladle".toUpperCase(), R.drawable.ladle);
        imagenes.put("jug".toUpperCase(), R.drawable.jug);
        imagenes.put("tray".toUpperCase(), R.drawable.tray);
        imagenes.put("mincer".toUpperCase(), R.drawable.mincer);
        imagenes.put("masher".toUpperCase(), R.drawable.masher);
        imagenes.put("pie slice".toUpperCase(), R.drawable.pieslice);
        imagenes.put("drainer".toUpperCase(), R.drawable.drainer);
        imagenes.put("corkscrew".toUpperCase(), R.drawable.corkscrew);
        imagenes.put("mortar and pestle".toUpperCase(), R.drawable.mortarandpestle);
        imagenes.put("colander".toUpperCase(), R.drawable.colander);
        imagenes.put("hob".toUpperCase(), R.drawable.hob);
        imagenes.put("oven".toUpperCase(), R.drawable.oven);
        imagenes.put("scales".toUpperCase(), R.drawable.scales);
        imagenes.put("rolling pin".toUpperCase(), R.drawable.rollingpin);
        imagenes.put("steel".toUpperCase(), R.drawable.steel);
        imagenes.put("Boxing".toUpperCase(), R.drawable.boxing);
        imagenes.put("American Football".toUpperCase(), R.drawable.americanfootball);
        imagenes.put("Football".toUpperCase(), R.drawable.football);
        imagenes.put("Chequered Flag".toUpperCase(), R.drawable.chequeredfalg);
        imagenes.put("Volley shot".toUpperCase(), R.drawable.volleyshot);
        imagenes.put("Mountain bike".toUpperCase(), R.drawable.mountainbike);
        imagenes.put("Racquet".toUpperCase(), R.drawable.racquet);
        imagenes.put("Hockey".toUpperCase(), R.drawable.hockey);
        imagenes.put("Swimming".toUpperCase(), R.drawable.swimming);
        imagenes.put("Scuba diving".toUpperCase(), R.drawable.scubadiving);

    }
}
