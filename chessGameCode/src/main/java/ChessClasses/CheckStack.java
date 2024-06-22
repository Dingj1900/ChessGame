package ChessClasses;

public class CheckStack {

    String piece;

    int [] location = new int[2];


    public CheckStack(String piece, int[] location){
        this.piece = piece;
        this.location = location;
    }
    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }
}
