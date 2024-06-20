package ChessClasses;

import java.util.Stack;

public class InCheck {

    Stack<int[]> priorityCheck = new Stack<>();

    /*
    returns 0 for no checks
    returns 1 for checks
    */
    public boolean checkForChecks(ChessBoard chessBoard, boolean isWhiteTurn){
        int [][] kingslocation = chessBoard.getKingsLocation();

        int [] theCurrentKingLocation = new int [2];

        if(isWhiteTurn){
            theCurrentKingLocation[0] = kingslocation[0][0];
            theCurrentKingLocation[1] = kingslocation[0][1];
        }else{
            theCurrentKingLocation[0] = kingslocation[1][0];
            theCurrentKingLocation[1] = kingslocation[1][1];

        }
    }
}
