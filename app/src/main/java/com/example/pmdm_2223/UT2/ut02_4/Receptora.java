package com.example.pmdm_2223.UT2.ut02_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm_2223.R;

public class Receptora extends AppCompatActivity {
    TextView mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptora);

        mensaje=findViewById(R.id.Receptora);

        Intent i= getIntent();


    }
}