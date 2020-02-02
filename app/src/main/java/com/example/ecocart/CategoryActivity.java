package com.example.ecocart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    RecyclerView rvFoods;
    List<Food> foods = new ArrayList<>();
    FoodDatabase foodDatabase;
    FoodAdapter adapter;
    TextView foodTypeTitle;
    ImageButton shoppingCartButton;
    ArrayList<String> shoppingCart;
    ImageButton addItemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        String foodType = getIntent().getStringExtra("foodType");
        Log.i("TAG", "CategoryActivity onCreate: "+foodType);

        foodTypeTitle = findViewById(R.id.categoryFoodTitle);
        foodTypeTitle.setText(foodType+"s");
        shoppingCartButton = findViewById(R.id.shoppingCartButton);
        rvFoods = findViewById(R.id.rvfood);
        List<Food> specifiedFoods = new ArrayList<>();
        FoodDatabase foodDatabase = new FoodDatabase(this, null, null, 17);
        this.foodDatabase = foodDatabase;
        this.foodDatabase.addAll();
        specifiedFoods.addAll(this.foodDatabase.loadList(foodType));

        foods.clear();
        foods.addAll(specifiedFoods);

        adapter = new FoodAdapter(this, specifiedFoods, shoppingCart);
        LinearLayoutManager layoutManager = new LinearLayoutManager((this));
        rvFoods.setLayoutManager(layoutManager);
        rvFoods.setAdapter(adapter);

        shoppingCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });


    }

}
