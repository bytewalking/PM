package com.suda.zph.passwordmanager.database.databaseImp;

import android.content.Context;
import android.database.Cursor;
import com.suda.zph.passwordmanager.activity.MainActivity;
import com.suda.zph.passwordmanager.database.MyOpenHelper;

public class IUser {
    private MyOpenHelper helper;

    public Boolean findUser(Context context,String passWord){
        String sql = "select * from user where password = ? and user_id=1000";
        helper = new MyOpenHelper(context,"user.db3",1);
        Cursor cursor = helper.getReadableDatabase().rawQuery(sql,new String[]{passWord});
        if(cursor.moveToNext())return true;
        else return false;
    }
}
