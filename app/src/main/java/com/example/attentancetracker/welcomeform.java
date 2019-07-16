package com.example.attentancetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class welcomeform extends AppCompatActivity {
    Button manageButton;
    Button scanButton;
    Button viewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomeform);

        manageButton =findViewById(R.id.btn_manage);
        scanButton =findViewById(R.id.btn_scan);
        viewButton =findViewById(R.id.btn_view_attendance);


        manageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addcourse = new Intent(welcomeform.this,MainAddCourseForm.class);
                addcourse.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(addcourse);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int v = item.getItemId();
        if (v == R.id.action_download_student_info){
            Intent intent = new Intent(welcomeform.this,DownloadFilesActivity.class);
            startActivity(intent);
        }else  if (v == R.id.action_settings){
            Toast.makeText(welcomeform.this,"You clicked on Settings",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
