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

public class english extends AppCompatActivity {

    private ImageView wheels, mcd, shark, solar_sys;
    private VideoView vwheels, vmcd, vshark, vsolar;
    private Button backButton3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);

        // Initialize ImageViews (Thumbnails)
        wheels = findViewById(R.id.wheels);
        mcd = findViewById(R.id.mcd);
        shark = findViewById(R.id.shark);
        solar_sys = findViewById(R.id.solar_sys);

        // Initialize VideoViews
        vwheels = findViewById(R.id.vwheels);
        vmcd = findViewById(R.id.vmcd);
        vshark = findViewById(R.id.vshark);
        vsolar = findViewById(R.id.vsolar);

        // Initialize Back Button
        backButton3 = findViewById(R.id.backButton3);

        // Set OnClickListener for num thumbnail
        wheels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideo(vwheels);
            }
        });

        // Set OnClickListener for add thumbnail
        mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideo(vmcd);
            }
        });

        // Set OnClickListener for shape thumbnail
        shark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideo(vshark);
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
        backButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to activity_science.xml
                Intent intent = new Intent(english.this, english.class);
                startActivity(intent);
            }
        });
    }

    private void startVideo(VideoView videoView) {
        // Hide thumbnails
        wheels.setVisibility(View.GONE);
        mcd.setVisibility(View.GONE);
        shark.setVisibility(View.GONE);
        solar_sys.setVisibility(View.GONE);

        // Show VideoView
        videoView.setVisibility(View.VISIBLE);

        // Set up the video player
        int videoResource;
        if (videoView == vwheels) {
            videoResource = R.raw.wheels;
        } else if (videoView == vmcd) {
            videoResource = R.raw.mcdonald;
        } else if (videoView == vshark) {
            videoResource = R.raw.shark;
        } else { // vsolar
            videoResource = R.raw.solar;
        }

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + videoResource));
        videoView.start();

        // Show back button
        backButton3.setVisibility(View.VISIBLE);
    }
}
