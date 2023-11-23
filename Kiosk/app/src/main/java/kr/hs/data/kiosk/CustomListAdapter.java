package kr.hs.data.kiosk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    ArrayList<Menu> items = new ArrayList<Menu>();

    Context context;

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position){
        return items.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)  {
        context = parent.getContext();
        Menu listItem = items.get(position);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_list_item, parent, false);
        }

        TextView menuName = convertView.findViewById(R.id.menu_name);
        TextView menuPrice = convertView.findViewById(R.id.menu_price);
        ImageView menuThumbnail = convertView.findViewById(R.id.menu_thumnail);


        menuName.setText(listItem.name);
        menuPrice.setText(listItem.price+"원");
        menuThumbnail.setImageResource(listItem.thumbnail);

        return convertView;
    }

    public void addMenu(Menu menu){
        items.add(menu);
    }

}