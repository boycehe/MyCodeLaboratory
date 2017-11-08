package com.example.heboyce.learnandroid.Day4;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.example.heboyce.learnandroid.R;

import java.lang.ref.WeakReference;

public class LearnProgressDialogActivity extends AppCompatActivity {

    final static int MAX_PROGRESS = 100;
    private int[] data = new int[50];
   static int progressStatus = 0;
    int hasData = 0;
   static ProgressDialog pd1,pd2;

    private static class MyHandler extends Handler {

        private final WeakReference<Activity> mActivity;
        public MyHandler(Activity activity){

            mActivity = new WeakReference<Activity>(activity);

        }

        @Override
        public void handleMessage(Message msg){

            if(msg.what == 0x123){
                pd2.setProgress(progressStatus);

            }

            super.handleMessage(msg);
        }

    };

    public void showSpinner(View source){

        ProgressDialog.show(this,"任务执行中","任务执行中，请稍等",false,true);

    }

    public void showIndeterminate(View source){

        pd1 = new ProgressDialog(LearnProgressDialogActivity.this);
        pd1.setTitle("任务正在执行中");
        pd1.setMessage("任务正在执行中，敬请等待...");
        pd1.setCancelable(true);
        pd1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd1.setIndeterminate(true);
        pd1.show();
    }

    public void showProgress(View source){

        progressStatus = 0;
        hasData =0;
        pd2 = new ProgressDialog(LearnProgressDialogActivity.this);
        pd2.setMax(MAX_PROGRESS);
        pd2.setTitle("任务完成百分比");
        pd2.setMessage("耗时任务的百分比");
        pd2.setCancelable(false);
        pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd2.setIndeterminate(false);
        pd2.show();

        final  Handler handler = new MyHandler(this);

        new Thread()
        {
            public void run(){



                while (progressStatus < MAX_PROGRESS)
                {
                    progressStatus =MAX_PROGRESS*doWork()/data.length;

                    handler.sendEmptyMessage(0x123);
                }

                if (progressStatus >= MAX_PROGRESS)
                {
                    pd2.dismiss();
                }

            }
        }.start();


    }



    public int doWork() {

        data[hasData++] = (int) (Math.random() * 100);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return hasData;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_progress_dialog);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_progress_dialog, menu);
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
