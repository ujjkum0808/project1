package com.example.collegeapp;

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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class profile extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private TextView text;
    private Button logout;
    private DatabaseReference databaseReference;
    private EditText name,address;
    private Button btnsave;
    private ProgressDialog progress;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth =FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        name= findViewById(R.id.name);
        address=findViewById(R.id.address);
        btnsave=findViewById(R.id.buttonsave);



        if(firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this, login.class));
        }

        FirebaseUser user=firebaseAuth.getCurrentUser();
        text=findViewById(R.id.text1);
        text.setText("Welcome "+user.getEmail());
        logout=findViewById(R.id.buttonlogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), register.class));
            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveuserdetails();
            }
        });
    }

    public void saveuserdetails(){
        String newname=name.getText().toString().trim();
        String newaddress=address.getText().toString().trim();
        if(TextUtils.isEmpty(newname) || TextUtils.isEmpty(newaddress))
        {
            toast=Toast.makeText(getApplicationContext(),"please fill all the fields",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
            return;
        }
        /*
        progress.setMessage("Data Inserting...");
        progress.show();*/

        Userinformation userinformation=new Userinformation(newname, newaddress);

        FirebaseUser user=firebaseAuth.getCurrentUser();
        databaseReference.child(user.getUid()).setValue(userinformation);
        //progress.dismiss();
        toast=Toast.makeText(this,"Inserted Sucessfully", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
        return;

    }
}
