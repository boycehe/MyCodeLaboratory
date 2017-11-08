package com.example.heboyce.learnandroid.Day4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import com.example.heboyce.learnandroid.R;

import java.util.Calendar;

public class LearnDatePickerAndTimePicker extends AppCompatActivity {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_date_picker_and_time_picker);

        DatePicker datePicker = (DatePicker)findViewById(R.id.datePicker);
        TimePicker timePicker = (TimePicker)findViewById(R.id.timePicker);
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                LearnDatePickerAndTimePicker.this.year = year;
                LearnDatePickerAndTimePicker.this.month = month;
                LearnDatePickerAndTimePicker.this.day = day;
                showDate(year,month,day,hour,minute);
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                LearnDatePickerAndTimePicker.this.hour = hourOfDay;
                LearnDatePickerAndTimePicker.this.minute = minute;
                showDate(year,month,day,hour,minute);
            }
        });



    }

    private void showDate(int year,int month,int day,int hour,int minute){

        EditText show = (EditText)findViewById(R.id.show);
        show.setText("您的购买日期为："+year+"年"+(month+1)+"月"+day+"日"+hour+"时"+minute+"分");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_date_picker_and_time_picker, menu);
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
