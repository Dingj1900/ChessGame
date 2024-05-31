package ChessClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        //set up the board and the game
        String [][] chessBoard = setUpBoard();

        //While the game is continuing, game = true;
        boolean game = true;
        boolean enPassant = false;
        //Starting turn is white
        boolean whiteTurn = true;


        while (game){
            int [] chessPiece = validGamePiece(chessBoard, whiteTurn);

            String [] possibleMoves = chessPiecePossibleMoves(chessPiece, chessBoard);


        }


    }


    //Functions for starting the game

    //Sets up the beginning board
    public static String [][] setUpBoard(){
        String [][] chessBoard = new String[8][8];

        //create the pawns
        int whitePawns = 1;
        int blackPawns = 6;

        for (int i = 0; i < 8; i++) {
            chessBoard[i][whitePawns] = "w-p";
            chessBoard[i][blackPawns] = "b-p";
        }

        //white horse
        chessBoard[1][0] = "w-H";
        chessBoard[6][0] = "w-H";
        //black horse
        chessBoard[1][7] = "b-H";
        chessBoard[6][7] = "b-H";

        //white rook
        chessBoard[0][0] = "w-R";
        chessBoard[7][0] = "w-R";
        //black rook
        chessBoard[0][7] = "b-R";
        chessBoard[7][7] = "b-R";

        //white Bishop
        chessBoard[2][0] = "w-B";
        chessBoard[5][0] = "w-B";
        //black Bishop
        chessBoard[2][7] = "b-B";
        chessBoard[5][7] = "b-B";

        //white Queen
        chessBoard[3][0] = "w-Q";
        //black Queen
        chessBoard[3][7] = "b-Q";

        //white King
        chessBoard[4][0] = "w-K";
        //black King
        chessBoard[4][7] = "b-K";

        //fill the rest with three empty spaces
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessBoard[i][j].isEmpty()){
                    chessBoard[i][j] = "   ";
                }
            }
        }

        return chessBoard;
    }

    //Get a piece location from user
    //Will check the validity of the location
    public static int[] validGamePiece(String [][] chessBoard, boolean whiteTurn){

        boolean isValidPiece = false;
        int [] pieceLocation = new int[2];

        while(!isValidPiece){
             pieceLocation = choosePieceLocation(whiteTurn);

            boolean isRightColor = checkMatchingPieceAndPlayer(pieceLocation, chessBoard, whiteTurn);

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
    public static int[] choosePieceLocation(boolean whiteTurn) {
        //promote the user to choose a piece
        Scanner keyboard = new Scanner(System.in);

        String whoTurnIsIt;

        if(whiteTurn == true){
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
    public static boolean checkMatchingPieceAndPlayer(int [] pieceLocation, String [][] chessBoard, boolean whiteTurn){


        boolean isCorrectPiece = false;
        String color;

        if(whiteTurn){
            color = "w";
        }else{
            color = "b";
        }

        String piece = getChessPiece(pieceLocation, chessBoard);

        if(!piece.equals("   ")){
            isCorrectPiece = true;
        }

        return isCorrectPiece;
    }

    public static String getChessPiece(int[] pieceLocation, String [][] chessBoard){
        int column = pieceLocation[0];
        int row = pieceLocation[1];
        String piece = chessBoard[column][row];

        return piece;
    }

    //End of functions for starting the game

    public static String [] chessPiecePossibleMoves(int[] pieceLocation, String [][] chessBoard){
        String piece = getChessPiece(pieceLocation, chessBoard);
        String [] listOfMoves;
        String letter = Character.toString(piece.charAt(2));

        if(letter.equals("p")){

        }
        if(letter.equals("R")){

        }
        if(letter.equals("H")){

        }
        if(letter.equals("B")){

        }
        if(letter.equals("Q")){

        }
        if(letter.equals("K")){

        }


    }

    public static List<Integer> pawnMoves(int [] pieceLocation, String [][] chessBoard){
        int column = pieceLocation[0];
        int row = pieceLocation[1];

        //hold list of locations where it can move
        List<Integer[]> listOfMoves = new ArrayList<>();
        //used for adding location to the list
        Integer [] newMove = new Integer[2];

        //no need to check forward bounds due to promotion step after the move is selected
        //pawn will no longer be pawn

        //can go forward ny one if there is nothing there
        if(!chessBoard[column - 1 ][row + 1].equals("   ")){
            newMove[0] = column - 1;
            newMove[1] = row + 1;
            listOfMoves.add(newMove);
        }

        //if pawn hasn't moved, it can go two steps forward
        if(row == 1){
            //can go forward ny one if there is nothing there
            if(!chessBoard[column - 1 ][row + 2].equals("   ")){
                newMove[0] = column - 1;
                newMove[1] = row + 2;
                listOfMoves.add(newMove);
            }

        }

        //can go left diagonal by one if there is something there
        if(column - 1 >= 0){
            //if the slot is not empty, it can go eat it
            if(!chessBoard[column - 1 ][row + 1].equals("   ")){
                newMove[0] = column - 1;
                newMove[1] = row + 1;
                listOfMoves.add(newMove);
            }
        }

        //check right diagonal bu one
        if(column + 1 < 8){
            if(!chessBoard[column + 1 ][row + 1].equals("   ")){
                newMove[0] = column + 1;
                newMove[1] = row + 1;
                listOfMoves.add(newMove);
            }
        }




    }







}
