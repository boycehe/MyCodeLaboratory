package com.example.heboyce.learnandroid.Day2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.heboyce.learnandroid.R;

public class CustomView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.draw_view);
       //  LinearLayout root   = (LinearLayout) findViewById(R.id.root);

       // DrawView drawView = (DrawView)findViewById(R.layout.draw_view);

       // setContentView(drawView);
        //Solve 1
      //  setContentView(R.layout.draw_view);

        /*
        LinearLayout root = new LinearLayout(this);
        super.setContentView(root);
        //垂直
        root.setOrientation(LinearLayout.VERTICAL);
        final DrawView view = new DrawView(this);
        view.setMinimumHeight(500);
        view.setMinimumWidth(300);
        root.addView(view);
        */

    }

}
