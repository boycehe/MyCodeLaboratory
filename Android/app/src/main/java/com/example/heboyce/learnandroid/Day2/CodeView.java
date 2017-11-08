package com.example.heboyce.learnandroid.Day2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.heboyce.learnandroid.R;

public class CodeView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //线性布局容器
        LinearLayout layout = new LinearLayout(this);
        super.setContentView(layout);
        //垂直
        layout.setOrientation(LinearLayout.VERTICAL);

        final TextView show = new TextView(this);
        Button bn = new Button(this);
        bn.setText("OK");
        //设置内容包裹
        bn.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(show);
        layout.addView(bn);

        //设置点击监控
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                show.setText("Hello,Android,"+ new java.util.Date());
            }
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_code_view, menu);
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
