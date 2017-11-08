package com.example.heboyce.learnandroid.Day7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.heboyce.learnandroid.R;

public class Day7CategoryActivity extends AppCompatActivity {

    final static String CRAZYIT_ACTION = "com.example.heboyce.learnandroid.Day7.CRAZYIT_ACTION";
    final static String CRAZYIT_CATEGORY = "com.example.heboyce.learnandroid.Day7.CRAZYIT_CATEGORY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day7_category);

        Button bn = (Button)findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Day7CategoryActivity.CRAZYIT_ACTION);
                intent.addCategory(Day7CategoryActivity.CRAZYIT_CATEGORY);
                startActivity(intent);
            }
        });



    }
}
