package com.example.mbacet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class syllabus extends AppCompatActivity {

    PDFView sy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        sy=(PDFView)findViewById(R.id.pdfView);

        sy.fromAsset("srg.pdf").load();

    }
}