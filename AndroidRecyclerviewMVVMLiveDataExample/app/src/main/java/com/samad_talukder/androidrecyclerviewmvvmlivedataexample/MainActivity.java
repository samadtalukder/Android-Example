package com.samad_talukder.androidrecyclerviewmvvmlivedataexample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.samad_talukder.androidrecyclerviewmvvmlivedataexample.adapter.AdapterMovie;
import com.samad_talukder.androidrecyclerviewmvvmlivedataexample.model.Movie;
import com.samad_talukder.androidrecyclerviewmvvmlivedataexample.viewmodel.MovieViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_movie)
    RecyclerView rvMovie;

    private AdapterMovie adapterMovie;
    private MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieViewModel = ViewModelProviders.of(MainActivity.this).get(MovieViewModel.class);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        movieViewModel.getMovieMutableLiveData().observe(this, movieArrayList -> {

            adapterMovie = new AdapterMovie(MainActivity.this, movieArrayList);
            rvMovie.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            rvMovie.setAdapter(adapterMovie);

        });

    }
}
