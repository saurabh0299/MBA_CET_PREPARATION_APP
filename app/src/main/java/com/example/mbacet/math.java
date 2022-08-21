package com.example.mbacet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class math extends AppCompatActivity {


    PDFView math;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);


        math=(PDFView)findViewById(R.id.pdfView);

        math.fromAsset("maths.pdf").load();
    }
}