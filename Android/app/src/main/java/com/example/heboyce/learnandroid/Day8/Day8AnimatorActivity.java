package com.example.heboyce.learnandroid.Day8;

import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.heboyce.learnandroid.R;

public class Day8AnimatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day8_animator);
      //  LinearLayout container = (LinearLayout)findViewById(R.id.container);
      //  container.addView(new MyAnimationView(this));

    }

    public class MyAnimationView extends View {

        public MyAnimationView(Context context){

            super(context);
            ObjectAnimator colorAnim = (ObjectAnimator) AnimatorInflater.loadAnimator(Day8AnimatorActivity.this,R.animator.color_anim);
            colorAnim.setEvaluator(new ArgbEvaluator());
            colorAnim.setTarget(this);
            colorAnim.start();

        }

    }
}
