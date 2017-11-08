package com.example.heboyce.learnandroid.Day4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.heboyce.learnandroid.R;

public class Day4List extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day4_list);

        ListView list1 = (ListView)findViewById(R.id.day4_listView);
        String[] arr1 = {
                "叠在一起的图片",
                "进度条1",
                "进度条2",
                "SeekBar",
                "仿Android系统Launcher界面",
                "图像切换器",
                "Toast测试显示",
                "日历显示",
                "用户选择日期，时间",
                "选择意向的价格范围",
                "搜索",
                "通知",
                "显示提示消息的对话框",
                "使用PopupWindow",
                "使用DatePickerDialog,TimePickerDialog",
                "使用ProgressDialog创建进度对话框",
                "选择菜单和子菜单",
                "创建复选菜单项和单选菜单项",
                "上下文菜单",
                "使用PopupMenu创建弹出式菜单",
                "学习ActionBar",
                "学习ActionBarItem",

        };

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.array_item,arr1);
        list1.setAdapter(adapter1);
        list1.setOnItemClickListener(this);
    }


    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {


        Toast.makeText(getApplicationContext(), "点击了" + position, Toast.LENGTH_LONG).show();

        Intent itent = new Intent();

        switch (position){

            case 0:
            {
                itent.setClass(Day4List.this, LearnStackView.class);
            }
            break;
            case 1:
            {
                itent.setClass(Day4List.this, LearnProgressBar.class);
            }
            break;
            case 2:
            {
                itent.setClass(Day4List.this, LearnWindowProgress.class);
            }
            break;
            case 3:
            {
                itent.setClass(Day4List.this, LearnSeekBar.class);
            }
            break;
            case 4:
            {
                itent.setClass(Day4List.this, LearnViewSwitcher.class);
            }
            break;
            case 5:
            {
                itent.setClass(Day4List.this, LearnImageSwitcher.class);
            }
            break;
            case 6:
            {
                itent.setClass(Day4List.this, LearnToastActivity.class);
            }
            break;
            case 7:
            {
                itent.setClass(Day4List.this, LearnCalendarView.class);
            }
            break;
            case 8:
            {
                itent.setClass(Day4List.this, LearnDatePickerAndTimePicker.class);
            }
            break;
            case 9:
            {
                itent.setClass(Day4List.this, LearnNumberPickerActivity.class);
            }
            break;
            case 10:
            {
                itent.setClass(Day4List.this, LearnSearchViewActivity.class);
            }
            break;
            case 11:
            {
                itent.setClass(Day4List.this, LearnScrollViewActivity.class);
            }
            break;
            case 12:
            {
                itent.setClass(Day4List.this, LearnAlertDialogActivity.class);
            }
            break;
            case 13:
            {
                itent.setClass(Day4List.this,LearnPopupWindowAcitvity.class);
            }
            break;
            case 14:
            {
                itent.setClass(Day4List.this,LearnDateTimePickDialogWindowActivity.class);
            }
            break;
            case 15:
            {
                itent.setClass(Day4List.this,LearnProgressDialogActivity.class);
            }
            break;
            case 16:
            {
                itent.setClass(Day4List.this,LearnSubMenuActivity.class);
            }
            break;
            case 17:
            {
                itent.setClass(Day4List.this,LearnActivityMenu.class);
            }
            break;
            case 18:
            {
                itent.setClass(Day4List.this,LearnContextMenuActivity.class);
            }
                break;
            case 19:
            {
                itent.setClass(Day4List.this,LearnPopupMenuActivity.class);
            }
            break;
            case 20:
            {
              itent.setClass(Day4List.this,LearnActionBarActivity.class);
            }
            break;
            case 21:
            {
               itent.setClass(Day4List.this,LearnActionBarItemActivity.class);
            }
            break;
            case 22:
            {
                itent.setClass(Day4List.this,LearnActionBarItemActivity.class);
            }
            break;
            default:
                break;

        }

        startActivity(itent);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_day4_list, menu);
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
