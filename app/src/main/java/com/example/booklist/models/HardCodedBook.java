package com.example.booklist.models;

public class HardCodedBook implements Book {
    String title;
    String Author;

    public HardCodedBook(String title, String author) {
        this.title = title;
        Author = author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return Author;
    }
}