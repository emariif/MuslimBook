package com.example.picodiploma.muslimbook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvBook;
    private ArrayList<Book> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBook = findViewById(R.id.rv_book);
        rvBook.setHasFixedSize(true);

        list.addAll(BooksData.getListData());
        showRecyclerCardView();
    }

    private void showRecyclerCardView(){
//        rvBook.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,2);
        rvBook.setLayoutManager(mLayoutManager);
        CardViewBookAdapter cardViewBookAdapter = new CardViewBookAdapter(list);
        rvBook.setAdapter(cardViewBookAdapter);

        cardViewBookAdapter.setOnItemClickCallback(new CardViewBookAdapter.OnItemClickCallback(){
            @Override
            public void onItemClicked(Book data) {
                showSelectedBook(data);
            }

        });
    }

    private void showSelectedBook(Book book) {
        Toast.makeText(this, "Kamu memilih " + book.getName(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, Detail.class);
        intent.putExtra(Detail.nama, book.getName());
        intent.putExtra(Detail.penulis, book.getAuthor());
        intent.putExtra(Detail.penerbit, book.getPublisher());
        intent.putExtra(Detail.kategori, book.getCategories());
        intent.putExtra(Detail.deskripsi, book.getDescription());
        intent.putExtra(Detail.foto, book.getPhoto());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

//    private void showSelectedBook(Book book) {
//        Toast.makeText(this, "Kamu memilih " + book.getName(),Toast.LENGTH_SHORT).show();
//    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.about_menu:
                Intent moveAbout = new Intent(MainActivity.this, About.class);
                startActivity(moveAbout);
                break;
        }
    }
}
