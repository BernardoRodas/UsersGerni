package com.example.pc01.usersgerni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditarActivity extends AppCompatActivity implements View.OnClickListener {
    private CircleImageView fotoper;
    private TextView nombre;
    EditText nom;
    TextView name;

    Button bsalvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        nom=(EditText) findViewById(R.id.Username);
        name=(TextView) findViewById(R.id.nombre);
        bsalvar=(Button)findViewById(R.id.bsalvar);
        bsalvar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bsalvar:
                Intent involver= new Intent(EditarActivity.this,ChatActivity.class);
                involver.putExtra("nombreasiequis",nom.getText().toString());
                startActivity(involver);
                break;
        }
    }
}
