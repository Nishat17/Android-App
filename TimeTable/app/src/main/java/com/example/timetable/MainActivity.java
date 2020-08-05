package com.example.timetable;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import static android.view.LayoutInflater.*;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();
        initToolbar();
        setupListView();


    }

    private void setupUIViews(){
        toolbar=(Toolbar)findViewById(R.id.ToolbarMain);
        listView=(ListView)findViewById(R.id.lvMain);
    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MJCET TimeTable");
    }

    private void setupListView(){
        String[] title=getResources().getStringArray(R.array.Main);
        String[] description=getResources().getStringArray(R.array.Description);

        SimpleApadter simpleAdapter=new SimpleApadter(this,title,description);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:{
                        Intent intent=new Intent(MainActivity.this,WeekActivityy.class);
                        startActivity(intent);
                        break;
                    }
                    case 1:{
                        Intent intent=new Intent(MainActivity.this,SubjectActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 2:{
                        Intent intent=new Intent(MainActivity.this,Faculty.class);
                        startActivity(intent);
                        break;
                    }
                    case 3:{
                        Intent intent=new Intent(MainActivity.this,ResoucesActivity.class);
                        startActivity(intent);
                        break;

                    }
                    case 4:{
                        Intent intent=new Intent(MainActivity.this,EventsActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 5:{
                        break;
                    }
            }
        }

    });
    }



    public class SimpleApadter extends BaseAdapter{
        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title,description;
        private String[] titleArray;
        private String[] descriptionArray;
        private ImageView imageView;



        public SimpleApadter(Context context,String[] title,String[] description) {
            mContext=context;
            titleArray=title;
            descriptionArray=description;
            layoutInflater= LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("InflateParams")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null)
                convertView = layoutInflater.inflate(R.layout.mainactivitysingleitem, null);
            title=(TextView)convertView.findViewById(R.id.tvMain);
            description=(TextView)convertView.findViewById(R.id.tvDescription);
            imageView=(ImageView)convertView.findViewById(R.id.ivMain);

            title.setText(titleArray[position]);
            description.setText(descriptionArray[position]);
            if(titleArray[position].equalsIgnoreCase("Timetable")){
                imageView.setImageResource(R.drawable.timetable1);
            }else if(titleArray[position].equalsIgnoreCase("Subject")){
                imageView.setImageResource(R.drawable.subjects);
            }else if(titleArray[position].equalsIgnoreCase("Faculty")) {
                imageView.setImageResource(R.drawable.fac);
            }else if(titleArray[position].equalsIgnoreCase("Resources")) {
                imageView.setImageResource(R.drawable.resources);
            }
            else{
                imageView.setImageResource(R.drawable.events);
            }
            return convertView;



        }
    }
}