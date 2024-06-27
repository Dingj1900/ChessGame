package rules_of_chess;

import items_of_chess_game.Board;
import items_of_chess_game.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PossibleMovesWhenInCheck extends CanBeAttacked{

    Stack<Piece> attackStackList;

    boolean isWhiteTurn;

    Piece[][] chessBoard = new Piece[8][8];

    CanBeAttacked blockAndCapture;
    public PossibleMovesWhenInCheck(){

    }
    public PossibleMovesWhenInCheck(Stack<Piece> attackStackList, boolean isWhiteTurn){
        this.attackStackList = attackStackList;
        this.isWhiteTurn = isWhiteTurn;
        blockAndCapture = new CanBeAttacked();
    }

    /*
    * Assumes that attackStackList is not null
    *
    */
    public List<int []> checkForPossibleMovesWhenInCheck(Board chessBoard, int [] kingsLocation){

        this.chessBoard = chessBoard.getBoard();

        List<int []> allPossibleMovies = new ArrayList<>();

        int kingColumn = kingsLocation[0];
        int kingRow = kingsLocation[1];

        //for one piece checking king
        //check for any piece that can block it and any possible king movies
        if(attackStackList.size() == 1){

            Piece attackingPiece = attackStackList.pop();
            int[] attackingPieceLocation = attackingPiece.getLocation();
            int attackingPieceColumn = attackingPieceLocation[0];
            int attackingPieceRow = attackingPieceLocation[1];

            String [] attackingPieceType = attackingPiece.getName().split(" ");

            int columnDistance = 0;
            int rowDistance = 0;

            switch (attackingPieceType[1]){
                case "Queen":

                    if(kingColumn > attackingPieceColumn){
                        columnDistance = kingColumn - attackingPieceColumn;
                    }
                    else{
                       columnDistance = attackingPieceColumn - kingColumn;
                    }
                    if(kingRow > attackingPieceRow){
                        rowDistance = kingColumn - attackingPieceColumn;
                    }
                    else{

                    }

                    break;
                case "Rook":
                    break;
                case "Bishop":
                    break;
                case "Knight":
                    break;
                case "Pawn":
                    break;
                default:


            }

            //check what can block it/includes taking it

            //check if the moving move gives another check

            //if yes cancel it repeat, if no allow the move

        }
        //for multiple checks from different pieces
        //only the king can move
        else{

        }

        return allPossibleMovies;

    }



}
