package com.example.heboyce.learnandroid.Day4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TextView;
import com.example.heboyce.learnandroid.R;

public class LearnAlertDialogActivity extends AppCompatActivity {

    TextView show;
    String[] items = new String[] {
            "hello1", "hello2",
            "hello3",
            "hello4" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_alert_dialog);
        show = (TextView)findViewById(R.id.show1);
    }



    public void simple(View source)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                // ÉèÖÃ¶Ô»°¿ò±êÌâ
                .setTitle("¼òµ¥¶Ô»°¿ò")
                        // ÉèÖÃÍ¼±ê
                .setIcon(R.drawable.tools)
                .setMessage("¶Ô»°¿òµÄ²âÊÔÄÚÈÝ\nµÚ¶þÐÐÄÚÈÝ");
        // ÎªAlertDialog.BuilderÌí¼Ó¡¾È·¶¨¡¿°´Å¥
        setPositiveButton(builder);
        // ÎªAlertDialog.BuilderÌí¼Ó¡¾È¡Ïû¡¿°´Å¥
        setNegativeButton(builder)
                .create()
                .show();
    }

    public void simpleList(View source)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                // ÉèÖÃ¶Ô»°¿ò±êÌâ
                .setTitle("¼òµ¥ÁÐ±íÏî¶Ô»°¿ò")
                        // ÉèÖÃÍ¼±ê
                .setIcon(R.drawable.tools)
                        // ÉèÖÃ¼òµ¥µÄÁÐ±íÏîÄÚÈÝ
                .setItems(items, new OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        show.setText("ÄãÑ¡ÖÐÁË¡¶" + items[which] + "¡·");
                    }
                });
        // ÎªAlertDialog.BuilderÌí¼Ó¡¾È·¶¨¡¿°´Å¥
        setPositiveButton(builder);
        // ÎªAlertDialog.BuilderÌí¼Ó¡¾È¡Ïû¡¿°´Å¥
        setNegativeButton(builder)
                .create()
                .show();
    }

    public void singleChoice(View source)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                // ÉèÖÃ¶Ô»°¿ò±êÌâ
                .setTitle("µ¥Ñ¡ÁÐ±íÏî¶Ô»°¿ò")
                        // ÉèÖÃÍ¼±ê
                .setIcon(R.drawable.tools)
                        // ÉèÖÃµ¥Ñ¡ÁÐ±íÏî,Ä¬ÈÏÑ¡ÖÐµÚ¶þÏî£¨Ë÷ÒýÎª1£©
                .setSingleChoiceItems(items, 1, new OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        show.setText("ÄãÑ¡ÖÐÁË¡¶" + items[which] + "¡·");
                    }
                });
        // ÎªAlertDialog.BuilderÌí¼Ó¡¾È·¶¨¡¿°´Å¥
        setPositiveButton(builder);
        // ÎªAlertDialog.BuilderÌí¼Ó¡¾È¡Ïû¡¿°´Å¥
        setNegativeButton(builder)
                .create()
                .show();
    }
    public void multiChoice(View source)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                // ÉèÖÃ¶Ô»°¿ò±êÌâ
                .setTitle("¶àÑ¡ÁÐ±íÏî¶Ô»°¿ò")
                        // ÉèÖÃÍ¼±ê
                .setIcon(R.drawable.tools)
                        // ÉèÖÃ¶àÑ¡ÁÐ±íÏî£¬ÉèÖÃ¹´Ñ¡µÚ2Ïî¡¢µÚ4Ïî
                .setMultiChoiceItems(items
                        , new boolean[]{false , true ,false ,true}, null);
        // ÎªAlertDialog.BuilderÌí¼Ó¡¾È·¶¨¡¿°´Å¥
        setPositiveButton(builder);
        // ÎªAlertDialog.BuilderÌí¼Ó¡¾È¡Ïû¡¿°´Å¥
        setNegativeButton(builder)
                .create()
                .show();
    }
    public void customList(View source)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                // ÉèÖÃ¶Ô»°¿ò±êÌâ
                .setTitle("×Ô¶¨ÒåÁÐ±íÏî¶Ô»°¿ò")
                        // ÉèÖÃÍ¼±ê
                .setIcon(R.drawable.tools)
                        // ÉèÖÃ×Ô¶¨ÒåÁÐ±íÏî
                .setAdapter(new ArrayAdapter<String>(this
                        , R.layout.array_item
                        , items), null);
        // ÎªAlertDialog.BuilderÌí¼Ó¡¾È·¶¨¡¿°´Å¥
        setPositiveButton(builder);
        // ÎªAlertDialog.BuilderÌí¼Ó¡¾È¡Ïû¡¿°´Å¥
        setNegativeButton(builder)
                .create()
                .show();
    }

    public void customView(View source)
    {

        TableLayout loginForm = (TableLayout)getLayoutInflater()
                .inflate( R.layout.login, null);
        new AlertDialog.Builder(this)

                .setIcon(R.drawable.tools)

                .setTitle("×Ô¶¨ÒåView¶Ô»°¿ò")

                .setView(loginForm)

                .setPositiveButton("µÇÂ¼" , new OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which)
                    {

                    }
                })

                .setNegativeButton("È¡Ïû", new OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which)
                    {

                    }
                })

                .create()
                .show();
    }

    private AlertDialog.Builder setPositiveButton(
            AlertDialog.Builder builder)
    {

        return builder.setPositiveButton("È·¶¨", new OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                show.setText("µ¥»÷ÁË¡¾È·¶¨¡¿°´Å¥£¡");
            }
        });
    }

    private AlertDialog.Builder setNegativeButton(
            AlertDialog.Builder builder)
    {

        return builder.setNegativeButton("È¡Ïû", new OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                show.setText("µ¥»÷ÁË¡¾È¡Ïû¡¿°´Å¥£¡");
            }
        });
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_alert_dialog, menu);
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
