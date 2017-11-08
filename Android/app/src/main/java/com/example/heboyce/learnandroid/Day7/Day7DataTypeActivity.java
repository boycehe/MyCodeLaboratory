package com.example.heboyce.learnandroid.Day7;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.heboyce.learnandroid.R;

public class Day7DataTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day7_data_type);

    }

    public void scheme(View source)
    {
        Intent intent = new Intent();
        // 只设置Intent的Data属性
        intent.setData(Uri.parse("lee://www.crazyit.org:1234/test"));
        startActivity(intent);
    }
    public void schemeHostPort(View source)
    {
        Intent intent = new Intent();
        // 只设置Intent的Data属性
        intent.setData(Uri.parse("lee://www.fkjava.org:8888/test"));
        startActivity(intent);
    }
    public void schemeHostPath(View source)
    {
        Intent intent = new Intent();
        // 只设置Intent的Data属性
        intent.setData(Uri.parse("lee://www.fkjava.org:1234/mypath"));
        startActivity(intent);
    }
    public void schemeHostPortPath(View source)
    {
        Intent intent = new Intent();
        // 只设置Intent的Data属性
        intent.setData(Uri.parse("lee://www.fkjava.org:8888/mypath"));
        startActivity(intent);
    }
    public void schemeHostPortPathType(View source)
    {
        Intent intent = new Intent();
        // 同时设置Intent的Data、Type属性
        intent.setDataAndType(Uri.parse("lee://www.fkjava.org:8888/mypath")
                , "abc/xyz");
        startActivity(intent);
    }

    public void overrideType(View source){

        Intent intent = new Intent();
        intent.setType("abc/xyz");
        intent.setData(Uri.parse("lee://www.fkjava.org:8888/test"));
        Toast.makeText(this,intent.toString(),Toast.LENGTH_LONG).show();;
    }

    public void overrideData(View source){
        Intent intent = new Intent();
        intent.setData(Uri.parse("lee://www.fkjava.org:8888/test"));
        intent.setType("abc/xyz");
        Toast.makeText(this,intent.toString(),Toast.LENGTH_LONG).show();
    }

    public void dataAndType(View source){

        Intent intent = new Intent();
        intent.setDataAndType(Uri.parse("lee://www.fkjava.org:8888/mypath"),"abc/xyz");
        Toast.makeText(this,intent.toString(),Toast.LENGTH_LONG).show();

    }

}
