package com.example.heboyce.learnandroid.Day9;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.example.heboyce.learnandroid.R;

import java.security.PublicKey;
import java.util.Random;

/**
 * TODO: document your custom view class.
 */
public class FishView extends SurfaceView implements SurfaceHolder.Callback{

    private SurfaceHolder holder;
    private UpdateViewThread updateViewThread;
    private boolean hasSurface;
    private Bitmap  back;
    private Bitmap[] fishs;
    private int fishIndex = 0;//定义变量记录回执第几张鱼的图片
    private float fishX = 778;
    private float fishY = 500;
    private float fishSpeed = 6;

    private int fishAngle = new Random().nextInt(60);
    Matrix matrix = new Matrix();
    public FishView(Context ctx,AttributeSet set){

        super(ctx,set);
        holder = getHolder();
        holder.addCallback(this);
        hasSurface =  false;
        back = BitmapFactory.decodeResource(ctx.getResources(),R.drawable.fishbg);
        fishs = new Bitmap[10];
        for (int i = 0;i < 10;i++){
            try {
                int fishId = (Integer)R.drawable.class.getField("fish"+(i+1)).getInt(null);

                fishs[i] = BitmapFactory.decodeResource(ctx.getResources(),fishId);

            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }


    public void  resume(){

        if (updateViewThread == null){
            updateViewThread = new UpdateViewThread();
            if (hasSurface == true){
                updateViewThread.start();
            }
        }

    }
    public void pause(){
        if (updateViewThread != null){
            updateViewThread.requestExitAndWait();
            updateViewThread = null;
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){

        hasSurface = true;
        resume();

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        hasSurface = false;
        pause();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder,int format,int w,int h){

        if (updateViewThread != null){
            updateViewThread.onWindowResize(w,h);
        }

    }

    class UpdateViewThread extends Thread {
        private boolean done;

        UpdateViewThread(){
            super();
            done = false;
        }

        @Override
        public void run(){
            SurfaceHolder surfaceHolder = holder;

            while (!done){
                Canvas canvas = surfaceHolder.lockCanvas();
                canvas.drawBitmap(back,0,0,null);
                if (fishX < 0 ){
                    fishX  = 778;
                    fishY  = 500;
                    fishAngle = new Random().nextInt(60);
                }

                if (fishY < 0){
                    fishX = 778;
                    fishY = 500;
                    fishAngle = new Random().nextInt(60);
                }

                matrix.reset();
                matrix.setRotate(fishAngle);
                matrix.postTranslate(fishX -= fishSpeed * Math.cos(Math.toRadians(fishAngle)),fishY -= fishSpeed * Math.sin(Math.toRadians(fishAngle)));
                canvas.drawBitmap(fishs[fishIndex++ % fishs.length],matrix,null);
                surfaceHolder.unlockCanvasAndPost(canvas);

                try {
                    Thread.sleep(60);
                }catch (InterruptedException e){}

            }


        }

        public void requestExitAndWait(){
            done= true;
            try {
                join();
            }catch (InterruptedException ex){

            }
        }

        public void onWindowResize(int w,int h){

        }

    }


}
