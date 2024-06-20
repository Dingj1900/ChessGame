package ChessClasses;

public class ChessBoard {


    public String [][] chessBoard = new String[8][8];

    public ChessBoard(){
        chessBoard = setUpBoard();
    }
    //Sets up the beginning board
    public String [][] setUpBoard(){
        String [][] chessBoard = new String[8][8];

        //create the pawns
        int whitePawns = 1;
        int blackPawns = 6;

        for (int i = 0; i < 8; i++) {
            chessBoard[i][whitePawns] = "w-p";
            chessBoard[i][blackPawns] = "b-p";
        }

        //white horse
        chessBoard[1][0] = "w-H";
        chessBoard[6][0] = "w-H";
        //black horse
        chessBoard[1][7] = "b-H";
        chessBoard[6][7] = "b-H";

        //white rook
        chessBoard[0][0] = "w-R";
        chessBoard[7][0] = "w-R";
        //black rook
        chessBoard[0][7] = "b-R";
        chessBoard[7][7] = "b-R";

        //white Bishop
        chessBoard[2][0] = "w-B";
        chessBoard[5][0] = "w-B";
        //black Bishop
        chessBoard[2][7] = "b-B";
        chessBoard[5][7] = "b-B";

        //white Queen
        chessBoard[3][0] = "w-Q";
        //black Queen
        chessBoard[3][7] = "b-Q";

        //white King
        chessBoard[4][0] = "w-K";
        //black King
        chessBoard[4][7] = "b-K";

        //fill the rest with three empty spaces
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessBoard[i][j].isEmpty()){
                    chessBoard[i][j] = "   ";
                }
            }
        }

        return chessBoard;
    }

    public String [][] getChessBoard(){
        return chessBoard;
    }

    public int [][] getKingsLocation(){
        int [][] kingLocation = new int[2][2];
        kingLocation[0][0] = -1;
        kingLocation[0][1] = -1;
        kingLocation[1][0] = -1;
        kingLocation[1][1] = -1;


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessBoard[i][j] == "w-K"){
                    kingLocation[0][0] = i;
                    kingLocation[0][1] = j;
                }
                if(chessBoard[i][j] == "b-K"){
                    kingLocation[1][0] = i;
                    kingLocation[1][1] = j;
                }
            }
        }
        return kingLocation;
    }

    public void flipBoard(){
        String [][] newChessBoard = new String[8][8];

        for (int column = 0; column < 7; column++) {
            for (int row = 0; row < 7; row++) {
                    newChessBoard[column][row] = this.chessBoard[7 - column][ 7 - row];
            }
        }

        this.chessBoard = newChessBoard;
    }

}
