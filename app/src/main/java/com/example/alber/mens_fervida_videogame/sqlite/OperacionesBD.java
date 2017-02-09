package com.example.alber.mens_fervida_videogame.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alber.mens_fervida_videogame.entidades.Pregunta;

/**
 * Created by PedroMiguel on 09/02/2017.
 */

public class OperacionesBD {
    public static String[] cargarPregunta(int nivelJuego){
        int nivelPalbra=1;
        if(nivelJuego%2==0){
            nivelPalbra=nivelJuego/2;
        }
        else{
            nivelPalbra=nivelJuego/2+1;
        }
        String args[]={String.valueOf(nivelPalbra)};
        SQLiteDatabase db =IdiomasSQLiteOpenHelper.getInstance(null).getReadableDatabase();
        Cursor curso= db.rawQuery("SELECT rowid _id, * FROM SPANISH WHERE NIVEL=? ORDER BY RANDOM() LIMIT 1;", args);
        curso.moveToFirst();
        return new String[]{curso.getString(1), curso.getString(2), curso.getString(3), curso.getString(4), curso.getString(5), curso.getString(6)};
    }
}
