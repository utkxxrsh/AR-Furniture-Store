package com.example.furnished.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furnished.R;
import com.example.furnished.model.popularfur;

import java.util.List;

public class popularfuradapter extends RecyclerView.Adapter<popularfuradapter.popularfurViewHolder> {
    Context context;
    List<popularfur> popularfurList;

    public popularfuradapter(Context context, List<popularfur> popularfurList) {
        this.context = context;
        this.popularfurList = popularfurList;
    }

    @NonNull
    @Override
    public popularfurViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_fur_row,parent,false);

        return new popularfurViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull popularfurViewHolder holder, int position) {
        holder.furImage.setImageResource(popularfurList.get(position).getImgageurl());
        holder.name.setText(popularfurList.get(position).getName());
        holder.price.setText(popularfurList.get(position).getPrice());


    }

    @Override
    public int getItemCount() {
        return popularfurList.size();
    }

    public static final class popularfurViewHolder extends RecyclerView.ViewHolder {
        ImageView furImage;
        TextView price,name;

        public popularfurViewHolder(@NonNull View itemView) {

            super(itemView);
            furImage= itemView.findViewById(R.id.imageView7);
            price=itemView.findViewById(R.id.textView7);
            name=itemView.findViewById(R.id.textView4);
        }
    }
}

