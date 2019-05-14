package com.samad_talukder.androidcustomlistviewexample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomListViewAdapter extends ArrayAdapter<AndroidVersion> {
    private Context context;
    private List<AndroidVersion> androidVersionList;
    int resource;


    public CustomListViewAdapter(@NonNull Context context, int resource, List<AndroidVersion> androidVersionList) {
        super(context, resource, androidVersionList);
        this.context = context;
        this.resource = resource;
        this.androidVersionList = androidVersionList;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //getting the view
        @SuppressLint("ViewHolder")
        View view = LayoutInflater.from(context).inflate(resource,null,false);
        //getting the view elements of the list from the view
        ImageView appIconIV = view.findViewById(R.id.appIconIV);
        TextView androidVersionNameTV = view.findViewById(R.id.androidVersionNameTV);
        TextView androidVersionTV = view.findViewById(R.id.androidVersionTV);
        //getting the specified position
        AndroidVersion androidVersion = androidVersionList.get(position);
        appIconIV.setImageResource(androidVersion.getAndroidVersionImage());
        androidVersionNameTV.setText(androidVersion.getAndroidVersionName());
        androidVersionTV.setText(androidVersion.getAndroidVersion());

        return view;
    }
}
