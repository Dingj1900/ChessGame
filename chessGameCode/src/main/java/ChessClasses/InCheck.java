package ChessClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InCheck {

    List<CheckStack> checkStackList = new ArrayList<>();

    char enemyColor;
    int column;
    int row;
    String [][] chessBoard = new String[8][8];

    /*
    returns 0 for no checks
    returns 1 for checks
    */
    public int checkForChecks(ChessBoard chessBoard, boolean isWhiteTurn){

        setChessBoard(chessBoard);

        //set enemy color and king location
        {
            int[][] kingsLocation = chessBoard.getKingsLocation();

            int kingType = 0; // white
            enemyColor = 'b';

            if (!isWhiteTurn) {
                kingType = 1; //black
                enemyColor = 'w';
            }
            column = kingsLocation[kingType][0];
            row = kingsLocation[kingType][1];
        }

        leftAttackedSide();
        rightAttackedSide();
        frontAttackedSide();
        backAttackedSide();

        northWestDiagonalAttackedSide();
        northEastDiagonalAttackedSide();
        southEastDiagonalAttackedSide();
        southWestDiagonalAttackedSide();

        northHorseAttackedSide();
        southHorseAttackedSide();
        eastHorseAttackedSide();
        westHorseAttackedSide();


        if(checkStackList.isEmpty()){
            return 0;
        }
        return 1;
    }

    public void resetCheckStackList() {
        this.checkStackList = new ArrayList<>();
    }
    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard.getChessBoard();
    }
    public void setChessBoard(String [][] chessBoard){
        this.chessBoard = chessBoard;
    }



    private void leftAttackedSide(){

        //check left
        while(column >= 0){
            if(!chessBoard[column][row].isEmpty()){
                break;
            }
            column--;
        }

        if (column == -1){
            //empty
        }else{

            if(chessBoard[column][row].charAt(0) == enemyColor){
                if (chessBoard[column][row].charAt(3) == 'R' || chessBoard[column][row].charAt(3) == 'Q'){

                    int[] pieceLocation = {column,row};
                    CheckStack enemyAttackingPiece = new CheckStack(chessBoard[column][row],pieceLocation);
                    checkStackList.add(enemyAttackingPiece);
                }
            }
        }
    }

    private void rightAttackedSide(){

        //check left
        while(column <= 7){
            if(!chessBoard[column][row].isEmpty()){
                break;
            }
            column++;
        }

        if (column == 8){
            //empty
        }else{

            if(chessBoard[column][row].charAt(0) == enemyColor){
                if (chessBoard[column][row].charAt(3) == 'R' || chessBoard[column][row].charAt(3) == 'Q'){

                    int[] pieceLocation = {column,row};
                    CheckStack enemyAttackingPiece = new CheckStack(chessBoard[column][row],pieceLocation);
                    checkStackList.add(enemyAttackingPiece);
                }
            }
        }
    }

    private void frontAttackedSide(){

        //check left
        while(row <= 7){
            if(!chessBoard[column][row].isEmpty()){
                break;
            }
            row++;
        }

        if (row == 8){
            //empty
        }else{

            if(chessBoard[column][row].charAt(0) == enemyColor){
                if (chessBoard[column][row].charAt(3) == 'R' || chessBoard[column][row].charAt(3) == 'Q'){

                    int[] pieceLocation = {column,row};
                    CheckStack enemyAttackingPiece = new CheckStack(chessBoard[column][row],pieceLocation);
                    checkStackList.add(enemyAttackingPiece);
                }
            }
        }
    }

    private void backAttackedSide(){

        //check left
        while(row >= 0){
            if(!chessBoard[column][row].isEmpty()){
                break;
            }
            row--;
        }

        if (row == -1){
            //empty
        }else{

            if(chessBoard[column][row].charAt(0) == enemyColor){
                if (chessBoard[column][row].charAt(3) == 'R' || chessBoard[column][row].charAt(3) == 'Q'){

                    int[] pieceLocation = {column,row};
                    CheckStack enemyAttackingPiece = new CheckStack(chessBoard[column][row],pieceLocation);
                    checkStackList.add(enemyAttackingPiece);
                }
            }
        }
    }

    private void northWestDiagonalAttackedSide(){

        //check left
        while(row <= 7 || column >= 0){
            if(!chessBoard[column][row].isEmpty()){
                break;
            }
            row++;
            column--;
        }

        if (row == 8 || column == -1){
            //empty
        }else{

            if(chessBoard[column][row].charAt(0) == enemyColor){
                if (chessBoard[column][row].charAt(3) == 'B' || chessBoard[column][row].charAt(3) == 'Q'){

                    int[] pieceLocation = {column,row};
                    CheckStack enemyAttackingPiece = new CheckStack(chessBoard[column][row],pieceLocation);
                    checkStackList.add(enemyAttackingPiece);
                }
            }
        }
    }

    private void northEastDiagonalAttackedSide(){

        //check left
        while(row <= 7 || column <= 7){
            if(!chessBoard[column][row].isEmpty()){
                break;
            }
            row++;
            column++;
        }

        if (row == 8 || column == 8){
            //empty
        }else{

            if(chessBoard[column][row].charAt(0) == enemyColor){
                if (chessBoard[column][row].charAt(3) == 'B' || chessBoard[column][row].charAt(3) == 'Q'){

                    int[] pieceLocation = {column,row};
                    CheckStack enemyAttackingPiece = new CheckStack(chessBoard[column][row],pieceLocation);
                    checkStackList.add(enemyAttackingPiece);
                }
            }
        }
    }

    private void southWestDiagonalAttackedSide(){

        //check left
        while(row >= 0  || column >= 0){
            if(!chessBoard[column][row].isEmpty()){
                break;
            }
            row--;
            column--;
        }

        if (row == -1 || column == -1){
            //empty
        }else{

            if(chessBoard[column][row].charAt(0) == enemyColor){
                if (chessBoard[column][row].charAt(3) == 'B' || chessBoard[column][row].charAt(3) == 'Q'){

                    int[] pieceLocation = {column,row};
                    CheckStack enemyAttackingPiece = new CheckStack(chessBoard[column][row],pieceLocation);
                    checkStackList.add(enemyAttackingPiece);
                }
            }
        }
    }

    private void southEastDiagonalAttackedSide(){

        //check left
        while(row >= 0 && column <= 7){
            if(!chessBoard[column][row].isEmpty()){
                break;
            }
            row--;
            column++;
        }

        if (row == -1 || column == 8){
            //empty
        }else{

            if(chessBoard[column][row].charAt(0) == enemyColor){
                if (chessBoard[column][row].charAt(3) == 'B' || chessBoard[column][row].charAt(3) == 'Q'){

                    int[] pieceLocation = {column,row};
                    CheckStack enemyAttackingPiece = new CheckStack(chessBoard[column][row],pieceLocation);
                    checkStackList.add(enemyAttackingPiece);
                }
            }
        }
    }

    private void northHorseAttackedSide(){
        if(row + 2 < 8){
            row = row + 2;
            if(column + 1 < 8){
                column = column + 1;

                if(chessBoard[column][row].charAt(0) == enemyColor){
                    if (chessBoard[column][row].charAt(3) == 'H'){

                        int[] pieceLocation = {column ,row };

                        CheckStack enemyAttackingPiece = new CheckStack(chessBoard[column][row],pieceLocation);
                        checkStackList.add(enemyAttackingPiece);
                    }
                }
            }
            if(column - 1 > -1){
                column = column - 1;

                if(chessBoard[column][row].charAt(0) == enemyColor){
                    if (chessBoard[column][row].charAt(3) == 'H'){

                        int[] pieceLocation = {column,row};

                        CheckStack enemyAttackingPiece = new CheckStack(chessBoard[column][row],pieceLocation);
                        checkStackList.add(enemyAttackingPiece);
                    }
                }
            }

        }
    }

    private void southHorseAttackedSide(){
        if(row - 2 > -1){
            row = row - 2;
            if(column + 1 < 8){
                column = column + 1;

                if(chessBoard[column][row].charAt(0) == enemyColor){
                    if (chessBoard[column][row].charAt(3) == 'H'){

                        int[] pieceLocation = {column ,row };

                        CheckStack enemyAttackingPiece = new CheckStack(chessBoard[column][row],pieceLocation);
                        checkStackList.add(enemyAttackingPiece);
                    }
                }
            }
            if(column - 1 > -1){
                column = column - 1;

                if(chessBoard[column][row].charAt(0) == enemyColor){
                    if (chessBoard[column][row].charAt(3) == 'H'){

                        int[] pieceLocation = {column,row};

                        CheckStack enemyAttackingPiece = new CheckStack(chessBoard[column][row],pieceLocation);
                        checkStackList.add(enemyAttackingPiece);
                    }
                }
            }

        }
    }

    private void westHorseAttackedSide(){
        if(column - 2 > -1){
            column = column - 2;

            if(row + 1 < 8){
                row = row + 1;

                if(chessBoard[column][row].charAt(0) == enemyColor){
                    if (chessBoard[column][row].charAt(3) == 'H'){

                        int[] pieceLocation = {column ,row };

                        CheckStack enemyAttackingPiece = new CheckStack(chessBoard[column][row],pieceLocation);
                        checkStackList.add(enemyAttackingPiece);
                    }
                }
            }
            if(row - 1 > -1){
                row = row - 1;

                if(chessBoard[column][row].charAt(0) == enemyColor){
                    if (chessBoard[column][row].charAt(3) == 'H'){

                        int[] pieceLocation = {column,row};

                        CheckStack enemyAttackingPiece = new CheckStack(chessBoard[column][row],pieceLocation);
                        checkStackList.add(enemyAttackingPiece);
                    }
                }
            }

        }
    }

    private void eastHorseAttackedSide(){
        if(column + 2 < 8){
            column = column - 2;

            if(row + 1 < 8){
                row = row + 1;

                if(chessBoard[column][row].charAt(0) == enemyColor){
                    if (chessBoard[column][row].charAt(3) == 'H'){

                        int[] pieceLocation = {column ,row };

                        CheckStack enemyAttackingPiece = new CheckStack(chessBoard[column][row],pieceLocation);
                        checkStackList.add(enemyAttackingPiece);
                    }
                }
            }
            if(row - 1 > -1){
                row = row - 1;

                if(chessBoard[column][row].charAt(0) == enemyColor){
                    if (chessBoard[column][row].charAt(3) == 'H'){

                        int[] pieceLocation = {column,row};

                        CheckStack enemyAttackingPiece = new CheckStack(chessBoard[column][row],pieceLocation);
                        checkStackList.add(enemyAttackingPiece);
                    }
                }
            }

        }
    }

}
