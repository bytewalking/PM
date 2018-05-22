package com.suda.zph.passwordmanager.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {
    public MyOpenHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE user (" +
                "user_id  INTEGER," +
                "password  TEXT(24)," +
                "last_login_time  TEXT(32)," +
                "last_password_changed_time  TEXT(32)" +
                ")"
        );
        sqLiteDatabase.execSQL("insert into user (user_id,password)values(1000,123456)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        System.out.println("------升级------oldVersion:"+i+" newVersion:"+i1);
    }
}
