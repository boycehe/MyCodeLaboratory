package com.example.heboyce.learnandroid.Chapter9;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class FirstProvider extends ContentProvider {
    public FirstProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        System.out.print(uri + "===delete方法调用===");
        System.out.println("where参数为："+selection);
        return 0;

    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        return  null;

    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        System.out.println(uri + "===insert方法被调用====");
        System.out.println("values参数为："+values);
        return null;
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        System.out.println("=====onCreate方法调用=======");
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        System.out.println(uri + "===query方法调用====");
        System.out.println("where 参数为："+selection);
      return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        System.out.println(uri + "===update方法被调用===");
        System.out.println("where参数为："+selection+",values参数为："+values);
        return 0;
    }
}
