package com.example.dotsandboxes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Play extends AppCompatActivity {
    public ArrayList<Integer> coords = new ArrayList<Integer>();
    public int buttonClicked = 0;
    public HashMap<String, ImageView> mapViews = new HashMap<>();

    Backbone back = new Backbone(); //new backbone object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        back.clearBoard();
    }

    public void dotClicked(View view){
        char[] contentDes = view.getContentDescription().toString().toCharArray();
        coords.add(contentDes[0]-48);
        coords.add(contentDes[1]-48);
        buttonClicked++;

        if(buttonClicked == 2){


            back.dotsConnected(coords.get(0), coords.get(1), coords.get(2), coords.get(3));

            String location = "";
            if(back.x1 == back.x2)
                location += back.x1 + Math.min(back.y1, back.y2) + back.x2 + Math.max(back.y1, back.y2);
            else if(back.y1 == back.y2)
                location += Math.min(back.x1, back.x2) + back.y1 + Math.max(back.x1, back.x2) + back.y2;

            mapViews.get(location).setVisibility(View.VISIBLE);

            if(!back.isConnectPoints(back.x1, back.x2, back.y1, back.y2)){
                back.currTurn = !back.currTurn;
            }

            TextView temp = (TextView)findViewById(R.id.currentTurnText);

            if(back.currTurn){
                temp.setText("Current Turn: Red");
            }
            else{
                temp.setText("Current Turn: Blue");
            }

            buttonClicked = 0;
            coords.clear();
            back.numMoves--;

            if(back.numMoves == 0) {
                Intent intent = new Intent(Play.this, MainActivity.class);
                startActivity(intent);
            }
        }
    }

    public void mapID(){
        mapViews.put("0001", (ImageView)findViewById(R.id.h0001));
        mapViews.put("0102", (ImageView)findViewById(R.id.h0102));
        mapViews.put("0203", (ImageView)findViewById(R.id.h0203));
        mapViews.put("0304", (ImageView)findViewById(R.id.h0304));
        
    }

    public void resetUI(){

    }
}
