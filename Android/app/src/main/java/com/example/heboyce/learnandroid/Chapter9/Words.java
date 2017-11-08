package com.example.heboyce.learnandroid.Chapter9;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by heboyce on 2017/11/8.
 */

public final class Words {

    public static final String AUTHORITY = "org.crazyit.providers.dictprovider";

    public static final class Word implements BaseColumns{

        public final static String _ID  = "_id";
        public final static String WORD = "word";
        public final static String DETALL = "detail";
        public final static Uri DICT_CONTENT_URI = Uri.parse("content://"+AUTHORITY+"/words");
        public final static Uri WORD_CONTENT_URI = Uri.parse("content://"+AUTHORITY+"/word");

    }


}
