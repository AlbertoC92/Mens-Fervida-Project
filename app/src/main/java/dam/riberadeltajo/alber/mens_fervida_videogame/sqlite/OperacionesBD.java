package dam.riberadeltajo.alber.mens_fervida_videogame.sqlite;

import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import dam.riberadeltajo.alber.mens_fervida_videogame.entidades.Jugador;

/**
 * Created by PedroMiguel on 09/02/2017.
 */

public class OperacionesBD {
    public static int nivelJuegoAnterior=0;
    public static int numImagenesNivel=0;
    public static int numPalabrasNivel=0;
    static ArrayList<Integer> aleatoriosPalabras = new ArrayList<Integer>();
    static int UltimoAleatorioPalabras=0;
    static ArrayList<Integer> aleatoriosImagenes = new ArrayList<Integer>();
    static int UltimoAleatorioImagenes=0;
    static Cursor cursorImagenes=null;
    static Cursor cursorPalabras=null;
    public static String[] cargarPregunta(int idioma, int nivelJuego){


        SQLiteDatabase db = IdiomasSQLiteOpenHelper.getInstance(null).getReadableDatabase();

        int nivelPalbra=1;
        if(nivelJuego%2==0){
            nivelPalbra=nivelJuego/2;
        }
        else{
            nivelPalbra=nivelJuego/2+1;
        }
        String args[]={String.valueOf(nivelPalbra)};

        if(nivelJuegoAnterior!=nivelPalbra ) {
            nivelJuegoAnterior=nivelPalbra ;
            String filtro="";
            switch (idioma){
                case Jugador.SPANISH:
                    filtro="SPANISH";
                    break;
                case Jugador.POLISH:
                    filtro="POLISH";
                    break;
                case Jugador.GERMAN:
                    filtro="GERMAN";
                    break;
                case Jugador.FRENCH:
                    filtro="FRENCH";
                    break;
                case Jugador.NO_LANGUAGE:
                    filtro="IMAGES";
                    break;
            }
            cursorPalabras= db.rawQuery("SELECT rowid _id, * FROM "+filtro+" WHERE NIVEL=?;", args);
            cursorImagenes= db.rawQuery("SELECT rowid _id, * FROM IMAGES WHERE NIVEL=?;", args);
            numPalabrasNivel=cursorPalabras.getCount();
            numImagenesNivel=cursorImagenes.getCount();
            Log.i("MFCS","Nivel"+nivelPalbra+" Numero de palabras:"+numPalabrasNivel);
            Log.i("MFCS","Nivel"+nivelPalbra+" Numero de imagenes"+numImagenesNivel);
            for (int i = 0; i < numPalabrasNivel; ++i) aleatoriosPalabras.add(i);
            Collections.shuffle(aleatoriosPalabras);
            for (int i = 0; i < numImagenesNivel; ++i) aleatoriosImagenes.add(i);
            Collections.shuffle(aleatoriosImagenes);
        }


        switch (idioma){

            case Jugador.NO_LANGUAGE:
                int aleatI=aleatoriosImagenes.get(UltimoAleatorioImagenes);
                UltimoAleatorioImagenes++;
                if(UltimoAleatorioImagenes>=numPalabrasNivel-1){
                    Collections.shuffle(aleatoriosImagenes);
                    UltimoAleatorioImagenes=0;
                }
                cursorImagenes.moveToPosition(aleatI);
                return new String[]{cursorImagenes.getString(1), cursorImagenes.getString(2), cursorImagenes.getString(3), cursorImagenes.getString(4), cursorImagenes.getString(5), cursorImagenes.getString(6)};

            default: //POLISH, SPANISH, etc
                int aleat=aleatoriosPalabras.get(UltimoAleatorioPalabras);
                UltimoAleatorioPalabras++;
                if(UltimoAleatorioPalabras>=numPalabrasNivel-1){
                    Collections.shuffle(aleatoriosPalabras);
                    UltimoAleatorioPalabras=0;
                }
                cursorPalabras.moveToPosition(aleat);
                return new String[]{cursorPalabras.getString(1), cursorPalabras.getString(2), cursorPalabras.getString(3), cursorPalabras.getString(4), cursorPalabras.getString(5), cursorPalabras.getString(6)};
        }


    }
}
