package com.example.ecocart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity {
    List<Food> shoppingCart = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        /*
        Intent intent = getIntent();
        FoodWrapper shoppingCartFoodWrapper = (FoodWrapper) intent.getSerializableExtra("shoppingCart");
        List<Food> shoppingCart_ = shoppingCartFoodWrapper.getFoods();
        shoppingCart.addAll(shoppingCart_);
        System.out.println(shoppingCart.size());

         */
    }
}
