package com.example.ecocart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {
    TextView userName;
    ImageButton goButton;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);
        userName = findViewById(R.id.nameInput);
        goButton = findViewById(R.id.goToMainButton);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().equals("")){
                    //Toast response
                }
                else{
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    intent.putExtra("name", userName.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}
