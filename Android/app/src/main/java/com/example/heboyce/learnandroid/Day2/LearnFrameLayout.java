package com.example.heboyce.learnandroid.Day2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.example.heboyce.learnandroid.R;

import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class LearnFrameLayout extends AppCompatActivity {


    private static int currentColor = 0;
    final static int[] colors = new  int[]{
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5,
            R.color.color6,
    };

    final static  int[] names = new int[]{
            R.id.view01,
            R.id.view02,
            R.id.view03,
            R.id.view04,
            R.id.view05,
            R.id.view06,
    };

   static TextView[] views = new TextView[names.length];



    private static class MyHandler extends Handler{

        private final WeakReference<Activity> mActivity;
        public MyHandler(Activity activity){

            mActivity = new WeakReference<Activity>(activity);

        }

        @Override
        public void handleMessage(Message msg){

            if (msg.what == 0x123){

                for (int i = 0; i<names.length;i++){

                    views[i].setBackgroundResource(colors[(i+currentColor)%names.length]);


                }

                currentColor++;


            }

            super.handleMessage(msg);



        }


    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_frame_layout);


        final   Handler handler = new MyHandler(this);

        for (int i = 0;i<names.length;i++){

            views[i] = (TextView)findViewById(names[i]);

        }


        new Timer().schedule(new TimerTask() {
          @Override
          public void run() {
            handler.sendEmptyMessage(0x123);
          }
      },0,200);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_frame_layout, menu);
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
