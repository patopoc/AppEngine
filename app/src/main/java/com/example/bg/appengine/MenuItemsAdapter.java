package com.example.bg.appengine;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuItemsAdapter extends BaseAdapter {

    Context context;
    List<RowItem> rowItems;

    public MenuItemsAdapter(Context context, List<RowItem> items) {
        this.context = context;
        this.rowItems = items;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
        }

        ImageView icon = (ImageView) convertView.findViewById(R.id.itemIcon);
        TextView text = (TextView) convertView.findViewById(R.id.itemText);

        icon.setImageResource(rowItems.get(position).getIcon());
        Log.d("foto", rowItems.get(position).getIcon() + "");
        text.setText(rowItems.get(position).getText());

        return convertView;
    }


}
