package pl.pawc.chess.model;

public class Pawn extends Figure {

	public Pawn(int x, int y, String color) {
		super(x, y, color);
	}

	public boolean isMoveValid(int x1, int y1, int x2, int y2, Board board){
		switch(getColor()){
			case "BLUE" : 
				if(x1<=x2) return false;
				if(((x1-x2)==2)&&x1!=6) return false;
				if(((x1-x2)>2)||(Math.abs(y2-y1)>1)) return false;
				if(((x1-x2)==1)&&(y1==y2)&&board.getBoard()[x2][y2]!=null) return false;
				if(((x1-x2)==1)&&(Math.abs(y2-y1)==1)&&board.getBoard()[x2][y2]==null) return false;
				break;
				
			case "RED" :
				if(x1>=x2) return false;
				if(((x2-x1)==2)&&x1!=1) return false;
				if(((x2-x1)>2)||(Math.abs(y2-y1)>1)) return false;
				if(((x2-x1)==1)&&(y1==y2)&&board.getBoard()[x2][y2]!=null) return false;
				if(((x2-x1)==1)&&(Math.abs(y2-y1)==1)&&board.getBoard()[x2][y2]==null) return false;
				break;	
		}
		return true;
	}
}
