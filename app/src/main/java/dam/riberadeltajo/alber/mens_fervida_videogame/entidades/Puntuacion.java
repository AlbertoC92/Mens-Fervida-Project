package dam.riberadeltajo.alber.mens_fervida_videogame.entidades;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import dam.riberadeltajo.alber.mens_fervida_videogame.Conexion;

/**
 * Created by PedroMiguel on 24/02/2017.
 */

public class Puntuacion {
    public Object[][] conseguirPuntuacion(){
        String json = null;
        String[][] devolver=null;
        Conexion con =new Conexion();
        try {
            json=con.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {

            JSONArray arr = new JSONArray(json);
            devolver=new String[arr.length()][5];
            for (int i = 0; i < arr.length(); i++)
            {
                devolver[(arr.length()-1)-i][0]=arr.getJSONObject(i).getString("user");
                devolver[(arr.length()-1)-i][1]=arr.getJSONObject(i).getString("score");
                devolver[(arr.length()-1)-i][2]=arr.getJSONObject(i).getString("date");
                devolver[(arr.length()-1)-i][3]=arr.getJSONObject(i).getString("img_url");
                devolver[(arr.length()-1)-i][4]=arr.getJSONObject(i).getString("country");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return devolver;
    }
}
