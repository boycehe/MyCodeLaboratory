package com.example.heboyce.learnandroid.Day4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import com.example.heboyce.learnandroid.R;

public class LearnSearchViewActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private SearchView sv;
    private ListView   lv;

    private final String[] mStrings ={"aaa","bbbbbb","cccccc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_search_view);

        lv = (ListView)findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mStrings));
        lv.setTextFilterEnabled(true);
        sv = (SearchView)findViewById(R.id.sv);
        sv.setIconifiedByDefault(false);
        sv.setOnQueryTextListener(this);
        sv.setSubmitButtonEnabled(true);
        //sv.setQuery("查找");
        sv.setQuery("查找",true);


    }

    @Override
    public   boolean onQueryTextChange(String newText){

        if (TextUtils.isEmpty(newText)){
            lv.clearTextFilter();
        }else {
            lv.setFilterText(newText);
        }

        return true;
    }

    @Override
    public  boolean onQueryTextSubmit(String query){
        Toast.makeText(this,"您的选择是："+query,Toast.LENGTH_SHORT).show();
        return  true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_search_view, menu);
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
