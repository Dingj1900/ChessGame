package rules_of_chess;

import items_of_chess_game.Board;
import items_of_chess_game.NoPiece;
import items_of_chess_game.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PossibleMovesWhenInCheck {


    boolean isWhiteTurn;

    Piece[][] chessBoard = new Piece[8][8];

    Board chessBoardClass;

    int [] kingsLocation;


    public PossibleMovesWhenInCheck(Board chessBoard, boolean isWhiteTurn){
        this.isWhiteTurn = isWhiteTurn;
        this.chessBoard = chessBoard.getBoard();
        this.chessBoardClass = chessBoard;
        this.kingsLocation = getKingsLocation(chessBoard);
    }



    //Check for any piece that can block an attacking piece, usually for a king
    //Takes in the attacking Piece and gives squares
    public List <Piece> blockSquares(Piece attackingPiece){


        //space where a piece can go
        List<Piece> blockAttackingSquares = new ArrayList<>();

        int[] attackingPieceLocation = attackingPiece.getLocation();
        int attackingPieceColumn = attackingPieceLocation[0];
        int attackingPieceRow = attackingPieceLocation[1];

        int kingColumn = kingsLocation[0];
        int kingRow = kingsLocation[1];


        //adjustColumnValues is 1 if attackingPiece is on the right side of the king and -1 for the left
        //adjustRowValue is 1 if attackingPiece is below the king and -1 for above
        int adjustColumnValue = 1;
        int adjustRowValue = 1;

        if(attackingPieceColumn - kingColumn < 0){
            adjustColumnValue = -1;
        }
        if(attackingPieceRow - kingRow < 0){
            adjustRowValue = -1;
        }



        //if it's a knight, nothing can block it except taking it
        if(attackingPiece.getName().equals("Knight")){
            blockAttackingSquares.add(attackingPiece);

        }
        //Otherwise, it's a straight line from the king to the attackingPiece
        //add all spaces/location between king and attackingPiece, includes the attackingPiece's location as well
        else {

            for (int column = attackingPieceColumn, row = attackingPieceRow;
                 column != kingColumn && row != kingRow;) {

                blockAttackingSquares.add(this.chessBoard[column][row]);

                if(column != kingColumn){
                    column = column + adjustColumnValue;
                }

                if(row != kingRow){
                    row = row + adjustRowValue;
                }

            }
        }

        return blockAttackingSquares;

    }

    //If any piece can block the check, return true otherwise it returns false
    public boolean isThereOneValidPieceToBlock(List <Piece> blockSquares){

        boolean isThereOneValidPiece = false;
        //set up to check if your piece can attack a certain square
        CheckForAttacksAtLocation counterBlockOrTake = new CheckForAttacksAtLocation(this.chessBoard, !isWhiteTurn);


        //loop all spaces and see if one of your piece can block it
        for(Piece blockablePieceLocation: blockSquares){

            //Check if a selected space can be occupied by your own piece
            boolean check = counterBlockOrTake.isThereAnAttacks(blockablePieceLocation.getLocation());

            //if it can block it, check if moving that piece stop check and not reveal any new checks
            if(check){

                //stack of pieces that can block for that space
                Stack <Piece> canAttackPiece = counterBlockOrTake.getAttackStackList();

                //go through the entire stack to check if at least one piece is valid to move to that space
                while(!canAttackPiece.isEmpty()){
                    Piece ourPiece = canAttackPiece.pop();

                    int [] ourPieceLocation = ourPiece.getLocation();
                    int columnOurPiece = ourPieceLocation[0];
                    int rowOurPiece = ourPieceLocation[1];

                    int [] blockLocation = blockablePieceLocation.getLocation();
                    int columnBlockPiece = blockLocation[0];
                    int rowBlockPiece = blockLocation[1];

                    Board testingBoard = this.chessBoardClass;

                    Piece [][] testingChessBoard = testingBoard.getBoard();

                    //move our piece to the block location
                    testingChessBoard[columnBlockPiece][rowBlockPiece] = testingChessBoard[columnOurPiece][rowOurPiece];
                    testingChessBoard[columnBlockPiece][rowBlockPiece].setLocation(columnBlockPiece, rowBlockPiece);
                    testingChessBoard[columnOurPiece][rowOurPiece] = new NoPiece();

                    //reset with testing board to look for checks
                    counterBlockOrTake = new CheckForAttacksAtLocation(testingChessBoard, isWhiteTurn);

                    testingBoard.setBoard(testingChessBoard);

                    counterBlockOrTake.isThereAnAttacks(getKingsLocation(testingBoard));

                    //if attackStack is empty, it means no check so return true since at least one piece can block
                    //if attackStack is not empty, it means a check is revealed after that piece moved to block
                    //So continue the loop to check for other pieces and spaces
                    if(counterBlockOrTake.getAttackStackList().isEmpty()){
                        isThereOneValidPiece = true;
                        return isThereOneValidPiece;
                    }


                }

            }

        }
        return isThereOneValidPiece;
    }



    //gets your current king location
    private int []getKingsLocation(Board chessBoard){

        int [] kingsLocation = new int[2];

        int [][] bothKingsLocation = chessBoard.getKingsLocation();
        if(isWhiteTurn){
            kingsLocation[0] = bothKingsLocation[0][0];
            kingsLocation[1] = bothKingsLocation[0][1];
        }else{
            kingsLocation[0] = bothKingsLocation[1][0];
            kingsLocation[1] = bothKingsLocation[1][1];
        }
        return kingsLocation;
    }





}
