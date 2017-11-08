package com.example.heboyce.learnandroid.Day3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;
import com.example.heboyce.learnandroid.R;

public class LearnToggButtonAndSwitch extends AppCompatActivity {

    ToggleButton toggle;
    Switch switcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_togg_button_and_switch);

        toggle = (ToggleButton) findViewById(R.id.toggle);
        switcher = (Switch)findViewById(R.id.switcher);
        final LinearLayout test = (LinearLayout)findViewById(R.id.test);

        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    test.setOrientation(1);
                }else {
                    test.setOrientation(0);
                }

            }
        };

        toggle.setOnCheckedChangeListener(listener);
        switcher.setOnCheckedChangeListener(listener);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_togg_button_and_switch, menu);
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
