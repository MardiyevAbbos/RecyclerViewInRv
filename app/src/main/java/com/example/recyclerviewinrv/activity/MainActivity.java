package com.example.recyclerviewinrv.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.recyclerviewinrv.R;
import com.example.recyclerviewinrv.adapter.CustomAdapter;
import com.example.recyclerviewinrv.model.Fruit;
import com.example.recyclerviewinrv.model.FruitSub;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ArrayList<Fruit> fruits = prepareFruitList();
        refreshAdapter(fruits);

    }

    private void refreshAdapter(ArrayList<Fruit> fruits) {
        CustomAdapter adapter = new CustomAdapter(context, fruits);
        recyclerView.setAdapter(adapter);
    }


    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }


    private ArrayList<Fruit> prepareFruitList() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        for (int i = 1; i < 25; i++) {
            if (i == 3 || i == 7 || i == 11 || i == 13 || i == 18 || i == 23) {
                fruits.add(new Fruit(R.drawable.apple1, prepareSubFruits(i)));
            } else {
                if (i % 3 == 1) fruits.add(new Fruit(R.drawable.apple2, null));
                else if (i % 3 == 2) fruits.add(new Fruit(R.drawable.bananas3, null));
                else fruits.add(new Fruit(R.drawable.grapes3, null));
            }
        }
        return fruits;
    }


    private ArrayList<FruitSub> prepareSubFruits(int test) {
        ArrayList<FruitSub> subFruits = new ArrayList<>();
        if (test % 3 == 1) {
            for (int i = 1; i < 12; i++) {
                if (i % 4 == 1) subFruits.add(new FruitSub(R.drawable.apple1));
                else if (i % 4 == 2) subFruits.add(new FruitSub(R.drawable.apple2));
                else if (i % 4 == 3) subFruits.add(new FruitSub(R.drawable.apple3));
                else subFruits.add(new FruitSub(R.drawable.apple4));
            }
        } else if (test % 3 == 2) {
            for (int i = 1; i < 12; i++) {
                if (i % 4 == 1) subFruits.add(new FruitSub(R.drawable.bananas1));
                else if (i % 4 == 2) subFruits.add(new FruitSub(R.drawable.bananas2));
                else if (i % 4 == 3) subFruits.add(new FruitSub(R.drawable.bananas3));
                else subFruits.add(new FruitSub(R.drawable.bananas4));
            }
        } else {
            for (int i = 1; i < 12; i++) {
                if (i % 4 == 1) subFruits.add(new FruitSub(R.drawable.grapes1));
                else if (i % 4 == 2) subFruits.add(new FruitSub(R.drawable.grapes2));
                else if (i % 4 == 3) subFruits.add(new FruitSub(R.drawable.grapes3));
                else subFruits.add(new FruitSub(R.drawable.grapes4));
            }
        }
        return subFruits;
    }

}