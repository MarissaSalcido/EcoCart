package com.example.ecocart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;
    Button carbButton;
    Button proteinButton;
    Button fatButton;
    TextView nameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameField = findViewById(R.id.nameField);
        carbButton = findViewById(R.id.carbButton);
        proteinButton = findViewById(R.id.proteinButton);
        fatButton = findViewById(R.id.fatButton);

        String name = getIntent().getStringExtra("name");
        String text = nameField.getText().toString().replace("name", name);
        Log.i("TAG", text);
        nameField.setText(text);

        carbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                intent.putExtra("foodType", "carb");
                startActivity(intent);
            }
        });

        proteinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                intent.putExtra("foodType", "protein");
                startActivity(intent);
            }
        });

        fatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                intent.putExtra("foodType", "fat");
                startActivity(intent);
            }
        });

    }
}

