package com.example.alber.mens_fervida_videogame.entidades;

/**
 * Created by PedroMiguel on 09/02/2017.
 */

public class Jugador {
    private int puntuacion;
    private int puntuacionMax;
    private int avatar;
    private int idioma;
    private String nombre;
    private float estrellas;
    private static Jugador jugador;

    private Jugador(){
        setPuntuacion(1);
        //cargarSharedPreferences();

    }
    public static Jugador getInstance(){
        if(jugador==null){
            jugador=new Jugador();
        }
        return jugador;
    }

    private void cargarSharedPreferences() {

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
        if(idioma==0 || idioma==1 || idioma==2)
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
