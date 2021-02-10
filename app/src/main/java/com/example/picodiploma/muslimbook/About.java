package com.example.picodiploma.muslimbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class About extends AppCompatActivity {
    ImageView imgProfil;
    TextView name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_about);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("About Me");
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        imgProfil = findViewById(R.id.img_item_profil);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);

        Glide.with(this)
                .load(R.drawable.huda)
                .into(imgProfil);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
