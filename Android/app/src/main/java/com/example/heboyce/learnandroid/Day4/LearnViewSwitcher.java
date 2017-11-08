package com.example.heboyce.learnandroid.Day4;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;
import com.example.heboyce.learnandroid.R;

import java.util.ArrayList;

public class LearnViewSwitcher extends AppCompatActivity {


    public static final int NUMBER_PER_SCREEN = 12;

    public static class DataItem{

        public String dataName;
        public Drawable drawable;

    }

    private ArrayList<DataItem> items = new ArrayList<DataItem>();
    private int screenNo = -1;
    private int screenCount;
    ViewSwitcher switcher;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_view_switcher);
        inflater = LayoutInflater.from(LearnViewSwitcher.this);

        for (int i = 0;i<40;i++){

            String label      = ""+i;
            Drawable drawable = getResources().getDrawable(R.drawable.bomb10);
            DataItem item     = new DataItem();
            item.dataName     = label;
            item.drawable     = drawable;
            items.add(item);

        }

        screenCount = items.size()%NUMBER_PER_SCREEN == 0 ? items.size()/NUMBER_PER_SCREEN : items.size()/NUMBER_PER_SCREEN +1;
        switcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return inflater.inflate(R.layout.slidelistview,null);
            }
        });

      next(null);
    }

    public void next(View v){

        if (screenNo < screenCount-1){

            screenNo++;
            switcher.setInAnimation(this,R.anim.abc_slide_in_bottom);
            switcher.setOutAnimation(this,R.anim.abc_slide_out_top);
            ((GridView)switcher.getNextView()).setAdapter(adapter);
            switcher.showNext();
        }

    }

    public void prev(View v){

        if (screenNo > 0){

            screenNo--;
            switcher.setInAnimation(this,android.R.anim.slide_in_left);
            switcher.setOutAnimation(this,android.R.anim.slide_out_right);
            switcher.showPrevious();
        }
    }

    private BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            if (screenNo == screenCount -1 && items.size()%NUMBER_PER_SCREEN !=0){
                return items.size()%NUMBER_PER_SCREEN;
            }
            return NUMBER_PER_SCREEN;
        }

        @Override
        public DataItem getItem(int position) {
            return items.get(screenNo*NUMBER_PER_SCREEN+position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;

            if (convertView == null){
                view = inflater.inflate(R.layout.labelicon,null);
            }

            ImageView imageView = (ImageView)view.findViewById(R.id.imageview322);
            imageView.setImageDrawable(getItem(position).drawable);
            TextView textView = (TextView)view.findViewById(R.id.textview);
            textView.setText(getItem(position).dataName);
            return view;
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_view_switcher, menu);
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
