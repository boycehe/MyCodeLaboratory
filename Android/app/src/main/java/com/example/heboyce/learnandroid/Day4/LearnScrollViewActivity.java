package com.example.heboyce.learnandroid.Day4;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.example.heboyce.learnandroid.Day1.OtherActiviyt;
import com.example.heboyce.learnandroid.R;

public class LearnScrollViewActivity extends AppCompatActivity {

    static final int NOTIFICATION_ID = 0x123;
    NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_scroll_view);

        nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

    }

    public void send(View source){

        Intent intent = new Intent(LearnScrollViewActivity.this, OtherActiviyt.class);
        PendingIntent pi = PendingIntent.getActivity(LearnScrollViewActivity.this,0,intent,0);
        Notification notify = new Notification.Builder(this).setAutoCancel(true).setTicker("有新消息").setSmallIcon(R.drawable.notify1).setContentTitle("一条新通知").setContentText("恭喜你，您加薪了，工资增加为20%").setSound(Uri.parse("android.resource://org.crazyit.ui/"+R.raw.msg)).setWhen(System.currentTimeMillis()).setContentIntent(pi).build();


    }

    public void del(View v){

        nm.cancel(NOTIFICATION_ID);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_scroll_view, menu);
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
