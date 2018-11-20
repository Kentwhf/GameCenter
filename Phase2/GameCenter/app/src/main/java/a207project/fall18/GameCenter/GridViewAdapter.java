package a207project.fall18.GameCenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> list;
    ;

    public GridViewAdapter(Context context, ArrayList<String> buttons ) {
        this.context = context;
        this.list = buttons;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Button button;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            button = new Button(context);
            button.setLayoutParams(new ViewGroup.LayoutParams(85, 85));
            button.setPadding(8, 8, 8, 8);
            button.setText(list.get(position));
        } else button = (Button) convertView;
        return button;
    }
}
