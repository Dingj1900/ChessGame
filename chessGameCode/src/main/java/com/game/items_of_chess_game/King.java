package com.game.items_of_chess_game;

import java.util.ArrayList;
import java.util.List;

public class King implements Piece {


    private int [] location = new int[2];
    private final String color;

    public King(String color){
        this.color = color;
    }

    //return a list of int[] of moves that are in range but not check validated
    public List<int []> moves(Piece [][] chessBoard){
        List<int[]> listOfMoves = new ArrayList<>();

        int column = location[0];
        int row = location[1];

        int [][] possibleLocations = new int [8][2];

        //north
        possibleLocations[0][0] = column;
        possibleLocations[0][1] = row + 1;
        //northeast
        possibleLocations[1][0] = column +1;
        possibleLocations[1][1] = row + 1;
        //east
        possibleLocations[2][0] = column + 1;
        possibleLocations[2][1] = row;
        //southeast
        possibleLocations[3][0] = column + 1;
        possibleLocations[3][1] = row - 1;
        //south
        possibleLocations[4][0] = column;
        possibleLocations[4][1] = row - 1;
        //southwest
        possibleLocations[5][0] = column - 1;
        possibleLocations[5][1] = row - 1;
        //west
        possibleLocations[6][0] = column - 1;
        possibleLocations[6][1] = row;
        //northwest
        possibleLocations[7][0] = column - 1;
        possibleLocations[7][1] = row + 1;

        for (int[] possibleLocation : possibleLocations) {
            if (//Check columns and row for being within range for the board
                    (possibleLocation[0] <= 0 || possibleLocation[0] >= 7) && (possibleLocation[1] <= 0 || possibleLocation[1] >= 7)
            ) {

                int [] checkPiece = {possibleLocation[0], possibleLocation[1]};

                listOfMoves.add(checkPiece);

            }
        }

        return listOfMoves;
    }



    @Override
    public String getName() {
        return "King";
    }

    @Override
    public String getColor(){
        return color;
    }

    @Override
    public void setLocation(int column, int row) {
        this.location[0] = column;
        this.location[1] = row;
    }
    @Override
    public void setLocation(int[]location) {
        this.location[0] = location[0];
        this.location[1] = location[1];
    }

    @Override
    public int[] getLocation() {
        return location;
    }
}
