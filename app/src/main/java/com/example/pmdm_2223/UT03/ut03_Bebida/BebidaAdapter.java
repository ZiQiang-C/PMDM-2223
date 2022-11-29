package com.example.pmdm_2223.UT03.ut03_Bebida;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_2223.R;
import com.example.pmdm_2223.UT03.ut03_Agenda.ListaAdapter;
import com.example.pmdm_2223.UT2.ut02_1.Pracatica21;


import java.util.ArrayList;
import java.util.List;

public class BebidaAdapter extends RecyclerView.Adapter<BebidaAdapter.ViewHolder> {
    private List<BebidaTable> bebidas;
    private static RecyclerViewClickListener listener;

    public BebidaAdapter(List<BebidaTable> sdatos,RecyclerViewClickListener listener ){
        this.bebidas=sdatos;
        this.listener=listener;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        private final TextView nombre;
        private final TextView empresa;


        public ViewHolder( View view) {
            super(view);
            nombre=(TextView) view.findViewById(R.id.rowbebidaNombre);
            empresa=(TextView) view.findViewById(R.id.rowbebidaEmpresa);
            view.setOnClickListener(this);
        }

        public TextView getEmpresa() {
            return empresa;
        }

        public TextView getNombre() {
            return nombre;
        }


        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public BebidaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_bebida,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BebidaAdapter.ViewHolder viewHolder, int position) {
        viewHolder.getNombre().setText(bebidas.get(position).nombre);
        viewHolder.getEmpresa().setText(bebidas.get(position).empresa);



    }

    @Override
    public int getItemCount() {
        return bebidas.size();
    }


    public static void setListener(RecyclerViewClickListener listener) {
        BebidaAdapter.listener = listener;
    }

    public interface RecyclerViewClickListener{
        void onClick(View v,int position);
    }

}
