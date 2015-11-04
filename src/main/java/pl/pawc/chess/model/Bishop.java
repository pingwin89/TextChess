package pl.pawc.chess.model;

public class Bishop extends Figure{

	public Bishop(int x, int y, String color) {
		super(x, y, color);
	}

	public static boolean isMoveValid(int x1, int y1, int x2, int y2, Board board){
		if(Double.compare(Math.abs(x1-x2), Math.abs(y1-y2))!=0) return false;	
		return true;
	}

}
	
