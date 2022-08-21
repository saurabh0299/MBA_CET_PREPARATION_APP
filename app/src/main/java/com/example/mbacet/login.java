package com.example.mbacet;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {


    Button registration , login;
    EditText username_var,password_var;

    String str_name,str_passw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username_var = findViewById(R.id.l2);
        password_var = findViewById(R.id.l3);
        login = (Button) findViewById(R.id.l4);
        registration = (Button) findViewById(R.id.l6);



        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),registration.class);
                startActivity(intent);


            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validation();
            }
        });




    }

    private  void Validation(){
        str_name=username_var.getText().toString();
        str_passw=password_var.getText().toString();


        if(str_name.isEmpty()){
            username_var.setError("Enter Correct Name");
            username_var.requestFocus();
        }if(str_passw.isEmpty()) {
            password_var.setError("Enter Correct Password");
            password_var.requestFocus();
            return;
        }



        checkFromDB();
    }

    private void checkFromDB(){
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Users");
        reference.child(str_name)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            String db_pass=snapshot.child("password").getValue(String.class);
                            if(str_passw.equals(db_pass))
                            {

                                Intent intent = new Intent(getApplicationContext(), Mainscreen.class);
                                intent.putExtra("name",str_name);
                                Toast.makeText(login.this, "Login sucessful", Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                                finish();

                            }
                            else {
                                Toast.makeText(getApplicationContext(), "invalid  password ", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(login.this, "Record not found ", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });





    }
}