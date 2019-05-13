package com.samad_talukder.androidrecyclerviewwithbutterknife;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.book_name_tv)
    TextView book_name;
    @BindView(R.id.book_author_name_tv)
    TextView book_author_name;
    @BindView(R.id.book_cover_image_iv)
    ImageView book_cover_image;


    public BookViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}
