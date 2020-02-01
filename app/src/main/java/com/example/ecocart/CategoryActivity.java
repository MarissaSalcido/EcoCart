package com.example.ecocart;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        String foodType = getIntent().getStringExtra("foodType");
        Log.i("TAG", "CategoryActivity onCreate: "+foodType);

    }

}
