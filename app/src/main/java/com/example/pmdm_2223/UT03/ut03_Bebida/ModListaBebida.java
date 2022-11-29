package com.example.pmdm_2223.UT03.ut03_Bebida;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmdm_2223.R;

import java.util.List;

public class ModListaBebida extends AppCompatActivity {
        private List<BebidaTable> bebidaTableLista;
        Button modi,borrar,vueler;
        EditText nombre, empresa;
        TextView Tnombre,Tempresa;
        BebidaTableDAO bebidaTableDao;
        BebidaTableDataBase db;
    ActivityResultLauncher<String> requestPermissionLauncher;
    public static int PARAFILTRAR=10;
    private final  int MAINMODACTIVITY=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_lista_bebida);

        modi=findViewById(R.id.ut03ModListaBebidaModi);
        borrar=findViewById(R.id.ut03ModListaBebidaBorrar);
        vueler=findViewById(R.id.ut03ModListaBebidaVuelver);

        nombre =findViewById(R.id.ut03ModListaBebidaNobre);
        empresa =findViewById(R.id.ut03ModListaBebidaEmpresa);

        Tnombre=findViewById(R.id.ut03ModListaBebidaTNombre);
        Tempresa=findViewById(R.id.ut03ModListaBebidaTEmpresa);
        creatORM();
        asigBebida();

        modi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modifi();
            }
        });
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                borrar();
            }
        });
        vueler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vuelver();
            }
        });

        requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
            if (isGranted) {

                llamar();
            } else {
                Toast.makeText(ModListaBebida.this, "Se requiere el permiso", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public  void creatORM(){
        db = Room.databaseBuilder(getApplicationContext(),
                BebidaTableDataBase.class, "bebidas").allowMainThreadQueries().build();

        //Extrae los datos de la bd para poder hacer querys
        bebidaTableDao= db.bebidaTableDAO();
    }
    public  void vuelver(){
        Intent volverInt = new Intent(this,Listacoger.class);
        setResult(MAINMODACTIVITY,volverInt);
        finish();
    }
    public void asigBebida () {

        //Se extrae todos los extras enviados
        Bundle extras=getIntent().getExtras();

        //Se asigna valores a los TextViews
        Tnombre.setText(extras.getString("nombre"));
        Tempresa.setText(extras.getString("empresa"));
    }
    public void borrar() {
        List<BebidaTable> bebidadb = bebidaTableDao.getAll();
        for (BebidaTable x : bebidadb) {
            if (x.nombre.equals(nombre.getText().toString())) {
                bebidaTableDao.delete(x);
            }
        }
    }
    public  void modifi(){
        //更改保存的数据
        //Extrae el total de la base de datos y comprueba si coincide
        //列表 = 数据库.getAll()； 将数据库里的数据全部转移到列表里
        bebidaTableLista= bebidaTableDao.getAll();
        String vNom= nombre.getText().toString();
        String vTel= empresa.getText().toString();

        for(BebidaTable a /*objeto vacio de la BD*/: bebidaTableLista) {
            if(a.nombre.equals(Tnombre.getText().toString())){
                a.nombre=vNom;
                a.empresa=vTel;
                if(a.nombre.equals("")){
                    nombre.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                }else{
                    nombre.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
                }
                if(a.empresa.equals("")){
                    empresa.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                }else{
                    empresa.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
                }
                if(
                        !(a.nombre.equals(""))
                                &&!(a.empresa.equals(""))
                ){
                    bebidaTableDao.update(a);
                    nombre.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
                    empresa.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
                    Toast.makeText(getApplicationContext(),"Has modificado un individuo",Toast.LENGTH_SHORT).show();
                    retornar();
                }else{
                    Toast.makeText(getApplicationContext(),"Datos vacíos",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    public void retornar () {
        //

        Intent intent = new Intent(this, Listacoger.class);
        setResult(PARAFILTRAR, intent);
        finish();

    }
    private void llamar(){
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        //sin el tel: no entiende que es un numero de telefono
        phoneIntent.setData(Uri.parse("tel:+34"+Tempresa.getText().toString()));
        startActivity(phoneIntent);
    }

    public void llamadaClick(View v){
        if (ContextCompat.checkSelfPermission(
                ModListaBebida.this, Manifest.permission.CALL_PHONE) ==
                PackageManager.PERMISSION_GRANTED) {
            // You can use the API that requires the permission.
            llamar();
        } else if (false) {
            // In an educational UI, explain to the user why your app requires this
            // permission for a specific feature to behave as expected, and what
            // features are disabled if it's declined. In this UI, include a
            // "cancel" or "no thanks" button that lets the user continue
            // using your app without granting the permission.

            // Mostrar UI Dialog para explicar al usuarios la necesidad del permiso
            // Vamos a usar la de por defecto de Android. Se ejecuta en el else
            Toast.makeText(getApplicationContext(),"no hay permiso",Toast.LENGTH_SHORT).show();
        } else {
            // You can directly ask for the permission.
            // The registered ActivityResultCallback gets the result of this request.
            requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE);
        }
    }
}
