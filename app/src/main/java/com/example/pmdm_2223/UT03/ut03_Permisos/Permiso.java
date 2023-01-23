package com.example.pmdm_2223.UT03.ut03_Permisos;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pmdm_2223.R;

public class Permiso extends AppCompatActivity {
    Button image;
    ActivityResultLauncher<Intent> imgResult;
    ActivityResultLauncher<String> requestPermissionLauncher;
    ActivityResultLauncher<String> requestPermissionImage;
    Uri uriCapturada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permiso);
        image=findViewById(R.id.Foto);

        requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
            if (isGranted) {

                llamar();

            } else {

                Toast.makeText(Permiso.this, "Necesitamos permiso para llamar", Toast.LENGTH_SHORT).show();
            }
        });
        requestPermissionImage=registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted->{
            if (isGranted) {

                meteImagen2();

            } else {

                Toast.makeText(Permiso.this, "Necesitamos permiso para iamge", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void llamar(){
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse("tel:0034 666 66 66 66"));
        startActivity(phoneIntent);
    }
    public void meteImagen2(){
        Intent i =new Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivity(i);
    }
    public void imageClick2(View v){
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED) {

            meteImagen2();
        } else if (false) {

            Toast.makeText(getApplicationContext(),"no hay permiso",Toast.LENGTH_SHORT).show();
        } else {

            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
    }
    public void llamadaClick(View v){
        if (ContextCompat.checkSelfPermission(
                Permiso.this, Manifest.permission.CALL_PHONE) ==
                PackageManager.PERMISSION_GRANTED) {

            llamar();
        } else if (false) {


        } else {

            requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE);
        }
    }
}