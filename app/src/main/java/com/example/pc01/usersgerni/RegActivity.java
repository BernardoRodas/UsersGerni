package com.example.pc01.usersgerni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.annotation.NonNull;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import android.content.Intent;

public class RegActivity extends AppCompatActivity implements View.OnClickListener{
    Button br;
    EditText t3;
    EditText t4;
    EditText t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        t3=(EditText) findViewById(R.id.usur);
        t4=(EditText) findViewById(R.id.mailr);
        t5=(EditText) findViewById(R.id.passwordr);
        br=(Button) findViewById(R.id.regis);
        br.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String usu, con, mai;
        usu=t3.getText().toString();
        mai=t4.getText().toString();
        con=t5.getText().toString();
        if(usu.equalsIgnoreCase("")||con.equalsIgnoreCase("")||mai.equalsIgnoreCase("")){
            Toast.makeText(getApplicationContext(),"ERROR: No deje espacios blancos",Toast.LENGTH_SHORT).show();
        }else {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(mai,con).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "Usuario creado con exito", Toast.LENGTH_SHORT).show();
                        Intent in3= new Intent(RegActivity.this,MainActivity.class);
                        startActivity(in3);
                    }else{
                        Toast.makeText(getApplicationContext(), "Error: creacion usuario fallida", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            Intent in4 = new Intent(RegActivity.this, MainActivity.class);
            startActivity(in4);
        }
    }
}
