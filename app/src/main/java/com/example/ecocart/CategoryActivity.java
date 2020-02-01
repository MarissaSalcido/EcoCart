package com.example.ecocart;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    RecyclerView rvFoods;
    List<Food> foods;
    FoodAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        String foodType = getIntent().getStringExtra("foodType");
        Log.i("TAG", "CategoryActivity onCreate: "+foodType);

        rvFoods = findViewById(R.id.rvfood);
        foods = new ArrayList<>();
        adapter = new FoodAdapter(foods);
        LinearLayoutManager layoutManager = new LinearLayoutManager((this));
        rvFoods.setLayoutManager(layoutManager);
        rvFoods.setAdapter(adapter);

    }

}
