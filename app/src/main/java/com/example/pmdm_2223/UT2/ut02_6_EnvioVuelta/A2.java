package com.example.pmdm_2223.UT2.ut02_6_EnvioVuelta;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import static com.example.pmdm_2223.UT2.ut02_6_EnvioVuelta.A1.CLAVE_A1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm_2223.R;
import com.example.pmdm_2223.UT2.ut02.ActivityLayouts;
import com.example.pmdm_2223.UT2.ut02_4.Receptora;

public class A2 extends AppCompatActivity {
    public static  String CLAVE_A2 = "";
    Button volver,enviar3,nuevaA1;
    TextView visual2;
    EditText nombre2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);

        volver=findViewById(R.id.ut02_6_A2_volver);
        enviar3=findViewById(R.id.ut02_6_A2_enviaA3);
        nombre2=findViewById(R.id.ut02_6_A2_texto);
        visual2 =findViewById(R.id.ut02_6_A2_visual);
        nuevaA1=findViewById(R.id.ut02_6_A2_nuevaA1);

        ActivityResultLauncher<Intent> activityResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Log.d(TAG,""+result.getResultCode());
                        int code= result.getResultCode();
                        switch (code){
                            case R.id.ut02_6_A2_nuevaA1:
                                    Log.d(TAG,"limpiar texto");
                                    nombre2.setText("");
                                break;
                            case R.id.ut02_6_A2_volver:
                                Log.d(TAG,"Vuelve con codigo , buscar iternt");
                            Intent intent =result.getData();
                            String mensaje =intent.getStringExtra(A1.CLAVE_A1);
                            nombre2.setText(mensaje);
                        }
                    }
                }
        );

        nuevaA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ;
            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}