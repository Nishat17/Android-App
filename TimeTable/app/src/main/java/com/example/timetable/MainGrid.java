package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainGrid extends AppCompatActivity implements View.OnClickListener {

    private CardView cardView1,cardView2,cardView3,cardView4,cardView5;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView1=(CardView) findViewById(R.id.CardViewgd1);
        cardView2=(CardView) findViewById(R.id.CardViewgd2);
        cardView3=(CardView) findViewById(R.id.CardViewgd3);
        cardView4=(CardView) findViewById(R.id.CardViewgd4);
        cardView5=(CardView) findViewById(R.id.CardViewgd5);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MJCET Catalogue");

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);
        cardView5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.CardViewgd1:
                intent=new Intent(MainGrid.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.CardViewgd2:
                intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.CardViewgd3:
                intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.CardViewgd4:
                intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.CardViewgd5:
                intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
        }

    }
}

