package com.samad_talukder.androidrecyclerviewwithbutterknife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.book_list_rv)
    RecyclerView bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bookList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        bookList.setHasFixedSize(true);
        bookList.setAdapter(new BookAdapter(this, getBookList()));
    }

    private List<Book> getBookList() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(R.drawable.content, "The Light Between Oceans", "by M.L Stedman"));
        books.add(new Book(R.drawable.content, "Book Name 1", "Book Author"));
        books.add(new Book(R.drawable.content, "The Light Between Oceans", "by M.L Stedman"));
        books.add(new Book(R.drawable.content, "Book Name 1", "Book Author"));
        books.add(new Book(R.drawable.content, "The Light Between Oceans", "by M.L Stedman"));
        books.add(new Book(R.drawable.content, "Book Name 1", "Book Author"));
        return books;
    }
}
