package com.example.heboyce.learnandroid.Day4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.example.heboyce.learnandroid.R;

public class LearnWindowProgress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_PROGRESS);
       // requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

        setContentView(R.layout.activity_learn_window_progress);

        Button bn1 = (Button)findViewById(R.id.bn11);
        Button bn2 = (Button)findViewById(R.id.bn22);

        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressBarIndeterminateVisibility(true);
                setProgressBarVisibility(true);
                setProgress(4500);
            }
        });

        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressBarIndeterminateVisibility(false);
                setProgressBarVisibility(false);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_window_progress, menu);
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
