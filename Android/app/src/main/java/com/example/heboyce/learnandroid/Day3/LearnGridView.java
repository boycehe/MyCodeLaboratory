package com.example.heboyce.learnandroid.Day3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import com.example.heboyce.learnandroid.R;

import java.util.*;

public class LearnGridView extends AppCompatActivity {



    GridView grid;
    ImageView imageView;

    int[] imageIds = new int[]{
      R.drawable.bomb5,
            R.drawable.bomb6,
            R.drawable.bomb7,
            R.drawable.bomb8,
            R.drawable.bomb9,
            R.drawable.bomb10,
            R.drawable.bomb11,
            R.drawable.bomb12,
            R.drawable.bomb13,
            R.drawable.bomb14,
            R.drawable.bomb15,
            R.drawable.bomb16,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_grid_view);

        List<Map<String ,Object>> listItems = new ArrayList<Map<String ,Object>>();
        for (int i = 0;i < imageIds.length;i++){
            Map<String ,Object> listItem = new HashMap<String,Object>();
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);
        }

        imageView = (ImageView) findViewById(R.id.imageView);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.cell,new String[]{"image"},new int[]{R.id.image11});
        grid = (GridView)findViewById(R.id.grid01);
        grid.setAdapter(simpleAdapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(imageIds[position]);
            }



        });

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(imageIds[position]);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_grid_view, menu);
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
