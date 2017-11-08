package com.example.heboyce.learnandroid.Day7;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.heboyce.learnandroid.R;

public class Day701Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day701);
        Button bn = (Button)findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ComponentName comp = new ComponentName(Day701Activity.this,Day7002Activity.class);
                Intent intent  = new Intent();
                intent.setComponent(comp);
                startActivity(intent);


            }
        });

    }
}
