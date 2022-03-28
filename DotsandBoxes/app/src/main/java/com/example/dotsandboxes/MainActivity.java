package com.example.dotsandboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {
    public Button button, tutorialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.playButton);
        tutorialButton = findViewById(R.id.tutorial);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Play.class);
            startActivity(intent);
        });

        tutorialButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Inflates tutorial view
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupTutorial = inflater.inflate(R.layout.activity_tutorial, null);
                View popupTutorial1 = inflater.inflate(R.layout.activity_tutorial_two, null);
                View popupTutorial2 = inflater.inflate(R.layout.activity_tutorial_three, null);
                View popupTutorial3 = inflater.inflate(R.layout.activity_tutorial_four, null);

                //Wraps pop up and sets window
                int width = LinearLayout.LayoutParams.MATCH_PARENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                final PopupWindow popupWindow = new PopupWindow(popupTutorial, width, height, true);

                //Show window
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                Button nextButton = (Button) popupTutorial.findViewById(R.id.next);

                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();

                        PopupWindow popupWindow1 = new PopupWindow(popupTutorial1, width, height, true);
                        popupWindow1.showAtLocation(view, Gravity.CENTER, 0, 0);

                        Button nextButton1 = (Button) popupTutorial1.findViewById(R.id.next_2);

                        nextButton1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                popupWindow1.dismiss();

                                PopupWindow popupWindow2 = new PopupWindow(popupTutorial2, width, height, true);
                                popupWindow2.showAtLocation(view, Gravity.CENTER, 0, 0);

                                Button nextButton2 = (Button) popupTutorial2.findViewById(R.id.next_3);

                                nextButton2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        popupWindow2.dismiss();

                                        PopupWindow popupWindow3 = new PopupWindow(popupTutorial3, width, height, true);
                                        popupWindow3.showAtLocation(view, Gravity.CENTER, 0, 0);

                                        Button doneButton = (Button) popupTutorial3.findViewById(R.id.done);

                                        doneButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                popupWindow3.dismiss();
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    }
}