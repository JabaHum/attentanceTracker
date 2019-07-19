package com.example.attentancetracker;

import android.app.ProgressDialog;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.attentancetracker.Adapters.CustomRecyclerviewAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ViewAttendanceActivity extends AppCompatActivity {

    //data
    // Log tag
    private static final String TAG = ViewAttendanceActivity.class.getSimpleName();

    // declare progresss bar
    private ProgressDialog pDialog;
    private  RecyclerView recyclerView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");

        pDialog.show();

        Log.i(TAG,"On Create method");

        ArrayList studentNames = new ArrayList<>(Arrays.asList("Settings", "Report Cards", "Electives",
                "Sms", "Email", "Database",
                "Statistics", "Schedules", "Accommodation"));
        ArrayList studentImages = new ArrayList<>(Arrays.asList(R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4,
                R.drawable.image5,
                R.drawable.image6,
                R.drawable.image7,
                R.drawable.image8,
                R.drawable.image9
        ));
        ArrayList studentIds = new ArrayList<>(Arrays.asList("250", "251", "252",
                "253", "254", "256",
                "257", "258", "258"));


        // Recyclerview set up with Layout manager

        RecyclerView recyclerView = findViewById(R.id.view_attendance_recycler);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter
        RecyclerView.Adapter mAdapter = new CustomRecyclerviewAdapter
                (studentNames,studentIds,studentImages,ViewAttendanceActivity.this);
        recyclerView.setAdapter(mAdapter);
        //hide progress bar /dialog
        hidePDialog();



    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }


}
