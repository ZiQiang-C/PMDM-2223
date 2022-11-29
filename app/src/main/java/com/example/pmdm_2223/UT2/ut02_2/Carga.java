package com.example.pmdm_2223.UT2.ut02_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm_2223.R;

public class Carga extends AppCompatActivity {
    TextView Cvisual;
    EditText Cnombre;
    EditText Ctele;
    EditText Ccorreo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga);

        Cnombre =findViewById(R.id.nombreEdite);
        Ctele=findViewById(R.id.teleEdite);
        Ccorreo=findViewById(R.id.correoEdite);
        Cvisual=findViewById(R.id.visualEdite);


        TextView.OnEditorActionListener manejador = new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if(actionId == EditorInfo.IME_ACTION_GO){
                        Cvisual.setText(
                                String.format(
                                        "hola %stus datos: \n%s\n%s",
                                        Cnombre.getText(),
                                        Ccorreo.getText(),
                                        Ctele.getText()

                                )
                        );
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                    }
                return false;
            }
        };
        Cnombre.setOnEditorActionListener(manejador);
        Ctele.setOnEditorActionListener(manejador);
        Ccorreo.setOnEditorActionListener(manejador);
    }
}