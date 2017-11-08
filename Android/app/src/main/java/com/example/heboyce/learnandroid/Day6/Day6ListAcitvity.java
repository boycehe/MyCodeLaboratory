package com.example.heboyce.learnandroid.Day6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.heboyce.learnandroid.R;

public class Day6ListAcitvity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day6_list_acitvity);
        ListView list1 = (ListView)findViewById(R.id.event_listView_day6);
        String[] arr1 = {
                "查询图片",
                "绘图图片",
        };

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.array_item,arr1);
        list1.setAdapter(adapter1);
        list1.setOnItemClickListener(this);

    }

    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {


        Toast.makeText(getApplicationContext(), "点击了" + position, Toast.LENGTH_LONG).show();

        Intent itent = new Intent();

        switch (position){

            case 0:
            {
              itent.setClass(Day6ListAcitvity.this,BitmapTest.class);
            }
            break;
            case 1:
            {
                itent.setClass(Day6ListAcitvity.this,DrawPicture.class);
            }
            break;
            default:
                break;

        }

        startActivity(itent);
        Day6ListAcitvity.this.finish();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_day6_list_acitvity, menu);
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
