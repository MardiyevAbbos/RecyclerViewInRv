package com.example.recyclerviewinrv.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewinrv.R;
import com.example.recyclerviewinrv.model.Fruit;
import com.example.recyclerviewinrv.model.FruitSub;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM_VIEW = 0;
    private static final int TYPE_ITEM_LIST = 1;

    private Context context;
    private ArrayList<Fruit> fruits;

    public CustomAdapter(Context context, ArrayList<Fruit> fruits) {
        this.context = context;
        this.fruits = fruits;
    }

    @Override
    public int getItemViewType(int position) {
        Fruit fruit = fruits.get(position);
        if (fruit.getImageSubs() != null) return TYPE_ITEM_LIST;

        return TYPE_ITEM_VIEW;
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM_LIST) {
            View list = LayoutInflater.from(context).inflate(R.layout.item_custom_layout_list, parent, false);
            return new CustomListHolder(list);
        }

        View view = LayoutInflater.from(context).inflate(R.layout.item_custom_layout_view, parent, false);
        return new CustomViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Fruit fruit = fruits.get(position);

        if (holder instanceof CustomViewHolder) {
            ImageView imageV = ((CustomViewHolder) holder).imageView;
            imageV.setImageResource(fruit.getImage());
        }

        if (holder instanceof CustomListHolder) {
            RecyclerView recyclerView = ((CustomListHolder) holder).recyclerView;
            LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);

            ArrayList<FruitSub> fruitSubs = fruit.getImageSubs();
            refreshAdapter(recyclerView, fruitSubs);
        }

    }

    private void refreshAdapter(RecyclerView recyclerView, ArrayList<FruitSub> fruitSubs) {
        CustomSubAdapter adapter = new CustomSubAdapter(context, fruitSubs);
        recyclerView.setAdapter(adapter);
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView imageView;

        public CustomViewHolder(View v) {
            super(v);
            this.view = v;
            imageView = view.findViewById(R.id.iv_main);
        }
    }


    class CustomListHolder extends RecyclerView.ViewHolder {
        public View view;
        public RecyclerView recyclerView;

        public CustomListHolder(View v) {
            super(v);
            this.view = v;
            recyclerView = view.findViewById(R.id.recyclerView_sub);
        }
    }


}
