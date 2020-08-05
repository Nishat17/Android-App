package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.example.timetable.Utils.LetterImageView;

public class DayDetail extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;
    public static String[] Monday;
    public static String[] Tuesday;
    public static String[] Wednesday;
    public static String[] Thursday;
    public static String[] Friday;
    public static String[] Saturday;
    public static String[] Time1;
    public static String[] Time2;
    public static String[] Time3;
    public static String[] Time4;
    public static String[] Time5;
    public static String[] Time6;
    private String[] PreferredDay;
    private String[] PreferredTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_detail);
        setupUIViews();
        initToolbar();
        setupListView();

    }

    private void setupUIViews() {
        listView = (ListView) findViewById(R.id.lvDayDetail);
        toolbar = (Toolbar) findViewById(R.id.ToolbarDayDetail);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(WeekActivityy.sharedPreferences.getString(WeekActivityy.SEL_DAY, null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView() {

        Monday = getResources().getStringArray(R.array.Monday);
        Tuesday = getResources().getStringArray(R.array.Tuesday);
        Wednesday = getResources().getStringArray(R.array.Wednesday);
        Thursday = getResources().getStringArray(R.array.Thursday);
        Friday = getResources().getStringArray(R.array.Friday);
        Saturday = getResources().getStringArray(R.array.Saturday);

        Time1 = getResources().getStringArray(R.array.Time1);
        Time2 = getResources().getStringArray(R.array.Time2);
        Time3 = getResources().getStringArray(R.array.Time3);
        Time4 = getResources().getStringArray(R.array.Time4);
        Time5 = getResources().getStringArray(R.array.Time5);
        Time6 = getResources().getStringArray(R.array.Time6);

        String selected_day = WeekActivityy.sharedPreferences.getString(WeekActivityy.SEL_DAY, null);

        if (selected_day.equalsIgnoreCase("Monday")) {
            PreferredDay = Monday;
            PreferredTime = Time1;
        } else if (selected_day.equalsIgnoreCase("Monday")) {
            PreferredDay = Tuesday;
            PreferredTime = Time2;

        } else if (selected_day.equalsIgnoreCase("Monday")) {
            PreferredDay = Wednesday;
            PreferredTime = Time3;

        } else if (selected_day.equalsIgnoreCase("Monday")) {
            PreferredDay = Thursday;
            PreferredTime = Time4;

        } else if (selected_day.equalsIgnoreCase("Monday")) {
            PreferredDay = Friday;
            PreferredTime = Time5;

        } else {
            PreferredDay = Saturday;
            PreferredTime = Time6;
        }
        SimpleApadter simpleadapter = new SimpleApadter(this, PreferredDay, PreferredTime);
        listView.setAdapter(simpleadapter);
    }

    public class SimpleApadter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView Subject, Time;
        private String[] SubjectArray;
        private String[] TimeArray;
        private LetterImageView letterimageView;


        public SimpleApadter(Context context, String[] SubjectArray, String[] TimeArray) {
            mContext = context;
            this.SubjectArray = SubjectArray;
            this.TimeArray = TimeArray;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return SubjectArray.length;
        }

        @Override
        public Object getItem(int position) {
            return SubjectArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("InflateParams")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = layoutInflater.inflate(R.layout.daydetailsingleitem, null);
            Subject = (TextView) convertView.findViewById(R.id.tvSubDayDetails);
            Time = (TextView) convertView.findViewById(R.id.tvTimeDayDetail);
            letterimageView = (LetterImageView) convertView.findViewById(R.id.ivDayDetails);

            Subject.setText(SubjectArray[position]);
            Time.setText(TimeArray[position]);

            letterimageView.setOval(true);
            letterimageView.setLetter(SubjectArray[position].charAt(0));

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

