package pl.pawc.chess.model;

import pl.pawc.chess.Start;

public class Board {
	
	private Figure[][] board;
	
	public Board(){
		board = new Figure[8][8];
		for(int i=0; i<8; i++){
			board[1][i] = new Pawn(1, i);
			board[6][i] = new Pawn(6, i);
		}
		board[0][2] = new Knight(0,2);
		board[0][6] = new Knight(0,6);
		board[0][0] = new Rook(0,1);
		board[0][7] = new Rook(0,7);
		board[0][1] = new Bishop(0,1);
		board[0][5] = new Bishop(0,5);
		board[0][3] = new King(0,3);
		board[0][4] = new Queen(0,4);
		
		board[7][2] = new Knight(7,2);
		board[7][6] = new Knight(7,6);
		board[7][0] = new Rook(7,1);
		board[7][7] = new Rook(7,7);
		board[7][1] = new Bishop(7,1);
		board[7][5] = new Bishop(7,5);
		board[7][3] = new King(7,3);
		board[7][4] = new Queen(7,4);
	}
	
	public void printOut(){
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(board[i][j] != null ){
					if(board[i][j] instanceof Pawn) Start.logRed("P");
					if(board[i][j] instanceof Knight) Start.logRed("K");
					if(board[i][j] instanceof Bishop) Start.logRed("B");
					if(board[i][j] instanceof Rook) Start.logRed("R");
					if(board[i][j] instanceof Queen) Start.logRed("Q");
					if(board[i][j] instanceof King) Start.logRed("+");
					
				}
				else{
					Start.logNormal("-");
				}
			}
		System.out.println();
		}
	}

}
