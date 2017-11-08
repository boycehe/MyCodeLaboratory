package com.example.heboyce.learnandroid.Day6;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.example.heboyce.learnandroid.R;

import java.io.IOException;

public class BitmapTest extends AppCompatActivity {

    String[] images = null;
    AssetManager assets = null;
    int currentImg = 0;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_test);

        System.out.println("start");

        image = (ImageView)findViewById(R.id.imageBitmap);
        try {
            assets = getAssets();
            images = assets.list("");


        }
        catch (IOException e){
            System.out.println(e);
            e.printStackTrace();
        }

        final Button next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentImg >= images.length){
                    currentImg = 0;
                }

                System.out.println("图片数组长度:"+images.length);

                for (int i = 0;i < images.length;i++){
                    System.out.println(images[i]);
                }

                System.out.println("begin");
                System.out.println("图片:"+images);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bitmap_test, menu);
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
