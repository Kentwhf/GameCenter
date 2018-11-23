//package a207project.fall18.GameCenter.dao;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
//import java.util.List;
//
//import a207project.fall18.GameCenter.BoardManager;
//import a207project.fall18.GameCenter.bean.User;
//
//public class SaveDao extends Dao<BoardManager> {
//
//    public SaveDao(Context context){
//        super(context);
//        sqLiteHelper = new SQLiteHelper(context);
//    }
//    @Override
//    public long insert(BoardManager boardManager, String place, User user, String game) {
//        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();
//        ContentValues value = new ContentValues();
//        byte[] boardmanager = getSerializedObject(boardManager);
//
//        if (!place.equals(null) ){
//            value.put("auto", boardmanager);
//            value.put("File1", null);
//            value.put("userId", user.getId());
//            value.put("nickname", user.getNickname());
//            value.put("gameType", game);
//            Long result = db.insert("SaveFile", null, value);
//            return result;
//        }
//
//
//
//    }
//
//    @Override
//    public boolean delete(int ID) {
//        return false;
//    }
//
//    @Override
//    public boolean update(BoardManager boardManager) {
//        return false;
//    }
//
//    @Override
//    public List<BoardManager> query(String s) {
//        return null;
//    }
//
//    private boolean find(Integer userId){
//        boolean result = false;
//        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();
//        Cursor cs = db.query("SaveFile", null, "userId=?", new String[]{userId.toString()}, null, null, null);
//        if (cs.moveToNext()){
//            result = true;
//        }
//        cs.close();
//        db.close();
//        return result;
//    }
//
//
//
//
//    public static byte[] getSerializedObject(Serializable s) {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ObjectOutputStream oos = null;
//        try {
//            oos = new ObjectOutputStream(baos);
//            oos.writeObject(s);
//        } catch (IOException e) {
//            return null;
//        } finally {
//            try {
//                oos.close();
//            } catch (IOException e) {
//            }
//        }
//        byte[] result = baos.toByteArray();
//        return result;
//    }
//
//
//    public static Object readSerializedObject(byte[] in) {
//        Object result = null;
//        ByteArrayInputStream bais = new ByteArrayInputStream(in);
//        ObjectInputStream ois = null;
//        try {
//            ois = new ObjectInputStream(bais);
//            result = ois.readObject();
//        } catch (Exception e) {
//            result = null;
//        } finally {
//            try {
//                ois.close();
//            } catch (Throwable e) {
//            }
//        }
//        return result;
//
//}
