package com.example.picodiploma.muslimbook;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class CardViewBookAdapter extends RecyclerView.Adapter<CardViewBookAdapter.CardViewViewHolder> {

    private ArrayList<Book> listBook;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public CardViewBookAdapter(ArrayList<Book> list) {
        this.listBook = list;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_book, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {

        Book book = listBook.get(position);

        Glide.with(holder.itemView.getContext())
                .load(book.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvName.setText(book.getName());
        holder.tvAuthor.setText(book.getAuthor());
        holder.tvPublisher.setText(book.getPublisher());
        holder.tvCategories.setText(book.getCategories());

        holder.btnCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "" +
                        listBook.get(holder.getAdapterPosition()).getCategories(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "" + listBook.get(holder.getAdapterPosition()).getName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), Detail.class);
                intent.putExtra(Detail.nama, listBook.get(holder.getAdapterPosition()).getName());
                intent.putExtra(Detail.penulis, listBook.get(holder.getAdapterPosition()).getAuthor());
                intent.putExtra(Detail.penerbit, listBook.get(holder.getAdapterPosition()).getPublisher());
                intent.putExtra(Detail.kategori, listBook.get(holder.getAdapterPosition()).getCategories());
                intent.putExtra(Detail.deskripsi, listBook.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra(Detail.foto, listBook.get(holder.getAdapterPosition()).getPhoto());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvAuthor, tvPublisher, tvCategories;
        Button btnCategories;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvAuthor = itemView.findViewById(R.id.tv_item_author);
            tvPublisher = itemView.findViewById(R.id.tv_item_publisher);
            tvCategories = itemView.findViewById(R.id.btn_set_categories);
            btnCategories = itemView.findViewById(R.id.btn_set_categories);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Book data);
    }
}
