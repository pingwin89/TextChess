package pl.pawc.chess.model;

public class Bishop extends Figure{

	public Bishop(int x, int y, String color) {
		super(x, y, color);
	}

	public static boolean isMoveValid(int x1, int y1, int x2, int y2, Board board){
		if(Double.compare(Math.abs(x1-x2), Math.abs(y1-y2))!=0) return false;	
		if((x1-x2)==0) return false;
		if((x1<x2)&&(y1<y2)){for(int i=1;i<(x2-x1);i++){if(board.getBoard()[x1+i][y1+i]!=null) return false;}}
		if((x1<x2)&&(y1>y2)){for(int i=1;i<(x2-x1);i++){if(board.getBoard()[x1+i][y1-i]!=null) return false;}}
		if((x1>x2)&&(y1<y2)){for(int i=1;i<(x1-x2);i++){if(board.getBoard()[x1-i][y1+i]!=null) return false;}}
		if((x1>x2)&&(y1>y2)){for(int i=1;i<(x1-x2);i++){if(board.getBoard()[x1-i][y1-i]!=null) return false;}}
		return true;
	}
}
