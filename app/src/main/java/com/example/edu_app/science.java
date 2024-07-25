package com.example.edu_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class science extends AppCompatActivity {

    private ImageView dinos, plants, solar, water;
    private VideoView vdinos, vplants, vsolar, vwater;
    private Button backButton2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);

        // Initialize ImageViews (Thumbnails)
        dinos = findViewById(R.id.dinos);
        plants = findViewById(R.id.plants);
        solar = findViewById(R.id.solar);
        water = findViewById(R.id.water);

        // Initialize VideoViews
        vdinos = findViewById(R.id.vdinos);
        vplants = findViewById(R.id.vplants);
        vsolar = findViewById(R.id.vsolar);
        vwater = findViewById(R.id.vwater);

        // Initialize Back Button
        backButton2 = findViewById(R.id.backButton2);

        // Set OnClickListener for num thumbnail
        dinos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideo(vdinos);
            }
        });

        // Set OnClickListener for add thumbnail
        plants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideo(vplants);
            }
        });

        // Set OnClickListener for shape thumbnail
        solar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideo(vsolar);
            }
        });

        // Set OnClickListener for sub thumbnail
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideo(vwater);
            }
        });

        // Set OnClickListener for back button
        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to activity_science.xml
                Intent intent = new Intent(science.this, science.class);
                startActivity(intent);
            }
        });
    }

    private void startVideo(VideoView videoView) {
        // Hide thumbnails
        dinos.setVisibility(View.GONE);
        plants.setVisibility(View.GONE);
        solar.setVisibility(View.GONE);
        water.setVisibility(View.GONE);

        // Show VideoView
        videoView.setVisibility(View.VISIBLE);

        // Set up the video player
        int videoResource;
        if (videoView == vdinos) {
            videoResource = R.raw.dinos;
        } else if (videoView == vplants) {
            videoResource = R.raw.plants;
        } else if (videoView == vsolar) {
            videoResource = R.raw.solar;
        } else { // vwater
            videoResource = R.raw.water_cycle;
        }

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + videoResource));
        videoView.start();

        // Show back button
        backButton2.setVisibility(View.VISIBLE);
    }
}
