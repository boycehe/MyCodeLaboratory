package com.example.heboyce.learnandroid.Day3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import com.example.heboyce.learnandroid.R;

public class LearnAutoCompleteTextView extends AppCompatActivity {

    AutoCompleteTextView actv;
    MultiAutoCompleteTextView mauto;


    String[] books = new String[]{

            "疯狂的Java讲义",
            "疯狂的Ajax讲义",
            "疯狂XML讲义",
            "疯狂Workflow讲义",

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_auto_complete_text_view);


        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,books);
        actv = (AutoCompleteTextView)findViewById(R.id.auto);
        actv.setAdapter(aa);
        mauto = (MultiAutoCompleteTextView)findViewById(R.id.mauto);
        mauto.setAdapter(aa);
        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_auto_complete_text_view, menu);
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
