package com.virus_men.androidrecyclerviewscrollingexample.rv_horizontal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.virus_men.androidrecyclerviewscrollingexample.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RVHorizontalAdapter extends RecyclerView.Adapter<RVHorizontalAdapter.RVHorizontalViewHolder> {
    private Context context;
    private List<HorizontalModel> horizontalModelList = new ArrayList<>();

    public RVHorizontalAdapter(Context context, List<HorizontalModel> horizontalModelList) {
        this.context = context;
        this.horizontalModelList = horizontalModelList;
    }

    @NonNull
    @Override
    public RVHorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rvView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_horizontal,viewGroup,false);
        return new RVHorizontalViewHolder(rvView);
    }

    @Override
    public void onBindViewHolder(@NonNull RVHorizontalViewHolder rvHorizontalViewHolder, int i) {
        rvHorizontalViewHolder.firstChar.setText(horizontalModelList.get(i).getName().substring(0,1).toUpperCase());
        rvHorizontalViewHolder.firstChar.setBackgroundColor(getRandomColor());
        rvHorizontalViewHolder.name.setText(horizontalModelList.get(i).getName());

    }

    private int getRandomColor() {
        Random random = new Random();
        return Color.argb(255, random.nextInt(256), random.nextInt(256),     random.nextInt(256));
    }

    @Override
    public int getItemCount() {
        return horizontalModelList.size();
    }

    public class RVHorizontalViewHolder extends RecyclerView.ViewHolder{
        private TextView firstChar,name;
        public RVHorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            firstChar = itemView.findViewById(R.id.tv_middle);
            name = itemView.findViewById(R.id.tv_name);
        }
    }
}
