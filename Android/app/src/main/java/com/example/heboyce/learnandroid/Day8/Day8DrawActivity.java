package com.example.heboyce.learnandroid.Day8;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.heboyce.learnandroid.R;

public class Day8DrawActivity extends AppCompatActivity {

    EmbossMaskFilter emboss;
    BlurMaskFilter blur;
    DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_day8_draw);
        LinearLayout line = new LinearLayout(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        drawView = new DrawView(this,displayMetrics.widthPixels,displayMetrics.heightPixels);
        line.addView(drawView);
        setContentView(line);
        emboss = new EmbossMaskFilter(new float[]{1.5f,1.5f,1.5f},0.6f,6,4.2f);
        blur = new BlurMaskFilter(8,BlurMaskFilter.Blur.NORMAL);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_draw,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi){

        switch (mi.getItemId()){
            case R.id.red:
                drawView.paint.setColor(Color.RED);
                mi.setCheckable(true);
                break;
            case R.id.green:
                drawView.paint.setColor(Color.GREEN);
                mi.setCheckable(true);
                break;
            case R.id.blue:
                drawView.paint.setColor(Color.BLUE);
                mi.setCheckable(true);
                break;
            case R.id.width_1:
                drawView.paint.setStrokeWidth(1);
                break;
            case R.id.width_2:
                drawView.paint.setStrokeWidth(2);
                break;
            case R.id.width_3:
                drawView.paint.setStrokeWidth(3);
                break;
            case R.id.blur:
                drawView.paint.setMaskFilter(blur);
                break;
            case R.id.emboss:
                drawView.paint.setMaskFilter(emboss);
                break;
            default:
                break;
        }

        return true;

    }
}
