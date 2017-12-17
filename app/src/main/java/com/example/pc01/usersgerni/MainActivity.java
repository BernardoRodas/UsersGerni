package com.example.pc01.usersgerni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.support.annotation.NonNull;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2;
    EditText t1,t2;
    FirebaseAuth.AuthStateListener Lis1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.ing);
        b2=(Button) findViewById(R.id.reg);
        t1=(EditText) findViewById(R.id.mail);
        t2=(EditText) findViewById(R.id.password);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        Lis1=new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user!=null){
                    Intent in=new Intent(MainActivity.this,ChatActivity.class);
                    startActivity(in);
                }
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ing:
                String usu,con;
                usu=t1.getText().toString();
                con=t2.getText().toString();
                if (usu.equalsIgnoreCase("")||con.equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(), "Error: No deje espacios blancos", Toast.LENGTH_SHORT).show();
                }else{
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(usu,con).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent intent2 = new Intent(MainActivity.this,ChatActivity.class);
                                startActivity(intent2);
                            }else{
                                Toast.makeText(getApplicationContext(), "Error: Fallo inicio sesion", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                break;
            case R.id.reg:
                Intent intent = new Intent(MainActivity.this,RegActivity.class);
                startActivity(intent);
                break;
        }
    }

    
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(Lis1);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (Lis1!=null){
            FirebaseAuth.getInstance().removeAuthStateListener(Lis1);
        }
    }
}
