package com.example.heboyce.learnandroid.Chapter8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.heboyce.learnandroid.R;

public class Chapter841Activity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter841);

        detector = new GestureDetector(this, this);

    }

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        return detector.onTouchEvent(me);
    }

    @Override
    public boolean onDown(MotionEvent arg0) {
        Toast.makeText(this, "onDown", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1,MotionEvent e2,float velocityX,float velocityY){

        Toast.makeText(this,"onFling",Toast.LENGTH_SHORT).show();
        return false;

    }

    @Override
    public void onLongPress(MotionEvent event){
        Toast.makeText(this,"onLongPress",Toast.LENGTH_SHORT).show();

    }

    @Override
    public  boolean onScroll(MotionEvent e1,MotionEvent e2,float distanceX,float distanceY){
        Toast.makeText(this,"onScroll",Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void  onShowPress(MotionEvent e){
        Toast.makeText(this,"onShowPress",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e){
        Toast.makeText(this,"onSingleTapUp",Toast.LENGTH_SHORT).show();
        return  false;
    }


}

