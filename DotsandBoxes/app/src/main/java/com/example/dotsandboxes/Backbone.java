package com.example.dotsandboxes;

public class Backbone {
    int p1points, p2points; //keeps tally of points for the two players
    int x1, x2, y1, y2; //x and y coords of 2 dots chosen
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

    public boolean isConnectPoints(int[][] dot1, int[][] dot2){
        int pointsMade = 0; //home many points were made this turn
        boolean result = false;
    }
    //lets program know if a box was filled in

    public void dotsConnected(int[][] dot1, int[][] dot2){
        self.dot1 = dot1;
        self.dot2 = dot2;
        self.x1 = x1;
        self.x2 = x2;
        self.y1 = y1;
        self.y2 = y2;
    }
    //adds functionality to connect to main game about what is played

    public void mainGame(){
        int[][] dot1 = new int[sizeBoard][sizeBoard];
        int[][] dot2 = new int[sizeBoard][sizeBoard];
        //dots the user selects

        while(numMoves > 0){
            dotsConnected(dot1, dot2); //takes two connected dots
            if(!isConnectPoints(dot1, dot2)){
                currTurn = !currTurn;
            }
            //flips player's turn if no box was filled

            numMoves--;// subtracts moves to be made by 1
        }//while moves remain to be played
    }
    //game itself

    public static void main(String[] args){
        Backbone back = new Backbone();
        back.clearBoard(); //sets app to be used later
        back.mainGame(); //runs the actual game
        back.results(); //displays the results
    }
}
