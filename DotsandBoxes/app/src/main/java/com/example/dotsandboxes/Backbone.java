package com.example.dotsandboxes;

public class Backbone {
    int p1points, p2points; //keeps tally of points for the two players
    int sizeBoard = 5; // size of the board
    int numMoves; //how many moves can be made before the round ends
    int pointsMade;
    int block = -1;
    int block2 = -1;
    int x1, x2, y1, y2; //x and y coords of 2 dots chosen
    boolean currTurn; //true if p1's turn, false if p2's
    String[][] dotData = new String[sizeBoard][sizeBoard]; //keeps data of board stored
    //important variables for use later

    public void clearBoard(){
        for(int i = 0; i<sizeBoard; i++){
            for(int j = 0; j<sizeBoard; j++){
                dotData[i][j] = "";
            }
        }
        p1points = 0;
        p2points = 0;

        numMoves = 40;//40
        currTurn = true;
    }
    //clears the board so it can be used for repeat games

    public boolean isSquareFilled(int x1, int dummyX, int y1, int dummyY, int form){
        int detBlock;
        if(dummyY < y1)
            detBlock = dummyX+dummyY*4;
        else
            detBlock = x1+y1*4;

        if (form == 0)  { //Base needs U and L, Dummy needs D and R
            if ((dotData[x1][y1].contains("U") && dotData[x1][y1].contains("L"))
                    && (dotData[dummyX][dummyY].contains("D") && dotData[dummyX][dummyY].contains("R"))) {
                if(pointsMade == 1)
                    block2 = detBlock;
                else block = detBlock;

                return true;
            }
        }
        else if (form == 1) { //Base needs D and R, Dummy needs U and L
            if ((dotData[x1][y1].contains("D") && dotData[x1][y1].contains("R"))
                    && (dotData[dummyX][dummyY].contains("U") && dotData[dummyX][dummyY].contains("L"))) {
                if(pointsMade == 1)
                    block2 = detBlock;
                else block = detBlock;

                return true;
            }
        }
        return false;
    }
    //lets system know if a certain square was filled

    public void updatePoints(int points) {
        if (currTurn) {
            p1points += points;
        }
        else {
            p2points += points;
        }
    }

    public boolean isConnectPoints(int x1, int x2, int y1, int y2){
        pointsMade = 0; //home many points were made this turn
        boolean result = false;
        block = -1;
        block2 = -1;

        if(x1 == x2){ //if nodes are vertical from each other
            if(y1>y2){
                dotData[x1][y1] += 'U';
                dotData[x2][y2] += 'D';
                if(x1 - 1 > -1 && y1-1 > -1) {//if the dummy y won't go out of bounds
                    if (isSquareFilled(x1, x1 - 1, y1, y1 - 1, 0)) {
                        pointsMade++;
                        result = true;
                    }

                }
                if(x2 + 1 <sizeBoard && y2+1 < sizeBoard) {//if the dummy y won't go out of bounds
                    if (isSquareFilled(x2, x2 + 1, y2, y2 + 1, 1)) {
                        pointsMade++;
                        result = true;
                    }

                }

            }
            else{
                dotData[x1][y1] += 'D';
                dotData[x2][y2] += 'U';
                if(x2 - 1 > -1 && y2-1 > -1)//if the dummy y won't go out of bounds
                    if(isSquareFilled(x2, x2-1, y2, y2-1, 0)){
                        pointsMade++;
                        result = true;
                    }
                if(x1 + 1 < sizeBoard && y1+1 < sizeBoard)//if the dummy y won't go out of bounds
                    if(isSquareFilled(x1, x1+1, y1, y1+1, 1)){
                        pointsMade++;
                        result = true;
                    }
            }
        }

        if(y1 == y2){ //if nodes are horizontal from each other
            if(x1>x2){
                dotData[x1][y1] += 'L';
                dotData[x2][y2] += 'R';
                if(y1 - 1 > -1 && x1-1 > -1)//if the dummy y won't go out of bounds
                    if(isSquareFilled(x1, x1-1, y1, y1-1, 0)){
                        pointsMade++;
                        result = true;
                }
                if(y2 + 1 <sizeBoard && x2+1 < sizeBoard)//if the dummy y won't go out of bounds
                    if(isSquareFilled(x2, x2+1, y2, y2+1, 1)){
                        pointsMade++;
                        result = true;
                    }
            }
            else{
                dotData[x1][y1] += 'R';
                dotData[x2][y2] += 'L';
                if(y2 - 1 >= 0 && x2-1 > -1)//if the dummy y won't go out of bounds
                    if(isSquareFilled(x2, x2-1, y2, y2-1, 0)){
                        pointsMade++;
                        result = true;
                }
                if(y1 + 1 < sizeBoard && x1+1 < sizeBoard)//if the dummy y won't go out of bounds
                    if(isSquareFilled(x1, x1+1, y1, y1+1, 1)){
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

    public void dotsConnected(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
}
