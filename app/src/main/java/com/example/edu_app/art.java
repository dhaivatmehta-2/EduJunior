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

public class art extends AppCompatActivity {

    private ImageView octopus, rabbit, elephant, solar_sys;
    private VideoView voctopus, vrabbit, velephant, vsolar;
    private Button backButton4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art);

        // Initialize ImageViews (Thumbnails)
        octopus = findViewById(R.id.octopus);
        rabbit = findViewById(R.id.rabbit);
        elephant = findViewById(R.id.elephant);
        solar_sys = findViewById(R.id.solar_sys);

        // Initialize VideoViews
        voctopus = findViewById(R.id.voctopus);
        vrabbit = findViewById(R.id.vrabbit);
        velephant = findViewById(R.id.velephant);
        vsolar = findViewById(R.id.vsolar);

        // Initialize Back Button
        backButton4 = findViewById(R.id.backButton4);

        // Set OnClickListener for num thumbnail
        octopus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideo(voctopus);
            }
        });

        // Set OnClickListener for add thumbnail
        rabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideo(vrabbit);
            }
        });

        // Set OnClickListener for shape thumbnail
        elephant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideo(velephant);
            }
        });

        // Set OnClickListener for sub thumbnail
        solar_sys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideo(vsolar);
            }
        });

        // Set OnClickListener for back button
        backButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to activity_science.xml
                Intent intent = new Intent(art.this, art.class);
                startActivity(intent);
            }
        });
    }

    private void startVideo(VideoView videoView) {
        // Hide thumbnails
        octopus.setVisibility(View.GONE);
        rabbit.setVisibility(View.GONE);
        elephant.setVisibility(View.GONE);
        solar_sys.setVisibility(View.GONE);

        // Show VideoView
        videoView.setVisibility(View.VISIBLE);

        // Set up the video player
        int videoResource;
        if (videoView == voctopus) {
            videoResource = R.raw.octopus;
        } else if (videoView == vrabbit) {
            videoResource = R.raw.rabbit;
        } else if (videoView == velephant) {
            videoResource = R.raw.elephant;
        } else { // vsolar
            videoResource = R.raw.solar;
        }

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + videoResource));
        videoView.start();

        // Show back button
        backButton4.setVisibility(View.VISIBLE);
    }
}
