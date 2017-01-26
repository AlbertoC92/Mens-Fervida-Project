package com.example.alber.mens_fervida_videogame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class AvataresGridView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatares_grid_view);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new AvataresAdapter(this));

/*
Creando una nueva escucha para los elementos del Grid
 */
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(AvataresGridView.this, dialogoOpciones.class);
                i.putExtra("position", position);//Posición del elemento
                startActivity(i);

            }
        });
    }
}
