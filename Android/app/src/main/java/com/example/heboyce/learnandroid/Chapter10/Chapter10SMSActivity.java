package com.example.heboyce.learnandroid.Chapter10;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.heboyce.learnandroid.R;

public class Chapter10SMSActivity extends AppCompatActivity {


    EditText number,content;
    Button send;
    SmsManager sManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter10_sms);

        sManager = SmsManager.getDefault();
        number = (EditText)findViewById(R.id.number);
        content = (EditText)findViewById(R.id.content);
        send = (Button)findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PendingIntent pi = PendingIntent.getActivity(Chapter10SMSActivity.this,0,new Intent(),0);
                sManager.sendTextMessage(number.getText().toString(),null,content.getText().toString(),pi,null);
                Toast.makeText(Chapter10SMSActivity.this,"短信发送完成",Toast.LENGTH_SHORT).show();
            }
        });



    }
}
