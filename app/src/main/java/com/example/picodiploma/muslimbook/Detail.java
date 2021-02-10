package com.example.picodiploma.muslimbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class Detail extends AppCompatActivity {

    ImageView imgPhoto;
    TextView tvName, tvAuthor, tvPublisher, tvCategories, tvDescription;

    public static final String nama = "nama";
    public static final String penulis = "penulis";
    public static final String penerbit = "penerbit";
    public static final String kategori = "kategori";
    public static final String deskripsi = "deskripsi";
    public static final String foto = "foto";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        imgPhoto = findViewById(R.id.img_item_photo);
        tvName = findViewById(R.id.tv_item_name);
        tvAuthor = findViewById(R.id.tv_item_author);
        tvPublisher = findViewById(R.id.tv_item_publisher);
        tvCategories = findViewById(R.id.btn_set_categories);
        tvDescription = findViewById(R.id.tv_item_description);

        String getName = getIntent().getStringExtra(nama);
        String getAuthor = getIntent().getStringExtra(penulis);
        String getPublisher = getIntent().getStringExtra(penerbit);
        String getCategories = getIntent().getStringExtra(kategori);
        String getDescription = getIntent().getStringExtra(deskripsi);
        String getFoto = getIntent().getStringExtra(foto);

        Glide.with(this)
                .load(getFoto)
//                .apply(new RequestOptions().override(350, 550))
                .into(imgPhoto);

        tvName.setText(getName);
        tvAuthor.setText(getAuthor);
        tvPublisher.setText(getPublisher);
        tvCategories.setText(getCategories);
        tvDescription.setText(getDescription);
    }
}
