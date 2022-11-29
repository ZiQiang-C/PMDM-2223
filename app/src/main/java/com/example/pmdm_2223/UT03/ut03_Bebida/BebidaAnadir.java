package com.example.pmdm_2223.UT03.ut03_Bebida;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pmdm_2223.R;

import java.util.List;

public class BebidaAnadir extends AppCompatActivity {
    EditText nombre,empresa;
    Button vuelver,anadir;
    BebidaTableDAO bebidaTableDao ;
    BebidaTableDataBase db;
    private List<BebidaTable> bebidaTableLista;
    public static final int MAINMODACTIVITY = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebida_anadir);

        nombre=findViewById(R.id.ut03BebidaAnadirNombre);
        empresa=findViewById(R.id.ut03BebidaAnadirEmpresa);

        vuelver=findViewById(R.id.ut03BebidaAnadirVuelver);
        anadir=findViewById(R.id.ut03BebidaAnadirAnadir);

        getSupportActionBar().hide();
        createDB();
        anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nombre.getText().toString().equals("")) {

                    BebidaTable bebidaBd = new BebidaTable();
                    bebidaBd.nombre = nombre.getText().toString();
                    bebidaBd.empresa= empresa.getText().toString();
                    bebidaTableDao.insertAll(bebidaBd);
                    Toast.makeText(getApplicationContext(),"Plato añadido",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Debe introducir un nombre",Toast.LENGTH_SHORT).show();
                }
            }
        });
        vuelver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vuelver();
            }
        });


    }
    public void createDB(){
        //Se crea la base de datos
        db = Room.databaseBuilder(getApplicationContext(),
                BebidaTableDataBase.class, "bebidas").allowMainThreadQueries().build();

        //Extrae los datos de la bd para poder hacer querys
        bebidaTableDao = db.bebidaTableDAO();

        //extr4e el contenido de la bd
        bebidaTableLista= bebidaTableDao.getAll();
    }
    public  void vuelver(){
        Intent volverInt = new Intent(this,Listacoger.class);
        setResult(MAINMODACTIVITY,volverInt);
        finish();
    }

}
