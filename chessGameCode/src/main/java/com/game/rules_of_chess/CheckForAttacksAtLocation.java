package com.game.rules_of_chess;

import com.game.items_of_chess_game.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class CheckForAttacksAtLocation {

    private Stack<Piece> attackStackList = new Stack<>();

    private List<int []> spaces = new ArrayList<>();

    private int [] newSpace = new int[2];

    private String enemyColor;
    private int column;
    private int row;
    private int originalColumn;
    private int originalRow;

    private boolean isWhiteTurn;

    Piece[][] chessBoard;

    public CheckForAttacksAtLocation(Piece [][] chessBoard, boolean isWhiteTurn){
        this.chessBoard = chessBoard;
        this.isWhiteTurn = isWhiteTurn;
        setEnemyColor(isWhiteTurn);
    }

    /*
    parameter: Piece [][] object, boolean, int [] of size 2 at least
    returns false for no attacks and invalid pieceLocation size
    returns true for attacks
    */
    public boolean isThereAnAttacks(int [] pieceLocation){
        if(pieceLocation.length < 2){
            return false;
        }

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

        //Knight
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

    public List<int[]> getSpaces(){
        return spaces;
    }

    public void setColumn(int column){
        this.column = column;
        this.originalColumn = column;
    }

    public void setRow(int row){
        this.row = row;
        this.originalRow = row;
    }

    public void resetAttackStackList() {
        this.attackStackList = new Stack<>();
    }
    public Stack<Piece> getAttackStackList(){
        return attackStackList;
    }

    public void setChessBoard(Piece[][] chessBoard) {
        this.chessBoard = chessBoard;
    }

    //set enemy color to white if param is black/true
    //set enemy color to black if param is white/true
    public void setEnemyColor(Boolean isWhiteTurn){
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
    public void checkForEnemyAtLocation(String firstAttacker, String secondAttacker){

        Piece piece = chessBoard[column][row];


        if(piece.getColor().equals(enemyColor)){

            if (piece.getName().equals(firstAttacker) || piece.getName().equals(secondAttacker)){

                newSpace[0] = column;
                newSpace[1] = row;
                spaces.add(newSpace);

                Piece enemyAttackingPiece = chessBoard[column][row];
                attackStackList.push(enemyAttackingPiece);
            }
        }
        column = originalColumn;
        row = originalRow;
    }
    
    /*
    for pawns checks
    helps preventing kings from touching on their move
    DOES NOT RESET the columns or rows
    */
    public void checkForEnemyCloseBy(String attacker){

        Piece piece = chessBoard[column][row];

        if(piece.getColor().equals(enemyColor)){

            if (piece.getName().equals(attacker)){

                newSpace[0] = column;
                newSpace[1] = row;
                spaces.add(newSpace);

                Piece enemyAttackingPiece = chessBoard[column][row];
                attackStackList.push(enemyAttackingPiece);
            }
        }
        
    }

    public void leftAttackedSide(){




        //check left
        while(column >= 0){
            if(!chessBoard[column][row].getName().isBlank()){

                newSpace[0] = column;
                newSpace[1] = row;
                spaces.add(newSpace);

                break;
            }
            column--;
        }

        if (column == -1){
            //empty
        }else{
            if(column == originalColumn - 1){
                checkForEnemyCloseBy("King");
            }
            checkForEnemyAtLocation("Rook", "Queen");
        }


    }

    public void rightAttackedSide(){

        //check left
        while(column <= 7){
            if(!chessBoard[column][row].getName().isBlank()){

                newSpace[0] = column;
                newSpace[1] = row;
                spaces.add(newSpace);

                break;
            }
            column++;
        }

        if (column == 8){
            //empty
        }else{
            if(column == originalColumn + 1){
                checkForEnemyCloseBy("King");
            }
            checkForEnemyAtLocation("Rook","Queen");
        }
    }

    public void frontAttackedSide(){

        //check left
        while(row <= 7){
            if(!chessBoard[column][row].getName().isBlank()){

                newSpace[0] = column;
                newSpace[1] = row;
                spaces.add(newSpace);

                break;
            }
            row++;
        }

        if (row == 8){
            //empty
        }else{
            if(row == originalRow + 1){
                checkForEnemyCloseBy("King");
            }
            checkForEnemyAtLocation("Rook", "Queen");
        }
    }

    public void backAttackedSide(){

        //check left
        while(row >= 0){
            if(!chessBoard[column][row].getName().isBlank()){

                newSpace[0] = column;
                newSpace[1] = row;
                spaces.add(newSpace);

                break;
            }
            row--;
        }

        if (row == -1){
            //empty
        }else{
            if(row == originalRow - 1){
                checkForEnemyCloseBy("King");
            }
            checkForEnemyAtLocation("Rook", "Queen");
        }
    }

    public void northWestDiagonalAttackedSide(){

        //check left
        while(row <= 7 || column >= 0){
            if(!chessBoard[column][row].getName().isBlank()){

                newSpace[0] = column;
                newSpace[1] = row;
                spaces.add(newSpace);

                break;
            }
            row++;
            column--;
        }

        if (row == 8 || column == -1){
            //empty
        }else{
            
            if(originalColumn - 1 == column && originalRow + 1 == row){
                checkForEnemyCloseBy("Pawn");
                checkForEnemyCloseBy("King");
            }
            

            checkForEnemyAtLocation("Bishop","Queen");
        }
    }

    public void northEastDiagonalAttackedSide(){

        //check left
        while(row <= 7 || column <= 7){
            if(!chessBoard[column][row].getName().isBlank()){

                newSpace[0] = column;
                newSpace[1] = row;
                spaces.add(newSpace);

                break;
            }
            row++;
            column++;
        }

        if (row == 8 || column == 8){
            //empty
        }else{

            if(originalColumn + 1 == column && originalRow + 1 == row){
                checkForEnemyCloseBy("Pawn");
                checkForEnemyCloseBy("King");
            }
            
            checkForEnemyAtLocation("Bishop","Queen");

        }
    }

    public void southWestDiagonalAttackedSide(){

        //check left
        while(row >= 0  || column >= 0){
            if(!chessBoard[column][row].getName().isBlank()){

                newSpace[0] = column;
                newSpace[1] = row;
                spaces.add(newSpace);

                break;
            }
            row--;
            column--;
        }

        if (row == -1 || column == -1){
            //empty
        }else{
            if(column == originalColumn - 1 && row == originalRow -1){
                checkForEnemyCloseBy("King");
            }
            checkForEnemyAtLocation("Bishop","Queen");

        }
    }

    public void southEastDiagonalAttackedSide(){

        //check left
        while(row >= 0 && column <= 7){
            if(!chessBoard[column][row].getName().isBlank()){

                newSpace[0] = column;
                newSpace[1] = row;
                spaces.add(newSpace);

                break;
            }
            row--;
            column++;
        }

        if (row == -1 || column == 8){
            //empty
        }else{
            if(column == originalColumn + 1 && row == originalRow - 1){
                checkForEnemyCloseBy("King");
            }

            checkForEnemyAtLocation("Bishop", "Queen");
        }
    }


    public void northHorseAttackedSide(){
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
            //resets
            column = originalColumn;
            row = originalRow;

        }
    }

    public void southHorseAttackedSide(){
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
            //resets
            column = originalColumn;
            row = originalRow;

        }
    }

    public void westHorseAttackedSide(){
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
            //resets
            column = originalColumn;
            row = originalRow;

        }
    }

    public void eastHorseAttackedSide(){
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
            //resets
            column = originalColumn;
            row = originalRow;

        }
    }

}
