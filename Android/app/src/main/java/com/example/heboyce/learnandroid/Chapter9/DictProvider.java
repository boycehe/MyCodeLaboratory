package com.example.heboyce.learnandroid.Chapter9;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class DictProvider extends ContentProvider {
    public DictProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

    }

    @Override
    public String getType(Uri uri) {

    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

    }

    @Override
    public boolean onCreate() {

    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
       
    }
}
