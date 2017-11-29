package com.example.heboyce.learnandroid.Chapter10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"接收到Intent的Action为："+intent.getAction()+"\n消息内容是："+intent.getStringExtra("msg"),Toast.LENGTH_LONG).show();
        Bundle bundle = new Bundle();
        bundle.putString("first","第一个BroadcastReceiver传入的消息");
        setResultExtras(bundle);


    }
}
