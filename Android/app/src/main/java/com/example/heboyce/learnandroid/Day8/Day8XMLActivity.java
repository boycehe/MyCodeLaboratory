package com.example.heboyce.learnandroid.Day8;

import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.heboyce.learnandroid.R;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class Day8XMLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day8_xml);

        Button bn = (Button)findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XmlResourceParser xrp = getResources().getXml(R.xml.books);

                try {
                    StringBuilder sb = new StringBuilder("");
                    while (xrp.getEventType() != XmlResourceParser.END_DOCUMENT){

                        if (xrp.getEventType() == XmlResourceParser.START_TAG){

                            String tagName = xrp.getName();
                            if (tagName.equals("book")){
                                String bookName = xrp.getAttributeValue(null,"price");
                                sb.append("价格：");
                                sb.append(bookName);
                                String bookPrice = xrp.getAttributeValue(1);
                                sb.append("   出版日期");
                                sb.append(bookPrice);
                                sb.append("  书名  ");
                                sb.append(xrp.nextText());
                            }

                            sb.append("\n");

                        }

                        xrp.next();
                    }

                    EditText show = (EditText)findViewById(R.id.show);
                    show.setText(sb.toString());


                }catch (XmlPullParserException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        });

    }
}
