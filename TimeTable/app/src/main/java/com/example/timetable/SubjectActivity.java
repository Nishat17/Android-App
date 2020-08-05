package com.example.timetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.timetable.Utils.LetterImageView;

public class SubjectActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    private String[] subjects;
    public static SharedPreferences subjectpreferences;
    public static String SUB_PREF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        setupUIViews();
        initToolbar();
        setupListView();
    }
    private void setupUIViews(){
        toolbar=(Toolbar)findViewById(R.id.ToolbarSubject);
        listView=(ListView)findViewById(R.id.lvSubject);
        subjectpreferences=getSharedPreferences("Subjects",MODE_PRIVATE);

    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Subject");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListView(){
        subjects=getResources().getStringArray(R.array.Subjects);

        SubjectAdapter subjectAdapter=new SubjectAdapter(this,R.layout.subjectsingleitem,subjects);
        listView.setAdapter(subjectAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:{
                        subjectpreferences.edit().putString(SUB_PREF,"Data Structures").apply();
                        Intent intent=new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 1:
                    {
                        subjectpreferences.edit().putString(SUB_PREF,"Mathematics III").apply();
                        Intent intent=new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 2:
                    {
                        subjectpreferences.edit().putString(SUB_PREF,"Discrete Mathematics").apply();
                        Intent intent=new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 3:{
                        subjectpreferences.edit().putString(SUB_PREF,"Basic Electronics Eng").apply();
                        Intent intent=new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 4:
                    {
                        subjectpreferences.edit().putString(SUB_PREF,"Logic Switching Theory").apply();
                        Intent intent=new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 5:{
                        subjectpreferences.edit().putString(SUB_PREF,"Environmental Sciences").apply();
                        Intent intent=new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }
                    default:break;
                }
            }
        });
    }
    public class SubjectAdapter extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] subjects=new String[]{};

        public SubjectAdapter(Context context, int resource, String[] objects){
            super(context,resource,objects);
            this.resource=resource;
            this.subjects=objects;
            layoutInflater=(LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }


        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                holder=new ViewHolder();
                convertView=layoutInflater.inflate(resource,null);
                holder.ivLogo=(LetterImageView)convertView.findViewById(R.id.ivLetterSubject);
                holder.tvSubject=(TextView)convertView.findViewById(R.id.tvSubject);
                convertView.setTag(holder);

            }
            else{
                holder=(ViewHolder)convertView.getTag();
            }
            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(subjects[position].charAt(0));
            holder.tvSubject.setText(subjects[position]);

            return convertView;
        }
        class ViewHolder{
            public TextView tvSubject;
            private LetterImageView ivLogo;

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:{
                onBackPressed();

            }
        }
        return super.onOptionsItemSelected(item);
    }
}


