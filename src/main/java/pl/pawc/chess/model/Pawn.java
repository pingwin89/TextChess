package pl.pawc.chess.model;

public class Pawn extends Figure {

	public Pawn(int x, int y, String color) {
		super(x, y, color);
	}

	public static boolean isMoveValid(int x1, int y1, int x2, int y2){return true;}

}
