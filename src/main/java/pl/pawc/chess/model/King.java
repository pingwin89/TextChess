package pl.pawc.chess.model;

public class King extends Figure{

    public King(int x, int y, String color) {
		super(x, y, color);
		setItsClass("King");
	}

	public boolean isMoveValid(int x1, int y1, int x2, int y2, Board board){
		if((getColor().equals("BLUE"))&&(isCastlingPossible(board)==1)&&(x2==7)&&(y2==1)) return true;
		if((getColor().equals("BLUE"))&&(isCastlingPossible(board)==2)&&(x2==7)&&(y2==5)) return true;
		if((getColor().equals("RED"))&&(isCastlingPossible(board)==1)&&(x2==0)&&(y2==1)) return true;
		if((getColor().equals("RED"))&&(isCastlingPossible(board)==2)&&(x2==0)&&(y2==5)) return true;		
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
					if(figure instanceof King) if(((King) figure).isMoveValid(figure.getX(), figure.getY(), this.getX(), this.getY(), board)) return true;
				}
			}
		}
		return false;
	}
	//2 - queen side, 1 - the opposite side, 0 - not possible
	public int isCastlingPossible(Board board){
		boolean o = (getMoveCounter()==0);
		switch(getColor()){
			case "BLUE" : 
				boolean p = (board.getBoard()[7][0]!=null); 
				boolean t = (board.getBoard()[7][0].getMoveCounter()==0);
				boolean u = ((board.getBoard()[7][1]==null)&&(board.getBoard()[7][2]==null));
				boolean v = ((board.canMoveTo(7,1,"RED").size()==0)&&(board.canMoveTo(7,2,"RED").size()==0));
			 	if(o&&p&&t&&u&&v) return 1;
				boolean p2 = (board.getBoard()[7][7]!=null);
				boolean t2 = (board.getBoard()[7][7].getMoveCounter()==0);
				boolean u2 = ((board.getBoard()[7][6]==null)&&(board.getBoard()[7][5]==null)&&(board.getBoard()[7][4]==null));
				boolean v2 = ((board.canMoveTo(7,6,"RED").size()==0)&&(board.canMoveTo(7,5,"RED").size()==0)&&(board.canMoveTo(7,4,"RED").size()==0));
				if(o&&p2&&t2&&u2&&v2) return 2;
				break;
			case "RED" :
				boolean p3 = (board.getBoard()[0][0]!=null);
				boolean r3 = (board.getBoard()[0][0].getMoveCounter()==0);
				boolean u3 = ((board.getBoard()[0][1]==null)&&(board.getBoard()[0][2]==null));
			        boolean v3 = ((board.canMoveTo(0,1,"BLUE").size()==0)&&(board.canMoveTo(0,2,"BLUE").size()==0));
			        if(p3&&r3&&u3&&v3) return 1;
	        	        boolean p4 = (board.getBoard()[0][7]!=null);
		                boolean r4 = (board.getBoard()[0][7].getMoveCounter()==0);
                		boolean u4 = ((board.getBoard()[0][6]==null)&&(board.getBoard()[0][5]==null)&&(board.getBoard()[0][4]==null));
		                boolean v4 = ((board.canMoveTo(0,6,"BLUE").size()==0)&&(board.canMoveTo(0,5,"BLUE").size()==0)&&(board.canMoveTo(0, 4, "BLUE").size()==0));
		                if(p4&&r4&&u4&&v4) return 2;		 		
		}
	return 0;
	}

}
