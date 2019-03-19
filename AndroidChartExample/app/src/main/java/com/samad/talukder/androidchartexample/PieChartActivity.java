package com.samad.talukder.androidchartexample;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

import java.util.ArrayList;
import java.util.List;

public class PieChartActivity extends AppCompatActivity {
    private PieChart mPieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        mPieChart = findViewById(R.id.pieChart);
        setupPieChartData();
    }

    private void setupPieChartData() {
        ArrayList<PieEntry> dataList = new ArrayList<>();
        dataList.add(new PieEntry((float) 20.05, "Carbon"));
        dataList.add(new PieEntry((float) 30.50, "Oxygen"));
        dataList.add(new PieEntry((float) 50.40, "Hydrogen"));
        List<Integer> colorList = new ArrayList<Integer>();
        colorList.add(ContextCompat.getColor(this, R.color.colorAccent));
        colorList.add(ContextCompat.getColor(this, R.color.colorPrimary));
        colorList.add(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        // pie data set
        PieDataSet pieDataSet = new PieDataSet(dataList, "Data List");
        pieDataSet.setColors(colorList);
        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        pieDataSet.setValueLineColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        pieDataSet.setValueTextColors(colorList);
        // pie chart
        mPieChart.setData(new PieData(pieDataSet));
        mPieChart.setDrawEntryLabels(false);
        mPieChart.getDescription().setEnabled(false);
        mPieChart.getLegend().setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);
        mPieChart.setTransparentCircleRadius(0.0f);
        mPieChart.setDrawHoleEnabled(true);
        mPieChart.setHoleRadius(40.0f);
        mPieChart.invalidate();
        mPieChart.setCenterText("Test");

    }
}
