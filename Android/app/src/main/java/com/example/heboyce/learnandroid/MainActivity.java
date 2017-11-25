package com.example.heboyce.learnandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.heboyce.learnandroid.Chapter10.Chapter10Activity;
import com.example.heboyce.learnandroid.Chapter10.Chapter10TeleActivity;
import com.example.heboyce.learnandroid.Chapter8.Chapter81Activity;
import com.example.heboyce.learnandroid.Chapter8.Chapter82Activity;
import com.example.heboyce.learnandroid.Chapter8.Chapter841Activity;
import com.example.heboyce.learnandroid.Chapter9.Chapter92Activity;
import com.example.heboyce.learnandroid.Day1.OtherActiviyt;
import com.example.heboyce.learnandroid.Day2.Day2ListView;
import com.example.heboyce.learnandroid.Day3.TextViewList;
import com.example.heboyce.learnandroid.Day4.Day4List;
import com.example.heboyce.learnandroid.Day5.EventListActivity;
import com.example.heboyce.learnandroid.Day6.Day6ListAcitvity;
import com.example.heboyce.learnandroid.Day7.Day703Activity;
import com.example.heboyce.learnandroid.Day7.Day7ContactActivity;
import com.example.heboyce.learnandroid.Day7.Day7DataTypeActivity;
import com.example.heboyce.learnandroid.Day7.Day7HomeActivity;
import com.example.heboyce.learnandroid.Day8.Day8AnimActivity;
import com.example.heboyce.learnandroid.Day8.Day8ClipActivity;
import com.example.heboyce.learnandroid.Day8.Day8DrawActivity;
import com.example.heboyce.learnandroid.Day8.Day8GameActivity;
import com.example.heboyce.learnandroid.Day8.Day8MarblesActivity;
import com.example.heboyce.learnandroid.Day8.Day8MeshPicActivity;
import com.example.heboyce.learnandroid.Day8.Day8XMLActivity;
import com.example.heboyce.learnandroid.Day8.Day9ShapeActivity;
import com.example.heboyce.learnandroid.Day9.Day9Chapter772ShowWaveAcitvity;
import com.example.heboyce.learnandroid.Day9.Day9Chapter77SurfaceViewActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list1 = (ListView)findViewById(R.id.list1);
        String[] arr1 = {"深入理解Activity与Fragment--Day1",
                         "布局学习",
                        "TextView学习",
                        "UI学习",
                        "Android的事件处理",
                        "图形与图像处理",
                        "使用Intent和IntentFilter进行通信",
                        "测试用的"
        };

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.array_item,arr1);
        list1.setAdapter(adapter1);
        list1.setOnItemClickListener(this);

    }


    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Intent itent=new Intent();

        switch (position){

            case 0:
            {
                itent.setClass(MainActivity.this, OtherActiviyt.class);
            }
                break;
            case 1:
            {
                itent.setClass(MainActivity.this, Day2ListView.class);
            }
                break;
            case 2:
            {
                itent.setClass(MainActivity.this, TextViewList.class);
            }
            break;
            case 3:
            {
                itent.setClass(MainActivity.this, Day4List.class);
            }
            break;
            case 4:
            {
                itent.setClass(MainActivity.this, EventListActivity.class);
            }
            break;
            case 5:
            {
                itent.setClass(MainActivity.this, Day6ListAcitvity.class);
            }
            break;
            case 6:
            {
                itent.setClass(MainActivity.this, Day703Activity.class);
            }
            break;
            case 7:
            {
                itent.setClass(MainActivity.this,Chapter10TeleActivity.class);
                //393
            }
                break;
            default:
                break;

        }

        startActivity(itent);
        MainActivity.this.finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
