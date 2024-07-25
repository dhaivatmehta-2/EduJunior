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

public class maths extends AppCompatActivity {

    private ImageView num, add, shape, sub;
    private VideoView vnum, vadd, vshape, vsub;
    private Button backButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);

        // Initialize ImageViews (Thumbnails)
        num = findViewById(R.id.num);
        add = findViewById(R.id.add);
        shape = findViewById(R.id.shape);
        sub = findViewById(R.id.sub);

        // Initialize VideoViews
        vnum = findViewById(R.id.vnum);
        vadd = findViewById(R.id.vadd);
        vshape = findViewById(R.id.vshape);
        vsub = findViewById(R.id.vsub);

        // Initialize Back Button
        backButton = findViewById(R.id.backButton);

        // Set OnClickListener for num thumbnail
        num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideo(vnum);
            }
        });

        // Set OnClickListener for add thumbnail
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideo(vadd);
            }
        });

        // Set OnClickListener for shape thumbnail
        shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideo(vshape);
            }
        });

        // Set OnClickListener for sub thumbnail
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideo(vsub);
            }
        });

        // Set OnClickListener for back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to activity_science.xml
                Intent intent = new Intent(maths.this, maths.class);
                startActivity(intent);
            }
        });
    }

    private void startVideo(VideoView videoView) {
        // Hide thumbnails
        num.setVisibility(View.GONE);
        add.setVisibility(View.GONE);
        shape.setVisibility(View.GONE);
        sub.setVisibility(View.GONE);

        // Show VideoView
        videoView.setVisibility(View.VISIBLE);

        // Set up the video player
        int videoResource;
        if (videoView == vnum) {
            videoResource = R.raw.numbers;
        } else if (videoView == vadd) {
            videoResource = R.raw.add;
        } else if (videoView == vshape) {
            videoResource = R.raw.shapes;
        } else { // vsub
            videoResource = R.raw.sub;
        }

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + videoResource));
        videoView.start();

        // Show back button
        backButton.setVisibility(View.VISIBLE);
    }
}
