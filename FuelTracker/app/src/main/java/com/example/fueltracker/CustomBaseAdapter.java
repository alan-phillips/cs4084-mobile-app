package com.example.fueltracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    String stationList[];
    LayoutInflater inflater;

    public CustomBaseAdapter(Context ctx, String[] stationList){
        this.context = ctx;
        this.stationList = stationList;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return stationList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        convertView = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView txtView = (TextView) convertView.findViewById(R.id.nameId);
        txtView.setText(stationList[position]);
        return convertView;
    }
}
