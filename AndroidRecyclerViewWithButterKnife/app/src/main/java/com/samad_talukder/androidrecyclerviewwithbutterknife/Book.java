package com.samad_talukder.androidrecyclerviewwithbutterknife;

public class Book {
    private int bookCoverImage;
    private String bookName;
    private String bookAuthorName;

    public Book(int bookCoverImage, String bookName, String bookAuthorName) {
        this.bookCoverImage = bookCoverImage;
        this.bookName = bookName;
        this.bookAuthorName = bookAuthorName;
    }

    public int getBookCoverImage() {
        return bookCoverImage;
    }

    public void setBookCoverImage(int bookCoverImage) {
        this.bookCoverImage = bookCoverImage;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthorName() {
        return bookAuthorName;
    }

    public void setBookAuthorName(String bookAuthorName) {
        this.bookAuthorName = bookAuthorName;
    }
}
