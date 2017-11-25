package com.example.heboyce.learnandroid.Chapter10;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import java.security.PublicKey;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {


    public MyIntentService(){
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent){

        long endTime = System.currentTimeMillis()+20*1000;
        System.out.println("onStartCommand");
        while (System.currentTimeMillis() < endTime){
            synchronized (this){
                try {
                    wait(endTime - System.currentTimeMillis());
                }catch (Exception e){

                }
            }
        }
        System.out.println("--耗时任务执行完成--");
    }



}
