package com.example.alber.mens_fervida_videogame.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by PedroMiguel on 09/02/2017.
 */

public class IdiomasSQLiteOpenHelper extends SQLiteOpenHelper {
    public static final String NOMBRE_ARCHIVO_SQL = "bd.sql";
    Context context;
    private static IdiomasSQLiteOpenHelper conexion;
    private static final int versionBD=12;
    private static final String nombreBD="languages.db";

    private IdiomasSQLiteOpenHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(context, nombre, factory, version);
        this.context=context;

    }

    public static IdiomasSQLiteOpenHelper getInstance(Context context){
        if(conexion==null){
            conexion=new IdiomasSQLiteOpenHelper(context.getApplicationContext(), nombreBD, null, versionBD);
        }
        return conexion;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String[]sentencias=cargarDatosArchivoSQL();
        System.out.println(sentencias.length);
        for(int i=0; i<sentencias.length-1;i++){
            System.out.print(String.format("%s;",sentencias[i]));
            sqLiteDatabase.execSQL(String.format("%s;",sentencias[i]));
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String[]sentencias=cargarDatosArchivoSQL();
        for(int j=0; j<sentencias.length-1;j++){
            sqLiteDatabase.execSQL(String.format("%s;",sentencias[i]));
        }
    }

    public String[] cargarDatosArchivoSQL(){
        String salida="";
        try{

            BufferedReader bdFichero=new BufferedReader(new InputStreamReader(context.getAssets().open("bd.sql")));
            String nuevaLn;
            while((nuevaLn=bdFichero.readLine())!=null){
                salida=String.format("%s%s\n", salida, nuevaLn);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
        return salida.split(";");
    }
}
