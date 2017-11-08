package com.example.heboyce.learnandroid.Day5;

import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.heboyce.learnandroid.R;

public class SysActionActivity extends AppCompatActivity {

    final int PICK_CONTACT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sys_action);

        Button bn = (Button) findViewById(R.id.bnn);
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

        switch (requestCode)
        {
            case (PICK_CONTACT):
                if (resultCode == Activity.RESULT_OK)
                {
                    Uri contactData = data.getData();
                    CursorLoader cursorLoader = new CursorLoader(this,contactData,null,null,null,null);
                    Cursor cursor = cursorLoader.loadInBackground();

                    if (cursor.moveToFirst()){

                        String contactId = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                        String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                        String phoneNumber  = "此联系人暂未输入电话号码";
                        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"="+ contactId,null,null);

                        if (phones.moveToFirst())
                        {
                            phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        }
                        phones.close();
                        EditText show = (EditText)findViewById(R.id.show31);
                        show.setText(name);
                        EditText phone = (EditText)findViewById(R.id.phone);
                        phone.setText(phoneNumber);
                    }
                    cursor.close();
                }
                break;
        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sys_action, menu);
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
