package com.example.pmdm_2223.UT03.ut03_EjemploDato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm_2223.R;

public class MonitorAll extends AppCompatActivity {
    TextView mostraTodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_all);

        mostraTodos=findViewById(R.id.ut03_EjemploDato_MonitorAll_Vista);

        Intent i =getIntent();

        mostraTodos.setText(i.getStringExtra(Dato.CLAVE_DATO));
    }
}