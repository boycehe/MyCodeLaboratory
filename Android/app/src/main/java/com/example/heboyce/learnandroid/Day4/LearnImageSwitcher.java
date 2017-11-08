package com.example.heboyce.learnandroid.Day4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.heboyce.learnandroid.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LearnImageSwitcher extends AppCompatActivity {


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

    ImageSwitcher switcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_image_switcher);

        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();

        for (int i = 0;i < imageIds.length;i++){
            Map<String,Object> listItem = new HashMap<String,Object>();
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);
        }

        switcher = (ImageSwitcher)findViewById(R.id.switcher);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(LearnImageSwitcher.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.cell,new String[]{"image"},new int[]{R.id.image11});
        GridView grid = (GridView)findViewById(R.id.grid02);
        grid.setAdapter(simpleAdapter);
        grid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switcher.setImageResource(imageIds[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switcher.setImageResource(imageIds[position]);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_image_switcher, menu);
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
