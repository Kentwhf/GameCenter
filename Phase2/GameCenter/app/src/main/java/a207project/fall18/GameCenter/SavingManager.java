package a207project.fall18.GameCenter;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import a207project.fall18.GameCenter.bean.User;

public class SavingManager {

    private static Map<User, BoardManager> autosavemap = new HashMap<>();
    Context context;
    private static String filename;



    public SavingManager(Context context, String filename) {
        this.filename = filename;

        this.context = context;

        loadFromFile(filename);
    }

    public BoardManager getBoard(String username) {
        for(User u : autosavemap.keySet()){
            if (u.getUsername().equals(username)){
                return autosavemap.get(u);
            }
        }

        return null;
    }


    public void addAutosavemap(User user, BoardManager boardManager) {
        boolean oldplayer = false;
        for(User u : autosavemap.keySet()) {
            if (u.getUsername().equals(user.getUsername())) {
                oldplayer = true;
                autosavemap.put(u, boardManager);
            }
        }
        if (!oldplayer){autosavemap.put(user, boardManager);}

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    context.openFileOutput(filename, context.MODE_PRIVATE));
            outputStream.writeObject(autosavemap);
            outputStream.close();

        } catch (Exception i) {
//            i.printStackTrace();
        }
    }


    public void loadFromFile(String filename) {


        try {
            InputStream inputStream = context.openFileInput(filename);
            if (inputStream != null) {
                ObjectInputStream input = new ObjectInputStream(inputStream);
                autosavemap = (Map<User, BoardManager>) input.readObject();
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
//            Log.e("Exception","File not found:" + e.toString());
        } catch (IOException e) {
//            Log.e("Exception","Can not read file:" + e.toString());
        } catch (ClassNotFoundException e) {
//            Log.e("Exception","File contained unexpected data type:" + e.toString());
        }
    }

}
