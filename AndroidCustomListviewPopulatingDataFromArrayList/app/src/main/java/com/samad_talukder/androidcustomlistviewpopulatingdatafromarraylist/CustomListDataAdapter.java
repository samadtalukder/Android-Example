package com.samad_talukder.androidcustomlistviewpopulatingdatafromarraylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomListDataAdapter extends ArrayAdapter<DataModel> {
    private ArrayList<DataModel> dataModelArrayList;
    private LayoutInflater layoutInflater;
    private int resource;

    public CustomListDataAdapter(@NonNull Context context, int resource, ArrayList<DataModel> dataModelArrayList) {
        super(context, resource,dataModelArrayList);

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.resource = resource;
        this.dataModelArrayList = dataModelArrayList;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 100;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        final DataViewHolder dataViewHolder;

        if (view == null) {

            view = layoutInflater.inflate(R.layout.view_row, null);
            dataViewHolder = new DataViewHolder();

            dataViewHolder.id = view.findViewById(R.id.tvShowId);
            dataViewHolder.name = view.findViewById(R.id.tvShowName);
            dataViewHolder.address = view.findViewById(R.id.tvShowAddress);

            view.setTag(dataViewHolder);

        } else {

            dataViewHolder = (DataViewHolder) view.getTag();

        }

        dataViewHolder.id.setText("ID: " + dataModelArrayList.get(position).getId());
        dataViewHolder.name.setText("Name: " + dataModelArrayList.get(position).getName());
        dataViewHolder.address.setText("Address: " + dataModelArrayList.get(position).getAddress());

        return view;
    }

    private static class DataViewHolder {
        public TextView id;
        public TextView name;
        public TextView address;

    }
}
