package rules_of_chess;

import items_of_chess_game.Board;
import items_of_chess_game.Piece;

import java.util.ArrayList;
import java.util.List;

public class CanBeAttacked {

    List<Piece> attackStackList = new ArrayList<>();

    String enemyColor;
    int column;
    int row;
    int originalColumn;
    int originalRow;

    Piece[][] chessBoard = new Piece[8][8];


    /*
    returns false for no attacks
    returns true for attacks
    */
    public boolean isThereAnAttacks(Piece [][] Board, boolean isWhiteTurn, int [] pieceLocation){

        setBoard(Board);

        {
            setEnemyColor(isWhiteTurn);

            column = pieceLocation[0];
            row = pieceLocation[1];
            originalColumn = column;
            originalRow = row;

        }

        //straight
        {
            leftAttackedSide();
            rightAttackedSide();
            frontAttackedSide();
            backAttackedSide();
        }

        //diagonal
        {
            northWestDiagonalAttackedSide();
            northEastDiagonalAttackedSide();
            southEastDiagonalAttackedSide();
            southWestDiagonalAttackedSide();
        }

        //horse
        {
            northHorseAttackedSide();
            southHorseAttackedSide();
            eastHorseAttackedSide();
            westHorseAttackedSide();
        }

        if(attackStackList.isEmpty()){
            return false;
        }
        return true;
    }

    public void resetAttackStackList() {
        this.attackStackList = new ArrayList<>();
    }
    public List<Piece> getattackStackList(){
        return attackStackList;
    }
    public void setBoard(Piece [][] board) {
        this.chessBoard = board;
    }

    private void setEnemyColor(Boolean isWhiteTurn){
        if(isWhiteTurn){
            this.enemyColor = "Black";
        }else {
            this.enemyColor = "White";
        }
    }

    /*
    Checks if attackers are of correct color and type
    if yes, add piece to the attackStackList
    WILL RESET column and row to originalColumn and originalRow at the end
    */
    private void checkForEnemyAtLocation(String firstAttacker, String secondAttacker){

        String [] separateColorAndName = chessBoard[column][row].getName().split(" ");

        if(separateColorAndName[0].equals(enemyColor)){

            if (separateColorAndName[1].equals(firstAttacker) || separateColorAndName[1].equals(secondAttacker)){

                Piece enemyAttackingPiece = chessBoard[column][row];
                attackStackList.add(enemyAttackingPiece);
            }
        }
        column = originalColumn;
        row = originalRow;
    }

    private void leftAttackedSide(){

        //check left
        while(column >= 0){
            if(!chessBoard[column][row].getName().isBlank()){
                break;
            }
            column--;
        }

        if (column == -1){
            //empty
        }else{
            checkForEnemyAtLocation("Rook", "Queen");
        }


    }

    private void rightAttackedSide(){

        //check left
        while(column <= 7){
            if(!chessBoard[column][row].getName().isBlank()){
                break;
            }
            column++;
        }

        if (column == 8){
            //empty
        }else{
            checkForEnemyAtLocation("Rook","Queen");
        }
    }

    private void frontAttackedSide(){

        //check left
        while(row <= 7){
            if(!chessBoard[column][row].getName().isBlank()){
                break;
            }
            row++;
        }

        if (row == 8){
            //empty
        }else{
            checkForEnemyAtLocation("Rook", "Queen");
        }
    }

    private void backAttackedSide(){

        //check left
        while(row >= 0){
            if(!chessBoard[column][row].getName().isBlank()){
                break;
            }
            row--;
        }

        if (row == -1){
            //empty
        }else{

            checkForEnemyAtLocation("Rook", "Queen");
        }
    }

    private void northWestDiagonalAttackedSide(){

        //check left
        while(row <= 7 || column >= 0){
            if(!chessBoard[column][row].getName().isBlank()){
                break;
            }
            row++;
            column--;
        }

        if (row == 8 || column == -1){
            //empty
        }else{

            String [] separateColorAndName = chessBoard[column][row].getName().split(" ");

            //if the attacking piece is an enemy
            if(separateColorAndName.equals(enemyColor)){

                //for pawn, location needs on the piece's northwest by one to attack
                if(separateColorAndName[1].equals("Pawn")){
                    if(originalColumn - 1 == column && originalRow + 1 ==row){

                        Piece enemyAttackingPiece = chessBoard[column][row];
                        attackStackList.add(enemyAttackingPiece);
                    }
                }

            }

            checkForEnemyAtLocation("Bishop","Queen");
        }
    }

    private void northEastDiagonalAttackedSide(){

        //check left
        while(row <= 7 || column <= 7){
            if(!chessBoard[column][row].getName().isBlank()){
                break;
            }
            row++;
            column++;
        }

        if (row == 8 || column == 8){
            //empty
        }else{

            String [] separateColorAndName = chessBoard[column][row].getName().split(" ");
            //for pawn
            if(separateColorAndName[0].equals(enemyColor)){

                if(originalColumn + 1 == column && originalRow + 1 == row){
                    Piece enemyAttackingPiece = chessBoard[column][row];
                    attackStackList.add(enemyAttackingPiece);
                }
            }
            checkForEnemyAtLocation("Bishop","Queen");

        }
    }

    private void southWestDiagonalAttackedSide(){

        //check left
        while(row >= 0  || column >= 0){
            if(!chessBoard[column][row].getName().isBlank()){
                break;
            }
            row--;
            column--;
        }

        if (row == -1 || column == -1){
            //empty
        }else{
            checkForEnemyAtLocation("Bishop","Queen");

        }
    }

    private void southEastDiagonalAttackedSide(){

        //check left
        while(row >= 0 && column <= 7){
            if(!chessBoard[column][row].getName().isBlank()){
                break;
            }
            row--;
            column++;
        }

        if (row == -1 || column == 8){
            //empty
        }else{

            checkForEnemyAtLocation("Bishop", "Queen");
        }
    }


    private void northHorseAttackedSide(){
        if(row + 2 < 8){
            row = row + 2;
            if(column + 1 < 8){
                column++;

                checkForEnemyAtLocation("Knight", "Empty");

                row = row + 2; // due to method checkForEnemyReset, needed to recalculate row. Column reset is intended
            }
            if(column - 1 > -1){
                column--;

                checkForEnemyAtLocation("Knight", "Empty");

            }

        }
    }

    private void southHorseAttackedSide(){
        if(row - 2 > -1){
            row = row - 2;
            if(column + 1 < 8){
                column++;

                checkForEnemyAtLocation("Knight", "Empty");

                row = row - 2;
            }
            if(column - 1 > -1){
                column--;

                checkForEnemyAtLocation("Knight", "Empty");
            }

        }
    }

    private void westHorseAttackedSide(){
        if(column - 2 > -1){
            column = column - 2;

            if(row + 1 < 8){
                row++;

                checkForEnemyAtLocation("Knight", "Empty");

                column = column - 2;
            }
            if(row - 1 > -1){
                row--;

                checkForEnemyAtLocation("Knight", "Empty");
            }

        }
    }

    private void eastHorseAttackedSide(){
        if(column + 2 < 8){
            column = column + 2;

            if(row + 1 < 8){
                row = row + 1;

                checkForEnemyAtLocation("Knight", "Empty");

                column = column -2;
            }
            if(row - 1 > -1){
                row = row - 1;

                checkForEnemyAtLocation("Knight", "Empty");
            }

        }
    }

}
