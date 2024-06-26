package items_of_chess_game;

public class King implements Piece {
    private String name = "King";

    private int [] location = new int[2];

    public King(String color){
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
