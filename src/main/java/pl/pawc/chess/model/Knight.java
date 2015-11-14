package pl.pawc.chess.model;

public class Knight extends Figure{

	public Knight(int x, int y, String color) {
		super(x, y, color);
		setItsClass("Knight");
	}

	public static boolean isMoveValid(int x1, int y1, int x2, int y2){
		if(Math.abs(x1-x2)==2&&Math.abs(y1-y2)==1||Math.abs(x1-x2)==1&&Math.abs(y1-y2)==2){
		return true; 
		} 
		else{ 
		return false; 
		} 
	}

}
