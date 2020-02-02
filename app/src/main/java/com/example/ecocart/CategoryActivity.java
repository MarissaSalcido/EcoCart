package com.example.ecocart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    RecyclerView rvFoods;
    List<Food> foods =  new ArrayList<>(Arrays.asList(new Food("Lamb", 39.2, "Protein"), new Food("Beef", 27.2 , "Protein"),
            new Food("Cheese", 13.5, "Fat"), new Food("Pork", 12.1, "Protein"), new Food("Farmed Salmon", 11.9, "Fat"),
            new Food("Turkey", 10.9, "Protein"), new Food("Chicken", 6.9, "Protein"), new Food("Canned Tune", 6.1, "Fat"),
            new Food("Eggs", 4.8, "Protein"), new Food("Potatoes", 2.9, "Carb"), new Food("Rice", 2.7, "Carb"),
            new Food("Peanut Butter", 2.5, "Fat"), new Food("Nuts", 2.3, "Fat"), new Food("Yogurt", 2.2, "Fat"),
            new Food("Broccoli", 2.0, "Carb"), new Food("Tofu", 2.0, "Protein"), new Food("Dried Beans", 2.0, "Protein"),
            new Food("2% Milk", 1.9, "Protein"), new Food("Tomato", 1.1, "Carb"), new Food("Lentils", 0.9, "Protein")));

    FoodAdapter adapter;
    TextView foodTypeTitle;
    ImageButton shoppingCartButton;

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
        FoodDatabase foodDatabase = new FoodDatabase(this, null, null, 16);
        foodDatabase.addAll();
        specifiedFoods.addAll(foodDatabase.loadList(foodType));
        adapter = new FoodAdapter(specifiedFoods);
        LinearLayoutManager layoutManager = new LinearLayoutManager((this));
        rvFoods.setLayoutManager(layoutManager);
        rvFoods.setAdapter(adapter);

        shoppingCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, ShoppingCartActivity.class);
                //set up bundle to add shopping cart list, pass bundle to next activity
            }
        });


    }

}
