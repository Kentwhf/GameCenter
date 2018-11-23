package a207project.fall18.GameCenter.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context) {
        super(context,"GameCenter.db",null,5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table User(id integer primary key autoincrement, username varchar(20), password varchar(20), nickname varchar(20)) ");
        db.execSQL("create table Score(id integer primary key autoincrement, userId integer, nickname varchar(20), gameType varchar(20), finalScore integer)");
//        db.execSQL("create table SaveFile(id integer primary key autoincrement, " +
//                "userId integer, nickname varchar(20), gameType varchar(20), auto ByteArray, File1 ByteArray, File2 ByteArray, File3 ByteArray)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("alter table person add account varchar(20)");

    }
}
