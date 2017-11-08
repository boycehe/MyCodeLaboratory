package com.example.heboyce.learnandroid.Day4;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.example.heboyce.learnandroid.R;

public class LearnToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_toast);

        Button simple = (Button)findViewById(R.id.btn221);
        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(LearnToastActivity.this,"简单的提示信息",Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        Button bn = (Button)findViewById(R.id.btn222);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(LearnToastActivity.this);
                toast.setGravity(Gravity.CENTER,0,0);
                ImageView image = new ImageView(LearnToastActivity.this);
                image.setImageResource(R.drawable.tools);
                LinearLayout ll = new LinearLayout(LearnToastActivity.this);
                ll.addView(image);
                TextView textView = new TextView(LearnToastActivity.this);
                textView.setText("带图片的提示信息");
                textView.setTextColor(Color.MAGENTA);
                ll.addView(textView);
                toast.setView(ll);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_toast, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
