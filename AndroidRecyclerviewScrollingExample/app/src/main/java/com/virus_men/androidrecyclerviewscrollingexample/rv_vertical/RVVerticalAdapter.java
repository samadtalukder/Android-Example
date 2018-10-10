package com.virus_men.androidrecyclerviewscrollingexample.rv_vertical;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.virus_men.androidrecyclerviewscrollingexample.R;

import java.util.ArrayList;
import java.util.List;

public class RVVerticalAdapter extends RecyclerView.Adapter<RVVerticalAdapter.RVVerticalHolder> {
    private Context context;
    private List<VerticalModel> verticalModels = new ArrayList<>();

    public RVVerticalAdapter(Context context, List<VerticalModel> verticalModels) {
        this.context = context;
        this.verticalModels = verticalModels;
    }

    @NonNull
    @Override
    public RVVerticalHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View verticalView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_vertical,viewGroup,false);

        return new RVVerticalHolder(verticalView);
    }

    @Override
    public void onBindViewHolder(@NonNull RVVerticalHolder rvVerticalHolder, int i) {
        rvVerticalHolder.tvIcon.setText(verticalModels.get(i).getEmailSender().substring(0,1));
        rvVerticalHolder.tvEmailSender.setText(verticalModels.get(i).getEmailSender());
        rvVerticalHolder.tvEmailTitle.setText(verticalModels.get(i).getEmailTitle());
        rvVerticalHolder.tvEmailDetails.setText(verticalModels.get(i).getEmailDetails());
        rvVerticalHolder.tvEmailDate.setText(verticalModels.get(i).getEmailDate());

    }

    @Override
    public int getItemCount() {
        return verticalModels.size();
    }

    public class RVVerticalHolder extends RecyclerView.ViewHolder{
        private TextView tvIcon,tvEmailSender,tvEmailTitle,tvEmailDetails,tvEmailDate;

        public RVVerticalHolder(@NonNull View itemView) {
            super(itemView);
            tvIcon = itemView.findViewById(R.id.tvIcon);
            tvEmailSender = itemView.findViewById(R.id.tvEmailSender);
            tvEmailTitle = itemView.findViewById(R.id.tvEmailTitle);
            tvEmailDetails = itemView.findViewById(R.id.tvEmailDetails);
            tvEmailDate = itemView.findViewById(R.id.tvEmailDate);
        }
    }
}
