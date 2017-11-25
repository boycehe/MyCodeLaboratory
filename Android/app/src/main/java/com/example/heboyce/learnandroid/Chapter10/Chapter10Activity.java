package com.example.heboyce.learnandroid.Chapter10;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.heboyce.learnandroid.R;

public class Chapter10Activity extends AppCompatActivity {

    Button start,stop,bind,unbind,getServiceStatus;

    BindService.MyBinder binder;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("--Service Connected--");
            binder = (BindService.MyBinder)service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("--Service Disconnected--");

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter10);

        start = (Button)findViewById(R.id.start);
        stop  = (Button)findViewById(R.id.stop);

        final Intent intent = new Intent(this,FirstService.class);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });


        bind = (Button)findViewById(R.id.bind);
        unbind = (Button)findViewById(R.id.unbind);
        getServiceStatus = (Button)findViewById(R.id.getServiceStatus);

        final Intent intent1 = new Intent(this,BindService.class);
        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(intent1,conn, Service.BIND_AUTO_CREATE);
                System.out.println("falfjaljfaljfl:::"+binder);
            }
        });

        unbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(conn);
            }
        });

        getServiceStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Chapter10Activity.this,"Service的count值为："+binder.getCount(),Toast.LENGTH_SHORT).show();
            }
        });



    }


    public void startService(View source){

        Intent intent = new Intent(this,MyService.class);
        startService(intent);

    }

    public void startIntentService(View source){
        Intent intent = new Intent(this,MyIntentService.class);
        startService(intent);
    }


}
