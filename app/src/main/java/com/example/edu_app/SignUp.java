package com.example.edu_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.text.Spannable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    TextView proceed;
    ImageView phone_img, mail_img;
    Button button;
    private FirebaseAuth mAuth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText signupEmail = findViewById(R.id.editTextTextEmailAddress);
        EditText signupUsername = findViewById(R.id.editUsername);
        EditText signupPassword = findViewById(R.id.editPass1);
        Button button = findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();
        phone_img = findViewById(R.id.phone);
        mail_img = findViewById(R.id.mail);
        proceed = findViewById(R.id.textProceed);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = signupEmail.getText().toString().trim();
                String password = signupPassword.getText().toString().trim();
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
// Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(SignUp.this, "sign in successful.", Toast.LENGTH_SHORT).show();
                                } else {
// If sign in fails, display a message to the user.
                                    Toast.makeText(SignUp.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });

        phone_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel: 9769109394"));
                startActivity(intent1);
            }
        });

        mail_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Intent.ACTION_SENDTO);
                intent2.setData(Uri.parse("mailto: edujunior@gmail.com "));
                startActivity(intent2);
            }
        });

    }
    public void msg(View view){
        Toast.makeText(this, "Account Created!!!", Toast.LENGTH_SHORT).show();
    }
}