package com.example.dotsandboxes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Pause extends AppCompatActivity {
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause);

        button = findViewById(R.id.resumeButton);
        button.setOnClickListener(v -> {
            finish();
        });

        button = findViewById(R.id.mainMenuButton);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(Pause.this, MainActivity.class);
            startActivity(intent);
        });

    }
}
