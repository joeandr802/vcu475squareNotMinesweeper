package com.example.dotsandboxes;

import static android.graphics.Color.parseColor;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Play extends AppCompatActivity {
    public ArrayList<Integer> coords = new ArrayList<>();
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
    }

    public void dotClicked(View view){
        //Gets the clicked view's description
        char[] contentDes = view.getContentDescription().toString().toCharArray();
        //Splits the x and y coords of the button
        coords.add(contentDes[0]-48);
        coords.add(contentDes[1]-48);
        coords.add(contentDes[2]-48);
        coords.add(contentDes[3]-48);

        back.dotsConnected(coords.get(1), coords.get(0), coords.get(3), coords.get(2));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(coords.get(0) == coords.get(2)) {
                if (!back.currTurn)
                    ((ImageButton) view).setImageResource(R.drawable.bluehorz);
                else
                    ((ImageButton) view).setImageResource(R.drawable.redhorz);
            }
            else {
                if (!back.currTurn)
                    ((ImageButton) view).setImageResource(R.drawable.bluevert);
                else
                    ((ImageButton) view).setImageResource(R.drawable.redvert);
            }
        }

        if(!back.isConnectPoints(back.x1, back.x2, back.y1, back.y2)){
            back.currTurn = !back.currTurn;
        }

        if(back.block != -1){
            String imgViewID = "b" + back.block;
            String imgViewID2 = "b" + back.block2;
            int resID = getResources().getIdentifier(imgViewID, "id", getPackageName());
            int resID2;

            ImageView box = findViewById(resID);

            if(back.currTurn)
                box.setImageResource(R.drawable.redbox);
            else box.setImageResource(R.drawable.bluebox);

            if(back.block2 != -1) {
                resID2 = getResources().getIdentifier(imgViewID2, "id", getPackageName());
                ImageView box2 = findViewById(resID2);
                if(back.currTurn)
                    box2.setImageResource(R.drawable.redbox);
                else box2.setImageResource(R.drawable.bluebox);
            }
        }

        TextView temp = findViewById(R.id.currentTurnText);

        if(back.currTurn){
            temp.setText("Current Turn: Red");
            temp.setTextColor(parseColor("#F44336"));
        }
        else{
            temp.setText("Current Turn: Blue");
            temp.setTextColor(parseColor("#2196F3"));
        }



        temp = findViewById(R.id.scoreRedText);
        temp.setText("Red: " + back.p1points);
        temp = findViewById(R.id.scoreBlueText);
        temp.setText("Blue: " + back.p2points);

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
