package com.example.pmdm_2223.UT03.ut03_EjemploDeLista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pmdm_2223.R;

public class Lista extends AppCompatActivity {
    RecyclerView reyclerViewUser;
    Button add;
    PartidoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        reyclerViewUser = (RecyclerView) findViewById(R.id.ut03Lista);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        reyclerViewUser.setLayoutManager(layoutManager);


        adapter = new PartidoAdapter(Partido.generatePartidos(Partido.PAIS_monitor));
        reyclerViewUser.setAdapter(adapter);

        add = findViewById(R.id.ut03BT);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add(Partido.generatePartidos(Partido.PAIS_monitor));
            }
        });
    }
}