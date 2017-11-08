/**
 * 
 */
package com.example.heboyce.learnandroid.Day1;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.Button;
import com.example.heboyce.learnandroid.R;

import java.util.List;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class PreferenceActivityTest extends PreferenceActivity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		if (hasHeaders()){
			Button button = new Button(this);
			button.setText("设置操作");
			setListFooter(button);
		}

		addPreferencesFromResource(R.xml.preferences);
	}

	@Override
	public void onBuildHeaders(List<Header> target){
		//loadHeadersFromResource(R.xml.preferences_headers,target);
	}
}
