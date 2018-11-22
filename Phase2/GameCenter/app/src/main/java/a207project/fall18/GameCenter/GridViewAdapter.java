//package a207project.fall18.GameCenter;
//
//import android.content.Context;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.Button;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GridViewAdapter extends BaseAdapter {
//
//    Context context;
//    List<String> list;
//    ;
//
//    public GridViewAdapter(Context context, List<String> buttons ) {
//        this.context = context;
//        this.list = buttons;
//    }
//
//    @Override
//    public int getCount() {
//        return list.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return list.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        Button button;
//        if (convertView == null) {
//            // if it's not recycled, initialize some attributes
//            button = new Button(context);
//            button.setLayoutParams(new ViewGroup.LayoutParams(100, 100));
//            button.setPadding(8, 8, 8, 8);
//            button.setText(list.get(position));
//
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(context, button.getText().toString(), Toast.LENGTH_LONG).show();
//                }
//            });
//
//
//
//        } else button = (Button) convertView;
//        return button;
//    }
//}
