package rules_of_chess;

import items_of_chess_game.Piece;

import java.util.List;

public class PossibleMoves {

    private int column;
    private int row;


    Piece [][] chessBoard;

    public List<Piece> getValidMoves(int [] pieceLocation, int [][]possibleLocations, Piece [][] chessBoard){

        CheckForAttacksAtLocation checkForAttacksAtLocation = new CheckForAttacksAtLocation(chessBoard, );

        this.chessBoard = chessBoard;
        column = pieceLocation[0];
        row = pieceLocation[1];

        Piece piece = chessBoard[column][row];




        String [] type = piece.getName().trim().split(" ");



        switch (type[1]){
            case "Pawn":

            case "Knight":
            case "Bishop":
            case "Rook":
            case "Queen":

            case "King":
            default:

        }



    }

    private int [] pawnsMoves(int [] piece){

    }

    private int [] knightMoves(int [] piece){

    }
    private int [] bishopMoves(int [] piece){

    }

    private int [] rookMoves(int [] piece){

    }


    private int [] queenMoves(int [] piece){

    }
    private int [] kingMoves(int [] piece){




    }

}
