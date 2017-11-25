package com.example.heboyce.learnandroid.Chapter10;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.heboyce.learnandroid.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Chapter10TeleActivity extends AppCompatActivity {

    ListView showView;
    String [] statusNames;
    ArrayList<String> statusValues = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter10_tele);

        TelephonyManager tManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        statusNames = getResources().getStringArray(R.array.statusNames);
        String[] simState = getResources().getStringArray(R.array.simState);
        String[] phoneType =getResources().getStringArray(R.array.phoneType);
        statusValues.add(tManager.getDeviceId());
        statusValues.add(tManager.getDeviceSoftwareVersion() != null ? tManager.getDeviceSoftwareVersion():"未知");
        statusValues.add(tManager.getNetworkOperator());
        statusValues.add(tManager.getNetworkOperatorName());
        statusValues.add(phoneType[tManager.getPhoneType()]);
        statusValues.add(tManager.getCellLocation() != null ? tManager.getCellLocation().toString():"未知未知");
        statusValues.add(tManager.getSimCountryIso());
        statusValues.add(tManager.getSimSerialNumber());
        statusValues.add(simState[tManager.getSimState()]);

        showView = (ListView)findViewById(R.id.show);
        ArrayList<Map<String ,String>> status= new ArrayList<>();

        for (int i = 0;i < statusValues.size();i++){

            HashMap<String,String> map = new HashMap<>();
            map.put("name",statusNames[i]);
            map.put("value",statusValues.get(i));
            status.add(map);

        }

        SimpleAdapter adapter = new SimpleAdapter(this,status,R.layout.line,new String[]{"name","value"},new int[]{R.id.name,R.id.value});
        showView.setAdapter(adapter);


    }
}
