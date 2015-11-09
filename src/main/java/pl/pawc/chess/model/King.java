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

	public boolean isChecked(Board board){		
		for(int i=0; i<8; i++){
			for(Figure figure : board.getBoard()[i]){
				if((figure!=null)&&!figure.getColor().equals(this.getColor())){
					if(figure instanceof Pawn) if(((Pawn) figure).isMoveValid(figure.getX(), figure.getY(), this.getX(), this.getY(), board)) return true;
					if(figure instanceof Rook) if(Rook.isMoveValid(figure.getX(), figure.getY(), this.getX(), this.getY(), board)) return true;
					if(figure instanceof Knight) if(Knight.isMoveValid(figure.getX(), figure.getY(), this.getX(), this.getY())) return true;
					if(figure instanceof Bishop) if(Bishop.isMoveValid(figure.getX(), figure.getY(), this.getX(), this.getY(), board)) return true;
					if(figure instanceof Queen) if(Queen.isMoveValid(figure.getX(), figure.getY(), this.getX(), this.getY(), board)) return true;
					if(figure instanceof King) if(King.isMoveValid(figure.getX(), figure.getY(), this.getX(), this.getY(), board)) return true;
				}
			}
		}
		return false;
	}

}
