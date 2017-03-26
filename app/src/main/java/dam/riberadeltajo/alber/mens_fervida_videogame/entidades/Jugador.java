package dam.riberadeltajo.alber.mens_fervida_videogame.entidades;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import dam.riberadeltajo.alber.mens_fervida_videogame.AvataresAdapter;

/**
 * Created by PedroMiguel on 09/02/2017.
 */

public class Jugador {
    private final String CAMPO_PUNT_MAX="puntMax";
    private final String CAMPO_AVATAR="avatar";
    private final String NIVEL_MAXIMO_ALCANZADO="nivel";
    private final String CAMPO_IDIOMA="idioma";
    private final String CAMPO_NOMBRE="nombre";
    private final String CAMPO_ESTRELLAS="estrellas";
    private final String CAMPO_MUSICA="musicaPlaying";
    public static final int SPANISH=0;
    public static final int POLISH=1;
    public static final int GERMAN=2;
    public static final int FRENCH=3;
    public static final int NO_LANGUAGE=-1;


    private int puntuacion;
    private int puntuacionMax;
    private int nivelMaximoAlcanzado=1;
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
        cargarSharedPreferences();

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
        setPuntuacion(puntuacionMaxSP);
        setNivelMaximoAlcanzado(preferences.getInt(NIVEL_MAXIMO_ALCANZADO, 1));
        String nombreSP=preferences.getString(CAMPO_NOMBRE, "");
        boolean musicaSP=preferences.getBoolean(CAMPO_MUSICA, true);
        int idiomaSP=preferences.getInt(CAMPO_IDIOMA, SPANISH);
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
        editor.putInt(NIVEL_MAXIMO_ALCANZADO, getNivelMaximoAlcanzado());
        editor.putBoolean(CAMPO_MUSICA, isMusicaPlaying());
        editor.putInt(CAMPO_IDIOMA, getIdioma());
        editor.putInt(CAMPO_AVATAR, getAvatar());
        editor.putFloat(CAMPO_ESTRELLAS, getEstrellas());
        editor.commit();
    }



    public String httpParametro(String variable,String valor){
        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary = "*****";

        return twoHyphens+boundary+lineEnd+"Content-Disposition: form-data; name=\""+variable+"\""+ lineEnd+lineEnd+valor+lineEnd+twoHyphens + boundary + twoHyphens + lineEnd;
    }

    private class HighScores extends AsyncTask<Void, Integer, String> {

        public String getFecha(){
            String f;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            f=sdf.format(new Date());
            return f;
        }
        public void uploadHighScore(){

            int serverResponseCode = 0;
            String upLoadServerUri = null;
            HttpURLConnection conn = null;
            DataOutputStream dos = null;
            String lineEnd = "\r\n";
            String twoHyphens = "--";
            String boundary = "*****";
            int bytesRead, bytesAvailable, bufferSize;
            byte[] buffer;
            int maxBufferSize = 1 * 1024 * 1024;
            String reply="";

            AvataresAdapter a=new AvataresAdapter();

            // open a URL connection to the Servlet
            try {
                int drawableId=(int)a.getItemId(getAvatar());
                Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                        "://" + mActivity.getApplicationContext().getResources().getResourcePackageName(drawableId)
                        + '/' + mActivity.getApplicationContext().getResources().getResourceTypeName(drawableId)
                        + '/' + mActivity.getApplicationContext().getResources().getResourceEntryName(drawableId) );

                InputStream is = mActivity.getApplicationContext().getContentResolver().openInputStream(imageUri);
                upLoadServerUri = "http://riberadeltajo.es/mediahub/public_access/scores/index.php";
                URL url = new URL(upLoadServerUri);

                // Open a HTTP  connection to  the URL
                conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true); // Allow Inputs
                conn.setDoOutput(true); // Allow Outputs
                conn.setUseCaches(false); // Don't use a Cached Copy
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Connection", "Keep-Alive");
                conn.setRequestProperty("ENCTYPE", "multipart/form-data");
                conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
                dos = new DataOutputStream(conn.getOutputStream());

                // Los parámetros se envian con formato multipart/form-data:
                // consultad esto: https://www.w3.org/TR/html401/interact/forms.html#h-17.13.4
                dos.writeBytes(httpParametro("user",nombre));
                dos.writeBytes(httpParametro("score",String.valueOf(getPuntuacionMax())));
                dos.writeBytes(httpParametro("country",String.valueOf(getIdioma())));
                dos.writeBytes(httpParametro("date",getFecha()));
                dos.writeBytes(httpParametro("enviar","Enviar"));
                /*--------------------------*/
                /*AQUÍ SE ENVIA LA IMAGEN  -*/
                dos.writeBytes(twoHyphens + boundary + lineEnd);
                dos.writeBytes("Content-Disposition: form-data; name=\"file\";filename=\""
                        + "file" + "\"" + lineEnd);
                dos.writeBytes(lineEnd);
                // create a buffer of  maximum size
                bytesAvailable = is.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                buffer = new byte[bufferSize];
                // read file and write it into form...
                bytesRead = is.read(buffer, 0, bufferSize);
                while (bytesRead > 0) {
                    dos.write(buffer, 0, bufferSize);
                    bytesAvailable = is.available();
                    bufferSize = Math.min(bytesAvailable, maxBufferSize);
                    bytesRead = is.read(buffer, 0, bufferSize);
                }

                dos.writeBytes(lineEnd);
                dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
                /* FIN DE LA IMAGEN */
                /********************/

                // Responses from the server (code and message)
                serverResponseCode = conn.getResponseCode();
                String serverResponseMessage = conn.getResponseMessage();

                Log.i("uploadFile", "HTTP Response is : "
                        + serverResponseMessage + ": " + serverResponseCode);

                if(serverResponseCode == 200){

                    //LEER RESPUESTA DEL SERVIDOR
                    InputStream in = conn.getInputStream();
                    StringBuffer sb = new StringBuffer();
                    try {
                        int chr;
                        while ((chr = in.read()) != -1) {
                            sb.append((char) chr);
                        }
                        reply = sb.toString();

                    } finally {
                        in.close();
                    }
                }

                is.close();dos.flush();dos.close();

            } catch (MalformedURLException ex) {
                ex.printStackTrace();
                Log.e("Upload file to server", "error: " + ex.getMessage(), ex);
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("Upload Exception", "Exception : "  + e.getMessage(), e);
            }
        }
        @Override
        protected String doInBackground(Void... params) {
            uploadHighScore();
            return "ok";
        }

        @Override
        protected void onPostExecute(String respuesta) {
            Toast.makeText(mActivity.getApplicationContext(),"You've set a new high score!",Toast.LENGTH_LONG).show();
        }
    }

    public void newHighScore(){
        new HighScores().execute();
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
    public int getNivelMaximoAlcanzado(){return nivelMaximoAlcanzado;}
    public void setNivelMaximoAlcanzado(int n){
        nivelMaximoAlcanzado=n;
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
        if(idioma==SPANISH || idioma==POLISH || idioma==GERMAN ||idioma==Jugador.FRENCH || idioma==NO_LANGUAGE)
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
