package a207project.fall18.GameCenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class StoneHengeMainActivity extends AppCompatActivity {

    String[] characters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
    "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    ArrayList<String> buttons = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stone_henge_main);

        GridView gridview = (GridView) findViewById(R.id.gridView);
        setUplist();
//        GridViewAdapter adapter = new GridViewAdapter();
//        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(StoneHengeMainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUplist() {
        for (String item: characters)
            buttons.add(item);
    }
}
