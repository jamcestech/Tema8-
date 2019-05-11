package com.example.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.BandasViewHolder> {

    private List<Grupo> list;
    private Context context;
    private RecyclerView view;

    public MainAdapter(Context context, RecyclerView view) {
        this.list = new ArrayList<>();

        this.context = context;
        this.view = view;
    }

    public void swap(Example newList) {
        list.clear();
        Collection<? extends Grupo>  collection = new ArrayList<>(newList.getGrupos());

        list.addAll(collection);
        notifyDataSetChanged();

    }

    @Override
    public BandasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BandasViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cosas, parent, false));
    }

    @Override
    public void onBindViewHolder(BandasViewHolder holder, final int position) {
      //  final Result pokemon = list.get(position);

        holder.nombre.setText(list.get(position).getNombre());
        holder.descripcion.setText(list.get(position).getDescripcion());

        Picasso.get().load(list.get(position).getImagen()).into(holder.imagen);

        //holder.nombre.setText(list.get(position).getNombre());

        /*holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v != null) {
                    v.navigateToDetails(position+1);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class BandasViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView descripcion;
        ImageView imagen;

        public BandasViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView)itemView.findViewById(R.id.nombre);
            descripcion = (TextView)itemView.findViewById(R.id.descripcion);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
        }
    }
}