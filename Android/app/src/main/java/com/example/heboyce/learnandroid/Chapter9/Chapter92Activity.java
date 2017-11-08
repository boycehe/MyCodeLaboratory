package com.example.heboyce.learnandroid.Chapter9;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.heboyce.learnandroid.R;

public class Chapter92Activity extends AppCompatActivity {

    ContentResolver contentResolver;
    Uri uri = Uri.parse("content://org.crazyit.providers.firstprovider/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter92);
        contentResolver = getContentResolver();
    }

    public void query(View source){

        Cursor c = contentResolver.query(uri,null,"query_where",null,null);
        Toast.makeText(this,"远程ContentProvider返回的Cursor为：" + c,Toast.LENGTH_SHORT).show();

    }

    public void insert(View source){

        ContentValues values = new ContentValues();
        values.put("name","fkjava");
        Uri newUri = contentResolver.insert(uri,values);
        Toast.makeText(this,"远程ContentProvider新插入记录的Uri为：" + newUri,Toast.LENGTH_SHORT).show();

    }

    public void update(View source){

        ContentValues values = new ContentValues();
        values.put("name","fkjava");
        int count = contentResolver.update(uri,values,"update_where",null);
        Toast.makeText(this,"远程ContentProvider更新记录的Uri为：" + count,Toast.LENGTH_SHORT).show();

    }

    public void delete(View source){
        int count = contentResolver.delete(uri,"delete_where",null);
        Toast.makeText(this,"远程ContentProvider删除记录的Uri为：" + count,Toast.LENGTH_SHORT).show();
    }



}
