package es.riberadeltajo.mens_fervida_videogame.entidades;

import es.riberadeltajo.mens_fervida_videogame.sqlite.OperacionesBD;

/**
 * Created by PedroMiguel on 09/02/2017.
 */

public class Pregunta {
    public static final String NO_LEVEL = "No existe el nivel con ese número";
    public static final String ERROR_TRANSLATE = "La traduccion 1 no puede estar vacia";
    public static final String ERROR_TIPO = "El Tipo no puede estar vacío";
    public static final String ERROR_WORD = "La palabra en inglés no puede estar vacía";
    private String idiomaTabla="SPANISH";
    private String word;
    private String tl1;
    private String tl2;
    private String tl3;
    private int nivel;
    private String tipo;

    public Pregunta(int nivelJuego, String[] valoresPregunta){
        setWord(valoresPregunta[0]);
        setTl1(valoresPregunta[1]);
        setTl2(valoresPregunta[2]);
        setTl3(valoresPregunta[3]);
        setNivel(Integer.parseInt(valoresPregunta[4]));
        setTipo(valoresPregunta[5]);

    }
    public Pregunta(int idioma, int nivelJuego){
        this(nivelJuego, OperacionesBD.cargarPregunta(idioma,nivelJuego));

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        if(!word.isEmpty())
            this.word = word.toUpperCase();
        else
            throw new IllegalArgumentException(ERROR_WORD);
    }

    public String getTl1() {
        return tl1;
    }

    public void setTl1(String tl1) {
        if(!tl1.isEmpty()){
            this.tl1 = tl1.toUpperCase();
        }
        else{
            throw new IllegalArgumentException(ERROR_TRANSLATE);
        }
    }

    public String getTl2() {
        return tl2;
    }

    public void setTl2(String tl2) {
        if(!tl2.isEmpty()){
            this.tl2 = tl2.toUpperCase();
        }else{
            this.tl2=null;
        }
    }

    public String getTl3() {
        return tl3;
    }

    public void setTl3(String tl3) {
        if(!tl3.isEmpty()){
            this.tl3 = tl3.toUpperCase();
        }else{
            this.tl3=null;
        }
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if(nivel==1 || nivel==2 ||nivel==3 ||nivel==4 ||nivel==5){
            this.nivel = nivel;
        }
        else{
            throw new IllegalArgumentException(NO_LEVEL);
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if(!tipo.isEmpty()) {
            this.tipo = tipo.toUpperCase();
        }
        else
            throw new IllegalArgumentException(ERROR_TIPO);

    }

    public String[] getOtherWordsEnglish(){
        String [] conjuntoPalabras=new String[4];
        conjuntoPalabras[0]=getWord();
        for (int i=1;i<4;i++){
            conjuntoPalabras[i]=OperacionesBD.cargarPregunta(Jugador.getInstance().getIdioma(), getNivel())[0];
        }
        return conjuntoPalabras;
    }
    public String[] getOtherWordsYourLanguage(){
        String [] conjuntoPalabras=new String[4];
        conjuntoPalabras[0]=getTl1();
        for (int i=1;i<4;i++){
            conjuntoPalabras[i]=OperacionesBD.cargarPregunta(Jugador.getInstance().getIdioma(), getNivel())[1];
        }
        return conjuntoPalabras;
    }

    @Override
    public String toString() {
        return String.format("WORD: %s, TL1: %s, TL2: %s, TL3: %s, NIVEL: %d, TIPO: %s",getWord(), getTl1(), getTl2(), getTl3(), getNivel(), getTipo() );

    }
}
