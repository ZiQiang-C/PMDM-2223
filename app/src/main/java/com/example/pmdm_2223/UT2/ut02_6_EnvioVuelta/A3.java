package com.example.pmdm_2223.UT2.ut02_6_EnvioVuelta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm_2223.R;

public class A3 extends AppCompatActivity {
    TextView visual;
    Button volver,nuevaA2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);
    visual=findViewById(R.id.ut02_6_A3_visual1);
    volver=findViewById(R.id.ut02_6_A3_volver);
    nuevaA2=findViewById(R.id.ut02_6_A3_nuevaA2);
    }
}