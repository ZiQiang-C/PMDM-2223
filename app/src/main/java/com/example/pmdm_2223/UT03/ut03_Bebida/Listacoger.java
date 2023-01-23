package com.example.pmdm_2223.UT03.ut03_Bebida;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.pmdm_2223.R;

import java.util.ArrayList;
import java.util.List;

public class Listacoger extends AppCompatActivity {
    private List<BebidaTable> bebidaTableLista;
    RecyclerView recyclerView;
    BebidaAdapter adapter;
    BebidaTableDataBase db;
    BebidaTableDAO bebidaTableDao;
    Button nuevo;
    ImageView image;
    Uri uriCapturada;
    private BebidaAdapter.RecyclerViewClickListener listener;

    ActivityResultLauncher resultadoLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listacoger);

        recyclerView=(RecyclerView) findViewById(R.id.ut03ListaCogerRecy);
        nuevo=findViewById(R.id.ut03BebidaNuevo);

        //Creo el ArrayList que se utilizara para distintas operaciones
        bebidaTableLista=new ArrayList<>();
        //Oculta la barra
       // getSupportActionBar().hide();

        createDB();
        createRecycler();

        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                envio();
            }
        });
        //Intent principal, intent launcher, recibe todos los intent
        resultadoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result ->{

                    //Codigo que va a recibir los Intents entrantes
                    bebidaTableLista= bebidaTableDao.getAll();
                    adapter = new BebidaAdapter(bebidaTableLista,listener);
                    recyclerView.setAdapter(adapter);
                    //image guarta

                });

    }
    public void envio(){

        Intent intent = new Intent(Listacoger.this,BebidaAnadir.class);
        resultadoLauncher.launch(intent);
    }

    public void createRecycler() {

        //Llama al metodo  ClickListener
        setOnClickListener();



        adapter = new BebidaAdapter(bebidaTableLista,listener);

        //obtiene el layout del dispositivo
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this.getApplicationContext());
        recyclerView.setLayoutManager(LayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Anades el adaptador al dispositivo
        recyclerView.setAdapter(adapter);
    }

    //Metodo que recibe una pulsacion (click) para acceder a otra actividad
    private void setOnClickListener() {
        listener= new BebidaAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent= new Intent(getApplicationContext(),ModListaBebida.class);
                intent.putExtra("nombre",bebidaTableLista.get(position).getNombre());
                intent.putExtra("empresa",bebidaTableLista.get(position).getEmpresa());
                intent.putExtra("img",bebidaTableLista.get(position).getImagen());
                resultadoLauncher.launch(intent);

            }
        };
    }
    //metodo para el base de dato
    public void createDB(){
        //Se crea la base de datos
        db = Room.databaseBuilder(getApplicationContext(),
                BebidaTableDataBase.class, "bebidas").allowMainThreadQueries().build();

        //Extrae los datos de la bd para poder hacer querys
        bebidaTableDao = db.bebidaTableDAO();

        //extr4e el contenido de la bd
        bebidaTableLista= bebidaTableDao.getAll();
    }
}