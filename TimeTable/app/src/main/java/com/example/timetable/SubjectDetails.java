package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SubjectDetails extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_details);
        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarSubjectDetails);
        listView = (ListView) findViewById(R.id.lvSubjectDetails);


    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Syllabus");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView() {
        String subject_selected = SubjectActivity.subjectpreferences.getString(SubjectActivity.SUB_PREF, null);
        String[] syllabus = new String[]{};
        String[] titles=getResources().getStringArray(R.array.titles);

        if (subject_selected.equalsIgnoreCase("Data Structures")) {
            syllabus = getResources().getStringArray(R.array.DataStructures);
        } else if (subject_selected.equalsIgnoreCase("Mathematics III")) {
            syllabus = getResources().getStringArray(R.array.MathematicsIII);
        } else if (subject_selected.equalsIgnoreCase("Discrete Mathematics")) {
            syllabus = getResources().getStringArray(R.array.DiscreteMathematics);
        } else if (subject_selected.equalsIgnoreCase("Basic Electronics Eng")) {
            syllabus = getResources().getStringArray(R.array.BasicElectronicsEng);
        } else if (subject_selected.equalsIgnoreCase("Logic Switching Theory")) {
            syllabus = getResources().getStringArray(R.array.LogicSwitchingTheory);
        } else {
            syllabus = getResources().getStringArray(R.array.EnvironmentalSciences);
        }
        SubjectDetailsApadter subjectDetailsApadter=new SubjectDetailsApadter(this,titles,syllabus);
        listView.setAdapter(subjectDetailsApadter);

        }
    public class SubjectDetailsApadter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title,syllabus;
        private String[] titleArray;
        private String[] syllabusArray;




        public SubjectDetailsApadter(Context context,String[] title,String[] syllabus) {
            mContext=context;
            titleArray=title;
            syllabusArray=syllabus;
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
                convertView = layoutInflater.inflate(R.layout.subjectdetailsingleitem, null);
            title=(TextView)convertView.findViewById(R.id.tvSubjectTitle);
            syllabus=(TextView)convertView.findViewById(R.id.tvSyllabus);


            title.setText(titleArray[position]);
            syllabus.setText(syllabusArray[position]);

            return convertView;



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

