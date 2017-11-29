package com.example.heboyce.learnandroid.Chapter10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = getResultExtras(true);
        String first = bundle.getString("first");
        Toast.makeText(context,"第一个Broadcast传入的消息为："+first,Toast.LENGTH_LONG).show();

    }
}
