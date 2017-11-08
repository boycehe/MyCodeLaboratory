package com.example.heboyce.learnandroid.Day4;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.example.heboyce.learnandroid.R;

public class LearnActionBarItemActivity extends AppCompatActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_action_bar_item);
        txt = (TextView) findViewById(R.id.txt11);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_action_bar_item, menu);
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi) {

        if(mi.isCheckable())
        {
            mi.setChecked(true);  //¢Ú
        }

        switch (mi.getItemId())
        {
            case R.id.font_10:
                txt.setTextSize(10 * 2);
                break;
            case R.id.font_12:
                txt.setTextSize(12 * 2);
                break;
            case R.id.font_14:
                txt.setTextSize(14 * 2);
                break;
            case R.id.font_16:
                txt.setTextSize(16 * 2);
                break;
            case R.id.font_18:
                txt.setTextSize(18 * 2);
                break;
            case R.id.red_font:
                txt.setTextColor(Color.RED);
                mi.setChecked(true);
                break;
            case R.id.green_font:
                txt.setTextColor(Color.GREEN);
                mi.setChecked(true);
                break;
            case R.id.blue_font:
                txt.setTextColor(Color.BLUE);
                mi.setChecked(true);
                break;
            case R.id.plain_item:
                Toast toast = Toast.makeText(LearnActionBarItemActivity.this, "哈哈",
                        Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
        return true;
    }

}
