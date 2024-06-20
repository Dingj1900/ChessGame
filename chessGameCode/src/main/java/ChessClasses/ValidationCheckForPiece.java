package ChessClasses;

import java.util.Scanner;

public class ValidationCheckForPiece {
    private int [] pieceLocation = new int[2];

    private boolean isWhiteTurn;

    private String [][] chessBoard;

    private String piece = new String();


    public ValidationCheckForPiece(String [][] chessBoard, boolean isWhiteTurn){
        this.isWhiteTurn = isWhiteTurn;
        this.chessBoard = chessBoard;
    }


    //Get a piece location from user
    //Will check the validity of the location
    public int[] getValidGamePiece(){

        boolean isValidPiece = false;

        while(!isValidPiece){
            pieceLocation = choosePieceLocation();

            boolean isRightColor = checkMatchingPieceAndPlayer();

            //checks if piece color matches the player's color
            if(isRightColor){
                isValidPiece = true;
            }
            else{
                System.out.println("Location chosen is not the right color or is empty.");
            }

        }

        return pieceLocation;

    }

    //check if user has select a piece location within the board.
    private int[] choosePieceLocation() {
        //promote the user to choose a piece
        Scanner keyboard = new Scanner(System.in);

        String whoTurnIsIt;

        if(isWhiteTurn == true){
            whoTurnIsIt = "white";
        }
        else{
            whoTurnIsIt = "black";
        }

        int[] location = new int[2];


        while (true) {
            System.out.println("It is " + whoTurnIsIt + "'s turn. Choose a piece");
            System.out.println("Enter 0 to 7 for the column first, then a space, then another 0 to 7 for the row");

            String output = keyboard.nextLine();
            String[] cleanOutput = output.trim().split(" ");

            //if length is too short
            if(cleanOutput.length < 2){
                System.out.println("Needs two values.");
                continue;
            }

            //only takes the first two numbers
            Integer column = Integer.parseInt(cleanOutput[0]);
            Integer row = Integer.parseInt(cleanOutput[1]);

            //checks if location is within the board
            if (column >= 0 && column < 8 && row >= 0 && row < 8) {
                location[0] = column;
                location[1] = row;
                break;
            }
            else {
                System.out.println("the two values are not with this board.");
            }

        }

        return location;
    }

    //check if piece matches to the player's color
    private boolean checkMatchingPieceAndPlayer(){

        boolean isCorrectPiece = false;
        char color;

        if(isWhiteTurn){
            color = 'w';
        }else{
            color = 'b';
        }

        String piece = getChessPiece();

        if(piece.equals("   ")){

        }
        else{
            if(piece.charAt(0) == color){
                isCorrectPiece = true;
            }
        }

        return isCorrectPiece;
    }

    public String getChessPiece(){
        int column = pieceLocation[0];
        int row = pieceLocation[1];
        String piece = chessBoard[column][row];

        return piece;
    }


}
