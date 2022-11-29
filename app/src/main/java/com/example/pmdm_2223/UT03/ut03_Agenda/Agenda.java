package com.example.pmdm_2223.UT03.ut03_Agenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm_2223.R;

import java.util.ArrayList;
import java.util.List;

public class Agenda extends AppCompatActivity {
    Button andir,modif,delete,lista;
    EditText nombre,telef;
    GenteDAO genteDAO;
    GenteDataBase db;
    TextView ver;
    public static String CLAVE_GENTE ="";
    private ArrayList<GenteM> GenteSolos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        andir=findViewById(R.id.ut03agendaAnadir);
        modif=findViewById(R.id.ut03agendaModi);
        delete=findViewById(R.id.ut03agendaDelete);
        lista=findViewById(R.id.ut03agendaLista);

        nombre=findViewById(R.id.ut03agendaNombre);
        telef=findViewById(R.id.ut03agendaNumeroTele);
        ver=findViewById(R.id.ut03agendaVer);

        db = Room.databaseBuilder(getApplicationContext(),
                GenteDataBase.class, "gentes").allowMainThreadQueries().build();
        genteDAO=db.genteDAO();
        Monitor();
        GenteSolos=new ArrayList<>();
        andir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gente a= new Gente();
                a.nombre=nombre.getText().toString();
                a.telef=nombre.getText().toString();
                genteDAO.insertAll(a);
                Monitor();
            }
        });

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar();
            }
        });

        modif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Gente> gente = genteDAO.getAll();
                Gente p = new Gente();
                for (Gente a : gente) {
                    p.nombre = nombre.getText().toString();
                    p.telef = telef.getText().toString();
                    if (a.nombre.equals(p.nombre)) {
                        genteDAO.update(p);
                    }
                }
                Monitor();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Gente> gente = genteDAO.getAll();
                Gente p = new Gente();
                for (Gente a : gente) {
                    p.nombre = nombre.getText().toString();
                    p.telef = telef.getText().toString();
                    if (a.nombre.equals(p.nombre)) {
                        genteDAO.delete(a);
                    }
                }
                Monitor();
            }
        });



    }
    public  void mostrar(){
        Intent toda=new Intent(this, GenteLista.class);


        startActivity(toda);

    }
    public  void Monitor(){

        List<Gente> gente = genteDAO.getAll();
        String sData = "";
        for(Gente a : gente){
            sData += a.nombre + " \n" + a.telef + "\n";
        }
       ver.setText(sData);

    }
}