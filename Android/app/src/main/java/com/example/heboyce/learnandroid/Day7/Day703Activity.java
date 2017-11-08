package com.example.heboyce.learnandroid.Day7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.heboyce.learnandroid.MainActivity;
import com.example.heboyce.learnandroid.R;

public class Day703Activity extends AppCompatActivity {

    public final static String CRAZYIT_ACTION = "com.example.heboyce.learnandroid.Day7.CRAZYIT_ACTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day703);

        Button bn = (Button)findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Day703Activity.CRAZYIT_ACTION);
                startActivity(intent);
            }
        });

    }
}
