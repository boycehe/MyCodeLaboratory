package com.example.heboyce.learnandroid.Day8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.heboyce.learnandroid.R;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Day8MarblesActivity extends AppCompatActivity {

    private int tableWidth;
    private int tableHeight;
    private int racketY;
    private final int RACKET_HEIGHT = 30;
    private final int RACKET_WIDTH = 90;

    private final int BALL_SIZE = 16;
    private int ySpeed = 15;
    Random rand = new Random();

    private double xyRate = rand.nextDouble() - 0.5;
    private double xSpeed = (int)(ySpeed * xyRate * 2);
    private int ballX = rand.nextInt(200) + 20;
    private int ballY = rand.nextInt(10) + 20;

    private  int racketX = rand.nextInt(200);
    private boolean isLose = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final  GameView gameView = new GameView(this);
        setContentView(gameView);

        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        tableWidth = metrics.widthPixels;
        tableHeight = metrics.heightPixels;
        racketY = tableHeight - 80;
        final Handler handler = new Handler(){

            public void  handleMessage(Message msg){
                if (msg.what == 0x123){
                    gameView.invalidate();
                }
            }

        };

        gameView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                switch (event.getKeyCode()){

                    case KeyEvent.KEYCODE_A:
                        if (racketX > 0) racketX -= 10;
                        break;
                    case KeyEvent.KEYCODE_D:
                        if (racketX < tableWidth - RACKET_WIDTH) racketX += 10;
                        break;

                }

                gameView.invalidate();

                return true;
            }
        });

        final Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                if (ballX <= 0 || ballX >= tableWidth - BALL_SIZE){
                    xSpeed = -xSpeed;
                }
                if (ballY >= racketY - BALL_SIZE && (ballX < racketX || ballX > racketX + RACKET_WIDTH)){
                    timer.cancel();
                    isLose = true;
                }else if (ballY <= 0 || (ballY >= racketY - BALL_SIZE && ballX > racketX && ballX <= racketX + RACKET_WIDTH)){
                    ySpeed = -ySpeed;
                }

                ballY += ySpeed;
                ballX += xSpeed;
                handler.sendEmptyMessage(0x123);

            }
        },0,16);




    }

    class GameView extends View {

        Paint paint = new Paint();

        public GameView(Context context){
            super(context);
            setFocusable(true);
        }

        public void onDraw(Canvas canvas){

            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);

            if (isLose){
                paint.setColor(Color.RED);
                paint.setTextSize(40);
                canvas.drawText("游戏已结束",tableWidth/2-100,200,paint);

            }else {
                paint.setColor(Color.rgb(255,0,0));
                canvas.drawCircle(ballX,ballY,BALL_SIZE,paint);
                paint.setColor(Color.rgb(80,80,200));
                canvas.drawRect(racketX,racketY,racketX+RACKET_WIDTH,racketY+RACKET_HEIGHT,paint);
            }

        }

    }

}
