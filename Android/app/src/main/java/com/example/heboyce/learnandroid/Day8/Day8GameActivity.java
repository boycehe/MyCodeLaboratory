package com.example.heboyce.learnandroid.Day8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.example.heboyce.learnandroid.R;

import java.util.Timer;
import java.util.TimerTask;

public class Day8GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    class MyView extends View{

        final int BACK_HEIGHT = 1700;
        private Bitmap back;
        private Bitmap plane;
        final int WIDTH = 640;
        final int HEIGHT = 880;
        private Matrix matrix = new Matrix();
        private int startY = BACK_HEIGHT - HEIGHT;

        public MyView(Context context){

            super(context);

            back = BitmapFactory.decodeResource(context.getResources(),R.drawable.back_img);
            WindowManager windowManager = getWindowManager();
            Display display = windowManager.getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);

            float screenWidth = metrics.widthPixels;
            float scale = screenWidth / WIDTH;
            matrix.setScale(scale,scale);
            plane = BitmapFactory.decodeResource(context.getResources(),R.drawable.plane);

            final Handler handler = new Handler(){

                public void handleMessage(Message msg){

                    if (msg.what == 0x123){

                        if (startY <= 3){
                            startY = BACK_HEIGHT - HEIGHT;
                        }else {
                            startY -= 3;
                        }

                    }

                    invalidate();
                }

            };

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.sendEmptyMessage(0x123);
                }
            },0,100);

        }

        @Override
        public void onDraw(Canvas canvas){

            Bitmap bitmap2 = Bitmap.createBitmap(back,0,startY,WIDTH,HEIGHT,matrix,false);
            canvas.drawBitmap(bitmap2,0,0,null);
            canvas.drawBitmap(plane,320,700,null);

        }

    }

}
