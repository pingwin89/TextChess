package pl.pawc.chess.model;

import pl.pawc.chess.Start;

public class Board {
	
	private Figure[][] board;
	
	public Board(){
		board = new Figure[8][8];
		for(int i=0; i<8; i++){
			board[0][i] = new Knight(0, i);
			board[1][i] = new Pawn(1, i);
			board[6][i] = new Figure(6, i);
			board[7][i] = new Knight(7, i);
		}
	}
	
	public void printOut(){
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(board[i][j] != null ){
					if(board[i][j] instanceof Pawn) Start.logRed("P");
					if(board[i][j] instanceof Knight) Start.logRed("K");
				}
				else{
					Start.logNormal("-");
				}
			}
		System.out.println();
		}
	}

}
