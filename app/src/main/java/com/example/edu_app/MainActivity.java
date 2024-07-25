package com.example.edu_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    TextView sgnup;
    EditText mail, passwordEditText;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail = findViewById(R.id.maileditText);
        mAuth = FirebaseAuth.getInstance();
        sgnup = findViewById(R.id.signup);
        sgnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

        passwordEditText = findViewById(R.id.editText);
        ToggleButton togglePasswordVisibility = findViewById(R.id.togglePasswordVisibility);
        togglePasswordVisibility.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Show password
                    passwordEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    // Hide password
                    passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                // Move cursor to the end of the text
                passwordEditText.setSelection(passwordEditText.getText().length());
            }
        });

    }

    public void home(View view) {
        String email = mail.getText().toString();
        String password = passwordEditText.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Subject.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

}
