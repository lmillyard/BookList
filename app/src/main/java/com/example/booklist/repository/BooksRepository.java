package com.example.booklist.repository;

import com.example.booklist.models.Book;

import java.util.List;

public interface BooksRepository {
    List<Book> getBooks();
    List<Book> getBooksByAuthor(String author);
    List<Book> getBooksByKeyword(String Keyword);
}
