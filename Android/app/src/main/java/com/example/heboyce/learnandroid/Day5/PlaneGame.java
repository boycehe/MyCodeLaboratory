package com.example.heboyce.learnandroid.Day5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.*;
import com.example.heboyce.learnandroid.R;

public class PlaneGame extends AppCompatActivity {

    private int speed = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        //去掉窗口标题

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final PlaneView planeView = new PlaneView(this);
        setContentView(planeView);


        planeView.setBackgroundResource(R.drawable.back);
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        planeView.currentX = metrics.widthPixels/2;
        planeView.currentY = metrics.heightPixels-40;

        planeView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                switch (event.getKeyCode()){

                    case KeyEvent.KEYCODE_S:
                        planeView.currentY += speed;
                        break;
                    case KeyEvent.KEYCODE_W:
                        planeView.currentY -=speed;
                        break;
                    case KeyEvent.KEYCODE_A:
                        planeView.currentX -=speed;
                        break;
                    case KeyEvent.KEYCODE_D:
                        planeView.currentX +=speed;
                        break;
                }
                planeView.invalidate();

                return true;
            }

        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_plane_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
