package com.example.dotsandboxes;

public class Backbone {
    int p1points, p2points; //keeps tally of points for the two players
    int sizeBoard = 5; // size of the board
    int numMoves = 40; //how many moves can be made before the round ends
    boolean currTurn = true; //true if p1's turn, false if p2's
    String[][] dotData = new String[sizeBoard][sizeBoard]; //keeps data of board stored
    //important variables for use later

    public static void main(String[] args){
        clearBoard(); //sets app to be used later
        mainGame(); //runs the actual game
        results(); //displays the results
    }
}
