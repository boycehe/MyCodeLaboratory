package com.example.heboyce.learnandroid.Day5;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.Toast;

public class MyButton extends Button {

    public MyButton(Context context,AttributeSet set){
        super(context,set);
    }

    public boolean onKeyDown(int keyCode,KeyEvent event){

        super.onKeyDown(keyCode,event);
        Toast.makeText(getContext(),"the key down",Toast.LENGTH_LONG).show();
        return true;

    }

    public boolean onKeyLongPress(int keyCode,KeyEvent event){

        super.onKeyLongPress(keyCode,event);
        Toast.makeText(getContext(),"the key down",Toast.LENGTH_LONG).show();
        return true;
    }

}
