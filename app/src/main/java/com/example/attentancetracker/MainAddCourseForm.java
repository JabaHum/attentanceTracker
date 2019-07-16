package com.example.attentancetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainAddCourseForm extends AppCompatActivity {
    Button add_save_btn;
    EditText courseNumber;
    EditText courseName;
    EditText courseSemester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_add_course_form);

        courseNumber = findViewById(R.id.edt_coursecode);
        courseName = findViewById(R.id.edt_course);
        courseSemester = findViewById(R.id.edt_course_semester);


        add_save_btn = findViewById(R.id.btn_add_course);

        //setting button onClickListener
        add_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainAddCourseForm.this,"Course has been Saved",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_addcourse_activity,menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         int v = item.getItemId();
         if (v == R.id.action_addstudents){
             Intent intent = new Intent(MainAddCourseForm.this,AddStudentsActivity.class);
             startActivity(intent);
         }

        return super.onOptionsItemSelected(item);
    }
}
