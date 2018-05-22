package com.suda.zph.passwordmanager.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PassWordOpenHelper extends SQLiteOpenHelper {
    public PassWordOpenHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE account (" +
                "id  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "source  TEXT(56) NOT NULL," +
                "user_name  TEXT(56) NOT NULL," +
                "user_password  TEXT(56) NOT NULL," +
                "create_time  Date(32) NOT NULL," +
                "mod_time  Date(32) NOT NULL," +
                "delete_flag  INTEGER NOT NULL DEFAULT 0," +
                "remarks  TEXT(56)" +
                ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        System.out.println("------升级------oldVersion:"+i+" newVersion:"+i1);
    }
}
