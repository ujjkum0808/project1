package com.example.collegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    EditText email,passward;
    Button btnlogin;
    FirebaseAuth firebaseAuth;
    ProgressDialog progress;
    Toast t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.editText1);
        passward=findViewById(R.id.editText21);
        firebaseAuth=FirebaseAuth.getInstance();

        /*if(firebaseAuth.getCurrentUser() !=null){
            finish();
            startActivity(new Intent(getApplicationContext(), profile.class));
        }*/

        progress=new ProgressDialog(this);
        btnlogin=findViewById(R.id.button1);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gopage();
            }
        });
    }

    public void gopage(){
        String emailnew,passwardnew;
        emailnew=email.getText().toString().trim();
        passwardnew=passward.getText().toString().trim();

        if(TextUtils.isEmpty(emailnew)){
            t=Toast.makeText(getApplicationContext(),"please enter email",Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER,0,0);
            t.show();
            return;
        }
        if(TextUtils.isEmpty(passwardnew)){
            t=Toast.makeText(getApplicationContext(),"please enter passward",Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER,0,0);
            t.show();
            return;
        }

        progress.setMessage("Login...");
        progress.show();

        firebaseAuth.signInWithEmailAndPassword(emailnew,passwardnew)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progress.dismiss();
                            finish();
                            startActivity(new Intent(getApplicationContext(),profile.class));
                        }
                        else {
                            progress.dismiss();
                            t=Toast.makeText(getApplicationContext(),"Invalied user Id or passward",Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER,0,0);
                            t.show();


                        }
                    }
                });
    }
}
