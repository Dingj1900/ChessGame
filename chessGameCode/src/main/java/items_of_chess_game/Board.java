package items_of_chess_game;

public class Board {

    public Piece [][] Board;

    public Board(){
        Board = setUpBoard();
    }


    public int [][] getKingsLocation(){
        int [][] kingLocation = new int[2][2];
        kingLocation[0][0] = -1;
        kingLocation[0][1] = -1;
        kingLocation[1][0] = -1;
        kingLocation[1][1] = -1;


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(Board[i][j].getName().equals("White King")){
                    kingLocation[0][0] = i;
                    kingLocation[0][1] = j;
                }
                if(Board[i][j].getName().equals("Black King")){
                    kingLocation[1][0] = i;
                    kingLocation[1][1] = j;
                }
            }
        }
        return kingLocation;
    }

    //Sets up the beginning board
    public Piece [][] setUpBoard(){
        Piece [][] Board = new NoPiece[8][8];

        //create the pawns
        int whitePawns = 1;
        int blackPawns = 6;

        String whiteColor = "White";
        String blackColor = "Black";

        for (int i = 0; i < 8; i++) {
            Board[i][whitePawns] = new Pawn(whiteColor);
            Board[i][blackPawns] = new Pawn(blackColor);
        }

        //white horse
        Board[1][0] = new Knight(whiteColor);
        Board[6][0] = new Knight(whiteColor);
        //black horse
        Board[1][7] = new Knight(blackColor);
        Board[6][7] = new Knight(blackColor);

        //white rook
        Board[0][0] = new Rook(whiteColor);
        Board[7][0] = new Rook(whiteColor);
        //black rook
        Board[0][7] = new Rook(blackColor);
        Board[7][7] = new Rook(blackColor);

        //white Bishop
        Board[2][0] = new Bishop(whiteColor);
        Board[5][0] = new Bishop(whiteColor);
        //black Bishop
        Board[2][7] = new Bishop(blackColor);
        Board[5][7] = new Bishop(blackColor);

        //white Queen
        Board[3][0] = new Queen(whiteColor);
        //black Queen
        Board[3][7] = new Queen(blackColor);

        //white King
        Board[4][0] = new King(whiteColor);
        //black King
        Board[4][7] = new King(blackColor);




        //fill the rest with NoPiece
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(Board[i][j].equals(null) ){
                    Board[i][j] = new NoPiece();
                }
            }
        }

        return Board;
    }

    public Piece [][] getBoard(){
        return Board;
    }

    public void flipBoard(){
        Piece [][] newBoard = new Piece[8][8];

        for (int column = 0; column < 7; column++) {
            for (int row = 0; row < 7; row++) {
                    newBoard[column][row] = this.Board[7 - column][ 7 - row];
            }
        }
        this.Board = newBoard;
    }



}

