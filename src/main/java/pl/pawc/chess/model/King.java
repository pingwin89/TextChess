package pl.pawc.chess.model;

public class King extends Figure{

	public King(int x, int y, String color) {
		super(x, y, color);
	}

	public static boolean isMoveValid(int x1, int y1, int x2, int y2, Board board){
		
		if((x1==x2)&&(y1==y2)) return false;
		if((Math.abs(x1-x2)>1)||(Math.abs(y1-y2)>1)) return false;
		
		return true;
		
	}

}
