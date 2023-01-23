package com.example.pmdm_2223.UT03.ut03_Bebida;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pmdm_2223.R;

import java.util.List;

public class BebidaAnadir extends AppCompatActivity {
    EditText nombre,empresa;
    Button vuelver,anadir;
    ImageView image;
    BebidaTableDAO bebidaTableDao ;
    BebidaTableDataBase db;
    Uri uriCapturada;
    ActivityResultLauncher<Intent> imgResult;
    private List<BebidaTable> bebidaTableLista;
    ActivityResultLauncher<String> requestPermissionLauncher;
    public static final int MAINMODACTIVITY = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebida_anadir);

        nombre=findViewById(R.id.ut03BebidaAnadirNombre);
        empresa=findViewById(R.id.ut03BebidaAnadirEmpresa);

        vuelver=findViewById(R.id.ut03BebidaAnadirVuelver);
        anadir=findViewById(R.id.ut03BebidaAnadirAnadir);
        image=findViewById(R.id.bebidaImage);
        getSupportActionBar().hide();
        createDB();
        requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
            if (isGranted) {


                meteImagen2();
            } else {
                Toast.makeText(this, "Se requiere el permiso", Toast.LENGTH_SHORT).show();
            }
        });

        imgResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode()==RESULT_OK){
                        Intent data = result.getData();
                        uriCapturada = data.getData();
                        getContentResolver().takePersistableUriPermission(uriCapturada, Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        String s = uriCapturada.toString();
                        image.setImageURI(Uri.parse(s));
                    }
                }
        );
        anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nombre.getText().toString().equals("") && !image.toString().equals("")) {

                    BebidaTable bebidaBd = new BebidaTable();
                    bebidaBd.nombre = nombre.getText().toString();
                    bebidaBd.empresa= empresa.getText().toString();
                    bebidaBd.imagen = uriCapturada.toString();
                    bebidaTableDao.insertAll(bebidaBd);
                    Toast.makeText(getApplicationContext(),"Plato añadido",Toast.LENGTH_SHORT).show();
                    finish();
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
    public void meteImagen2(){
        Intent i =new Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        i.putExtra(MediaStore.EXTRA_OUTPUT, uriCapturada);
        imgResult.launch(i);
    }
    public void imageClick2(View v){
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED) {
            // You can use the API that requires the permission.
            meteImagen2();
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
            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
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
