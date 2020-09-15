package com.example.learningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    TextView storycontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        storycontent = findViewById(R.id.contentofstory);
        Intent i = getIntent();
        String title = i.getStringExtra("titleofstory");
        String content = i.getStringExtra("contentofstory");

        getSupportActionBar().setTitle(title);

        storycontent.setText(content);
        storycontent.setMovementMethod(new ScrollingMovementMethod());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}