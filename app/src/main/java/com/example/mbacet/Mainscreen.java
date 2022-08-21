package com.example.mbacet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Mainscreen extends AppCompatActivity {


    Button syllabus, qpaper,notes, Ved , whatsapp,quize;
    TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        //gradiant animation

        RelativeLayout relativeLayout = findViewById(R.id.bg1);
        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();

        //end

        logout = (TextView)findViewById(R.id.logo);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logO = new Intent(Mainscreen.this, login.class);
                startActivity(logO);
            }
        });

        syllabus = (Button) findViewById(R.id.li1);

        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),syllabus.class);
                startActivity(intent);


            }
        });




        quize = (Button) findViewById(R.id.li4);

        quize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Quize.class);
                startActivity(intent);


            }
        });






        qpaper = (Button) findViewById(R.id.li5);

        qpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LISTquestionpaper.class);
                startActivity(intent);


            }
        });


        notes = (Button) findViewById(R.id.li2);

        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Nsubjectname.class);
                startActivity(intent);


            }
        });


        Ved = (Button) findViewById(R.id.li3);

        Ved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),subjectVED.class);
                startActivity(intent);


            }
        });

        //whatsapp

        whatsapp = findViewById(R.id.li6);

        final String num = "+917318098116";
        final String text = "Hello";



        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean installed = isAppInstalled("com.whatsapp");

                if (installed)
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+num+"&text="+ text));
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean isAppInstalled(String s) {
        PackageManager packageManager = getPackageManager();
        boolean is_installed;

        try {
            packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES);
            is_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            is_installed = false;
            e.printStackTrace();
        }
        return is_installed;
    }

}



