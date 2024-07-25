package com.example.edu_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Home extends AppCompatActivity {

    ImageView gr1, gr2, gr3, gr4;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gr1 = findViewById(R.id.grade1);
        gr2 = findViewById(R.id.grade2);
        gr3 = findViewById(R.id.grade3);
        gr4 = findViewById(R.id.grade4);

        gr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Subject.class));
            }
        });

        gr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Subject.class));
            }
        });

        gr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Subject.class));
            }
        });

        gr4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Subject.class));
            }
        });


    }


}