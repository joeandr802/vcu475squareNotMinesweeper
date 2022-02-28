package com.example.dotsandboxes;

public class Backbone {
    int p1points, p2points; //keeps tally of points for the two players
    int sizeBoard = 5; // size of the board
    int numMoves = 40; //how many moves can be made before the round ends
    boolean currTurn = true; //true if p1's turn, false if p2's
    String[][] dotData = new String[sizeBoard][sizeBoard]; //keeps data of board stored
    //important variables for use later

    public void clearBoard(){
        for(int i = 0; i<sizeBoard; i++){
            for(int j = 0; j<sizeBoard; j++){
                dotData[i][j] = "";
            }
        }
    }
    //clears the board so it can be used for repeat games

    public static void main(String[] args){
        Backbone back = new Backbone();
        back.clearBoard(); //sets app to be used later
        back.mainGame(); //runs the actual game
        back.results(); //displays the results
    }
}
