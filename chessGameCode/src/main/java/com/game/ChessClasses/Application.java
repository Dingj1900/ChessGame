package com.game;

import com.game.items_of_chess_game.Board;
import com.game.rules_of_chess.CheckForAttacksAtLocation;
import com.game.rules_of_chess.ValidationCheckForPiece;

public class Application {

    public static void main(String[] args) {

        System.out.println(3-4);
        //While the game is continuing, game = true;
        boolean game = true;
        boolean isWhiteTurn = true; //white start first

        Board Board = new Board();
        CheckForAttacksAtLocation checkForCheck = new CheckForAttacksAtLocation();
        ValidationCheckForPiece validationCheckForPiece = new ValidationCheckForPiece(Board.getBoard(), isWhiteTurn);



        while (game){


            isWhiteTurn = !isWhiteTurn;//switch colors

            Board.flipBoard();//switch board for colors
        }


    }




}
