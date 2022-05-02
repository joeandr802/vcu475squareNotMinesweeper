package com.example.dotsandboxes;

import static android.graphics.Color.parseColor;

import android.content.Intent;
import android.graphics.BlendMode;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
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
    public ImageButton button;

    Backbone back = new Backbone(); //new backbone object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        button = findViewById(R.id.pauseButton);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(Play.this, Pause.class);
            startActivity(intent);
        });

        back.clearBoard();
        mapID();
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
                location += back.x1 + "" + Math.min(back.y1, back.y2) + "" + back.x2 + "" + Math.max(back.y1, back.y2);
            else if(back.y1 == back.y2)
                location += Math.min(back.x1, back.x2) + "" + back.y1 + "" + Math.max(back.x1, back.x2) + "" + back.y2;

            mapViews.get(location).setVisibility(View.VISIBLE);
            //mapViews.get(location).setColorFilter(parseColor("#F44336"));
            if (!back.currTurn) {
                mapViews.get(location).setColorFilter(parseColor("#2196F3"));
            } else {
                mapViews.get(location).setColorFilter(parseColor("#F44336"));
            }

            if(!back.isConnectPoints(back.x1, back.x2, back.y1, back.y2)){
                back.currTurn = !back.currTurn;
            }

            TextView temp = (TextView)findViewById(R.id.currentTurnText);

            if(back.currTurn){
                temp.setText("Current Turn: Red");
                temp.setTextColor(parseColor("#F44336"));
            }
            else{
                temp.setText("Current Turn: Blue");
                temp.setTextColor(parseColor("#2196F3"));
            }

            temp = (TextView) findViewById(R.id.scoreRedText);
            temp.setText("Red: " + back.p1points);
            temp = (TextView) findViewById(R.id.scoreBlueText);
            temp.setText("Blue: " + back.p2points);


            buttonClicked = 0;
            coords.clear();
            back.numMoves--;
            if(back.numMoves == 0) {//Game ends here
                finish();
                Intent intent = new Intent(Play.this, WinScreen.class);
                intent.putExtra("p1",back.p1points);
                intent.putExtra("p2",back.p2points);
                startActivity(intent);
            }
        }
    }

    public void mapID(){
        mapViews.put("0001", (ImageView)findViewById(R.id.h0001));
        mapViews.put("0102", (ImageView)findViewById(R.id.h0102));
        mapViews.put("0203", (ImageView)findViewById(R.id.h0203));
        mapViews.put("0304", (ImageView)findViewById(R.id.h0304));
        mapViews.put("0010", (ImageView)findViewById(R.id.v0010));
        mapViews.put("0111", (ImageView)findViewById(R.id.v0111));
        mapViews.put("0212", (ImageView)findViewById(R.id.v0212));
        mapViews.put("0313", (ImageView)findViewById(R.id.v0313));
        mapViews.put("0414", (ImageView)findViewById(R.id.v0414));
        mapViews.put("1011", (ImageView)findViewById(R.id.h1011));
        mapViews.put("1112", (ImageView)findViewById(R.id.h1112));
        mapViews.put("1213", (ImageView)findViewById(R.id.h1213));
        mapViews.put("1314", (ImageView)findViewById(R.id.h1314));
        mapViews.put("1020", (ImageView)findViewById(R.id.v1020));
        mapViews.put("1121", (ImageView)findViewById(R.id.v1121));
        mapViews.put("1222", (ImageView)findViewById(R.id.v1222));
        mapViews.put("1323", (ImageView)findViewById(R.id.v1323));
        mapViews.put("1424", (ImageView)findViewById(R.id.v1424));
        mapViews.put("2021", (ImageView)findViewById(R.id.h2021));
        mapViews.put("2122", (ImageView)findViewById(R.id.h2122));
        mapViews.put("2223", (ImageView)findViewById(R.id.h2223));
        mapViews.put("2324", (ImageView)findViewById(R.id.h2324));
        mapViews.put("2030", (ImageView)findViewById(R.id.v2030));
        mapViews.put("2131", (ImageView)findViewById(R.id.v2131));
        mapViews.put("2232", (ImageView)findViewById(R.id.v2232));
        mapViews.put("2333", (ImageView)findViewById(R.id.v2333));
        mapViews.put("2434", (ImageView)findViewById(R.id.v2434));
        mapViews.put("3031", (ImageView)findViewById(R.id.h3031));
        mapViews.put("3132", (ImageView)findViewById(R.id.h3132));
        mapViews.put("3233", (ImageView)findViewById(R.id.h3233));
        mapViews.put("3334", (ImageView)findViewById(R.id.h3334));
        mapViews.put("3040", (ImageView)findViewById(R.id.v3040));
        mapViews.put("3141", (ImageView)findViewById(R.id.v3141));
        mapViews.put("3242", (ImageView)findViewById(R.id.v3242));
        mapViews.put("3343", (ImageView)findViewById(R.id.v3343));
        mapViews.put("3444", (ImageView)findViewById(R.id.v3444));
        mapViews.put("4041", (ImageView)findViewById(R.id.h4041));
        mapViews.put("4142", (ImageView)findViewById(R.id.h4142));
        mapViews.put("4243", (ImageView)findViewById(R.id.h4243));
        mapViews.put("4344", (ImageView)findViewById(R.id.h4344));
    }
}
