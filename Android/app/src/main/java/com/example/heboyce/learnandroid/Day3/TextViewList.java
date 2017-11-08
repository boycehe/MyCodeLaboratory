package com.example.heboyce.learnandroid.Day3;

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

public class TextViewList extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_list);

        ListView list1 = (ListView)findViewById(R.id.day3_listView);

        String[] arr1 = {"不同颜色，字体，带链接的文本",
                         "边框，渐变背景的TextView",
                         "用户友好的输入界面",
                         "按钮，圆形按钮，带文字的图片按钮",
                         "利用单选按钮，复选框获取用户信息",
                         "动态控制布局",
                         "手机中的劳力士",
                         "计时器",
                         "图片浏览器",
                         "简单的ListView",
                         "自动完成文本框的功能和用法",
                        "带预览的图片浏览器",
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
              itent.setClass(TextViewList.this,LearnTextView01.class);
            }
            break;
            case 1:
            {
                itent.setClass(TextViewList.this,LearnTextView02.class);
            }
            break;
            case 2:
            {
                itent.setClass(TextViewList.this,LearnEditText.class);
            }
            break;
            case 3:
            {
                itent.setClass(TextViewList.this,LeranButton.class);
            }
            break;
            case 4:
            {
                itent.setClass(TextViewList.this,LearnRadioButtonAndCheckBox.class);
            }
            break;
            case 5:
            {
              itent.setClass(TextViewList.this,LearnToggButtonAndSwitch.class);
            }
            break;
            case 6:
            {
              itent.setClass(TextViewList.this,LearnAnalogClock.class);
            }
            break;
            case 7:
            {
                itent.setClass(TextViewList.this,ChronometerTest.class);
            }
                break;
            case 8:
            {
                itent.setClass(TextViewList.this,LearnImageView01.class);
            }
            break;
            case 9:
            {
                itent.setClass(TextViewList.this,SimpleAdapterTest.class);
            }
            break;
            case 10:
            {
                itent.setClass(TextViewList.this,LearnAutoCompleteTextView.class);
            }
            break;
            case 11:
            {
                itent.setClass(TextViewList.this,LearnGridView.class);
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
        getMenuInflater().inflate(R.menu.menu_text_view_list, menu);
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
