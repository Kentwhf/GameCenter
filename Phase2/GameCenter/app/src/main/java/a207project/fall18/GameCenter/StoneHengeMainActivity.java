package a207project.fall18.GameCenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class StoneHengeMainActivity extends AppCompatActivity {

    String[] characters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
    "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    ArrayList<String> buttons = new ArrayList<String>();


    public static int GAME = 0;//判断游戏是否已经开始,0为未开始,1为已开始
    private static int ROW = 19;
    private static int COL = 14;
    private static int NUM = 30;//雷的个数
    private int num =30;
    private LinearLayout gv;
    private LinearLayout[] lay_out = new LinearLayout[ROW];
    private static Base[][] base = new Base[ROW][COL];
    private static int [] FKNUM={R.drawable.i0,R.drawable.i1,R.drawable.i2,
            R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i6,R.drawable.i7,R.drawable.i8};



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
