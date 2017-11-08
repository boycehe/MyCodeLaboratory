package com.example.heboyce.learnandroid.Day2;

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

public class Day2ListView extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day2_list_view);

        ListView list1 = (ListView)findViewById(R.id.day2_listView);
        String[] arr1 = {"用编程式的方式开发UI界面",
                          "简单的图片浏览器",
                          "跟随手指的小球",
                          "线性布局",
                          "表格布局",
                          "帧布局",
                "梅花",
                "计数器"
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
                itent.setClass(Day2ListView.this, CodeView.class);
            }
            break;
            case 1:
            {
                itent.setClass(Day2ListView.this, MixView.class);
            }
            break;
            case 2:
            {
                itent.setClass(Day2ListView.this, CustomView.class);
            }
            break;
            case 3:
            {
                itent.setClass(Day2ListView.this, LinearActivity.class);
            }
                break;
            case 4:
            {
                itent.setClass(Day2ListView.this, TableLayout.class);
            }
                break;
            case 5:
            {
                itent.setClass(Day2ListView.this, LearnFrameLayout.class);
            }
            break;
            case 6:
            {
                itent.setClass(Day2ListView.this,LearnRelativeLayout.class);
            }
            break;
            case 7:
            {
                itent.setClass(Day2ListView.this,LearnGridLayout.class);
            }
            break;
            default:
                break;

        }

        startActivity(itent);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_day2_list_view, menu);
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
