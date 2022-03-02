package com.example.dotsandboxes;

public class Backbone {
    int p1points, p2points; //keeps tally of points for the two players
    int sizeBoard = 5; // size of the board
    int numMoves = 40; //how many moves can be made before the round ends
    int x1, x2, y1, y2; //x and y coords of 2 dots chosen
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

    public boolean isSquareFilled(int x1, int dummyX, int y1, int dummyY){

    }
    //lets system know if a certain square was filled

    public boolean isConnectPoints(int x1, int x2, int y1, int y2){
        int pointsMade = 0; //home many points were made this turn
        boolean result = false;

        if(x1 == x2){ //if nodes are vertical from each other
            if(y1>y2){
                dotData[x1][y1] += 'U';
                dotData[x2][y2] += 'D';
                if(x1 - 1 >= 0)//if the dummy y won't go out of bounds
                    if(isSquareFilled(x1, x1-1, y1, y1-1)){
                        pointsMade++;
                        result = true;
                    }
                if(x2 + 1 <sizeBoard)//if the dummy y won't go out of bounds
                    if(isSquareFilled(x2, x2+1, y2, y2+1)){
                        pointsMade++;
                        result = true;
                    }
            }
            else{
                dotData[x1][y1] += 'D';
                dotData[x2][y2] += 'U';
                if(x2 - 1 >= 0)//if the dummy y won't go out of bounds
                    if(isSquareFilled(x2, x2-1, y2, y2-1)){
                        pointsMade++;
                        result = true;
                    }
                if(x1 + 1 < sizeBoard)//if the dummy y won't go out of bounds
                    if(isSquareFilled(x1, x1+1, y1, y1+1)){
                        pointsMade++;
                        result = true;
                    }
            }
        }

        if(y1 == y2){ //if nodes are horizontal from each other
            if(x1>x2){
                dotData[x1][y1] += 'L';
                dotData[x2][y2] += 'R';
                if(y1 - 1 >= 0)//if the dummy y won't go out of bounds
                    if(isSquareFilled(x1, x1-1, y1, y1-1)){
                        pointsMade++;
                        result = true;
                }
                if(y2 + 1 <sizeBoard)//if the dummy y won't go out of bounds
                    if(isSquareFilled(x2, x2+1, y2, y2+1)){
                        pointsMade++;
                        result = true;
                    }
            }
            else{
                dotData[x1][y1] += 'R';
                dotData[x2][y2] += 'L';
                if(y2 - 1 >= 0)//if the dummy y won't go out of bounds
                    if(isSquareFilled(x2, x2-1, y2, y2-1)){
                        pointsMade++;
                        result = true;
                }
                if(y1 + 1 < sizeBoard)//if the dummy y won't go out of bounds
                    if(isSquareFilled(x1, x1+1, y1, y1+1)){
                        pointsMade++;
                        result = true;
                    }
            }
        }
        //determines if points need to be added, if any

        updatePoints(pointsMade); //will update points correctly
        return result;
    }
    //lets program know if a box was filled in

    public void dotsConnected(int x1, int x2, int y1, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    //adds functionality to connect to main game about what is played

    public void mainGame(){

        while(numMoves > 0){
            dotsConnected(x1, x2, y1, y2); //takes two connected dots
            if(!isConnectPoints(x1, x2, y1, y2)){
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
