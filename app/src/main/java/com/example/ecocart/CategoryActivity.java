package com.example.ecocart;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    RecyclerView rvFoods;
    ArrayList<String> foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        String foodType = getIntent().getStringExtra("foodType"); // if (foodType == " ")
        Log.i("TAG", "CategoryActivity onCreate: "+foodType);

        rvFoods = findViewById(R.id.rvfood);
        //foods = new ArrayList<>();


        FoodDatabase foodDatabase = new FoodDatabase(this, null, null, 1);

        for (int i = 0; i < foods.size();i++)
        {
            foods.add(foodDatabase.loadList("Protein").get(i).toString());
        }


        FoodAdapter foodAdapter = new FoodAdapter(foods);
        rvFoods.setAdapter(foodAdapter);
        rvFoods.setLayoutManager(new LinearLayoutManager(this));



        //LinearLayoutManager layoutManager = new LinearLayoutManager((this));
        //rvFoods.setLayoutManager(layoutManager);
        //rvFoods.setAdapter(adapter);


    }

}
