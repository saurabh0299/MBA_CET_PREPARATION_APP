package com.example.mbacet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class registration extends AppCompatActivity {


    Button register;
    EditText name , emaild, mobileno,pass,repass;

    String s_name , s_emaild, s_mobileno,s_pass,s_repass;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);






        name = findViewById(R.id.r2);
        emaild =  findViewById(R.id.r3);
        mobileno = findViewById(R.id.r4);
        pass =  findViewById(R.id.r5);
        repass = findViewById(R.id.r6);

        register = (Button) findViewById(R.id.r7);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);




        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validation();
            }
        });
    }

    private  void Validation(){
        s_name=name.getText().toString();
        s_emaild=emaild.getText().toString();
        s_mobileno=mobileno.getText().toString();
        s_pass=pass.getText().toString();
        s_repass=repass.getText().toString();



        if(s_name.isEmpty()){
            name.setError("fill the name ");
            name.requestFocus();
            return;
        }if(s_emaild.isEmpty()){
            emaild.setError("fill the correct email id");
            emaild.requestFocus();
            return;
        } if(!Patterns.EMAIL_ADDRESS.matcher(s_emaild).matches()){
            emaild.setError("fill the field");
            emaild.requestFocus();
            return;
        }

        if(s_mobileno.isEmpty()){
            mobileno.setError("fill the 10 digit mobile no");
            mobileno.requestFocus();
            return;
        }if (!numberCheck(s_mobileno)){
            mobileno.setError("invald mobile no");
            mobileno.requestFocus();
            return;
        }if(s_pass.isEmpty()){
            pass.setError("password must be between 0-10");
            pass.requestFocus();
            return;

        }else if(!passwordValidation(s_pass)){
            pass.setError("fill correct password");
            pass.requestFocus();


        }if(s_repass.isEmpty()){
            repass.setError("fill correct password");
            repass.requestFocus();
            return;
        }



        createAccount();











    }

    private void createAccount() {


        progressDialog.setMessage("creating Account....");
        progressDialog.show();

        sendDatatoDb();

    }

    private void sendDatatoDb() {

        String regtime=""+System.currentTimeMillis();
        HashMap<String,Object> data=new HashMap<>();

        data.put("name",s_name);
        data.put("email-id",s_emaild);
        data.put("mobile no",s_mobileno);
        data.put("password",s_pass);


        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Users");
        reference.child(s_name).setValue(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        //db updaate

                        progressDialog.dismiss();
                        Toast.makeText(registration.this, "Registration successful ", Toast.LENGTH_SHORT).show();

                        //mainscreen intent

                        Intent i = new Intent(registration.this, Mainscreen.class);

                        startActivity(i);
                        finish();

                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(registration.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });





    }

    private boolean passwordValidation(String s_pass) {

        Pattern p=Pattern.compile(".{10}");
        Matcher m=p.matcher(s_pass);
        return m.matches();


    }

    private boolean numberCheck(String s_mobileno) {

        Pattern p=Pattern.compile("[0-9]{10}");
        Matcher m=p.matcher(s_mobileno);
        return m.matches();

    }

}

