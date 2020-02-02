package com.example.ecocart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity {
    List<Food> shoppingCart = new ArrayList<>();
    ShoppingCartAdapter adapter;
    RecyclerView rvshopping;

    Button donebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);


        String foodType = getIntent().getStringExtra("foodType");


        adapter = new ShoppingCartAdapter(this);
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
