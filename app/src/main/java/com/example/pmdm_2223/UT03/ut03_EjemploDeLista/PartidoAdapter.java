package com.example.pmdm_2223.UT03.ut03_EjemploDeLista;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_2223.R;

import java.util.ArrayList;
import java.util.Arrays;
public class PartidoAdapter  extends RecyclerView.Adapter<PartidoAdapter.ViewHolder> {

    private ArrayList<Partido> datos;



    public static class ViewHolder extends RecyclerView.ViewHolder{
            private final TextView partido;
            private  final TextView resultado;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            partido = (TextView) view.findViewById(R.id.ListaNombre);
            resultado = (TextView) view.findViewById(R.id.ListaResultado);
        }

        public TextView getTextPartido() {
            return partido;
        }

        public TextView getTextResultado() {
            return resultado;
        }

    }
    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
   public PartidoAdapter(Partido[] dataSet){
       datos=new ArrayList<Partido>();
       add(dataSet);
   }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view =LayoutInflater.from(viewGroup.getContext()) .inflate(R.layout.row_partido, viewGroup, false);
        return new ViewHolder(view);
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        viewHolder.getTextPartido().setText(datos.get(position).pais);
        viewHolder.getTextResultado().setText(datos.get(position).resultadoN);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void add(Partido[] dataSet){
        datos.addAll(Arrays.asList(dataSet));
        notifyDataSetChanged();
    }
}
