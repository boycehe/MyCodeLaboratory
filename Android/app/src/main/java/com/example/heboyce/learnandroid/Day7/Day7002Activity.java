package com.example.heboyce.learnandroid.Day7;

import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.heboyce.learnandroid.R;

public class Day7002Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day7002);

        EditText show = (EditText) findViewById(R.id.show);
        ComponentName comp = getIntent().getComponent();
        String action = getIntent().getAction();
        show.setText("组件包名为："+comp.getPackageName()+"\n组件类名为："+comp.getClassName()+"\nAction为："+action);

    }
}
