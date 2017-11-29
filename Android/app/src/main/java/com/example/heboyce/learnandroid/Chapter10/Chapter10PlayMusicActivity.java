package com.example.heboyce.learnandroid.Chapter10;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.heboyce.learnandroid.R;

public class Chapter10PlayMusicActivity extends Activity implements View.OnClickListener{

    TextView title,author;
    ImageButton play,stop;
    ActivityReceiver activityReceiver;

    public static final String CTL_ACTION = "org.crazyit.action.CTL_ACTION";
    public static final String UPDATE_ACTION = "org.crazyit.action.UPDATE_ACTION";
    int staus = 0x11;
    String[]  titleStrs = new String[]{"心愿","约定","美丽新世界"};
    String[]  authorStrs = new String[]{"未知艺术家","周惠","伍佰"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter10_play_music);

        play = (ImageButton)findViewById(R.id.play);
        stop = (ImageButton)findViewById(R.id.stop);
        title = (TextView)findViewById(R.id.title);
        author = (TextView)findViewById(R.id.author);

       play.setOnClickListener(this);
        stop.setOnClickListener(this);

        activityReceiver = new ActivityReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(UPDATE_ACTION);
        registerReceiver(activityReceiver,filter);
        Intent intent = new Intent(this,MusicService.class);
        startService(intent);


    }

    public class ActivityReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent){

            int update  = intent.getIntExtra("update",-1);
            int current = intent.getIntExtra("current",-1);
            if (current >= 0){

                title.setText(titleStrs[current]);
                author.setText(authorStrs[current]);

            }

            switch (update){

                case 0x11:
                    play.setImageResource(R.drawable.play);
                    staus = 0x11;
                    break;
                case 0x12:
                    play.setImageResource(R.drawable.pause);
                    staus = 0x12;
                    break;
                case 0x13:
                    play.setImageResource(R.drawable.play);
                    staus = 0x13;
                    break;


            }


        }


    }

    @Override
    public void onClick(View source){

        Intent intent = new Intent("org.crazyit.action.CTL_ACTION");
        switch (source.getId()){

            case R.id.play:
                intent.putExtra("control",1);
                break;
            case R.id.stop:
                intent.putExtra("control",2);
                break;


        }

        sendBroadcast(intent);

    }


}
