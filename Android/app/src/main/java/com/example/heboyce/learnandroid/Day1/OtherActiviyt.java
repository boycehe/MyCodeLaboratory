package com.example.heboyce.learnandroid.Day1;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.example.heboyce.learnandroid.R;

public class OtherActiviyt extends LauncherActivity implements AdapterView.OnItemClickListener{

    String[] names = {"设置程序参数","查看星级兵种"};

    Class<?>[] clazzs = {PreferenceActivityTest.class, ExpandableListActivityTest.class};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);

        setListAdapter(adapter);
    }


    @Override
    public Intent intentForPosition(int position){
        return  new Intent(OtherActiviyt.this,clazzs[position]);

    }

    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Intent itent= intentForPosition(position);
        itent.setClass(OtherActiviyt.this, clazzs[position]);
        startActivity(itent);
        OtherActiviyt.this.finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_other_activiyt, menu);
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
