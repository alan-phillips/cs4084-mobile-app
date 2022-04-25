package com.example.fueltracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class StationListAdapter extends ArrayAdapter<Station> {

    private static final String TAG = "PersonListAdapter";
    private Context context;
    LayoutInflater inflater;
    int resource;

    public StationListAdapter(Context context, int resource, ArrayList<Station> stationList){
        super(context, resource, stationList);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position).getName();
        double diesel = getItem(position).getDiesel();
        double petrol = getItem(position).getPetrol();

        Station station = new Station(name, diesel, petrol);

        inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.nameId);
        TextView tvDiesel = (TextView) convertView.findViewById(R.id.diesel);
        TextView tvPetrol = (TextView) convertView.findViewById(R.id.petrol);

        tvName.setText(name);
        tvDiesel.setText("Diesel: €" + Double.toString(diesel));
        tvPetrol.setText("Petrol: €" + Double.toString(petrol));

        return convertView;
    }
}
