package pl.pawc.chess.model;

import pl.pawc.chess.Start;

public class Board {
	
	private Figure[][] board;
	
	public Board(){
		board = new Figure[8][8];
		for(int i=0; i<8; i++){
			board[1][i] = new Pawn(1, i, "RED");
			board[6][i] = new Pawn(6, i, "BLUE");
		}
		board[0][1] = new Knight(0,1, "RED");
		board[0][6] = new Knight(0,6, "RED");
		board[0][0] = new Rook(0,0, "RED");
		board[0][7] = new Rook(0,7, "RED");
		board[0][2] = new Bishop(0,2, "RED");
		board[0][5] = new Bishop(0,5, "RED");
		board[0][3] = new King(0,3, "RED");
		board[0][4] = new Queen(0,4, "RED");
		
		board[7][1] = new Knight(7,1, "BLUE");
		board[7][6] = new Knight(7,6, "BLUE");
		board[7][0] = new Rook(7,0, "BLUE");
		board[7][7] = new Rook(7,7, "BLUE");
		board[7][2] = new Bishop(7,2, "BLUE");
		board[7][5] = new Bishop(7,5, "BLUE");
		board[7][3] = new King(7,3, "BLUE");
		board[7][4] = new Queen(7,4, "BLUE");
	}
	
	public Figure[][] getBoard(){
		return board;
	}

	public void printOut(){
		//Start.logNormal("\n");
		Start.logNormal("  0 1 2 3 4 5 6 7\n");		
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(j==0) Start.logNormal(Integer.toString(i)+" ");
				if(board[i][j] != null ){

					if(board[i][j] instanceof Pawn) if(board[i][j].getColor().equals("RED")) Start.logRed("P"); 
					if(board[i][j] instanceof Pawn) if(board[i][j].getColor().equals("BLUE")) Start.logBlue("P"); 
					if(board[i][j] instanceof Knight) if(board[i][j].getColor().equals("RED")) Start.logRed("K"); 
					if(board[i][j] instanceof Knight) if(board[i][j].getColor().equals("BLUE")) Start.logBlue("K"); 
					if(board[i][j] instanceof Bishop) if(board[i][j].getColor().equals("RED")) Start.logRed("B"); 
					if(board[i][j] instanceof Bishop) if(board[i][j].getColor().equals("BLUE")) Start.logBlue("B"); 
					if(board[i][j] instanceof Rook) if(board[i][j].getColor().equals("RED")) Start.logRed("R"); 
					if(board[i][j] instanceof Rook) if(board[i][j].getColor().equals("BLUE")) Start.logBlue("R"); 
					if(board[i][j] instanceof Queen) if(board[i][j].getColor().equals("RED")) Start.logRed("Q"); 
					if(board[i][j] instanceof Queen) if(board[i][j].getColor().equals("BLUE")) Start.logBlue("Q");
					if(board[i][j] instanceof King) if(board[i][j].getColor().equals("RED")) Start.logRed("+");  
					if(board[i][j] instanceof King) if(board[i][j].getColor().equals("BLUE")) Start.logBlue("+");    
				
				}
				else{
					Start.logNormal("-");
				}
				Start.logNormal(" ");
			}
		Start.logNormal("\n");
		}
	Start.logNormal("\n");
	}

	public void move(int x1, int y1, int x2, int y2){
		board[x2][y2] = board[x1][y1];
		board[x1][y1] = null;
	}

}
