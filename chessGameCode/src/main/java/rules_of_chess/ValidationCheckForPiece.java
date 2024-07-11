package rules_of_chess;

import items_of_chess_game.Piece;

import java.util.Scanner;
import java.util.zip.DataFormatException;

public class ValidationCheckForPiece {
    private int [] pieceLocation = new int[2];

    private boolean isWhiteTurn;

    private Piece[][] chessBoard;


    public ValidationCheckForPiece(Piece [][] board, boolean isWhiteTurn){
        this.isWhiteTurn = isWhiteTurn;
        this.chessBoard = board;
    }

    //check if user has select a piece location within the board.
    private int[] choosePieceLocation() {
        //promote the user to choose a piece
        Scanner keyboard = new Scanner(System.in);

        String whoTurnIsIt;

        if(isWhiteTurn){
            whoTurnIsIt = "White";
        }
        else{
            whoTurnIsIt = "Black";
        }

        int[] location = new int[2];

        while (true) {
            System.out.println("It is " + whoTurnIsIt + "'s turn. Choose a piece");
            System.out.println("Enter 1 to 8 for the column first, then a space, then another 1 to 8 for the row");

            String output = keyboard.nextLine();
            String[] userInput = output.trim().split(" ");

            //if length is too short or too long
            if(userInput.length != 2){
                System.out.println("Needs two values.");
                continue;
            }

            int column = 0;
            int row = 0;

            //only takes the first two numbers
            try {
                column = Integer.parseInt(userInput[0]);
                row = Integer.parseInt(userInput[1]);
            }catch(NumberFormatException error){
                System.out.println("The input is not a number. Try again");
                continue; //re-loops to top
            }

            //checks if location is within the board
            if (column >= 1 && column < 9 && row >= 1 && row < 9) {
                //adjust for 0 to 7 instead of 1 to 8
                location[0] = column - 1;
                location[1] = row - 1;
                break;
            }
            else {
                System.out.println("the two values are not with this board.");
            }

        }
        //actual location
        pieceLocation = location;

        return location;
    }

    //parameter: Piece object
    //check if piece matches to the player's color
    private boolean checkMatchingPieceAndPlayer(Piece piece){

        boolean isCorrectPiece = false;
        char color;

        if(isWhiteTurn){
            color = 'W';
        }else{
            color = 'B';
        }

        if(!piece.getName().isBlank()){

            if(piece.getColor().charAt(0) == color){
                isCorrectPiece = true;
            }
        }

        return isCorrectPiece;
    }
    public Piece getChessPiece(){
        int column = pieceLocation[0];
        int row = pieceLocation[1];
        Piece piece = chessBoard[column][row];

        return piece;
    }

    public void setChessBoard(Piece[][] chessBoard) {
        this.chessBoard = chessBoard;
    }

    public void setWhiteTurn(boolean whiteTurn) {
        isWhiteTurn = whiteTurn;
    }
}
