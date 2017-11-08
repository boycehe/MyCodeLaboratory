package com.example.heboyce.learnandroid.Day8;

import android.graphics.drawable.ClipDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.heboyce.learnandroid.R;

import java.util.Timer;
import java.util.TimerTask;

public class Day8ClipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day8_clip);

        ImageView imageView = (ImageView)findViewById(R.id.image);
        final ClipDrawable drawable = (ClipDrawable)imageView.getDrawable();

        final Handler handler = new Handler(){

            @Override
            public void handleMessage(Message msg){

                if (msg.what == 0x1233){
                    drawable.setLevel(drawable.getLevel()+200);
                }

            }

        };

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 0x1233;
                handler.sendMessage(msg);
                if (drawable.getLevel() >= 10000){
                    timer.cancel();
                }
            }
        },0,300);



    }
}
