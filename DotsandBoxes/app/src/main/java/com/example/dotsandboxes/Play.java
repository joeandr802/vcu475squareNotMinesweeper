package com.example.dotsandboxes;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Play extends AppCompatActivity {
    public int[] cordsA = new int[2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


    }

    public void getCord(View view){
        char[] contentDes = view.getContentDescription().toString().toCharArray();

        for(int i = 0; i < 2; i++)
            cordsA[i] = contentDes[i]-48;
    }
}
