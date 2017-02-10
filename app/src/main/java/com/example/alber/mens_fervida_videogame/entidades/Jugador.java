package com.example.alber.mens_fervida_videogame.entidades;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by PedroMiguel on 09/02/2017.
 */

public class Jugador {
    private final String CAMPO_PUNT_MAX="puntMax";
    private final String CAMPO_AVATAR="avatar";
    private final String CAMPO_IDIOMA="idioma";
    private final String CAMPO_NOMBRE="nombre";
    private final String CAMPO_ESTRELLAS="estrellas";
    private final String CAMPO_MUSICA="musicaPlaying";
    public static final int SPANISH=0;
    public static final int POLISH=1;
    public static final int GERMAN=2;
    public static final int NO_LANGUAGE=-1;
    private int puntuacion;
    private int puntuacionMax;
    private int avatar;
    private int idioma;
    private String nombre;
    private float estrellas;
    private static Jugador jugador;
    private boolean musicaPlaying;
    private Activity mActivity;
    private SharedPreferences preferences;

    public boolean isMusicaPlaying() {
        return musicaPlaying;
    }

    public void setMusicaPlaying(boolean musica) {
        this.musicaPlaying = musica;
    }

    private Jugador(){
        setPuntuacion(0);
        setMusicaPlaying(true);
        //cargarSharedPreferences();

    }
    private Jugador(Activity activity){
        setPuntuacion(0);
        setMusicaPlaying(true);
        mActivity=activity;
        cargarSharedPreferences();

    }
    public static Jugador getInstance(){
        if(jugador==null){
            jugador=new Jugador();
        }
        return jugador;
    }
    public static Jugador getInstance(Activity activity){
        if(jugador==null){
            jugador=new Jugador(activity);
        }
        return jugador;
    }

    public void cargarSharedPreferences() {
        preferences=mActivity.getSharedPreferences("jugador", Context.MODE_PRIVATE);
        int puntuacionMaxSP=preferences.getInt(CAMPO_PUNT_MAX, 0);
        String nombreSP=preferences.getString(CAMPO_NOMBRE, "");
        boolean musicaSP=preferences.getBoolean(CAMPO_MUSICA, true);
        int idiomaSP=preferences.getInt(CAMPO_IDIOMA, NO_LANGUAGE);
        int avatarSP=preferences.getInt(CAMPO_AVATAR, 0);
        float estrellasSP=preferences.getFloat(CAMPO_ESTRELLAS, 0);
        setPuntuacionMax(puntuacionMaxSP);
        if(!nombreSP.isEmpty()){
            setNombre(nombreSP);
        }
        setMusicaPlaying(musicaSP);
        setIdioma(idiomaSP);
        setAvatar(avatarSP);
        setEstrellas(estrellasSP);

    }

    public void guardarSharedPreferences() {
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString(CAMPO_NOMBRE, getNombre());
        editor.putInt(CAMPO_PUNT_MAX, getPuntuacion());
        editor.putBoolean(CAMPO_MUSICA, isMusicaPlaying());
        editor.putInt(CAMPO_IDIOMA, getIdioma());
        editor.putInt(CAMPO_AVATAR, getAvatar());
        editor.putFloat(CAMPO_ESTRELLAS, getAvatar());
        editor.commit();


    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        if(puntuacion>=0)
            this.puntuacion = puntuacion;
        else
            throw new IllegalArgumentException();
    }

    public int getPuntuacionMax() {
        return puntuacionMax;
    }

    public void setPuntuacionMax(int puntuacionMax) {
        if(puntuacionMax>=0)
            this.puntuacionMax = puntuacionMax;
        else
            throw new IllegalArgumentException();
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        if(avatar==0 ||avatar==0 ||avatar==1 ||avatar==2 ||avatar==3 ||avatar==4 ||avatar==5 ||avatar==6 ||avatar==7)
            this.avatar = avatar;
        else
            throw new IllegalArgumentException();
    }

    public int getIdioma() {
        return idioma;
    }

    public void setIdioma(int idioma) {
        if(idioma==SPANISH || idioma==POLISH || idioma==GERMAN || idioma==NO_LANGUAGE)
            this.idioma = idioma;
        else
            throw new IllegalArgumentException();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(!nombre.isEmpty())
            this.nombre = nombre;
        else
            throw new IllegalArgumentException();
    }

    public float getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(float estrellas) {
        if(estrellas>=0)
            this.estrellas = estrellas;
        else
            throw new IllegalArgumentException();
    }


}
