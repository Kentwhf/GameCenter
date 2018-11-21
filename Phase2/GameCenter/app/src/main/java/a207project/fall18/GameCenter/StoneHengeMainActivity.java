package a207project.fall18.GameCenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StoneHengeMainActivity extends AppCompatActivity {

    String[] characters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
    "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    ArrayList<String> buttons = new ArrayList<>();

//    String[][] horizontal = [['@', 'A', 'B'], ['@', 'C', 'D', 'E'],
//            ['@', 'F', 'G', 'H', 'I'],
//            ['@', 'J', 'K', 'L', 'M', 'N'],
//            ['@', 'O', 'P', 'Q', 'R', 'S', 'T'],
//            ['U', '@', 'V', 'W', 'X', 'Y']]

    private StoneManager stoneManager;

//    public static int GAME = 0;//判断游戏是否已经开始,0为未开始,1为已开始
//    private static int ROW = 19;
//    private static int COL = 14;
//    private static int NUM = 30;//雷的个数
//    private int num =30;
//    private LinearLayout gv;
//    private LinearLayout[] lay_out = new LinearLayout[ROW];
//    private static Base[][] base = new Base[ROW][COL];
//    private static int [] FKNUM={R.drawable.i0,R.drawable.i1,R.drawable.i2,
//            R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i6,R.drawable.i7,R.drawable.i8};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stone_henge_main);
        stoneManager = new StoneManager();

        GridView gridview1 = (GridView) findViewById(R.id.gridView1);
        GridView gridview2 = (GridView) findViewById(R.id.gridView2);
        GridView gridview3 = (GridView) findViewById(R.id.gridView3);
        GridView gridview4 = (GridView) findViewById(R.id.gridView4);
        GridView gridview5 = (GridView) findViewById(R.id.gridView5);
        GridView gridview6 = (GridView) findViewById(R.id.gridView6);
        GridView gridview7 = (GridView) findViewById(R.id.gridView7);
        GridView gridview8 = (GridView) findViewById(R.id.gridView8);
        GridView gridview9 = (GridView) findViewById(R.id.gridView9);
        GridView gridview10 = (GridView) findViewById(R.id.gridView10);
        GridView gridview11 = (GridView) findViewById(R.id.gridView11);


        setUplist(stoneManager, 0);
        GridViewAdapter adapter1 = new GridViewAdapter(this, buttons);
        gridview1.setAdapter(adapter1);

        setUplist(stoneManager, 1);
        GridViewAdapter adapter2 = new GridViewAdapter(this, buttons);
        gridview2.setAdapter(adapter2);

        setUplist(stoneManager, 2);
        GridViewAdapter adapter3 = new GridViewAdapter(this, buttons);
        gridview3.setAdapter(adapter3);

        setUplist(stoneManager, 3);
        GridViewAdapter adapter4 = new GridViewAdapter(this, buttons);
        gridview4.setAdapter(adapter4);

        setUplist(stoneManager, 4);
        GridViewAdapter adapter5 = new GridViewAdapter(this, buttons);
        gridview5.setAdapter(adapter5);

        setUplist(stoneManager, 5);
        GridViewAdapter adapter6 = new GridViewAdapter(this, buttons);
        gridview6.setAdapter(adapter6);

//        setUplist(stoneManager, 7);
//        GridViewAdapter adapter7 = new GridViewAdapter(this, buttons);
//        gridview7.setAdapter(adapter7);

//        GridViewAdapter adapter7 = new GridViewAdapter(this, buttons);
//        gridview1.setAdapter(adapter7);
//
//        GridViewAdapter adapter1 = new GridViewAdapter(this, buttons);
//        gridview1.setAdapter(adapter1);
//
//        GridViewAdapter adapter1 = new GridViewAdapter(this, buttons);
//        gridview1.setAdapter(adapter1);
//
//        GridViewAdapter adapter1 = new GridViewAdapter(this, buttons);
//        gridview1.setAdapter(adapter1);
//
//        GridViewAdapter adapter1 = new GridViewAdapter(this, buttons);
//        gridview1.setAdapter(adapter1);

        gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(StoneHengeMainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUplist(StoneManager stonemanager, int i) {
        ArrayList<String> temp = new ArrayList<>();

        for (String item: stonemanager.board[i])
            temp.add(item);
        buttons = temp;
//        buttons = stonemanager.board[i];
    }
}
