package com.example.ecocart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity {
    List<ShoppingCartItem> shoppingCart = new ArrayList<>();
    ShoppingCartAdapter adapter;
    RecyclerView rvshopping;

    Button donebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        rvshopping = findViewById(R.id.rvshopping);

        String foodType = getIntent().getStringExtra("foodType");

        FoodDatabase db = new FoodDatabase(this, null, null, 17);
        List<ShoppingCartItem> items = new ArrayList<>();
        items.addAll(db.loadCart("Protein"));
        items.addAll(db.loadCart("Fat"));
        items.addAll(db.loadCart("Carb"));
        shoppingCart.addAll(items);
        adapter = new ShoppingCartAdapter(this, shoppingCart);
        LinearLayoutManager layoutManager = new LinearLayoutManager((this));
        rvshopping.setLayoutManager(layoutManager);
        rvshopping.setAdapter(adapter);

        donebtn = findViewById(R.id.donebtn);

        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingCartActivity.this,DoneActivity.class);

                startActivity(intent);

            }
        });

    }
}
