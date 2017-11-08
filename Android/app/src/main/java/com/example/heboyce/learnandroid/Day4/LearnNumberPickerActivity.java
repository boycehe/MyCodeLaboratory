package com.example.heboyce.learnandroid.Day4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.NumberPicker;
import android.widget.Toast;
import com.example.heboyce.learnandroid.R;

public class LearnNumberPickerActivity extends AppCompatActivity {

    NumberPicker np1,np2;
    int minPrice = 25,maxPrice = 75;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_number_picker);

        np1 = (NumberPicker)findViewById(R.id.np1);
        np1.setMinValue(10);
        np1.setMaxValue(50);
        np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                minPrice = newVal;
                showSelectedPrice();

            }
        });

        np2 = (NumberPicker)findViewById(R.id.np2);
        np2.setMinValue(60);
        np2.setMaxValue(100);
        np2.setValue(maxPrice);
        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                maxPrice = newVal;
                showSelectedPrice();
            }
        });



    }

    private void showSelectedPrice(){

        Toast.makeText(this,"您选择最低价格："+minPrice+"，最高价格为："+maxPrice,Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_number_picker, menu);
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
