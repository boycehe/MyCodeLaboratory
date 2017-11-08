package com.example.heboyce.learnandroid.Day6;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.example.heboyce.learnandroid.R;

public class DataTypeOverride extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_type_override);
    }

    public void overrideType(View source){

        Intent intent = new Intent();
        //先为Intent设置Type属性
        intent.setType("abc/xyz");
        //再为Intent设置Data属性，覆盖Type属性
        intent.setData(Uri.parse("lee://www.fkjava.org:8888/test"));
        Toast.makeText(this,intent.toString(),Toast.LENGTH_LONG).show();

    }

    public void overrideData(View source){
        Intent intent = new Intent();
        intent.setData(Uri.parse("lee://www.fkjava.org:8888/mypath"));
        intent.setType("abc/xyz");
        Toast.makeText(this,intent.toString(),Toast.LENGTH_LONG).show();
    }

    public void dataAndType(View source){
        Intent intent = new Intent();
        intent.setDataAndType(Uri.parse("lee://www.fkjava.org:8888/mypath"),"abc/xyz");
        Toast.makeText(this,intent.toString(),Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_data_type_override, menu);
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
