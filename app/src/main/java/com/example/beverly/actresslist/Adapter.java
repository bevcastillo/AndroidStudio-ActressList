package com.example.beverly.actresslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    Context context;
    ArrayList<Names> list;
    LayoutInflater inflater;


    public Adapter(Context context, ArrayList<Names> list) {
        super();
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
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
        ItemHandler handler = null;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.custom_listview, null);
            handler = new ItemHandler();
            handler.image = (ImageView) convertView.findViewById(R.id.imageView);
            handler.name = (TextView) convertView.findViewById(R.id.textView1);
            convertView.setTag(handler);
        }
        else handler = (ItemHandler) convertView.getTag();
        handler.image.setImageResource(list.get(position).getImg());
        handler.name.setText(list.get(position).getName());

        return convertView;
    }

    static class ItemHandler{
        ImageView image;
        TextView name;
    }
}
