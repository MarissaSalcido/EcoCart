package com.example.ecocart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DoneActivity extends AppCompatActivity {

    TextView donetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

        donetext = findViewById(R.id.donetext);




    }
}
