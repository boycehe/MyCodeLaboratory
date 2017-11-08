package com.example.heboyce.learnandroid.Day7;

import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.heboyce.learnandroid.R;

public class Day7ContactActivity extends AppCompatActivity {


    final int PICK_CONTACT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day7_contact);

        Button bn = (Button)findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("vnd.android.cursor.item/phone");
                startActivityForResult(intent,PICK_CONTACT);
            }
        });

    }


    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){

        super.onActivityResult(requestCode,resultCode,data);

        Log.e("11","bbbb"+requestCode);

        switch (requestCode){

            case (PICK_CONTACT):
            {
                if (resultCode == Activity.RESULT_OK)
                {

                    Uri contactData = data.getData();
                    CursorLoader cursorLoader = new CursorLoader(this,contactData,null,null,null,null);
                    Cursor cursor = cursorLoader.loadInBackground();
                    if (cursor.moveToFirst()){
                        String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                        String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                        String phonenNumber = "此联系人暂未输入电话号码";
                        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"="+contactId,null,null);
                        if (phones.moveToFirst()){
                            phonenNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        }

                        phones.close();
                        EditText show = (EditText)findViewById(R.id.show);
                        show.setText(name);
                        EditText phone =  (EditText)findViewById(R.id.phone);
                        phone.setText(phonenNumber);

                    }
                    cursor.close();

                }
                break;
            }

            default:
                break;


        }

    }

}
