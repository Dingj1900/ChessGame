package items_of_chess_game;

public class NoPiece implements Piece {


    private int [] location = new int[2];

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getColor(){
        return "";
    }
    @Override
    public void setLocation(int column, int row) {
        this.location[0] = column;
        this.location[1] = row;
    }

    @Override
    public int[] getLocation() {
        return location;
    }

    @Override
    public void setLocation(int[]location) {
        this.location[0] = location[0];
        this.location[1] = location[1];
    }
}
