package com.example.edu_app;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;

public class Draw extends AppCompatActivity {

    LinearLayout mylayout;
    Spinner myspin;
    Button my_btn;
    TouchScreen tc;
    Switch bgSwitch;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw); // Corrected layout reference

        bgSwitch = findViewById(R.id.bg_switch);
        mylayout = findViewById(R.id.screen);
        myspin = findViewById(R.id.spin);
        my_btn = findViewById(R.id.btn);
        tc = new TouchScreen(this, null);
        mylayout.addView(tc);

        my_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tc.clearCanvas();
            }
        });

        myspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String choice = myspin.getSelectedItem().toString();
                tc.changeColor(choice);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Do nothing
            }
        });

        bgSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    mylayout.setBackgroundColor(Color.BLACK);
                } else {
                    mylayout.setBackgroundColor(Color.WHITE);
                }
            }
        });

    }
}
