package com.example.mbacet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class s2020 extends AppCompatActivity {


    PDFView s2020;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s2020);



        s2020=(PDFView)findViewById(R.id.pdfView);

        s2020.fromAsset("2020.pdf").load();
    }
}