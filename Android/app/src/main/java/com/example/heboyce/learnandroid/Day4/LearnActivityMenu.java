package com.example.heboyce.learnandroid.Day4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import com.example.heboyce.learnandroid.Day1.OtherActiviyt;
import com.example.heboyce.learnandroid.R;

public class LearnActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_activity_menu);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        SubMenu prog = menu.addSubMenu("启动程序");
        prog.setHeaderIcon(R.drawable.tools);
        prog.setHeaderTitle("选择您要启动的程序");

        MenuItem item = prog.add("查看经典Java EE");
        item.setIntent(new Intent(this, OtherActiviyt.class));
        return super.onCreateOptionsMenu(menu);

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
