package pl.pawc.chess.model;

public class Rook extends Figure {

	public Rook(int x, int y, String color) {
		super(x, y, color);
	}

	@Override public boolean isMoveValid(int x1, int y1, int x2, int y2){return true;}

}
