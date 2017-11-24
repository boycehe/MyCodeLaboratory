package com.example.heboyce.learnandroid.Chapter10;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class FirstService extends Service {
    public FirstService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
            return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        System.out.println("service is Created");
    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId){

        System.out.println("Service is Started");
        return START_STICKY;

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        System.out.println("Service is Desstroyed");
    }

}
