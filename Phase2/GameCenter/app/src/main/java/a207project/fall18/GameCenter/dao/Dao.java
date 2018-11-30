package a207project.fall18.GameCenter.dao;

import android.content.Context;

import java.util.List;

public abstract class Dao<T>{
    SQLiteHelper sqLiteHelper;
    Context context;

    public Dao(Context context){
        this.context = context;
        sqLiteHelper = new SQLiteHelper(context);
    }

    abstract public long insert(T t);

    abstract public boolean delete(int ID);

    abstract public boolean update(T t);

    abstract public List<T> query(String s);


}
