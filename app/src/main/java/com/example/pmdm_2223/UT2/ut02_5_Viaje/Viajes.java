package com.example.pmdm_2223.UT2.ut02_5_Viaje;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import com.example.pmdm_2223.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Viajes extends AppCompatActivity {
    public static String ciudadC;
    public static String ciudadD ;

    public static  String CLAVE_VIAJE  = "PRIMERO";
    boolean vuelta=false;
    Button viajeEnvia,buttonFecha;
    ToggleButton viajeVulta;
    Spinner comienzo,destino;
    EditText nombre,apellido,DNI,time,fecha,vultafecha,vultatime;
    TextView error,vultaVT,vultaVD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viajes);

        comienzo =findViewById(R.id.comienzo);
        destino=findViewById(R.id.destino);

        nombre =findViewById(R.id.viajesNombre);
        apellido =findViewById(R.id.viajesApellido);
        DNI=findViewById(R.id.viajesDNI);
        time=findViewById(R.id.viajeTime2);
        fecha=findViewById(R.id.viajeDate2);
        vultafecha=findViewById(R.id.vultaDate);
        vultatime=findViewById(R.id.vultaTime);
        vultaVD=findViewById(R.id.vultaVD);
        vultaVT=findViewById(R.id.vultaVT);


        viajeEnvia=findViewById(R.id.viajesENVIAR);
        viajeVulta=findViewById(R.id.viajeVulta);

        error=findViewById(R.id.visualError);

        destino.getSelectedItemPosition();


        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(fecha);

            }
        });
        vultafecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(vultafecha);
            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickTimelog(time);
            }
        });
        vultatime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickTimelog(vultatime);
            }
        });


        // boton vultaTiempo si ver o no ver
        viajeVulta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compara, boolean b) {
                if(b){
                    vultafecha.setVisibility(View.VISIBLE);
                    vultatime.setVisibility(View.VISIBLE);
                    vultaVD.setVisibility(View.VISIBLE);
                    vultaVT.setVisibility(View.VISIBLE);
                    vuelta=true;
                }else{
                    vultafecha.setVisibility(View.GONE);
                    vultatime.setVisibility(View.GONE);
                    vultaVD.setVisibility(View.GONE);
                    vultaVT.setVisibility(View.GONE);
                    vuelta=false;
                }
            }
        });
        viajeEnvia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean errorCiudad,errorFecha=true;
                if(comienzo.getSelectedItem() == destino.getSelectedItem()){
                    error.setText("el ciudad que no puede es iguales");
                    errorCiudad=false;
                }else{
                    errorCiudad=true;
                }
                if(vuelta){
                    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        if(sdf.parse(fecha.getText().toString()).before(sdf.parse(vultafecha.getText().toString())) ){
                            errorFecha=true;
                        }else{
                            errorFecha=false;
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                }
           /*     if(vuelta){
                    if(validarFecha(fecha) && validarFecha(vultafecha) && validaTime(time) && validaTime(vultatime)){
                        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

                        try {
                            Date date1=sdf.parse(fecha.getText().toString());
                            Date date2=sdf.parse(vultafecha.getText().toString());
                            if (date1.before(date2)){
                                errorFecha=true;
                            }else{
                                errorFecha=false;
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }else{
                        errorFecha=false;
                    }
                }else{
                    if(validarFecha(fecha)  && validaTime(time) ){

                        errorFecha=true;
                    }else{
                        errorFecha=false;
                    }
                }*/
                if(errorCiudad && validarDNI()  ){
                    mostrar();
                }
            }
        });

    }
    public boolean validarDNI(){
        String dniIntroducido = DNI.getText().toString();
        Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
        Matcher mat = patron.matcher(dniIntroducido);
        if(!mat.matches()){
            error.setText("el DNI escribe error!!");
            return false;
        }else{
            return true;
        }

    }
    public boolean validarFecha(EditText fecha){
        Pattern patron1 = Pattern.compile("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
        String fecha1=fecha.getText().toString();
        Matcher mat=patron1.matcher(fecha1);
        if (!mat.matches()){

            return  false;
        }else {
            return true;
        }
    }
    public  boolean validaTime(EditText time){
        Pattern patron1 = Pattern.compile("^(20|21|22|23|[0-1]\\d):[0-5]\\d$" );
        String time1=time.getText().toString();
        Matcher mat=patron1.matcher(time1);
        if (!mat.matches()){
            error.setText("el tiempo es error");
            return  false;
        }else {
            return true;
        }
    }
    public  void mostrar(){
        Intent toda=new Intent(this,MostrarTodo.class);
        if(vuelta){
            toda.putExtra(CLAVE_VIAJE,"ciudad comienzo:"+comienzo.getSelectedItem()+"\nciudad destino: "+destino.getTransitionName()+"\n fecho: "+fecha.getText().toString()+"\n tiempo: "+time.getText().toString()+
                    "\nNOMBRE."+nombre.getText().toString()+"\n APELLIDO: "+apellido.getText().toString()+"\n DNI: "+DNI.getText().toString()+"\n vultarFecha: "+vultafecha.getText().toString()
            +"\n VueltarTiempo: "+vultatime.getText().toString());

        }else{
            toda.putExtra(CLAVE_VIAJE,"ciudad comienzo:"+comienzo.getSelectedItem()+"\nciudad destino: "+destino.getTransitionName()+"\n fecho: "+fecha.getText().toString()+"\n tiempo: "+time.getText().toString()+
                    "\nNOMBRE."+nombre.getText().toString()+"\n APELLIDO: "+apellido.getText().toString()+"\n DNI: "+DNI.getText().toString());

        }
        startActivity(toda);

    }

    private void showDatePickerDialog(EditText v) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                v.setText(selectedDate);
            }
        });
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    private  void showDatePickTimelog(EditText v){
        TimePickerFragmet newFtagmentTime =TimePickerFragmet.newInstance(new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hora, int minuto) {
                final String selectedTime=hora+" : "+minuto;
                v.setText(selectedTime);
            }
        });
        newFtagmentTime.show(getSupportFragmentManager(), "datePicker");
    }
}

