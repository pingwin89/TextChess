package pl.pawc.chess.model;

public class Pawn extends Figure {

	public Pawn(int x, int y, String color) {
		super(x, y, color);
		setItsClass("Pawn");
	}

	public boolean isMoveValid(int x1, int y1, int x2, int y2, Board board){
		switch(getColor()){
			case "BLUE" : 
				if((x1-x2==1)&&(y1==y2)&&(board.getBoard()[x2][y2]==null)) return true; //podstawowy ruch do przodu
				if((x1==6)&&(board.getBoard()[5][y1]==null)&&(x1-x2==2)&&(y1==y2)&&(board.getBoard()[x2][y2]==null)) return true; //dwa ruchy do przodu na poczatku
				if((x1-x2==1)&&(((y1-y2)==1)||((y2-y1)==1))&&(board.getBoard()[x2][y2]!=null)) return true; //bicie po skosie
				break;
				
			case "RED" :
                		if((x2-x1==1)&&(y1==y2)&&(board.getBoard()[x2][y2]==null)) return true; //podstawowy ruch do przodu
                		if((x1==1)&&(board.getBoard()[2][y1]==null)&&(x2-x1==2)&&(y1==y2)&&(board.getBoard()[x2][y2]==null)) return true; //dwa ruchy do przodu na poczatku
                		if((x2-x1==1)&&(((y1-y2)==1)||((y2-y1)==1))&&(board.getBoard()[x2][y2]!=null)) return true; //bicie po skosie
				break;	
		}
		return false;
	}
}
