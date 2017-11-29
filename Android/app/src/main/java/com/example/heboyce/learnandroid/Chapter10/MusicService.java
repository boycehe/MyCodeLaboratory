package com.example.heboyce.learnandroid.Chapter10;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

public class MusicService extends Service {

    MyReceiver3 serviceReceiver;
    AssetManager am;
    String[] musics = new String[]{"wish.mp3","promise.mp3","beautiful.mp3"};
    MediaPlayer mPlayer;
    int status = 0x11;
    int current = 0;


    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }


    @Override
    public void onCreate(){

        super.onCreate();

        am = getAssets();
        serviceReceiver = new MyReceiver3();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Chapter10PlayMusicActivity.CTL_ACTION);
        registerReceiver(serviceReceiver,filter);
        mPlayer = new MediaPlayer();
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                current++;

                if (current >= 3){
                    current = 0;
                }

                Intent sendIntent = new Intent(Chapter10PlayMusicActivity.UPDATE_ACTION);
                sendIntent.putExtra("current",current);
                sendBroadcast(sendIntent);
                prepareAndPlay(musics[current]);


            }
        });
    }

    public class MyReceiver3 extends BroadcastReceiver{


        @Override
        public void onReceive(final Context context,Intent intent){

            int control = intent.getIntExtra("control",-1);
            switch (control){

                case 1:
                    if (status == 0x11){
                        prepareAndPlay(musics[current]);
                        status = 0x12;
                    }else if(status == 0x12){
                        mPlayer.pause();
                        status = 0x13;
                    }else if(status == 0x13){
                        mPlayer.start();
                        status = 0x12;
                    }
                    break;
                case 2:
                    if (status == 0x12 || status == 0x13){
                        mPlayer.stop();
                        status = 0x11;
                    }


            }

            Intent sendIntent = new Intent(Chapter10PlayMusicActivity.UPDATE_ACTION);
            sendIntent.putExtra("update",status);
            sendIntent.putExtra("current",current);
            sendBroadcast(sendIntent);


        }


    }

    private void prepareAndPlay(String music){

        try {
            AssetFileDescriptor afd = am.openFd(music);
            mPlayer.reset();
            mPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            mPlayer.prepare();
            mPlayer.start();
        }catch (IOException e){
            e.printStackTrace();
        }

    }



}
