package com.example.heboyce.learnandroid.Day3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.example.heboyce.learnandroid.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterTest extends AppCompatActivity {



    private String[] names = new String[]{"虎头","弄玉","李清照","李白"};
    private String[] descs = new String[]{"可爱的小孩","一个擅长音乐的女哈","一个擅长文学的女性","浪漫主义诗人"};
    private int[] imageIds = new int[]{R.drawable.tiger,
            R.drawable.nongyu,
            R.drawable.qingzhao,
            R.drawable.libai};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_test);

        List<Map<String,Object>> listItems = new ArrayList<Map<String, Object>>();

        for (int i = 0;i < names.length;i++){

            Map<String,Object> listItem = new HashMap<String,Object>();
            listItem.put("header",imageIds[i]);
            listItem.put("personName",names[i]);
            listItem.put("desc",descs[i]);
            listItems.add(listItem);

        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.simple_item,new String[]{"personName","header","desc"},new int[]{R.id.name,R.id.header,R.id.desc});
        ListView list = (ListView)findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_simple_adapter_test, menu);
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
