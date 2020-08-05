package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class FcultyDetails extends AppCompatActivity {

    private CircleImageView facultyImage;
    private Toolbar toolbar;
    private TextView facultyName;
    private TextView phoneNumber;
    private TextView email;
    private TextView place;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fculty_details);

        setupUIViews();
        initToolbar();
        setupDetails();
    }
    private void setupUIViews(){
        toolbar= (Toolbar) findViewById(R.id.ToolbarFacultyDetails);
        facultyImage=(CircleImageView) findViewById(R.id.ivFaculty);
        facultyName=(TextView)findViewById(R.id.tvFacultySelName);
        phoneNumber=(TextView)findViewById(R.id.tvPhoneNo);
        email=(TextView)findViewById(R.id.tvEmailId);
        place=(TextView)findViewById(R.id.tvStaffRoomno);
    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Faculty details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupDetails() {
        int faculty_pos = Faculty.sharedPreferences.getInt(Faculty.SEL_Faculty, 0);
        String[] facultyNames = getResources().getStringArray(R.array.faculty_name);
        int[] facultyImages = new int[]{R.drawable.shabbir, R.drawable.mohiuddin, R.drawable.maniza, R.drawable.keerthi, R.drawable.manjusha, R.drawable.mohiuddin};
        int[] facultyArray = new int[]{R.array.DrShabbeer, R.array.Mohiuddin, R.array.ManizaHijab, R.array.KrishnaKeerthi, R.array.Manjusha, R.array.Amanullah};
        String[] facultyDetails = getResources().getStringArray(facultyArray[faculty_pos]);
        phoneNumber.setText(facultyDetails[0]);
        email.setText(facultyDetails[1]);
        place.setText(facultyDetails[2]);
        facultyImage.setImageResource(facultyImages[faculty_pos]);
        facultyName.setText(facultyNames[faculty_pos]);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:{
                onBackPressed();

            }
        }
        return super.onOptionsItemSelected(item);
    }
}
