package ChessClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Application {

    public static void main(String[] args) {

        //While the game is continuing, game = true;
        boolean game = true;
        boolean isWhiteTurn = true; //white start first

        ChessBoard chessBoard = new ChessBoard();
        InCheck checkForCheck = new InCheck();
        ValidationCheckForPiece validationCheckForPiece = new ValidationCheckForPiece(chessBoard.getChessBoard(), isWhiteTurn);



        while (game){


            validationCheckForPiece.getValidGamePiece();
            int [] chessPieceLocation = piece.getValidGamePiece();
            String chessPieceType = piece.getChessPiece();


            isWhiteTurn = !isWhiteTurn;//switch colors

            chessBoard.flipBoard();//switch board for colors
        }


    }




}
