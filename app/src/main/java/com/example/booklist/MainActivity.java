package com.example.booklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.booklist.models.Book;
import com.example.booklist.repository.BookRepositoryFactory;
import com.example.booklist.repository.HardcodedBooksRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView booksRecyclerView = findViewById(R.id.booksRecyclerView);

        List<Book> bookList = BookRepositoryFactory.getBooksRepository().getBooks();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        booksRecyclerView.setLayoutManager(layoutManager);
        booksRecyclerView.setAdapter(new BooksAdapter(bookList, this));
        booksRecyclerView.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));

        EditText searchEditText = findViewById(R.id.searchEditText);
        Button searchButton = findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keyword = String.valueOf(searchEditText.getText());
                List<Book> bookList = BookRepositoryFactory.getBooksRepository().getBooksByKeyword(keyword);
                booksRecyclerView.setAdapter(new BooksAdapter(bookList, view.getContext()));
            }
        });

    }
}