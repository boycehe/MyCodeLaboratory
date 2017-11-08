package com.example.heboyce.learnandroid.Day5;

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

public class EventListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        ListView list1 = (ListView)findViewById(R.id.event_listView);
        String[] arr1 = {
                "控制飞机移动",
                "发短信",
                "Activity本身作为事件监听",
                "异步指数",
                "开发显示图书详情的Fragment",
                "查看并获取联系人电话",

        };

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.array_item,arr1);
        list1.setAdapter(adapter1);
        list1.setOnItemClickListener(this);
        return true;
    }


    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Toast.makeText(getApplicationContext(), "点击了" + position, Toast.LENGTH_LONG).show();

        Intent itent = new Intent();

        switch (position){

            case 0:
            {
                itent.setClass(EventListActivity.this, PlaneGame.class);
            }
            break;
            case 1:
            {
                itent.setClass(EventListActivity.this,SendSmsActivity.class);
            }
            break;
            case 2:
            {
                itent.setClass(EventListActivity.this,AnonymousListener.class);
            }
            break;
            case 3:
            {
                itent.setClass(EventListActivity.this,CalPrime.class);
            }
            break;
            case 4:
            {
                itent.setClass(EventListActivity.this,BookDetailFragment.class);
            }
            break;
            case 5:
            {
                itent.setClass(EventListActivity.this,SysActionActivity.class);
            }
            break;
            default:
                break;

        }

        startActivity(itent);


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
