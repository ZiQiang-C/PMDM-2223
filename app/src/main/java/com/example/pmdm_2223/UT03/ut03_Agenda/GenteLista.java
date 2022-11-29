package com.example.pmdm_2223.UT03.ut03_Agenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pmdm_2223.R;

import java.util.ArrayList;
import java.util.List;

public class GenteLista extends AppCompatActivity {
    RecyclerView reyclerViewUser;
    Button nuevo;
    ListaAdapter adapter;
    GenteDAO genteDAO;
    GenteDataBase db;
    private ArrayList<GenteM> GenteSolos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gente_lista);
        Intent i =new Intent();
        GenteSolos=new ArrayList<>();
        createORM()  ;
        nuevo=findViewById(R.id.ut03agendaListaNuevo);


        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar();
            }
        });

    }
    public  void mostrar(){
        Intent toda=new Intent(this, Agenda.class);


        startActivity(toda);

    }
    public  void createORM () {

        db = Room.databaseBuilder(getApplicationContext(),
                GenteDataBase.class, "gentes").allowMainThreadQueries().build();

        genteDAO=db.genteDAO();

        List<Gente> gente =genteDAO.getAll();
        for (Gente a : gente){
            GenteSolos.add(new GenteM(a.nombre,a.telef));
        }
        createRecycler();
    }
    public void createRecycler(){
        //Crea el ArrayList, obtiene el id del Recycler, obtiene el layout del dispositivo
        reyclerViewUser = (RecyclerView) findViewById(R.id.ut03agendaLista);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        reyclerViewUser.setLayoutManager(layoutManager);
        //Se envia el ArrayList de las comidas
        adapter = new ListaAdapter(GenteSolos);
        //Anades el adaptador al dispositivo
       reyclerViewUser.setAdapter(adapter);
    }
}