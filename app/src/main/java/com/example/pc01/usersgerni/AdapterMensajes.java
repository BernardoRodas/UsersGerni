package com.example.pc01.usersgerni;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafae on 17/12/2017.
 */

public class AdapterMensajes extends RecyclerView.Adapter<HolderMensajes> {

    private List<Mensaje> listMensaje= new ArrayList<>();
    private Context c;

    public AdapterMensajes(Context c) {
        this.c = c;
    }
    public void addMensaje(Mensaje n){
        listMensaje.add (n);
        notifyItemInserted(listMensaje.size());
    }

    @Override
    public HolderMensajes onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.cardview_men,parent,false);
        return new HolderMensajes(v);
    }

    @Override
    public void onBindViewHolder(HolderMensajes holder, int position) {
        holder.getNom().setText(listMensaje.get(position).getNombre());
        holder.getHor().setText(listMensaje.get(position).getHora());
        holder.getMen().setText(listMensaje.get(position).getMensaje());
    }

    @Override
    public int getItemCount() {
        return listMensaje.size();
    }
}
