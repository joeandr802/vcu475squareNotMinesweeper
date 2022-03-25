package com.example.dotsandboxes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinScreen extends Play{
    public Button rematch, mainMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        int p1score = extras.getInt("p1");
        int p2score = extras.getInt("p2");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        //Determines and sets who wins
        TextView winner = (TextView)findViewById(R.id.winner);
        if (p1score > p2score) {
            winner.setText("Red: " + p1score);
            winner.setTextColor(Color.parseColor("#F44336"));
        }
        else if (p2score > p1score) {
            winner.setText("Blue: " + p2score);
            winner.setTextColor(Color.parseColor("#2196F3"));
        }
        else {
            winner.setText("Draw!");
        }

        //Shows scores accordingly
        winner = (TextView)findViewById(R.id.scoreRedText2);
        winner.setText("Red: " + p1score);

        winner = (TextView)findViewById(R.id.scoreBlueText2);
        winner.setText("Blue: " + p2score);

        rematch = findViewById(R.id.rematch);
        mainMenu = findViewById(R.id.mainMenu);

        rematch.setOnClickListener(v -> {
            Intent intent = new Intent(WinScreen.this, Play.class);
            startActivity(intent);
        });

        mainMenu.setOnClickListener(v -> {
            Intent intent = new Intent(WinScreen.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
