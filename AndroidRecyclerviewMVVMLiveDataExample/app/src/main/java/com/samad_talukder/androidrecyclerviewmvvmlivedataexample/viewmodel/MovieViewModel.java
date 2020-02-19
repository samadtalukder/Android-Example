package com.samad_talukder.androidrecyclerviewmvvmlivedataexample.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.samad_talukder.androidrecyclerviewmvvmlivedataexample.R;
import com.samad_talukder.androidrecyclerviewmvvmlivedataexample.model.Movie;

import java.util.ArrayList;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Movie>> movieMutableLiveData;
    private ArrayList<Movie> movieArrayList;

    public MovieViewModel() {
        movieMutableLiveData = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<Movie>> getMovieMutableLiveData() {
        return movieMutableLiveData;
    }

    private void getMovieData() {
        movieArrayList = new ArrayList<>();
        movieArrayList.add(new Movie("The Shawshank Redemption", R.drawable.movie_poster_1, " Drama", " 14 October 1994 "));
        movieArrayList.add(new Movie("The Shawshank Redemption", R.drawable.movie_poster_1, " Drama", " 14 October 1994 "));
        movieArrayList.add(new Movie("The Shawshank Redemption", R.drawable.movie_poster_1, " Drama", " 14 October 1994 "));
        movieArrayList.add(new Movie("The Shawshank Redemption", R.drawable.movie_poster_1, " Drama", " 14 October 1994 "));
        movieArrayList.add(new Movie("The Shawshank Redemption", R.drawable.movie_poster_1, " Drama", " 14 October 1994 "));
        movieArrayList.add(new Movie("The Shawshank Redemption", R.drawable.movie_poster_1, " Drama", " 14 October 1994 "));
        movieArrayList.add(new Movie("The Shawshank Redemption", R.drawable.movie_poster_1, " Drama", " 14 October 1994 "));
    }

    private void init() {
        getMovieData();
        movieMutableLiveData.setValue(movieArrayList);
    }
}
