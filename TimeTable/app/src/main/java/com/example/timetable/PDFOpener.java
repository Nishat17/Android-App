package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFOpener extends AppCompatActivity {

    PDFView myPDFViewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_d_f_opener);

        myPDFViewer=(PDFView) findViewById(R.id.pdfViewer);

        String getItem=getIntent().getStringExtra("pdfFileName");
        if(getItem.equals("A")){
            myPDFViewer.fromAsset("saurabhgupta (9).pdf").load();
        }
        if(getItem.equals("B")){
            myPDFViewer.fromAsset("SE(V.Imp) (1).pdf").load();
        }
        if(getItem.equals("C")){
            myPDFViewer.fromAsset("SE-DrDKB-UNIT-1(1).pdf").load();
        }
        if(getItem.equals("D")){
            myPDFViewer.fromAsset("SEMANTIC IMAGE SYNTHESIS(2020) 09-041.pdf").load();
        }
        if(getItem.equals("E")){
            myPDFViewer.fromAsset("SEMANTIC IMAGE SYNTHESIS(2020) 09-041 (1).pdf").load();
        }
        if(getItem.equals("F")){
            myPDFViewer.fromAsset("serverStartup.pdf").load();
        }
        if(getItem.equals("G")){
            myPDFViewer.fromAsset("ServletJSP-Connect1.pdf").load();
        }
        if(getItem.equals("H")){
            myPDFViewer.fromAsset("Syllabus - Web Programming Theory.pdf").load();
        }
        if(getItem.equals("I")){
            myPDFViewer.fromAsset("testing.pdf").load();
        }
        if(getItem.equals("J")){
            myPDFViewer.fromAsset("testing-webtestclient.pdf").load();
        }
        if(getItem.equals("I")){
            myPDFViewer.fromAsset("Title Page (1).pdf").load();
        }
        if(getItem.equals("J")){
            myPDFViewer.fromAsset("Title Page (2).pdf").load();
        }

    }
}
