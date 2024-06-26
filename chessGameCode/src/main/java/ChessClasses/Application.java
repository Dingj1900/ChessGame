package ChessClasses;

import items_of_chess_game.Board;
import rules_of_chess.CanBeAttacked;
import rules_of_chess.ValidationCheckForPiece;

public class Application {

    public static void main(String[] args) {

        //While the game is continuing, game = true;
        boolean game = true;
        boolean isWhiteTurn = true; //white start first

        Board Board = new Board();
        CanBeAttacked checkForCheck = new CanBeAttacked();
        ValidationCheckForPiece validationCheckForPiece = new ValidationCheckForPiece(Board.getBoard(), isWhiteTurn);



        while (game){


            validationCheckForPiece.getValidGamePiece();
            int [] chessPieceLocation = piece.getValidGamePiece();
            String chessPieceType = piece.getChessPiece();


            isWhiteTurn = !isWhiteTurn;//switch colors

            Board.flipBoard();//switch board for colors
        }


    }




}
