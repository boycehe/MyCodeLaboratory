package com.example.heboyce.learnandroid.Chapter9;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.heboyce.learnandroid.MainActivity;
import com.example.heboyce.learnandroid.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DictResolverActivity extends AppCompatActivity {

    ContentResolver contentResolver;
    Button insert = null;
    Button search = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dict_resolver);

        contentResolver = getContentResolver();
        insert = (Button)findViewById(R.id.insert);
        search = (Button)findViewById(R.id.search);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = ((EditText)findViewById(R.id.word)).getText().toString();
                String detail = ((EditText)findViewById(R.id.detail)).getText().toString();
                ContentValues values = new ContentValues();
                values.put(Words.Word.WORD,word);
                values.put(Words.Word.DETALL,detail);
                contentResolver.insert(Words.Word.DICT_CONTENT_URI,values);
                Toast.makeText(DictResolverActivity.this,"添加生词成功！",Toast.LENGTH_SHORT).show();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key =  ((EditText)findViewById(R.id.key)).getText().toString();
                Cursor cursor = contentResolver.query(Words.Word.DICT_CONTENT_URI, null,"word like ? or detail like ?",new String[]{"%",key+"%","%"+key+"%"},null);
                Bundle data = new Bundle();
                data.putSerializable("data",converCursorToList(cursor));
                Intent intent = new Intent(DictResolverActivity.this,null);
                intent.putExtras(data);
                startActivity(intent);

            }
        });

    }

    private ArrayList<Map<String,String>> converCursorToList(Cursor cursor){

        ArrayList<Map<String,String>> result = new ArrayList<>();
        while (cursor.moveToNext()){

            Map<String ,String> map = new HashMap<>();
            map.put(Words.Word.WORD,cursor.getString(1));
            map.put(Words.Word.DETALL,cursor.getString(2));
            result.add(map);



        }

        return result;

    }
}
