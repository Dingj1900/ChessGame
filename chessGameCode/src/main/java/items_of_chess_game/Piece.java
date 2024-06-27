package items_of_chess_game;

import java.util.ArrayList;
import java.util.List;

public interface Piece {

    public String name = "";
    public int [] location = new int[2];

    //public List<int []> getPossibleMove = new ArrayList<>();
    public String getName();

    public void setName(String name);
    public void setLocation(int column, int row);

    public int[] getLocation();

}
