package com.example.pmdm_2223.UT03.ut03_Agenda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_2223.R;

import java.util.ArrayList;
import java.util.List;


public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ViewHolder> {

    private List<GenteM> datos  ;



    public ListaAdapter(List<GenteM>datos){
        datos= new ArrayList<>(datos);
        this.datos=datos;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombre;
        private  final TextView telef;

        public ViewHolder( View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            nombre = (TextView) view.findViewById(R.id.rowAgendaNombre);
            telef = (TextView) view.findViewById(R.id.rowAgendaTelef);

        }




    }


    @NonNull
    @Override
    public ListaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()) .inflate(R.layout.row_agenda, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAdapter.ViewHolder viewHolder, int position) {

        viewHolder.nombre.setText(datos.get(position).getNombre());
        viewHolder.telef.setText(datos.get(position).getTelef());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
    public interface RecyclerViewClickListener{
        void onClick(View v,int position);
    }
    public void add(List<GenteM> dataSet){
        datos.addAll(dataSet);
        notifyDataSetChanged();
    }
}


