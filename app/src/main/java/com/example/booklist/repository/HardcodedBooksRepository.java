package com.example.booklist.repository;

import com.example.booklist.models.Book;
import com.example.booklist.models.HardCodedBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HardcodedBooksRepository implements BooksRepository {
    private List<Book> list = new ArrayList<>();
    {
        list.add(new HardCodedBook("Going postal", "Terry Pratchett"));
        list.add(new HardCodedBook("Monster clothes", "Daisy Hirst"));
        list.add(new HardCodedBook("A short history of nearly everything", "Bill Bryson"));
        list.add(new HardCodedBook("Good Omens", "Terry Pratchett, Neil Gaiman"));
        list.add(new HardCodedBook("A modern utopia", "H G Wells"));
        list.add(new HardCodedBook("Life of pi", "Yann Martel"));
        list.add(new HardCodedBook("Shantaram", "Gregory David Roberts"));
        list.add(new HardCodedBook("Moby Dick", "Herman Melville"));
        list.add(new HardCodedBook("1984", "George Orwell"));
        list.add(new HardCodedBook("Freakonomics", "Steven d. Levitt"));
        list.add(new HardCodedBook("To kill a mockingbird", "Harper Lee"));
        list.add(new HardCodedBook("The great gatsby", "F. Scott Fitzgerald"));
        list.add(new HardCodedBook("The hobbit", "J. R. R. Tolkien"));
        list.add(new HardCodedBook("The alchemist", "Paulo Coelho"));
    }

    @Override
    public List<Book> getBooks() {
        return list;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        List<Book> filteredList = new ArrayList<>();
        for (Book book: list) {
            if (book.getAuthor().toLowerCase(Locale.ROOT).equals(author)) {
                filteredList.add(book);
            }
        }
        return filteredList;
    }

    @Override
    public List<Book> getBooksByKeyword(String keyword) {
        List<Book> filteredList = new ArrayList<>();
        for (Book book: list) {
            if (book.getAuthor().toLowerCase(Locale.ROOT).contains(keyword)
                    || book.getTitle().toLowerCase(Locale.ROOT).contains(keyword)) {
                filteredList.add(book);
            }
        }
        return filteredList;
    }
}
