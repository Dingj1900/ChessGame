package com.game.items_of_chess_game;

import java.util.ArrayList;
import java.util.List;

public interface Piece {



    public String getName();

    public String getColor();

    public void setLocation(int column, int row);

    public int[] getLocation();

    public void setLocation(int[]location);

}
