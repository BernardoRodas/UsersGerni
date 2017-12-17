package com.example.pc01.usersgerni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActualizaActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView rmens;
    private AdapterMensajes adaptador;
    Button retornox2;
    Button accLapiz;
    Button aceptar;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualiza);
        retornox2=(Button)findViewById(R.id.bvv);
        accLapiz=(Button) findViewById(R.id.vpb);
        accLapiz.setOnClickListener(this);
        retornox2.setOnClickListener(this);
        //
        database= FirebaseDatabase.getInstance();
        databaseReference=database.getReference("chat");
        //
        aceptar=(Button) findViewById(R.id.acep);
        aceptar.setOnClickListener(this);
        //
        adaptador= new AdapterMensajes(this);
        rmens=(RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager l= new LinearLayoutManager(this);
        rmens.setLayoutManager(l);
        rmens.setAdapter(adaptador);
        adaptador.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart,itemCount);
                setScrollBar();
            }
        });

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Mensaje n=dataSnapshot.getValue(Mensaje.class);
                adaptador.addMensaje(n);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.acep:
                Bundle texto = this.getIntent().getExtras();
                if(texto !=null){
                    String nombrecito =texto.getString("nombreasiequis");
                    String tt = texto.getString("textoenv");
                    databaseReference.push().setValue(new Mensaje(tt,nombrecito,"","1","00:00"));
                    tt=("");
                }
                break;
            case R.id.bvv:
                Intent retornoequis= new Intent(ActualizaActivity.this,ChatActivity.class);
                startActivity(retornoequis);
                break;
            case R.id.vpb:
                Intent vuelEs= new Intent(ActualizaActivity.this,PublicarActivity.class);
                startActivity(vuelEs);
                break;
        }
    }
    private void setScrollBar(){
        rmens.scrollToPosition(adaptador.getItemCount()-1);
    }
}
