package com.example.pc01.usersgerni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PublicarActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText tenv;
    private Button btenv;
    Button descartar;
    Button retornar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar);
        btenv=(Button)findViewById(R.id.enviar);
        tenv=(EditText) findViewById(R.id.tp);
        descartar=(Button) findViewById(R.id.descartar);
        retornar=(Button) findViewById(R.id.bvv);
        btenv.setOnClickListener(this);
        retornar.setOnClickListener(this);
        descartar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bvv:
                Intent retorno=new Intent(PublicarActivity.this,ChatActivity.class);
                startActivity(retorno);
                break;
            case R.id.descartar:
                tenv.setText("");
                break;
            case R.id.enviar:
                Intent inpp= new Intent(PublicarActivity.this,ActualizaActivity.class);
                inpp.putExtra("textoenv",tenv.getText().toString());
                startActivity(inpp);
                break;
        }
    }
}
