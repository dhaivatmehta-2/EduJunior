package com.example.edu_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Subject extends AppCompatActivity {
    ImageView artImageView, englishImageView, mathImageView, scienceImageView, draw;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        draw = findViewById(R.id.draw);
        artImageView = findViewById(R.id.art1);
        englishImageView = findViewById(R.id.english1);
        mathImageView = findViewById(R.id.math1);
        scienceImageView = findViewById(R.id.science1);

        artImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v, "Art");
            }
        });

        englishImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v, "English");
            }
        });

        mathImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v, "Math");
            }
        });

        scienceImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v, "Science");
            }
        });

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Subject.this, Draw.class);
                startActivity(intent);
                finish();
            }
        });
    }


    private void showPopupMenu(View v, final String subject) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.option1) {
                    // Action for Video Player option
                    openVideoPlayer(subject);
                    return true;
                } else if (item.getItemId() == R.id.option2) {
                    // Action for Reading option
                    openReadingMaterial(subject);
                    return true;
                } else if (item.getItemId() == R.id.option3) {
                    // Action for Quiz option
                    startQuiz(subject);
                    return true;
                } else {
                    return false;
                }
            }
        });

        popupMenu.show();
    }

    private void openVideoPlayer(String subject) {
        // Implement logic to open video player activity or link based on the subject
        // Example:
        if (subject.equals("Math")) {
            Intent intent = new Intent(Subject.this, maths.class);
            startActivity(intent);
            Toast.makeText(this, "Open video player for " + subject, Toast.LENGTH_SHORT).show();
        } else if (subject.equals("English")) {
            // Open video player activity or link for English
            Intent intent = new Intent(Subject.this, english.class);
            startActivity(intent);
        } else if (subject.equals("Science")) {
            // Open video player activity or link for Science
            Intent intent = new Intent(Subject.this, science.class);
            startActivity(intent);
        } else if (subject.equals("Art")) {
            // Open video player activity or link for Art
            Intent intent = new Intent(Subject.this, art.class);
            startActivity(intent);
        }
    }


    // Method to open reading material activity or link based on the subject
    private void openReadingMaterial(String subject) {
        // Implement logic to open reading material activity or link based on the subject
        // Example:
        if (subject.equals("Math")) {
            Intent intent = new Intent(Subject.this, Reading_math.class);
            startActivity(intent);
            Toast.makeText(this, "Open video player for " + subject, Toast.LENGTH_SHORT).show();
        } else if (subject.equals("English")) {
            // Open video player activity or link for English
            Intent intent = new Intent(Subject.this, Reading_english.class);
            startActivity(intent);
        } else if (subject.equals("Science")) {
            // Open video player activity or link for Science
            Intent intent = new Intent(Subject.this, Reading_science.class);
            startActivity(intent);
        } else if (subject.equals("Art")) {
            // Open video player activity or link for Art
            Intent intent = new Intent(Subject.this, Reading_art.class);
            startActivity(intent);
        }
    }

    // Method to start quiz activity based on the subject
    private void startQuiz(String subject) {
        // Implement logic to start quiz activity based on the subject
        // Example:
        if (subject.equals("Math")) {
            Intent intent = new Intent(Subject.this, Quiz_math.class);
            startActivity(intent);
            Toast.makeText(this, "Open video player for " + subject, Toast.LENGTH_SHORT).show();
        } else if (subject.equals("English")) {
            // Open video player activity or link for English
            Intent intent = new Intent(Subject.this, Quiz.class);
            startActivity(intent);
        } else if (subject.equals("Science")) {
            // Open video player activity or link for Science
            Intent intent = new Intent(Subject.this, Quiz_science.class);
            startActivity(intent);
        } else if (subject.equals("Art")) {
            // Open video player activity or link for Art
            Intent intent = new Intent(Subject.this, Quiz_art.class);
            startActivity(intent);
        }
    }
}
