package com.example.heboyce.learnandroid.Day4;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import com.example.heboyce.learnandroid.R;

import java.lang.ref.WeakReference;

public class LearnProgressBar extends AppCompatActivity {

    private int[] data = new int[100];
    int hasData  = 0;
    static   int status = 0;
    static   ProgressBar bar,bar2;

    private static class MyHandler extends Handler{

        private final WeakReference<Activity> mActivity;
        public MyHandler(Activity activity){

            mActivity = new WeakReference<Activity>(activity);

        }

        @Override
        public void handleMessage(Message msg){

            if (msg.what == 0x111){

                bar.setProgress(status);
                bar2.setProgress(status);

            }

            super.handleMessage(msg);

        }


    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_progress_bar);

      bar  = (ProgressBar)findViewById(R.id.bar);
      bar2 = (ProgressBar)findViewById(R.id.bar2);

      final  MyHandler myHandler = new MyHandler(this);

        new Thread(){

            public void run(){

                while (status < 100){

                    status = doWork();
                    myHandler.sendEmptyMessage(0x111);

                }

            }

        }.start();

    }

    public  int doWork(){

        data[hasData++] = (int)(Math.random()*100);
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return hasData;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_progress_bar, menu);
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
