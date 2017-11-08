package com.example.heboyce.learnandroid.Chapter8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.heboyce.learnandroid.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Chapter82Activity extends AppCompatActivity {

    String FILE_NAME = "crazyit.bin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter82);

        System.out.println(new StringBuilder("a").append("b").append("c").toString());
        final Button read = (Button)findViewById(R.id.read);
        final Button write = (Button)findViewById(R.id.write);
        final EditText edit1 = (EditText)findViewById(R.id.edit1);
        final EditText edit2 = (EditText)findViewById(R.id.edit2);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write(edit1.getText().toString());
                edit1.setText("");
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit2.setText(read());
            }
        });

    }


    private String read(){

        try{
            FileInputStream fis = openFileInput(FILE_NAME);
            byte[] buff = new byte[1024];
            int hasRead = 0;
            StringBuilder sb = new StringBuilder("");
            while ((hasRead = fis.read(buff))>0){
                sb.append(new String(buff,0,hasRead));
            }
            fis.close();
            return sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    private void write(String content){

        try {
            FileOutputStream fos = openFileOutput(FILE_NAME,MODE_APPEND);
            PrintStream ps = new PrintStream(fos);
            ps.println(content);
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
