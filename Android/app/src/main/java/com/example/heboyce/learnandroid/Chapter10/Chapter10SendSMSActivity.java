package com.example.heboyce.learnandroid.Chapter10;

import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.heboyce.learnandroid.R;

import java.util.ArrayList;

public class Chapter10SendSMSActivity extends AppCompatActivity {


    EditText numbers,content;
    Button select,send;
    SmsManager sManager;

    ArrayList<String> sendList = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter10_send_sms);

        sManager = SmsManager.getDefault();
        numbers = (EditText) findViewById(R.id.number);
        content = (EditText) findViewById(R.id.content);
        select = (Button) findViewById(R.id.select);
        send = (Button) findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (String number : sendList) {

                    PendingIntent pi = PendingIntent.getActivity(Chapter10SendSMSActivity.this, 0, new Intent(), 0);
                    sManager.sendTextMessage(number, null, content.getText().toString(), pi, null);
                }

                Toast.makeText(Chapter10SendSMSActivity.this, "短信群发完成", Toast.LENGTH_SHORT).show();

            }
        });



        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
                BaseAdapter adapter = new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return cursor.getCount();
                    }

                    @Override
                    public Object getItem(int position) {
                        return position;
                    }

                    @Override
                    public long getItemId(int position) {
                        return position;
                    }

                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        cursor.moveToPosition(position);
                        CheckBox rb = new CheckBox(Chapter10SendSMSActivity.this);
                        String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)).replace("-", "").replace(" ", "");
                        rb.setText(number);
                        if (isChecked(number)) {
                            rb.setChecked(true);
                        }

                        return rb;
                    }
                };

            }
        });



    };





    public boolean isChecked(String phone){

        for (String s1:sendList){
            if (s1.equals(phone)){
                return true;
            }
        }

        return false;

    }


}
