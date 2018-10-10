package com.virus_men.androidrecyclerviewscrollingexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.virus_men.androidrecyclerviewscrollingexample.rv_horizontal.HorizontalModel;
import com.virus_men.androidrecyclerviewscrollingexample.rv_horizontal.RVHorizontalAdapter;
import com.virus_men.androidrecyclerviewscrollingexample.rv_vertical.RVVerticalAdapter;
import com.virus_men.androidrecyclerviewscrollingexample.rv_vertical.VerticalModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHorizontal,rvVertical;
    private RVHorizontalAdapter rvHorizontalAdapter;
    private RVVerticalAdapter rvVerticalAdapter;
    private List<HorizontalModel> horizontalModelList = new ArrayList<>();
    private List<VerticalModel> verticalModelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHorizontal = findViewById(R.id.rv_horizontal);
        rvVertical = findViewById(R.id.rv_vertical);
        // RecyclerView Vertical init
        rvVerticalAdapter = new RVVerticalAdapter(this,getVerticalModelList());
        rvVertical.setAdapter(rvVerticalAdapter);
        rvVertical.setItemAnimator(new DefaultItemAnimator());
        rvVertical.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvVertical.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        rvVertical.setHasFixedSize(true);
        // RecyclerView Horizontal init
        rvHorizontalAdapter = new RVHorizontalAdapter(this,getHorizontalModelList());
        rvHorizontal.setAdapter(rvHorizontalAdapter);
        rvHorizontal.setItemAnimator(new DefaultItemAnimator());
        rvHorizontal.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvVertical.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
        rvVertical.setHasFixedSize(true);
    }

    private List<VerticalModel> getVerticalModelList() {
        verticalModelList.add(new VerticalModel("Google","Security Alert for your google account...","Fabric Connected to your google account","06 Sep"));
        verticalModelList.add(new VerticalModel("Fabric","Security Alert for your google account...","Fabric Connected to your google account","06 Sep"));
        verticalModelList.add(new VerticalModel("Udemy","New Promotional Announcement","It Is Not the Strongest of the Species that Survives But the Most Adaptable - Darwin","06 Sep"));
        verticalModelList.add(new VerticalModel("Rokomari","আর মাত্র কয়েক ঘণ্টা! বাংলাদেশ মাতানো অফার আপনি মিস করছেন না তো?","আজই শেষ হয়ে যাচ্ছে বাংলাদেশের ই-কমার্স ইতিহাসের সবচেয়ে বড় অফার। এই অফারে রকমারি ডট কম থেকে অর্ডার করলেই-","06 Sep"));
        verticalModelList.add(new VerticalModel("Google","Security Alert for your google account...","Fabric Connected to your google account","06 Sep"));
        verticalModelList.add(new VerticalModel("Google","Security Alert for your google account...","Fabric Connected to your google account","06 Sep"));
        return verticalModelList;
    }

    private List<HorizontalModel> getHorizontalModelList(){
        horizontalModelList.add(new HorizontalModel("hello Java"));
        horizontalModelList.add(new HorizontalModel("World"));
        horizontalModelList.add(new HorizontalModel("Bangladesh"));
        horizontalModelList.add(new HorizontalModel("Australia"));
        horizontalModelList.add(new HorizontalModel("Croatia"));
        return horizontalModelList;
    }
}
