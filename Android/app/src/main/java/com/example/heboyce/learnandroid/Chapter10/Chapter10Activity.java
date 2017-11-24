package com.example.heboyce.learnandroid.Chapter10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.heboyce.learnandroid.R;

public class Chapter10Activity extends AppCompatActivity {

    Button start,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter10);

        start = (Button)findViewById(R.id.start);
        stop  = (Button)findViewById(R.id.stop);

        final Intent intent = new Intent(this,FirstService.class);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });


    }
}
