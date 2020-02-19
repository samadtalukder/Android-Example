package com.samad_talukder.androidrecyclerviewmvvmlivedataexample.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.samad_talukder.androidrecyclerviewmvvmlivedataexample.R;
import com.samad_talukder.androidrecyclerviewmvvmlivedataexample.model.Movie;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterMovie extends RecyclerView.Adapter<AdapterMovie.MovieViewHolder> {

    private Context mContext;
    private ArrayList<Movie> movieArrayList;

    public AdapterMovie(Context mContext, ArrayList<Movie> movieArrayList) {
        this.mContext = mContext;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_movie, parent, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.dataBind(position);
    }

    @Override
    public int getItemCount() {
        return movieArrayList != null ? movieArrayList.size() : 0;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_movie_poster)
        ImageView ivMoviePoster;

        @BindView(R.id.tv_movie_title)
        TextView tvMovieTitle;

        @BindView(R.id.tv_genre)
        TextView tvGenre;

        @BindView(R.id.tv_movie_release)
        TextView tvMovieRelease;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void dataBind(int position) {

            Movie movie = movieArrayList.get(position);

            String movieTitle = movie.getMovieTitle();
            int moviePoster = movie.getMoviePoster();
            String movieGenre = movie.getMovieGenre();
            String movieReleaseDate = movie.getMovieReleaseDate();

            tvMovieTitle.setText(movieTitle);
            tvGenre.setText(movieGenre);
            tvMovieRelease.setText(movieReleaseDate);

            Glide.with(mContext)
                    .load(moviePoster)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(ivMoviePoster);

        }
    }
}
