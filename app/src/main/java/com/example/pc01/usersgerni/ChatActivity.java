package com.example.pc01.usersgerni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener{
    Button bs,bp,bv,bc;
    private TextView nombre;
    private CircleImageView fotoPer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        bs=(Button) findViewById(R.id.salir);
        bp=(Button) findViewById(R.id.publicar);
        bv=(Button) findViewById(R.id.ver);
        bc=(Button) findViewById(R.id.confi);
        nombre=(TextView) findViewById(R.id.nombre);
        bs.setOnClickListener(this);
        bp.setOnClickListener(this);
        bv.setOnClickListener(this);
        bc.setOnClickListener(this);
        Bundle texto = this.getIntent().getExtras();
        if(texto !=null){
            String nombrecito=texto.getString("nombreasiequis");
            nombre.setText(nombrecito);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.salir:
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getApplicationContext(),"Sesion cerrada",Toast.LENGTH_SHORT).show();
                Intent ins=new Intent(ChatActivity.this,MainActivity.class);
                startActivity(ins);
                break;
            case R.id.publicar:
                Intent inp=new Intent(ChatActivity.this,PublicarActivity.class);
                startActivity(inp);
                break;
            case R.id.ver:
                Intent inv=new Intent(ChatActivity.this,ActualizaActivity.class);
                startActivity(inv);
                break;
            case R.id.confi:
                Intent inc=new Intent(ChatActivity.this,EditarActivity.class);
                startActivity(inc);
                break;

        }
    }
}
