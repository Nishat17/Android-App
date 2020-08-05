package com.example.timetable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ResoucesActivity extends AppCompatActivity {

    ListView pdfListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resouces);
        pdfListView = (ListView) findViewById(R.id.PDFList);

        String[] pdfFiles = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "M"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pdfFiles) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = super.getView(position, convertView, parent);
                TextView mytext = (TextView) view.findViewById(android.R.id.text1);
                return view;
            }
        };
        pdfListView.setAdapter(adapter);
        pdfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = pdfListView.getItemAtPosition(i).toString();
                Intent start = new Intent(getApplicationContext(),PDFOpener.class);
                start.putExtra("pdfFileName",item);
                startActivity(start);
            }
        });
    }
}
