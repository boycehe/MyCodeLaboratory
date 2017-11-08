package com.example.heboyce.learnandroid.Day8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.heboyce.learnandroid.R;

public class Day8AnimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day8_anim);

        final ImageView image = (ImageView)findViewById(R.id.image);
        final Animation anim = AnimationUtils.loadAnimation(this,R.anim.my_anim);
        anim.setFillAfter(true);
        Button bn = (Button)findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.startAnimation(anim);
            }
        });

    }
}
