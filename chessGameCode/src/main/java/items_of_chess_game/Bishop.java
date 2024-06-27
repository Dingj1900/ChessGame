package items_of_chess_game;

public class Bishop implements Piece{
    private String name = "Bishop";
    private int [] location = new int[2];

    public Bishop(String color){
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
    public void setLocation(int column, int row) {
        this.location[0] = column;
        this.location[1] = row;
    }

    @Override
    public int[] getLocation() {
        return new int[0];
    }
}
