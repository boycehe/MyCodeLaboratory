package com.example.heboyce.learnandroid.Chapter10;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import com.example.heboyce.learnandroid.R;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;

public class Chapter10TeleManagerActivity extends AppCompatActivity {

    TelephonyManager tManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter10_tele_manager);

        tManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

        PhoneStateListener listener = new PhoneStateListener(){


            @Override
            public void onCallStateChanged(int state,String number){

                switch (state){

                    case TelephonyManager.CALL_STATE_IDLE:
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        break;
                    case TelephonyManager.CALL_STATE_RINGING:
                        OutputStream os = null;
                        try {
                            os = openFileOutput("phoneList",MODE_APPEND);
                        }catch (FileNotFoundException e){
                            e.printStackTrace();
                        }

                        PrintStream ps = new PrintStream(os);
                        ps.println(new Date()+"来电："+number);
                        ps.close();
                        break;

                    default:
                        break;

                }

                super.onCallStateChanged(state,number);

            }

        };


        tManager.listen(listener,PhoneStateListener.LISTEN_CALL_STATE);


    }
}
