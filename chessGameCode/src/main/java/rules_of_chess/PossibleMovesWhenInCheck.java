package rules_of_chess;

import items_of_chess_game.Board;
import items_of_chess_game.Piece;

import java.util.ArrayList;
import java.util.List;

public class PossibleMovesWhenInCheck extends CanBeAttacked{

    List<CheckStack> attackStackList;

    boolean isWhiteTurn;

    Piece[][] Board = new Piece[8][8];

    public PossibleMovesWhenInCheck(){

    }
    public PossibleMovesWhenInCheck(List<CheckStack> attackStackList, boolean isWhiteTurn){
        this.attackStackList = attackStackList;
        this.isWhiteTurn = isWhiteTurn;
    }

    public List<int []> checkForPossibleMovesWhenInCheck(Board Board){

        this.Board = Board.getBoard();

        List<int []> allPossibleMovies = new ArrayList<>();

        //for one piece checking king
        //check for any piece that can block it and any possible king movies
        if(attackStackList.size() == 1){
            //get the type of piece attacking

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
