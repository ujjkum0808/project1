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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
EditText ename,email,econtact,epass;
FirebaseAuth firebaseAuth;
ProgressDialog progress;
Toast toast;
TextView alreadyReg;
Button bsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth=FirebaseAuth.getInstance();
        progress=new ProgressDialog(this);

        ename=findViewById(R.id.editText);
        email=findViewById(R.id.editText2);
        econtact=findViewById(R.id.editText4);
        bsubmit=findViewById(R.id.button);
        epass=findViewById(R.id.editText122);
        alreadyReg=findViewById(R.id.alreadyreg);
        alreadyReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getApplicationContext(), login.class);
                startActivity(i1);
            }
        });

        bsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitfunction();
            }
        });


    }

    public void submitfunction(){
        String s1,s2,s3,s4;
        s1=ename.getText().toString();
        s2=email.getText().toString();
        s3=econtact.getText().toString();
        s4=epass.getText().toString();
        if(TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2) || TextUtils.isEmpty(s3) || TextUtils.isEmpty(s4)){
            toast=Toast.makeText(getApplicationContext(),"please fill all the fields",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
            return;
        }
        progress.setMessage("Registering...");
        progress.show();

        firebaseAuth.createUserWithEmailAndPassword(s2,s4)
                .addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progress.dismiss();
                            toast=Toast.makeText(register.this,"Registration Successful",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                        }else{
                            progress.dismiss();
                            toast=Toast.makeText(register.this,"Registration failed",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                        }
                    }
                });
    }

}
