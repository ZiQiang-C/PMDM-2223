package com.example.pmdm_2223.UT03.ut03_EjemploDato;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm_2223.R;

import java.util.List;

public class Dato extends AppCompatActivity {
    Button add;
    Button Modi;
    Button resta;
    EditText nombre;
    EditText telef;
    TextView datos;
    AppDataBase db;
    PersonaDAO personaDAO;
    public static String CLAVE_DATO ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dato);

        add = findViewById(R.id.ut03_EjemploDato_mas);
        Modi=findViewById(R.id.ut03_EjemploDataModi);
        nombre = findViewById(R.id.ut03_EjemploDateN);
        telef = findViewById(R.id.ut03_EjemploDateT);
        datos = findViewById(R.id.ut03_EjemploDatoV);
        resta=findViewById(R.id.ut03_EjemploDatoRe);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDataBase.class, "personales").allowMainThreadQueries().build();
        personaDAO = db.personaDAO();



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persona a = new Persona();
                a.nombre = nombre.getText().toString();
                a.telef = telef.getText().toString();
                personaDAO.insertAll(a);
                Monitor();
            }

        });

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Persona> persona = personaDAO.getAll();
                Persona p = new Persona();

                for(Persona a :persona){

                   p.nombre = nombre.getText().toString();
                    p.telef = telef.getText().toString();
                    if(a.nombre.equals(p.nombre) ){

                        personaDAO.delete(a);
                        Monitor();
                    }
                }
            }
        });
        Modi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Persona> persona = personaDAO.getAll();
                Persona p = new Persona();

                for(Persona a :persona){

                    p.nombre = nombre.getText().toString();
                    p.telef = telef.getText().toString();
                    if(a.nombre.equals(p.nombre) ){

                        personaDAO.delete(a);

                        personaDAO.insertAll(p);
                        mostrar();
                    }
                }
            }
        });

    }

    public  void Monitor(){

            List<Persona> persona = personaDAO.getAll();
            String sData = "";
            for(Persona a : persona){
                sData += a.nombre + " \n" + a.telef + "\n";
            }
            datos.setText(sData);

    }


    public  void mostrar(){
        Intent toda=new Intent(this, MonitorAll.class);

        List<Persona> persona = personaDAO.getAll();
        String sData = "";
        for(Persona a : persona){
              sData += a.nombre + "\n" + a.telef + "\n";
        }
        toda.putExtra(CLAVE_DATO,sData);

        startActivity(toda);

    }
}