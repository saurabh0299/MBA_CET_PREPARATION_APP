package com.example.mbacet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LISTquestionpaper extends AppCompatActivity {

    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listquestionpaper);


        lst=findViewById(R.id.listview);
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("                           MBA QUESTION PAPER 2020");
        arrayList.add("                           MBA QUESTION PAPER 2019");
        arrayList.add("                           MBA QUESTION PAPER 2018");
        arrayList.add("                           MBA QUESTION PAPER 2017");
        arrayList.add("                           MBA QUESTION PAPER 2016");
        arrayList.add("                           MBA QUESTION PAPER 2015");



        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        lst.setAdapter(arrayAdapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0)
                {
                    Intent intent=new Intent(getApplicationContext(), s2020.class);
                    startActivity(intent);
                }


            }
        });








    }
}