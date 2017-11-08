package com.example.heboyce.learnandroid.Day2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/**
 * TODO: document your custom view class.
 */
public class DrawView extends View {


    private String mExampleString; // TODO: use a default from R.string...
    private int mExampleColor = Color.RED; // TODO: use a default from R.color...
    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
    private Drawable mExampleDrawable;

    private TextPaint mTextPaint;
    private float mTextWidth;
    private float mTextHeight;

    public float currentX = 40;
    public float currentY = 50;
    Paint  p = new Paint();

    public DrawView(Context context){
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public DrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.RED);
        canvas.drawCircle(currentX,currentY,15,p);
    }

    public boolean onTouchEvent(MotionEvent event){
        currentX = event.getX();
        currentY = event.getY();
        invalidate();
        return true;
    }


}
