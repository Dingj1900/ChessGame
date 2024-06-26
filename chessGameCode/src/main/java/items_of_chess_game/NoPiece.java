package items_of_chess_game;

public class NoPiece implements Piece {

    private String name = "";

    private int [] location = new int[2];

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
