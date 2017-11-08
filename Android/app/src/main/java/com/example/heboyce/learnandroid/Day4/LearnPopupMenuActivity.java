package com.example.heboyce.learnandroid.Day4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;
import com.example.heboyce.learnandroid.R;

public class LearnPopupMenuActivity extends AppCompatActivity {

    PopupMenu popup = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_popup_menu);
    }

    public void onPopupButtonClick(View button){

        popup = new PopupMenu(this,button);
        getMenuInflater().inflate(R.menu.popup_menu,popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){

                    case R.id.exit:
                        popup.dismiss();
                        break;
                    default:
                        Toast.makeText(LearnPopupMenuActivity.this,"您单击了【"+item.getTitle()+"】菜单项",Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });

        popup.show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_popup_menu, menu);
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
