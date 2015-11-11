package pl.pawc.chess.game;

import pl.pawc.chess.model.Bishop;
import pl.pawc.chess.model.Board;
import pl.pawc.chess.model.King;
import pl.pawc.chess.model.Knight;
import pl.pawc.chess.model.Pawn;
import pl.pawc.chess.model.Queen;
import pl.pawc.chess.model.Rook;

public class MoveValidation {
    
    public static boolean validate(int x1, int y1, int x2, int y2, int turn, Board board){
        
        if(board.getBoard()[x1][y1]==null){
            Log.normal("There is no figure in this field\n");
            return false;
        }

        if((turn==0)&&(!board.getBoard()[x1][y1].getColor().equals("BLUE"))){
            Log.normal("It's blue player's turn\n\n");
           return false;
        }

        if((turn==1)&&(!board.getBoard()[x1][y1].getColor().equals("RED"))){
            Log.normal("It's red player's turn\n\n");
            return false;
        }

        if((board.getBoard()[x1][y1] instanceof Pawn)&&!((Pawn) board.getBoard()[x1][y1]).isMoveValid(x1,y1,x2,y2,board)){
            Log.normal("Invalid move for the pawn figure. Try again\n");
            return false;
        }

        if((board.getBoard()[x1][y1] instanceof Knight)&&!Knight.isMoveValid(x1,y1,x2,y2)){
            Log.normal("Invalid move for the knight figure. Try again\n");
            return false;
        }

        if((board.getBoard()[x1][y1] instanceof Rook)&&!Rook.isMoveValid(x1,y1,x2,y2,board)){
            Log.normal("Invalid move for the rook figure. Try again\n");
            return false;
        }

        if((board.getBoard()[x1][y1] instanceof Bishop)&&!Bishop.isMoveValid(x1,y1,x2,y2,board)){
            Log.normal("Invalid move for the bishop figure. Try again\n");
            return false;
        }
        
        if((board.getBoard()[x1][y1] instanceof Queen)&&!Queen.isMoveValid(x1,y1,x2,y2,board)){
            Log.normal("Invalid move for the queen figure. Try again\n");
            return false;
        }   
        
        if((board.getBoard()[x1][y1] instanceof King)&&!King.isMoveValid(x1,y1,x2,y2,board)){
            Log.normal("Invalid move for the king figure. Try again\n");
            return false;
        }   
        
        if((board.getBoard()[x2][y2]!=null)&&(board.getBoard()[x1][y1].getColor().equals(board.getBoard()[x2][y2].getColor()))){
            Log.normal("Cant beat your own figure\n");
            return false;
        }

        //preventing the king figure from moving into a check situation by cloning the current board and performing the movement there first
        Board tempBoard = null;
        try{
            tempBoard = board.clone();
        }
        catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        tempBoard.move(x1,y1,x2,y2);
        if((turn==1)&&((King) tempBoard.locateKing("RED")).isChecked(tempBoard)){
            System.out.println("Can't move because red king will be checked"); 
            return false;
        }
        if((turn==0)&&((King) tempBoard.locateKing("BLUE")).isChecked(tempBoard)){
            System.out.println("Can't move because blue king will be checked");
            return false;
        }
            
    return true;
    
    }

}