package com.example.ecocart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String hi = "hi";
    String hello;
    public Button carb, fat, protein;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

        carb = (Button) findViewById(R.id.carbButton);
        carb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println();
                //do something
            }
        });

        fat = (Button) findViewById(R.id.fatButton);
        carb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println();
                //do something
            }
        });

        protein = (Button) findViewById(R.id.proteinButton);
        carb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println();
                //do something
            }
        });
    }
}
