package items_of_chess_game;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements Piece {

    private String name = "Pawn";

    private int [] location = new int[2];

    public Pawn(String color){
        this.name = color + " " + this.name;
    }


    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setLocation(int[] location) {
        this.location = location;
    }
}
