package com.game.items_of_chess_game;

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
                if(Board[i][j].getName().equals("King") && Board[i][j].getColor().equals("White")){
                    kingLocation[0][0] = i;
                    kingLocation[0][1] = j;
                }
                if(Board[i][j].getName().equals("King") && Board[i][j].getColor().equals("Black")){
                    kingLocation[1][0] = i;
                    kingLocation[1][1] = j;
                }
            }
        }
        return kingLocation;
    }

    //Sets up the beginning board
    public Piece [][] setUpBoard(){
        Piece [][] Board = new Piece[8][8];

        //create the pawns
        int whitePawns = 1;
        int blackPawns = 6;

        String whiteColor = "White";
        String blackColor = "Black";

        for (int i = 0; i < 8; i++) {
            Board[i][whitePawns] = new Pawn(whiteColor);
            Board[i][whitePawns].setLocation(i,whitePawns);
            Board[i][blackPawns] = new Pawn(blackColor);
            Board[i][blackPawns].setLocation(i,blackPawns);
        }

        //white horse
        Board[1][0] = new Knight(whiteColor);
        Board[1][0].setLocation(1,0);
        Board[6][0] = new Knight(whiteColor);
        Board[6][0].setLocation(6,0);

        //black horse
        Board[1][7] = new Knight(blackColor);
        Board[1][7].setLocation(1,7);
        Board[6][7] = new Knight(blackColor);
        Board[6][7].setLocation(6,7);

        //white rook
        Board[0][0] = new Rook(whiteColor);
        Board[0][0].setLocation(0,0);
        Board[7][0] = new Rook(whiteColor);
        Board[7][0].setLocation(0,0);

        //black rook
        Board[0][7] = new Rook(blackColor);
        Board[0][7].setLocation(0,7);
        Board[7][7] = new Rook(blackColor);
        Board[7][7].setLocation(7,7);

        //white Bishop
        Board[2][0] = new Bishop(whiteColor);
        Board[2][0].setLocation(2,0);
        Board[5][0] = new Bishop(whiteColor);
        Board[5][0].setLocation(5,0);

        //black Bishop
        Board[2][7] = new Bishop(blackColor);
        Board[2][7].setLocation(2,7);
        Board[5][7] = new Bishop(blackColor);
        Board[5][7].setLocation(5,7);

        //white Queen
        Board[3][0] = new Queen(whiteColor);
        Board[3][0].setLocation(3,0);

        //black Queen
        Board[3][7] = new Queen(blackColor);
        Board[3][7].setLocation(3,7);

        //white King
        Board[4][0] = new King(whiteColor);
        Board[4][0].setLocation(4,0);
        //black King
        Board[4][7] = new King(blackColor);
        Board[4][7].setLocation(4,7);




        //fill the rest with NoPiece
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(Board[i][j] == null ){
                    Board[i][j] = new NoPiece();
                    Board[i][j].setLocation(i,j);
                }
            }
        }

        return Board;
    }

    public Piece [][] getBoard(){
        return Board;
    }

    public void setBoard(Piece[][] board) {
        Board = board;
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

