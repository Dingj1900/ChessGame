package ChessClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Application {

    public static void main(String[] args) {

        ChessBoard chessBoard = new ChessBoard();
        InCheck checkForCheck = new InCheck();

        //While the game is continuing, game = true;
        boolean game = true;
        boolean isWhiteTurn = true; //white start first


        while (game){




            ValidationCheckForPiece piece = new ValidationCheckForPiece(chessBoard.getChessBoard(), isWhiteTurn);
            int [] chessPieceLocation = piece.getValidGamePiece();
            String chessPieceType = piece.getChessPiece();

            List <int[]> possibleMoves = chessPiecePossibleMoves(chessPieceLocation, chessPieceType ,chessBoard.getChessBoard());


            isWhiteTurn = !isWhiteTurn;//switch colors

            chessBoard.flipBoard();//switch board for colors
        }


    }

    public static List <int []> chessPiecePossibleMoves(int[] pieceLocation, String chessPieceType,  String [][] chessBoard){

        List <int[]> allPossibleMoves = new ArrayList<>();
        String letter = Character.toString(chessPieceType.charAt(2));

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


        return allPossibleMoves;
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
