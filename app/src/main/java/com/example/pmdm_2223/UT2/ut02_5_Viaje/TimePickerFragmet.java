package com.example.pmdm_2223.UT2.ut02_5_Viaje;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragmet extends DialogFragment
{
    private TimePickerDialog.OnTimeSetListener listenerTime;

    public static TimePickerFragmet newInstance(TimePickerDialog.OnTimeSetListener listenerTime) {
        TimePickerFragmet fragment=new TimePickerFragmet();
        fragment.setListenerTime(listenerTime);

        return fragment;
    }
    public void setListenerTime(TimePickerDialog.OnTimeSetListener listenerTime) {
        this.listenerTime = listenerTime;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int minuto = c.get(Calendar.MINUTE);
        int hora = c.get(Calendar.HOUR_OF_DAY);


        // Create a new instance of DatePickerDialog and return it
        return new TimePickerDialog(getActivity(), listenerTime, hora, minuto,true);
    }
}