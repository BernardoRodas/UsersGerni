package com.example.pc01.usersgerni;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by rafae on 17/12/2017.
 */

public class HolderMensajes extends RecyclerView.ViewHolder{
    private TextView nom;
    private TextView hor;
    private TextView men;
    private CircleImageView fotomen;

    public HolderMensajes(View itemView) {
        super(itemView);
        nom=(TextView) itemView.findViewById(R.id.nomMen);
        hor=(TextView) itemView.findViewById(R.id.horMen);
        men=(TextView) itemView.findViewById(R.id.mensajeMen);
        fotomen=(CircleImageView) itemView.findViewById(R.id.fotPerMen);
    }

    public TextView getNom() {
        return nom;
    }

    public void setNom(TextView nom) {
        this.nom = nom;
    }

    public TextView getHor() { return hor; }

    public void setHor(TextView hor) {
        this.hor = hor;
    }

    public TextView getMen() {
        return men;
    }

    public void setMen(TextView men) {
        this.men = men;
    }

    public CircleImageView getFotomen() {
        return fotomen;
    }

    public void setFotomen(CircleImageView fotomen) {
        this.fotomen = fotomen;
    }
}
