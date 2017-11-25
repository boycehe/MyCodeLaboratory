package com.example.heboyce.learnandroid.Chapter10;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }


    @Override
    public int onStartCommand(Intent intent,int flags,int startId){

        long endTime = System.currentTimeMillis()+20*1000;
        System.out.println("onStart");
        while (System.currentTimeMillis() < endTime){
            synchronized (this){

                try {
                    wait(endTime - System.currentTimeMillis());
                } catch (Exception e){

                }

            }
        }

        System.out.println("--耗时任务执行完成--");
        return START_STICKY;

    }

}
