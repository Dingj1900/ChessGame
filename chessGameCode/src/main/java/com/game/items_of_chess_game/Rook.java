package com.game.items_of_chess_game;

public class Rook implements Piece {

    private final String color;

    private int [] location = new int[2];


    public Rook(String color){
        this.color = color;
    }

    @Override
    public String getName() {
        return "Rook";
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
        return  location;
    }
}
