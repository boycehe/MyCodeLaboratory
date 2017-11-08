package com.example.heboyce.learnandroid.Day4;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.heboyce.learnandroid.R;

public class LearnContextMenuActivity extends AppCompatActivity {


    final int MENU1 = 0x111;
    final int MENU2 = 0x112;
    final int MENU3 = 0x113;

    private TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_context_menu);
        txt = (TextView) findViewById(R.id.txt11);
        registerForContextMenu(txt);
    }




    @Override
    public void onCreateContextMenu(ContextMenu menu,View source,ContextMenu.ContextMenuInfo menuInfo){

        Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();
        menu.add(0,MENU1,0,"红色");
        menu.add(0,MENU2,0,"绿色");
        menu.add(0,MENU3,0,"蓝色");
        menu.setGroupCheckable(0,true,true);
        menu.setHeaderIcon(R.drawable.tools);
        menu.setHeaderTitle("选择背景色");

    }

    @Override
    public boolean onContextItemSelected(MenuItem mi){

        switch (mi.getItemId()){

            case MENU1:
                mi.setCheckable(true);
                txt.setBackgroundColor(Color.RED);
                break;
            case MENU2:
                mi.setCheckable(true);
                txt.setBackgroundColor(Color.GREEN);
                break;
            case MENU3:
                mi.setCheckable(true);
                txt.setBackgroundColor(Color.BLUE);
                break;
            default:
                break;


        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_context_menu, menu);
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
