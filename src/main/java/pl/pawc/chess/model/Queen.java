package pl.pawc.chess.model;

public class Queen extends Figure{

	public Queen(int x, int y, String color) {
		super(x, y, color);
		setItsClass("Queen");
	}

	public static boolean isMoveValid(int x1, int y1, int x2, int y2, Board board){

	if(( (x1-x2)==0)&&((y1-y2)==0)) return false;
	if((x1!=x2)&&(y1!=y2)&&(Double.compare(Math.abs(x1-x2), Math.abs(y1-y2))!=0)) return false;

	//rook

	if(y1==y2){
		if(x1<x2){
			for(int k=x1+1; k<x2; k++){
				if(board.getBoard()[k][y1]!=null) return false;	
			}
		}
		if(x2<x1){
			for(int k=x2+1; k<x1; k++){
				if(board.getBoard()[k][y1]!=null) return false;	
			}
		}
	}
	if(x1==x2){
		if(y1<y2){
			for(int k=y1+1; k<y2; k++){
				if(board.getBoard()[x1][k]!=null) return false;	
			}
		}
		if(y2<y1){
			for(int k=y2+1; k<y1; k++){
				if(board.getBoard()[x1][k]!=null) return false;	
			}
		}
	}
	
	//bishop

	if(Double.compare(Math.abs(x1-x2), Math.abs(y1-y2))==0){	
		if((x1-x2)==0) return false;
		if((x1<x2)&&(y1<y2)){for(int i=1;i<(x2-x1);i++){if(board.getBoard()[x1+i][y1+i]!=null) return false;}}
		if((x1<x2)&&(y1>y2)){for(int i=1;i<(x2-x1);i++){if(board.getBoard()[x1+i][y1-i]!=null) return false;}}
		if((x1>x2)&&(y1<y2)){for(int i=1;i<(x1-x2);i++){if(board.getBoard()[x1-i][y1+i]!=null) return false;}}
		if((x1>x2)&&(y1>y2)){for(int i=1;i<(x1-x2);i++){if(board.getBoard()[x1-i][y1-i]!=null) return false;}}
	}
	return true;
    }

}
