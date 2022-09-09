package com.example.booklist.repository;

public class BookRepositoryFactory {
    public static BooksRepository getBooksRepository() {
        return new HardcodedBooksRepository();
    }
}
