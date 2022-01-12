package com.example.recyclerviewinrv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewinrv.R;
import com.example.recyclerviewinrv.model.FruitSub;

import java.util.ArrayList;

public class CustomSubAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<FruitSub> fruitSubs;

    public CustomSubAdapter(Context context, ArrayList<FruitSub> fruitSubs) {
        this.context = context;
        this.fruitSubs = fruitSubs;
    }


    @Override
    public int getItemCount() {
        return fruitSubs.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_custom_layout_view_sub, parent, false);
        return new CustomSubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FruitSub fruitSub = fruitSubs.get(position);

        if (holder instanceof CustomSubViewHolder) {
            ImageView imageView = ((CustomSubViewHolder) holder).image;
            imageView.setImageResource(fruitSub.getImage());
        }
    }


    public class CustomSubViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView image;

        public CustomSubViewHolder(View v) {
            super(v);
            this.view = v;
            image = view.findViewById(R.id.iv_sub);
        }
    }

}
