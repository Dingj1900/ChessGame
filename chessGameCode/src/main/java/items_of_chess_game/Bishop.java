package items_of_chess_game;

import rules_of_chess.CheckForAttacksAtLocation;

import java.util.ArrayList;
import java.util.List;

public class Bishop implements Piece{

    private int [] location = new int[2];

    private final String color;

    public Bishop(String color){
        this.color = color;
    }


    //return a list of piece of moves that are in range but not check validated
    public List<int []> moves(Piece [][] chessBoard){
        List<int []> listOfMoves;

        CheckForAttacksAtLocation checkForAttacksAtLocation = new CheckForAttacksAtLocation(chessBoard, color.equals("White"));

        checkForAttacksAtLocation.setColumn(location[0]);
        checkForAttacksAtLocation.setRow(location[1]);

        checkForAttacksAtLocation.northEastDiagonalAttackedSide();
        checkForAttacksAtLocation.southEastDiagonalAttackedSide();
        checkForAttacksAtLocation.southWestDiagonalAttackedSide();
        checkForAttacksAtLocation.northWestDiagonalAttackedSide();

        return checkForAttacksAtLocation.getSpaces();

    }


    @Override
    public String getName() {
        return "Bishop";
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
