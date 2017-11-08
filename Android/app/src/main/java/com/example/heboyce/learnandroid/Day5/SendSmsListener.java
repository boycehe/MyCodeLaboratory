package com.example.heboyce.learnandroid.Day5;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by heboyce on 10/9/15.
 */
public class SendSmsListener implements View.OnLongClickListener{

    private Activity act ;
    private EditText address;
    private EditText content;

    public SendSmsListener(Activity act,EditText address,EditText content){
        this.act = act;
        this.address = address;
        this.content = content;
    }

    @Override
    public boolean onLongClick(View source){

        String addressStr = address.getText().toString();
        String contentStr = content.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        PendingIntent sentIntent = PendingIntent.getBroadcast(act,0,new Intent(),0);

        try {
            smsManager.sendTextMessage(addressStr,null,contentStr,sentIntent,null);
            Toast.makeText(act,"短信发送完成",Toast.LENGTH_LONG).show();

        }catch (Exception e){
            Toast.makeText(act,"发送失败",Toast.LENGTH_LONG).show();
            return false;
        }

        return  true;

    }

}
