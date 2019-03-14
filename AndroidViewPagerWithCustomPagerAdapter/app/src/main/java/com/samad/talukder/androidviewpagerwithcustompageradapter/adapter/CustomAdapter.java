package com.samad.talukder.androidviewpagerwithcustompageradapter.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.samad.talukder.androidviewpagerwithcustompageradapter.DataModel;
import com.samad.talukder.androidviewpagerwithcustompageradapter.R;

import java.util.List;

public class CustomAdapter extends PagerAdapter {
    private Context context;
    private List<DataModel> dataModelList;

    public CustomAdapter(Context context, List<DataModel> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;
    }

    @Override
    public int getCount() {
        return dataModelList.size();
    }
    public DataModel getItem(int position){
        return dataModelList.get(position);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        DataModel dataModel = dataModelList.get(position);
        View view = LayoutInflater.from(context).inflate(R.layout.pager_view_item, container, false);
        ImageView image = view.findViewById(R.id.itemImageIV);
        TextView text = view.findViewById(R.id.itemTextTV);
        text.setText(dataModel.getImageName());
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        image.setImageResource(dataModel.getImage());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
